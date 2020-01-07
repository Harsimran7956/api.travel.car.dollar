package com.kamadhenu.api.travel.car.dollar.model.supplier.request.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.*;

@Data
@ToString
@AllArgsConstructor
@XmlRootElement(name = "OTA_VehResRQ")
@XmlAccessorType(XmlAccessType.FIELD)
public class OTAVehResRQ {

    OTAVehResRQ(){}

    @XmlAttribute(name = "Target")
    private String target;

    @XmlAttribute(name = "Version")
    private String version;

    @XmlAttribute(name = "TransactionIdentifier")
    private String transactionIdentifier;

    @XmlAttribute(name = "PrimaryLangID")
    private String primaryLangID;

    @XmlAttribute(name = "xmlns")
    private String xmlns;

    @XmlAttribute(name = "xmlns:xsi")
    private String xmlnsxsi;

    @XmlElement(name = "POS")
    private BookPos bookPos;

    @XmlElement(name = "VehResRQCore")
    private VehResRQCore vehResRQCore;

    @XmlElement(name = "VehResRQInfo")
    private BookVehResRQInfo bookVehResRQInfo;
}
