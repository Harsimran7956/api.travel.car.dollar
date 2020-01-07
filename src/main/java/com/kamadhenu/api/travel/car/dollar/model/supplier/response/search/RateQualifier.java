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
public class RateQualifier {

    @XmlAttribute(name = "RateCategory")
    private String rateCategory;

    @XmlAttribute(name = "RateQualifier")
    private String rateQualifier;

    @XmlAttribute(name = "RatePeriod")
    private String ratePeriod;

    @XmlAttribute(name = "VendorRateID")
    private String vendorRateID;

    @XmlAttribute(name = "TourInfoRPH")
    private String tourInfoRPH;

    @XmlElement(name = "RateComments")
    private RateComments rateComments;
}
