package com.kamadhenu.api.travel.car.dollar.model.supplier.request.xsellItem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.*;

@Data
@ToString
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class OTAVehAvailRateRQX {

    OTAVehAvailRateRQX(){}

    @XmlAttribute(name = "xmlns")
    private String xmlns;

    @XmlAttribute(name = "xmlns:xsi")
    private String xmlnsxsi;

    @XmlAttribute(name = "xsi:schemaLocation")
    private String xsiSchemaLocation;

    @XmlAttribute(name = "Target")
    private String Target;

    @XmlAttribute(name = "Version")
    private String version;

    @XmlAttribute(name = "PrimaryLangID")
    private String primaryLangID;

    @XmlAttribute(name = "TransactionIdentifier")
    private String transactionIdentifier;

    @XmlElement(name = "POS")
    private POSX POSX;

    @XmlElement(name = "VehAVailRQCore")
    private VehAvailRQCoreX vehAvailRQCoreX;

    @XmlElement(name = "VehAvailRQInfo")
    private VehAvailRQInfoX vehAvailRQInfoX;


}
