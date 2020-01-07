package com.kamadhenu.api.travel.car.dollar.model.supplier.response.search;

import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@Data
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class RentalRate {

    @XmlElement(name = "RateDistance")
    private List<RateDistance> rateDistanceList;

    @XmlElement(name = "VehicleCharges")
    private VehicleCharges vehicleCharges;

    @XmlElement(name = "RateQualifier")
    private RateQualifier rateQualifier;

    @XmlElement(name = "RateRestrictions")
    private RateRestrictions rateRestrictions;
}
