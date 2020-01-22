package com.kamadhenu.api.travel.car.dollar.service;

import com.kamadhenu.api.travel.car.dollar.exception.ApiResponseException;
import com.kamadhenu.api.travel.car.dollar.model.domain.request.Book;
import com.kamadhenu.api.travel.car.dollar.model.domain.request.Cancel;
import com.kamadhenu.api.travel.car.dollar.model.domain.request.Search;
import com.kamadhenu.api.travel.car.dollar.model.domain.request.XsellItems;
import com.kamadhenu.api.travel.car.dollar.model.domain.response.book.DomainBook;
import com.kamadhenu.api.travel.car.dollar.model.domain.response.cancel.DomainCancel;
import com.kamadhenu.api.travel.car.dollar.model.domain.response.search.*;
import com.kamadhenu.api.travel.car.dollar.model.supplier.request.book.*;
import com.kamadhenu.api.travel.car.dollar.model.supplier.request.cancel.*;
import com.kamadhenu.api.travel.car.dollar.model.supplier.request.cancel.Vendor;
import com.kamadhenu.api.travel.car.dollar.model.supplier.request.search.PickUpLocation;
import com.kamadhenu.api.travel.car.dollar.model.supplier.request.search.ReturnLocation;
import com.kamadhenu.api.travel.car.dollar.model.supplier.request.search.TourInfo;
import com.kamadhenu.api.travel.car.dollar.model.supplier.request.search.VehRentalCore;
import com.kamadhenu.api.travel.car.dollar.model.supplier.request.xsellItem.*;
import com.kamadhenu.api.travel.car.dollar.model.supplier.request.search.*;
import com.kamadhenu.api.travel.car.dollar.model.supplier.request.search.SearchEnvelope;
import com.kamadhenu.api.travel.car.dollar.model.supplier.response.book.ConfID;
import com.kamadhenu.api.travel.car.dollar.model.supplier.response.book.OtaVehResRs;
import com.kamadhenu.api.travel.car.dollar.model.supplier.response.cancel.OtaVehCancelRs;
import com.kamadhenu.api.travel.car.dollar.model.supplier.response.search.*;
import com.kamadhenu.api.travel.car.dollar.util.Config;
import com.kamadhenu.api.travel.car.dollar.util.Helper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static java.lang.Boolean.TRUE;

