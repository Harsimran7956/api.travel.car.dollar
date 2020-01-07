package com.kamadhenu.api.travel.car.dollar.model.supplier.request.cancel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.*;

@Data
@ToString
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class OTAVehCancelRQ {

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
    private CancelPos posc;

    @XmlElement(name = "VehCancelRQCore")
    private VehCancelRQCore vehCancelRQCore;

    @XmlElement(name = "VehCancelRQInfo")
    private VehCancelRQInfo vehCancelRQInfo;
}
