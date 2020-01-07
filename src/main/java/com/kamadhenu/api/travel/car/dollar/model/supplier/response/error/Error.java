package com.kamadhenu.api.travel.car.dollar.model.supplier.response.error;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

/**
 * Error Response Model for Unmarshalling
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Error {

    @XmlAttribute(name = "Type")
    private String type;

    @XmlAttribute(name = "ShortText")
    private String shortText;
}
