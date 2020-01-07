package com.kamadhenu.api.travel.car.dollar.model.supplier.response.search;

import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@Data
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class VehRentalCore {

    @XmlAttribute(name = "PickUpDateTime")
    private String pickUpDateTime;

    @XmlAttribute(name = "ReturnDateTime")
    private String returnDateTime;

    @XmlAttribute(name = "MultiIslandRentalDays")
    private String multiIslandRentalDays;

    @XmlElement(name = "PickUpLocation")
    private PickUpLocation pickUpLocation;

    @XmlElement(name = "ReturnLocation")
    private ReturnLocation returnLocation;
}
