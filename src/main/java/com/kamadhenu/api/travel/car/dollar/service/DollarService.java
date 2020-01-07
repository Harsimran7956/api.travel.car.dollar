package com.kamadhenu.api.travel.car.dollar.service;

import com.kamadhenu.api.travel.car.dollar.exception.ApiResponseException;
import com.kamadhenu.api.travel.car.dollar.model.domain.request.Book;
import com.kamadhenu.api.travel.car.dollar.model.domain.request.Cancel;
import com.kamadhenu.api.travel.car.dollar.model.domain.request.Search;
import com.kamadhenu.api.travel.car.dollar.model.supplier.request.book.*;
import com.kamadhenu.api.travel.car.dollar.model.supplier.request.cancel.*;
import com.kamadhenu.api.travel.car.dollar.model.supplier.request.search.*;
import com.kamadhenu.api.travel.car.dollar.model.supplier.request.search.SearchEnvelope;
import com.kamadhenu.api.travel.car.dollar.model.supplier.response.book.OtaVehResRs;
import com.kamadhenu.api.travel.car.dollar.model.supplier.response.cancel.OtaVehCancelRs;
import com.kamadhenu.api.travel.car.dollar.model.supplier.response.search.OtaVehAvailRatesRs;
import com.kamadhenu.api.travel.car.dollar.util.Config;
import com.kamadhenu.api.travel.car.dollar.util.Helper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

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
    public static OtaVehAvailRatesRs search(Search searchRequest) throws ApiResponseException {

        OtaVehAvailRatesRs otaVehAvailRatesRs = new OtaVehAvailRatesRs();
        TourInfo tourInfo = new TourInfo(searchRequest.getTourNumber());
        TourOperator tourOperator = new TourOperator();
        VehAvailRQInfo vehAvailRQInfo = new VehAvailRQInfo(tourInfo, tourOperator);
        PickUpLocation pickUpLocation = new PickUpLocation(searchRequest.getPickUpLocationCode());
        ReturnLocation returnLocation = new ReturnLocation(searchRequest.getDropOffLocationCode());
        VehPref vehPref = new VehPref("ACAR", "ACRISS");
        VehPrefs vehPrefs = new VehPrefs(vehPref);
        VehRentalCore vehRentalCore = new VehRentalCore(Helper.getFormattedDate(searchRequest.getPickUpDateTime()), Helper.getFormattedDate(searchRequest.getDropOffDateTime()),
                pickUpLocation, returnLocation);
        VendorPref vendorPref = new VendorPref("ZT");
        VendorPrefs vendorPrefs = new VendorPrefs(vendorPref);
        VehAvailRQCore vehAvailRQCore = new VehAvailRQCore("Available", vehRentalCore, vendorPrefs, vehPrefs);
        RequestorID requestorID = new RequestorID("4", properties.getProperty("api-id"));
        SearchSource source = new SearchSource(searchRequest.getCountryCode(), searchRequest.getCurrencyCode(), requestorID);
        SearchPos pos = new SearchPos(source);
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
        return otaVehAvailRatesRs;
    }

    /**
     * Book cars depending upon upon pick, drop location and pick , return time
     *
     * @param bookRequest
     * @return otaVehResRs
     * @throws ApiResponseException
     */
    public static OtaVehResRs book(Book bookRequest) throws ApiResponseException {

        OtaVehResRs otaVehResRs = new OtaVehResRs();
        BookRequestorID bookRequestorID = new BookRequestorID("4", properties.getProperty("api-id"));
        BookSource bookSource = new BookSource(bookRequest.getCountryCode(), bookRequest.getCurrencyCode(), bookRequestorID);
        BookPos bookPos = new BookPos(bookSource);
        PickUpLocation pickUpLocation = new PickUpLocation(bookRequest.getPickUpLocationCode());
        ReturnLocation returnLocation = new ReturnLocation(bookRequest.getDropOffLocationCode());
        VehRentalCore vehRentalCore = new VehRentalCore(Helper.getFormattedDate(bookRequest.getPickUpDateTime()), Helper.getFormattedDate(bookRequest.getDropOffDateTime())
                , pickUpLocation, returnLocation);
        GivenName givenName = new GivenName(bookRequest.getFirstName());
        Surname surname = new Surname(bookRequest.getSurName());
        NamePrefix namePrefix = new NamePrefix(bookRequest.getDriverTitle());
        PersonName personName = new PersonName(namePrefix, givenName, surname);
        Telephone telephone = new Telephone(bookRequest.getTelephoneNumber());
        Email email = new Email(bookRequest.getEmail());
        Primary primary = new Primary(personName, email, telephone);
        Customer customer = new Customer(primary);
        VehPref vehPref = new VehPref("IDAR", "ACRISS");
        Voucher voucher = new Voucher(bookRequest.getOurBookingRef());
        RentalPaymentPref rentalPaymentPref = new RentalPaymentPref(voucher);
        TourInfo tourInfo = new TourInfo(bookRequest.getTourNumber());
        OperatingCompany operatingCompany = new OperatingCompany(bookRequest.getFlightCarrier());
        ArrivalDetails arrivalDetails = new ArrivalDetails(operatingCompany);
        VendorPref vendorPref = new VendorPref(bookRequest.getVehicleSipp());
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
//        String response1 = "<s:Envelope xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\"><s:Body xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"><MakeReservationResponse xmlns=\"http://www.opentravel.org/OTA/2003/05\"><OTA_VehResRS Version=\"3.000\" TransactionIdentifier=\"Book\" PrimaryLangID=\"EN\"><Success/><VehResRSCore ReservationStatus=\"Committed\"><VehReservation><Customer><Primary><PersonName><GivenName>TEST</GivenName><Surname>TEST</Surname></PersonName><Telephone PhoneTechType=\"1\" PhoneNumber=\"0123456789\"/><Email>harsimranjeet.singh@kamadhenu.co.in</Email></Primary></Customer><VehSegmentCore><ConfID Type=\"14\" ID=\"J2421665532\" ID_Context=\"Committed\"/><ConfID Type=\"24\" ID=\"EDI\"/><Vendor CompanyShortName=\"DOLLAR\" TravelSector=\"2\" Code=\"ZR\">DOLLAR</Vendor><VehRentalCore PickUpDateTime=\"2020-07-10T15:00:00\" ReturnDateTime=\"2020-07-14T15:00:00\" MultiIslandRentalDays=\"4\"><PickUpLocation LocationCode=\"MLBC01\">CAPE CANAVERAL, FL DLE</PickUpLocation><ReturnLocation LocationCode=\"MCO\">ORLANDO INTERNATIONAL AIRPORT</ReturnLocation></VehRentalCore><Vehicle AirConditionInd=\"true\" TransmissionType=\"Automatic\" PassengerQuantity=\"5\" BaggageQuantity=\"3\" VendorCarType=\"IDAR\" Code=\"IDAR\" CodeContext=\"ACRISS\"><VehType VehicleCategory=\"1\" DoorCount=\"4\"/><VehClass Size=\"6\"/><VehMakeModel Name=\"Toyota Corolla\" Code=\"IDAR\"/><PictureURL>http://www.dollar.com/images/dollar/images/cars/5FE50FF372854D4C9C842E22BC541704.gif</PictureURL></Vehicle><RentalRate><RateDistance Unlimited=\"true\" DistUnitName=\"Mile\" VehiclePeriodUnitName=\"Day\"/><RateDistance Unlimited=\"true\" DistUnitName=\"Mile\" VehiclePeriodUnitName=\"ExtraDay\"/><RateDistance Unlimited=\"true\" DistUnitName=\"Mile\" VehiclePeriodUnitName=\"Hour\"/><VehicleCharges><VehicleCharge Amount=\"180.00\" CurrencyCode=\"USD\" DecimalPlaces=\"2\" Description=\"TIME\" GuaranteedInd=\"true\" IncludedInRate=\"false\" IncludedInEstTotalInd=\"true\" Purpose=\"1\"><Calculation UnitCharge=\"45.00\" UnitName=\"Day\" Quantity=\"4\"/></VehicleCharge></VehicleCharges><RateQualifier RateCategory=\"13\" RateQualifier=\"F5PSL\" RatePeriod=\"Daily\" VendorRateID=\"J242166553\"/></RentalRate><Fees><Fee Amount=\"0.00\" TaxInclusive=\"false\" Description=\"BUS COST REC FEE\" GuaranteedInd=\"false\" IncludedInRate=\"true\" IncludedInEstTotalInd=\"true\" Purpose=\"5\"><Calculation UnitName=\"Day\" Quantity=\"1\"/></Fee><Fee Amount=\"0.00\" TaxInclusive=\"false\" Description=\"ENERGY SURCHARGE\" GuaranteedInd=\"false\" IncludedInRate=\"true\" IncludedInEstTotalInd=\"true\" Purpose=\"5\"><Calculation UnitName=\"Day\" Quantity=\"1\"/></Fee><Fee Amount=\"0.00\" TaxInclusive=\"false\" Description=\"PORT RECOVERY FEE\" GuaranteedInd=\"false\" IncludedInRate=\"true\" IncludedInEstTotalInd=\"true\" Purpose=\"5\"><Calculation UnitName=\"Day\" Quantity=\"1\"/></Fee><Fee Amount=\"0.00\" TaxInclusive=\"false\" Description=\"STATE TRANSACT SRG\" GuaranteedInd=\"false\" IncludedInRate=\"true\" IncludedInEstTotalInd=\"true\" Purpose=\"7\"><Calculation UnitName=\"Day\" Quantity=\"1\"/></Fee><Fee Amount=\"0.00\" TaxInclusive=\"false\" Description=\"STATE TAX\" GuaranteedInd=\"false\" IncludedInRate=\"true\" IncludedInEstTotalInd=\"true\" Purpose=\"7\"><Calculation UnitName=\"Day\" Quantity=\"1\"/></Fee><Fee Amount=\"0.00\" TaxInclusive=\"false\" Description=\"VEHICLE LICENSE FEE\" GuaranteedInd=\"false\" IncludedInRate=\"true\" IncludedInEstTotalInd=\"true\" Purpose=\"5\"><Calculation UnitName=\"Day\" Quantity=\"1\"/></Fee><Fee Amount=\"0.00\" TaxInclusive=\"false\" Description=\"TAX REC FEE\" GuaranteedInd=\"false\" IncludedInRate=\"true\" IncludedInEstTotalInd=\"true\" Purpose=\"7\"><Calculation UnitName=\"Day\" Quantity=\"1\"/></Fee><Fee Amount=\"0.00\" TaxInclusive=\"false\" Description=\"TOURISM FEE\" GuaranteedInd=\"false\" IncludedInRate=\"true\" IncludedInEstTotalInd=\"true\" Purpose=\"5\"><Calculation UnitName=\"Day\" Quantity=\"1\"/></Fee><Fee Amount=\"0.00\" TaxInclusive=\"false\" Description=\"VEHICLE LICENSE FEE\" GuaranteedInd=\"false\" IncludedInRate=\"true\" IncludedInEstTotalInd=\"true\" Purpose=\"5\"><Calculation UnitName=\"Day\" Quantity=\"1\"/></Fee><Fee Amount=\"0.00\" TaxInclusive=\"false\" Description=\"ADD'L DRIVER\" GuaranteedInd=\"false\" IncludedInRate=\"true\" IncludedInEstTotalInd=\"true\" Purpose=\"6\"><Calculation UnitName=\"Day\" Quantity=\"1\"/></Fee><Fee Amount=\"0.00\" TaxInclusive=\"false\" Description=\"AA  AMERICAN AIRLIN\" GuaranteedInd=\"false\" IncludedInRate=\"true\" IncludedInEstTotalInd=\"true\" Purpose=\"5\"><Calculation UnitName=\"Day\" Quantity=\"1\"/></Fee><Fee Amount=\"0.00\" Description=\"SUPPL LIAB INS\" GuaranteedInd=\"false\" IncludedInRate=\"true\" IncludedInEstTotalInd=\"true\" Purpose=\"4\"/><Fee Amount=\"0.00\" Description=\"PRE PAID FUEL\" GuaranteedInd=\"false\" IncludedInRate=\"true\" IncludedInEstTotalInd=\"true\" Purpose=\"24\"><Calculation UnitName=\"Day\" Quantity=\"1\"/></Fee></Fees><TotalCharge RateTotalAmount=\"180.00\" EstimatedTotalAmount=\"180.00\" CurrencyCode=\"USD\" DecimalPlaces=\"2\"/><TPA_Extensions><RateText xmlns=\"\">4 Days at $45.00 per day. Unlimited mileage. </RateText></TPA_Extensions></VehSegmentCore><VehSegmentInfo><RentalPaymentAmount><Voucher SeriesCode=\"ACH-2-20191211\"/></RentalPaymentAmount><PricedCoverages><PricedCoverage><Coverage CoverageType=\"24\"/><Charge Amount=\"0.00\" DecimalPlaces=\"0\" Description=\"Most popular. If anything happens to the car, you pay nothing.\" GuaranteedInd=\"false\" IncludedInRate=\"true\" IncludedInEstTotalInd=\"true\"><MinMax/></Charge></PricedCoverage><PricedCoverage><Coverage CoverageType=\"42\"/><Charge Amount=\"0.00\" DecimalPlaces=\"0\" Description=\"SUPP LIAB PLUS UMP\" GuaranteedInd=\"false\" IncludedInRate=\"true\" IncludedInEstTotalInd=\"true\"><MinMax/></Charge></PricedCoverage></PricedCoverages><VendorMessages><VendorMessage Title=\"Vendor Messages\"><SubSection><Paragraph><Text>VOUCHERLESS</Text></Paragraph><Paragraph><Text>INCLUSIVE ITEMS ARE VEHLICFEE,TAXRECFEE,TAG REC,SLI,BUSCOSTREC,OMB,PORTRECFEE,STATE SRG,STATE TAX,TUF,DRIVR,FFTXRECSRG,LDW1,LIS,PPFUEL</Text></Paragraph><Paragraph><Text>0 DAY ADV BOOKING REQUIRED.  DAILY 1-28</Text></Paragraph><Paragraph><Text>WEEKLY 5-28 DAYS THIS RATE CODE MAY REQUIRE RETURN</Text></Paragraph><Paragraph><Text>TO RENTAL LOCATION SEE CITY DROP POLICY</Text></Paragraph><Paragraph><Text>FIRST TANK OF GAS INCLUDED IN RATE</Text></Paragraph><Paragraph><Text>ONE WAY RENTAL CONFIRMED</Text></Paragraph><Paragraph><Text>ARRIVAL AT OR NEAR LOCATIONS OPENING OR CLOSING HOURS</Text></Paragraph></SubSection></VendorMessage><VendorMessage Title=\"Policies\"><SubSection><Paragraph><Text>Additional drivers must qualify with a valid driver's license in their own name. Additional charges may apply.</Text></Paragraph><Paragraph><Text>After hours returns - Drop box is located outside the office, note mileage and time of return on the rental jacket, place contract and keys in the drop box.</Text></Paragraph><Paragraph><Text>Loss Damage Waiver (LDW) and Liability Insurance Supplement (LIS) are optional. Additional charges apply.</Text></Paragraph><Paragraph><Text>Vehicles rented in the United States may not be driven into Mexico without obtaining Mexico Insurance at the rental counter. Mexico Insurance provides a customer with liability and damage protection on the rental vehicle to be in compliance with Mexican law when visiting Mexico. No off-road driving is permitted.</Text></Paragraph><Paragraph><Text>To qualify to rent a Dollar vehicle, the renter must present at the time of rental a valid driver’s license and valid major credit card or debit card (see Debit Card Usage below) in the renter's own name with available credit and funds. Non-prepaid Debit cards issued under a VISA, MasterCard or Discover logo which draw funds directly from the cardholder’s account may be used at the outset of a rental.  If the reservation was made within 24 hours of rental or if the customer is renting a convertible, premium, Dream or luxury car class, then a non-prepaid debit card with a VISA, Mastercard or Discover logo may be used as long as the following requirements are met: present two (2) valid forms of identification; and proof of a return travel ticket to coincide with the rental (airline/train/cruise). At the time of rental, an authorized hold will be secured on your credit/debit card provided to cover the estimated rental charges and any additional charges that may be incurred. These funds will not be available for your use for the duration of the rental. We will place an authorization amount of $200 plus the cost of the rental. The above incremental hold will not be applied to established EXPRESS members with a VISA card in their profile. If Dollar cannot secure credit approval or funds for this amount and/or proper identification credentials are not supplied, Dollar will decline your rental. Upon completion of rental, a different debit or credit card can be accepted for payment at the end of your rental. Cash rentals which require an up-front deposit of cash are accepted from customers who have obtained a Cash Deposit Identification (ID) Card. Applications for a Cash Deposit ID Card are available from Dollar.com. Prepaid Debit cards or store value cards are accepted for payment at the end of your rental.  Franchise locations may set their own requirements for debit card acceptance.  Please contact location for more details.</Text></Paragraph><Paragraph><Text>At time of rental, customers paying with a debit or credit card at ALL locations will have a $200 incidental amount added to their estimated total. These funds will not be available for their use. No incidental amount will be added for established Dollar EXPRESS members with a VISA debit card in their profile.</Text></Paragraph><Paragraph><Text>If a person renews their FL driver’s license, they are not allowed to keep/use the expired drivers license.  They are issued a receipt of paper from the DMV to prove they have renewed their license and are waiting on their new Driver's License.  This receipt of paper will expire in 30 days, the receipt is dated and the location will run the Florida Drivers License through the DMV. The location will accept the receipt as a valid drivers license.</Text></Paragraph><Paragraph><Text>When the renter chooses to receive Frequent Flyer miles, we will collect a Frequent Flyer surcharge, not to exceed $1.50 per day, at the time of rental to offset a portion of the annual cost of participation in the Frequent Flyer program.</Text></Paragraph><Paragraph><Text>Reservations will be honored for 2 hours after the original scheduled pick up time, unless the location has closed for the day.</Text></Paragraph><Paragraph><Text>Miami Port Drop-off Information:*** Vehicles may NOT be returned to the Port of Miami.***Customers needing shuttle service to the Port of Miami must book the Miami Cruise Ship location (Dollar – MIAP01/Thrifty – PM4), as the return location and return the vehicle to the Dollar or Thrifty rental counter at 3900 NW 25th Street (Miami Airport location).  A shuttle will take you to the Port of Miami.</Text></Paragraph><Paragraph><Text>We prohibit smoking in ALL vehicles.  If any evidence of smoking is found, a cleaning fee will apply.</Text></Paragraph><Paragraph><Text>Rental Office is located 4.2 miles away from the Port Canaveral Cruise Terminal. Pick up from Cruise Line:  Shuttle Bus Service is offered to and from the Cruise Terminal. No phone call is needed as shuttle runs continuously. Please ask the Lobby Attendants working in the Cruise Terminal on where to find the Dollar Thrifty Shuttle Bus.</Text></Paragraph><Paragraph><Text>Many roads throughout the United States are “all-electronic,” which means that there is not an option to pay for tolls with cash or credit/debit cards when utilizing these toll roads.  As a convenience, Dollar offers its customers an all-inclusive tolling product - PlatePass® - which is an optional product to pay for all electronic tolls that the customer encounters during his/her rental.  If a customer declines the PlatePass® option, Dollar will charge the customer the cash/highest undiscounted price for each electronic toll incurred plus a $15.00 administrative fee (FL and MA - $9.99 per occurrence) for each toll incurred (subject to a $90.00 cap for such toll-related administrative fees for the rental period) unless the customer makes some other arrangement to directly pay for the electronic tolls he/she incurs.  These toll-related charges can be avoided by staying off toll roads, using a personal transponder – where permitted – or by making direct-pay arrangements with the toll authority – where allowed.</Text></Paragraph><Paragraph><Text>Customers who do not purchase our refueling option must refill the vehicle within a 10 mile radius of the rental return facility and present a fuel receipt to avoid refueling charges.</Text></Paragraph><Paragraph><Text>A valid driver's license in the customer's own name must be presented at the time of pick up. The minimum age to rent a vehicle at most locations in the United States and Canada is 20 years of age. In Michigan, New York, and the province of Quebec, the minimum age to rent a vehicle is 18. Please see special Vehicle Requirements. Renters under 25 may be subject to an additional fee. International Renters must present a valid license from their country of residence.  An International Driving Permit (IDP) is strongly recommended for a driver’s license that is in a language other than English. Renters with driver’s licenses issued outside of the United States must provide a valid passport.  Learner Permits or Photocopies are NOT accepted.</Text></Paragraph><Paragraph><Text>Any changes to the reservation or rental may result in a change of rate or additional fees.</Text></Paragraph></SubSection></VendorMessage></VendorMessages><LocationDetails AtAirport=\"false\" Code=\"MLBC01\" Name=\"CAPE CANAVERAL, FL DLE\" ExtendedLocationCode=\"MLBC01\"><Address><AddressLine>6799 NORTH ATLANTIC AVE</AddressLine><CityName>CAPE CANAVERAL</CityName><PostalCode>32920</PostalCode><StateProv StateCode=\"FL\">FLORIDA</StateProv><CountryName Code=\"US\">UNITED STATES</CountryName></Address><Telephone PhoneTechType=\"1\" PhoneNumber=\"321-799-2945\"/><Telephone PhoneTechType=\"3\" PhoneNumber=\"321 799-1027\"/><AdditionalInfo><CounterLocation Location=\"7\"/><OperationSchedules><OperationSchedule><OperationTimes><OperationTime Mon=\"true\" Start=\"07:30:00+00:00\" End=\"15:30:00+00:00\"/><OperationTime Thur=\"true\" Start=\"07:30:00+00:00\" End=\"15:30:00+00:00\"/><OperationTime Fri=\"true\" Start=\"07:30:00+00:00\" End=\"15:30:00+00:00\"/><OperationTime Sat=\"true\" Start=\"07:30:00+00:00\" End=\"15:30:00+00:00\"/><OperationTime Sun=\"true\" Start=\"07:30:00+00:00\" End=\"15:30:00+00:00\"/></OperationTimes></OperationSchedule></OperationSchedules></AdditionalInfo></LocationDetails><LocationDetails AtAirport=\"true\" Code=\"MCO\" Name=\"ORLANDO INTERNATIONAL AIRPORT\" ExtendedLocationCode=\"MCO\"><Address><AddressLine>9201 AIRPORT BLVD</AddressLine><CityName>ORLANDO</CityName><PostalCode>32827</PostalCode><County>ORANGE</County><StateProv StateCode=\"FL\">FLORIDA</StateProv><CountryName Code=\"US\">UNITED STATES</CountryName></Address><Telephone PhoneTechType=\"1\" PhoneNumber=\"(866) 434-2226\"/><AdditionalInfo><CounterLocation Location=\"1\"/><OperationSchedules><OperationSchedule><OperationTimes><OperationTime Mon=\"true\" Tue=\"true\" Weds=\"true\" Thur=\"true\" Fri=\"true\" Sat=\"true\" Sun=\"true\" Start=\"00:00:00\" End=\"23:59:00\"/></OperationTimes></OperationSchedule></OperationSchedules></AdditionalInfo></LocationDetails><TourInfo TourNumber=\"IT1005256PSL\"><TourOperator/></TourInfo><TPA_Extensions><RateText xmlns=\"\">4 Days at $45.00 per day. Unlimited mileage. </RateText></TPA_Extensions></VehSegmentInfo></VehReservation></VehResRSCore></OTA_VehResRS></MakeReservationResponse></s:Body></s:Envelope>";

        if (response != null) {

            Helper.isErrorFound(response);
            otaVehResRs = Helper.getObjectByUnmarshalling(response, otaVehResRs, "OTA_VehResRS");
        }

        return otaVehResRs;
    }

    /**
     * Cancel booking based upon confirmation id received during booking process
     *
     * @param cancelRequest
     * @return otaVehCancelRs
     * @throws ApiResponseException
     */
    public static OtaVehCancelRs cancel(Cancel cancelRequest) throws ApiResponseException {

        OtaVehCancelRs otaVehCancelRs = new OtaVehCancelRs();
        RequestorID requestorID = new RequestorID("4", properties.getProperty("api-id"));
        SearchSource source = new SearchSource(cancelRequest.getCountryCode(), cancelRequest.getCurrencyCode(), requestorID);
        CancelPos cancelPos = new CancelPos(source);
        UniqueId uniqueId = new UniqueId("14", cancelRequest.getBookingRef());
        GivenName givenName = new GivenName(cancelRequest.getGivenName());
        Surname surname = new Surname(cancelRequest.getSurName());
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
//            String response1 = "<s:Envelope xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\"><s:Body xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"><CancelReservationResponse xmlns=\"http://www.opentravel.org/OTA/2003/05\"><OTA_VehCancelRS Version=\"4.000\" TransactionIdentifier=\"Cancel\" PrimaryLangID=\"EN\"><Success/><VehCancelRSCore CancelStatus=\"Cancelled\"><UniqueID Type=\"15\" ID=\"J2421665532\" ID_Context=\"Cancelled\"/></VehCancelRSCore><VehCancelRSInfo><VehReservation><Customer><Primary><PersonName><GivenName>TEST</GivenName><Surname>TEST</Surname></PersonName><Telephone PhoneTechType=\"1\" PhoneNumber=\"0123456789\"/><Email>harsimranjeet.singh@kamadhenu.co.in</Email></Primary></Customer><VehSegmentCore><ConfID Type=\"14\" ID=\"J2421665532\" ID_Context=\"Cancelled\"/><Vendor CompanyShortName=\"DOLLAR\" TravelSector=\"2\" Code=\"ZR\">DOLLAR</Vendor><VehRentalCore PickUpDateTime=\"2020-07-10T15:00:00\" ReturnDateTime=\"2020-07-14T15:00:00\" MultiIslandRentalDays=\"4\"><PickUpLocation>CAPE CANAVERAL, FL DLE</PickUpLocation><ReturnLocation>ORLANDO INTERNATIONAL AIRPORT</ReturnLocation></VehRentalCore><Vehicle AirConditionInd=\"true\" TransmissionType=\"Automatic\" PassengerQuantity=\"5\" BaggageQuantity=\"3\" VendorCarType=\"IDAR\" Code=\"IDAR\" CodeContext=\"ACRISS\"><VehType VehicleCategory=\"1\" DoorCount=\"4\"/><VehClass Size=\"6\"/><VehMakeModel Name=\"Toyota Corolla\" Code=\"IDAR\"/><PictureURL>http://www.dollar.com/images/dollar/images/cars/5FE50FF372854D4C9C842E22BC541704.gif(9 kB)\n" +
//                    "http://www.dollar.com/images/dollar/images/cars/5FE50FF372854D4C9C842E22BC541704.gif\n" +
//                    "</PictureURL></Vehicle></VehSegmentCore><VehSegmentInfo/></VehReservation></VehCancelRSInfo></OTA_VehCancelRS></CancelReservationResponse></s:Body></s:Envelope>";
        return otaVehCancelRs;
    }
}