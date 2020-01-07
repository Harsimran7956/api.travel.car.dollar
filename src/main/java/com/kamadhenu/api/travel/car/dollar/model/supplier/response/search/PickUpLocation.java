package com.kamadhenu.api.travel.car.dollar.model.supplier.response.search;

import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.*;

@Data
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class PickUpLocation {

    @XmlAttribute(name = "LocationCode")
    private String locationCode;

    @XmlAttribute(name = "ExtendedLocationCode")
    private String extendedLocationCode;

    @XmlValue
    private String value;
}
