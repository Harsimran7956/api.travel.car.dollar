package com.kamadhenu.api.travel.car.dollar.model.supplier.response.search;

import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@Data
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class TourInfo {

    @XmlAttribute(name = "TourNumber")
    private String tourNumber;

    @XmlAttribute(name = "RPH")
    private String rph;
}
