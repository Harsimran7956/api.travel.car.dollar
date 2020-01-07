package com.kamadhenu.api.travel.car.dollar.model.supplier.request.xsellItem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.*;

@Data
@ToString
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class VehRentalCoreX {

    @XmlAttribute( name= "PickUpDateTime")
    private String pickUpDateTime;

    @XmlAttribute( name= "ReturnDateTime")
    private String returnDateTime;

    @XmlElement(name = "PickUpLocation")
    private PickUpLocationX pickUpLocationX;

    @XmlElement(name = "ReturnLocation")
    private ReturnLocationX returnLocationX;
}
