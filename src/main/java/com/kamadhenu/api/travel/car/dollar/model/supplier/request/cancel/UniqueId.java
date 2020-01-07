package com.kamadhenu.api.travel.car.dollar.model.supplier.request.cancel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.*;

@Data
@ToString
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class UniqueId {

    @XmlAttribute(name = "Type")
    private String type;

    @XmlAttribute(name = "ID")
    private String id;
}
