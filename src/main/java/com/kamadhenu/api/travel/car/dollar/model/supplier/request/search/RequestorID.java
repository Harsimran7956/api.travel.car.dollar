package com.kamadhenu.api.travel.car.dollar.model.supplier.request.search;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.*;

@Data
@ToString
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class RequestorID {

    @XmlAttribute( name= "Type")
    private String type;

    @XmlAttribute( name= "ID")
    private String id;

}
