package com.kamadhenu.api.travel.car.dollar.model.supplier.request.xsellItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.*;

@Data
@ToString
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class PickUpLocationX {

    @XmlAttribute( name= "LocationCode")
    private String locationCode;
}
