package com.kamadhenu.api.travel.car.dollar.model.supplier.response.search;

import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@Data
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class VendorMessage {

    @XmlAttribute(name = "Title")
    private String title;

    @XmlAttribute(name = "InfoType")
    private String infoType;

    @XmlElement(name = "SubSection")
    private SubSection subSection;
}
