package com.kamadhenu.api.travel.car.dollar.model.supplier.response.cancel;

import com.kamadhenu.api.travel.car.dollar.model.supplier.response.search.Success;
import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.*;

@Data
@ToString
@XmlRootElement(name = "OTA_VehCancelRS")
@XmlAccessorType(XmlAccessType.FIELD)
public class OtaVehCancelRs {

    @XmlAttribute(name = "Version")
    private String version;

    @XmlAttribute(name = "TransactionIdentifier")
    private String transactionIdentifier;

    @XmlAttribute(name = "PrimaryLangID")
    private String primaryLangID;

    @XmlElement(name = "Success")
    private Success success;

    @XmlElement(name = "VehCancelRSCore")
    private VehCancelRSCore vehCancelRSCore;

    @XmlElement(name = "VehCancelRSInfo")
    private VehCancelRSInfo vehCancelRSInfo;
}
