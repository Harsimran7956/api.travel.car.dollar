package com.kamadhenu.api.travel.car.dollar.model.supplier.response.search;

import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@Data
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class PricedCoverageCharge {

    @XmlAttribute(name = "Charge")
    private String charge;

    @XmlAttribute(name = "DecimalPlaces")
    private String decimalPlaces;

    @XmlAttribute(name = "Description")
    private String description;

    @XmlAttribute(name = "GuaranteedInd")
    private String guaranteedInd;

    @XmlAttribute(name = "IncludedInRate")
    private String includedInRate;

    @XmlAttribute(name = "IncludedInEstTotalInd")
    private String includedInEstTotalInd;
}
