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
public class VehicleCharge {

    @XmlAttribute(name = "Amount")
    private double amount;

    @XmlAttribute(name = "CurrencyCode")
    private String currencyCode;

    @XmlAttribute(name = "DecimalPlaces")
    private String decimalPlaces;

    @XmlAttribute(name = "Description")
    private String description;

    @XmlAttribute(name = "GuaranteedInd")
    private String guaranteedInd;

    @XmlAttribute(name = "IncludedInEstTotalInd")
    private Boolean includedInEstTotalInd;

    @XmlAttribute(name = "Purpose")
    private String purpose;

    @XmlElement(name = "Calculation")
    private Calculation calculation;
}
