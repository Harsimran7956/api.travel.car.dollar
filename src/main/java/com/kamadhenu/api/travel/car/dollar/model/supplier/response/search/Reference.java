package com.kamadhenu.api.travel.car.dollar.model.supplier.response.search;

import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@Data
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class Reference {

    @XmlAttribute(name = "Type")
    private String type;

    @XmlAttribute(name = "ID")
    private String id;

    @XmlAttribute(name = "ID_Context")
    private String idContext;

    @XmlAttribute(name = "DateTime")
    private String dateTime;
}
