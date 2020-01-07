package com.kamadhenu.api.travel.car.dollar.model.supplier.response.book;

import com.kamadhenu.api.travel.car.dollar.model.supplier.response.search.Success;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@Data
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class OtaVehResRs {

    @XmlAttribute(name = "Version")
    private String version;

    @XmlAttribute(name = "TransactionIdentifier")
    private String transactionIdentifier;

    @XmlAttribute(name = "PrimaryLangID")
    private String primaryLangID;

    @XmlElement(name = "Success")
    private Success success;

    @XmlElement(name = "VehResRSCore")
    private VehResRSCore vehResRSCore;
}
