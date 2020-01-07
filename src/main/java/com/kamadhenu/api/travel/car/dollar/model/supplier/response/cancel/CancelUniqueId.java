package com.kamadhenu.api.travel.car.dollar.model.supplier.response.cancel;

import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.*;

@Data
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class CancelUniqueId {

    @XmlAttribute(name = "Type")
    private String type;

    @XmlAttribute(name = "ID")
    private String id;

    @XmlAttribute(name = "ID_Context")
    private String idContext;
}
