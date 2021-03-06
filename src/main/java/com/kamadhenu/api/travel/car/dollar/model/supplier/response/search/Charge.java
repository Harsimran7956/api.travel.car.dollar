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
public class Charge {

    @XmlAttribute(name = "Amount")
    private double amount;

    @XmlAttribute(name = "DecimalPlaces")
    private String decimalPlaces;

    @XmlAttribute(name = "Description")
    private String description;

    @XmlAttribute(name = "GuaranteedInd")
    private String guaranteedInd;

    @XmlAttribute(name = "IncludedInRate")
    private Boolean includedInRate;

    @XmlAttribute(name = "IncludedInEstTotalInd")
    private String includedInEstTotalInd;

    @XmlElement(name = "MinMax")
    private MinMax minMax;

    @XmlElement(name = "Calculation")
    private ChargeCalculation chargeCalculation;
}
