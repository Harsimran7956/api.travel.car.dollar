package com.kamadhenu.api.travel.car.dollar.model.supplier.response.cancel;

import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.*;

@Data
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class VehCancelRSCore {

    @XmlAttribute(name = "CancelStatus")
    private String cancelStatus;

    @XmlElement(name = "UniqueID")
    private CancelUniqueId cancelUniqueId;
}
