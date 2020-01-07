package com.kamadhenu.api.travel.car.dollar.model.supplier.response.search;

import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.*;

@Data
@ToString
@XmlRootElement(name = "OTA_VehAvailRateRS")
@XmlAccessorType(XmlAccessType.FIELD)
public class OtaVehAvailRatesRs {

    @XmlAttribute(name = "Target")
    private String target;

    @XmlAttribute(name = "Version")
    private String version;

    @XmlAttribute(name = "TransactionIdentifier")
    private String transactionIdentifier;

    @XmlAttribute(name = "PrimaryLangID")
    private String primaryLangID;

    @XmlAttribute(name = "AltLangID")
    private String altLangID;

    @XmlElement(name = "Success")
    private Success success;

    @XmlElement(name = "VehAvailRSCore")
    private VehAvailRSCore vehAvailRSCore;
}
