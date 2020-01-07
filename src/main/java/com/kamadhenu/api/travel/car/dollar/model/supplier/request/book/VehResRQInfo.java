package com.kamadhenu.api.travel.car.dollar.model.supplier.request.book;

import com.kamadhenu.api.travel.car.dollar.model.supplier.request.search.TourInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.*;

@Data
@ToString
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class VehResRQInfo {

    VehResRQInfo(){}

    @XmlElement(name = "TourInfo")
    private TourInfo tourInfo;

    @XmlElement(name = "arrivalDetails")
    private ArrivalDetails ArrivalDetails;


    @XmlElement(name = "RentalPaymentPref")
    private RentalPaymentPref rentalPaymentPref;

}
