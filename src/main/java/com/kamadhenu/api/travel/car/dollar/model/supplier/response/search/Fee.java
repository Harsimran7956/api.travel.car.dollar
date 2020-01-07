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
public class Fee {

    @XmlAttribute(name = "Amount")
    private String amount;

    @XmlAttribute(name = "Description")
    private String description;

    @XmlAttribute(name = "GuaranteedInd")
    private String guaranteedInd;

    @XmlAttribute(name = "IncludedInRate")
    private String includedInRate;

    @XmlAttribute(name = "IncludedInEstTotalInd")
    private String includedInEstTotalInd;

    @XmlAttribute(name = "Purpose")
    private String purpose;

    @XmlElement(name = "Calculation")
    private ChargeCalculation chargeCalculation;
}
