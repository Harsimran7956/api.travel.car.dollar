package com.kamadhenu.api.travel.car.dollar.model.supplier.request.search;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.*;

@Data
@ToString
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class VehRentalCore {

    VehRentalCore(){}

    @XmlAttribute( name= "PickUpDateTime")
    private String pickUpDateTime;

    @XmlAttribute( name= "ReturnDateTime")
    private String returnDateTime;

    @XmlElement(name = "PickUpLocation")
    private PickUpLocation pickUpLocation;

    @XmlElement(name = "ReturnLocation")
    private ReturnLocation returnLocation;
}
