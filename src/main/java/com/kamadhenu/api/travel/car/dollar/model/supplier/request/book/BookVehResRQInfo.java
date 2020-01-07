package com.kamadhenu.api.travel.car.dollar.model.supplier.request.book;

import com.kamadhenu.api.travel.car.dollar.model.supplier.request.search.TourInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.*;

@Data
@ToString
@AllArgsConstructor
@XmlRootElement(name = "OTA_VehResRQ")
@XmlAccessorType(XmlAccessType.FIELD)
public class BookVehResRQInfo {

    BookVehResRQInfo(){}

    @XmlElement(name = "TourInfo")
    private TourInfo tourInfo;

    @XmlElement(name = "ArrivalDetails")
    private ArrivalDetails arrivalDetails;

    @XmlElement(name = "RentalPaymentPref")
    private RentalPaymentPref rentalPaymentPref;
}
