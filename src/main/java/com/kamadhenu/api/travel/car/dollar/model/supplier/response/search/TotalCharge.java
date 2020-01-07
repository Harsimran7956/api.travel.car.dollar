package com.kamadhenu.api.travel.car.dollar.model.supplier.response.search;

import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@Data
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class TotalCharge {

    @XmlAttribute(name = "RateTotalAmount")
    private String rateTotalAmount;

    @XmlAttribute(name = "EstimatedTotalAmount")
    private String estimatedTotalAmount;

    @XmlAttribute(name = "DecimalPlaces")
    private String decimalPlaces;
}
