package com.kamadhenu.api.travel.car.dollar.model.supplier.response.search;

import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlValue;

@Data
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class AddressLine {

    @XmlValue
    private String value;
}