public class DollarService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DollarService.class);

    private static Properties properties = Config.config().getProperties();

    /**
     * Search available cars depending upon pick, drop location and pick , return time
     *
     * @param searchRequest
     * @return otaVehAvailRatesRs
     * @throws ApiResponseException
     */
    public static DomainVehAvails search(Search searchRequest) throws ApiResponseException {
        List<VehAvail> vehAvailList;
        VehAvailCore vehAvailCore;
        List<VehicleCharge> vehicleChargeList;
        Vehicle vehicle;
        TotalCharge totalCharge;
        RateQualifier rateQualifier;
        DomainVehAvails domainVehAvails;
        List<PricedEquip> pricedEquipList;
        OtaVehAvailRatesRs otaVehAvailRatesRs = new OtaVehAvailRatesRs();
        TourInfo tourInfo = new TourInfo(searchRequest.getTourCode());
        TourOperator tourOperator = new TourOperator();
        VehAvailRQInfo vehAvailRQInfo = new VehAvailRQInfo(tourInfo, tourOperator);
        PickUpLocation pickUpLocation = new PickUpLocation(searchRequest.getPickUpLocation());
        ReturnLocation returnLocation = new ReturnLocation(searchRequest.getDropOffLocation());
        VehPref vehPref = new VehPref("ACAR", "ACRISS");
        VehPrefs vehPrefs = new VehPrefs(vehPref);
        VehRentalCore vehRentalCore = new VehRentalCore(Helper.getFormattedDate(searchRequest.getPickUpDateTime()), Helper.getFormattedDate(searchRequest.getDropOffDateTime()),
                pickUpLocation, returnLocation);
        VendorPref vendorPref = new VendorPref("ZT");
        VendorPrefs vendorPrefs = new VendorPrefs(vendorPref);
        VehAvailRQCore vehAvailRQCore = new VehAvailRQCore("Available", vehRentalCore, vendorPrefs, vehPrefs);
        RequestorID requestorID = new RequestorID("4", properties.getProperty("api-id"));
        SearchSource source = new SearchSource(searchRequest.getPos(), searchRequest.getCurrency(), requestorID);
        SearchPOS pos = new SearchPOS(source);
        OTAVehAvailRateRQ otaVehAvailRateRQ = new OTAVehAvailRateRQ("http://www.opentravel.org/OTA/2003/05", "http://www.w3.org/2001/XMLSchema-instance",
                "http://www.opentravel.org/OTA/2003/05 OTA_VehAvailRateRQ.xsd", properties.getProperty("api-target"), "2.000",
                "EN", "SCA", pos, vehAvailRQCore, vehAvailRQInfo);
        GetRates getRates = new GetRates(otaVehAvailRateRQ);
        SearchBody body = new SearchBody(getRates);
        SearchHeader header = new SearchHeader();
        SearchEnvelope searchEnvelope = new SearchEnvelope("http://schemas.xmlsoap.org/soap/envelope/", "http://www.opentravel.org/OTA/2003/05", header, body);
        String xmlRequest = Helper.getStringByMarshalling(searchEnvelope);
        String response = Helper.transaction("http://ota.dollar.com/OTA/2010A/" + "RateService.svc", xmlRequest, properties.getProperty("search-action"));
        if (response != null) {
            Helper.isErrorFound(response);
            otaVehAvailRatesRs = Helper.getObjectByUnmarshalling(response, otaVehAvailRatesRs, "OTA_VehAvailRateRS");
        }
        List<DomainVehAvail> domainVehAvailList = new ArrayList<>();
        vehAvailList = otaVehAvailRatesRs.getVehAvailRSCore().getVehVendorAvails().getVehVendorAvail().getVehAvails().getVehAvailList();
        for (VehAvail vehAvail : vehAvailList) {
            vehAvailCore = vehAvail.getVehAvailCore();
            vehicle = vehAvail.getVehAvailCore().getVehicle();
            totalCharge = vehAvailCore.getTotalCharge();
            rateQualifier = vehAvailCore.getRentalRate().getRateQualifier();
            vehicleChargeList = vehAvailCore.getRentalRate().getVehicleCharges().getVehicleChargeList();
            List<DomainIncludedPrices> domainIncludedPriceList = new ArrayList<>();
            List<DomainExtras> domainExtrasList = new ArrayList<>();
            for (VehicleCharge vehicleCharge : vehicleChargeList) {
                if (vehicleCharge.getIncludedInEstTotalInd() == TRUE) {
                    domainIncludedPriceList.add(new DomainIncludedPrices(vehicleCharge.getAmount(), vehicleCharge.getCurrencyCode(), vehicleCharge.getDescription()));
                } else {
                    domainExtrasList.add(new DomainExtras(vehicleCharge.getAmount(), vehicleCharge.getCurrencyCode(), vehicleCharge.getPurpose()));
                }
            }
            DomainTotalCharge domainTotalCharge = new DomainTotalCharge(totalCharge.getRateTotalAmount(), totalCharge.getCurrencyCode());
            pricedEquipList = vehAvailCore.getPricedEquips().getPricedEquipList();
            for (PricedEquip pricedEquip : pricedEquipList) {
                if (pricedEquip.getCharge().getIncludedInRate() == TRUE) {
                    domainIncludedPriceList.add(new DomainIncludedPrices(pricedEquip.getCharge().getAmount(), totalCharge.getCurrencyCode(),
                            pricedEquip.getCharge().getDescription()));
                } else {
                    domainExtrasList.add(new DomainExtras(pricedEquip.getCharge().getAmount(),totalCharge.getCurrencyCode(),
                            pricedEquip.getCharge().getDescription()));
                }
            }
            DomainReference domainReference = new DomainReference(vehAvailCore.getReference().getId(),null);
            DomainVehicle domainVehicle = new DomainVehicle(vehicle.getAirConditionInd(), vehicle.getTransmissionType(), vehicle.getPassengerQuantity(), vehicle.getBaggageQuantity(),
                    vehicle.getCode(), vehicle.getCodeContext(), vehicle.getVehType().getVehicleCategory(), vehicle.getVehClass().getSize(),
                    vehicle.getVehMakeModel().getName(), vehicle.getPictureURL().getValue());
            domainVehAvailList.add(new DomainVehAvail(new DomainVehAvailCore(null,vehAvailCore.getStatus(), domainVehicle, domainIncludedPriceList,
                    domainExtrasList, domainTotalCharge, new DomainRateQualifier(rateQualifier.getRateQualifier()), domainReference)));
        }
        domainVehAvails = new DomainVehAvails(domainVehAvailList);
        return domainVehAvails;
    }

    /**
     * Cancel booking based upon confirmation id received during booking process
     *
     * @param xsellItemRequest
     * @return OtaVehAvailRatesRs
     * @throws ApiResponseException
     */
    public static OtaVehAvailRatesRs xSellItems(XsellItems xsellItemRequest) throws ApiResponseException {

        OtaVehAvailRatesRs otaVehAvailRatesRs = new OtaVehAvailRatesRs();
        XSellItemOTAVehAvailRateRQ otaVehAvailRatesRQ = new XSellItemOTAVehAvailRateRQ();
        XSellItemTourInfo tourInfo = new XSellItemTourInfo(xsellItemRequest.getTourNumber());
        XSellItemVehAvailRQInfo vehAvailRQInfo = new XSellItemVehAvailRQInfo(tourInfo);
        XSellItemPickUpLocation pickUpLocation = new XSellItemPickUpLocation(xsellItemRequest.getPickUpLocation());
        XSellItemReturnLocation returnLocation = new XSellItemReturnLocation(xsellItemRequest.getDropOffLocation());
        XSellItemVehPref vehPref = new XSellItemVehPref("ACAR", "ACRISS");
        XSellItemVehPrefs vehPrefs = new XSellItemVehPrefs(vehPref);
        XSellItemVehRentalCore vehRentalCore = new XSellItemVehRentalCore(Helper.getFormattedDate(xsellItemRequest.getPickUpDateTime()), Helper.getFormattedDate(xsellItemRequest.getDropOffDateTime()),
                pickUpLocation, returnLocation);
        XSellItemVendorPref vendorPref = new XSellItemVendorPref("ZT");
        XSellItemVendorPrefs vendorPrefs = new XSellItemVendorPrefs(vendorPref);
        XSellItemRateQualifier rateQualifier = new XSellItemRateQualifier(xsellItemRequest.getRateQualifier());
        XSellItemVehAvailRQCore vehAvailRQCore = new XSellItemVehAvailRQCore("Available", vehRentalCore, vendorPrefs, vehPrefs, rateQualifier);
        XSellItemRequestorID requestorID = new XSellItemRequestorID("4", properties.getProperty("api-id"));
        XSellItemSource source = new XSellItemSource(xsellItemRequest.getPos(), xsellItemRequest.getCurrency(), requestorID);
        XSellItemPOS pos = new XSellItemPOS(source);
        XSellItemOTAVehAvailRateRQ otaVehAvailRateRQ = new XSellItemOTAVehAvailRateRQ("http://www.opentravel.org/OTA/2003/05", "http://www.w3.org/2001/XMLSchema-instance",
                "http://www.opentravel.org/OTA/2003/05 OTA_VehAvailRateRQ.xsd", properties.getProperty("api-target"), "2.000",
                "EN", "SCA", pos, vehAvailRQCore, vehAvailRQInfo);
        XSellItemGetRates getRates = new XSellItemGetRates(otaVehAvailRateRQ);
        XSellItemBody body = new XSellItemBody(getRates);
        XSellItemHeader header = new XSellItemHeader();
        XSellItemEnvelope searchEnvelope = new XSellItemEnvelope("http://schemas.xmlsoap.org/soap/envelope/", "http://www.opentravel.org/OTA/2003/05", header, body);
        String xmlRequest = Helper.getStringByMarshalling(searchEnvelope);
        String response = Helper.transaction("http://ota.dollar.com/OTA/2010A/" + "RateService.svc", xmlRequest, properties.getProperty("search-action"));
        if (response != null) {
            Helper.isErrorFound(response);
            otaVehAvailRatesRs = Helper.getObjectByUnmarshalling(response, otaVehAvailRatesRs, "OTA_VehAvailRateRS");
        }

        return otaVehAvailRatesRs;
    }

    /**
     * Book cars depending upon upon pick, drop location and pick , return time
     *
     * @param bookRequest
     * @return otaVehResRs
     * @throws ApiResponseException
     */
    public static DomainBook book(Book bookRequest) throws ApiResponseException {

        List<ConfID> confIDList;
        DomainBook domainBook = null;
        OtaVehResRs otaVehResRs = new OtaVehResRs();
        BookRequestorID bookRequestorID = new BookRequestorID("4", properties.getProperty("api-id"));
        BookSource bookSource = new BookSource(bookRequest.getPos(), bookRequest.getCurrency(), bookRequestorID);
        BookPOS bookPos = new BookPOS(bookSource);
        PickUpLocation pickUpLocation = new PickUpLocation(bookRequest.getPickUpLocation());
        ReturnLocation returnLocation = new ReturnLocation(bookRequest.getDropOffLocation());
        VehRentalCore vehRentalCore = new VehRentalCore(Helper.getFormattedDate(bookRequest.getPickUpDateTime()), Helper.getFormattedDate(bookRequest.getDropOffDateTime())
                , pickUpLocation, returnLocation);
        GivenName givenName = new GivenName(bookRequest.getCustomer().getFirstName());
        Surname surname = new Surname(bookRequest.getCustomer().getLastName());
        NamePrefix namePrefix = new NamePrefix(bookRequest.getCustomer().getTitle());
        PersonName personName = new PersonName(namePrefix, givenName, surname);
        Telephone telephone = new Telephone(bookRequest.getCustomer().getPhone());
        Email email = new Email(bookRequest.getCustomer().getEmail());
        Primary primary = new Primary(personName, email, telephone);
        Customer customer = new Customer(primary);
        VehPref vehPref = new VehPref(bookRequest.getSipp(), "ACRISS");
        Voucher voucher = new Voucher(bookRequest.getBookingReference());
        RentalPaymentPref rentalPaymentPref = new RentalPaymentPref(voucher);
        TourInfo tourInfo = new TourInfo(bookRequest.getSupplier().getId());
        ArrivalDetails arrivalDetails = null;
        if (bookRequest.getFlightDetails() != null) {
            OperatingCompany operatingCompany = new OperatingCompany(bookRequest.getFlightDetails().getAirlineCode());
            arrivalDetails = new ArrivalDetails( "14", bookRequest.getFlightDetails().getFlightNumber(),operatingCompany);
        }
        VendorPref vendorPref = new VendorPref("ZR");
        VehResRQCore vehResRQCore = new VehResRQCore("Available", vehRentalCore, customer, vendorPref, vehPref);
        BookVehResRQInfo bookVehResRQInfo = new BookVehResRQInfo(tourInfo, arrivalDetails, rentalPaymentPref);
        OTAVehResRQ otaVehResRQ = new OTAVehResRQ(properties.getProperty("api-target"), "2.000", "Book",
                "EN", "http://www.opentravel.org/OTA/2003/05",
                "http://www.w3.org/2001/XMLSchema-instance", bookPos, vehResRQCore, bookVehResRQInfo);
        MakeReservation makeReservation = new MakeReservation(otaVehResRQ);
        BookBody body = new BookBody(makeReservation);
        BookHeader header = new BookHeader();
        BookEnvelope bookEnvelope = new BookEnvelope("http://schemas.xmlsoap.org/soap/envelope/",
                "http://www.opentravel.org/OTA/2003/05",
                header, body);
        String xmlRequest = Helper.getStringByMarshalling(bookEnvelope);
        String response = Helper.transaction("http://ota.dollar.com/OTA/2010A/" + "ReservationService.svc", xmlRequest, properties.getProperty("book-action"));

        if (response != null) {
            Helper.isErrorFound(response);
            otaVehResRs = Helper.getObjectByUnmarshalling(response, otaVehResRs, "OTA_VehResRS");
        }

        confIDList = otaVehResRs.getVehResRSCore().getVehReservation().getVehSegmentCore().getConfIDList();

        for(ConfID confID : confIDList){
            if(confID.getIdContext().equals("Committed")){
                domainBook = new DomainBook(otaVehResRs.getVehResRSCore().getReservationStatus(),confID.getId(),null);
                break;
            }
        }
        return domainBook;
    }

    /**
     * Cancel booking based upon confirmation id received during booking process
     *
     * @param cancelRequest
     * @return otaVehCancelRs
     * @throws ApiResponseException
     */
    public static DomainCancel cancel(Cancel cancelRequest) throws ApiResponseException {

        OtaVehCancelRs otaVehCancelRs = new OtaVehCancelRs();
        RequestorID requestorID = new RequestorID("4", properties.getProperty("api-id"));
        SearchSource source = new SearchSource(cancelRequest.getPos(), cancelRequest.getCurrency(), requestorID);
        CancelPOS cancelPos = new CancelPOS(source);
        UniqueId uniqueId = new UniqueId("14", cancelRequest.getBookingReference());
        GivenName givenName = new GivenName(cancelRequest.getDriverFirstName());
        Surname surname = new Surname(cancelRequest.getDriverLastName());
        PersonName personName = new PersonName(null, givenName, surname);
        VehCancelRQCore vehCancelRQCore = new VehCancelRQCore(uniqueId, personName);
        Vendor vendor = new Vendor(cancelRequest.getSupplierCode());
        VehCancelRQInfo vehCancelRQInfo = new VehCancelRQInfo(vendor);
        OTAVehCancelRQ otaVehCancelRQ = new OTAVehCancelRQ(properties.getProperty("api-target"), "2.000", "Cancel", "EN",
                "http://www.opentravel.org/OTA/2003/05", "http://www.w3.org/2001/XMLSchema-instance",
                cancelPos, vehCancelRQCore, vehCancelRQInfo);
        CancelReservation cancelReservation = new CancelReservation(otaVehCancelRQ);
        CancelHeader header = new CancelHeader();
        CancelBody body = new CancelBody(cancelReservation);
        CancelEnvelope cancelEnvelope = new CancelEnvelope("http://schemas.xmlsoap.org/soap/envelope/",
                "http://www.opentravel.org/OTA/2003/05", header, body);
        String xmlRequest = Helper.getStringByMarshalling(cancelEnvelope);
        String response = Helper.transaction("http://ota.dollar.com/OTA/2010A/" + "ReservationService.svc", xmlRequest, properties.getProperty("cancel-action"));

        if (response != null) {
            Helper.isErrorFound(response);
            otaVehCancelRs = Helper.getObjectByUnmarshalling(response, otaVehCancelRs, "OTA_VehCancelRS");
        }
        DomainCancel domainCancel = new DomainCancel(otaVehCancelRs.getVehCancelRSCore().getCancelStatus());
        return domainCancel;
    }
}