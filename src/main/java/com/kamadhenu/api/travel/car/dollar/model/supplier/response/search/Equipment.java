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
public class Equipment {

    @XmlAttribute(name = "EquipType")
    private String equipType;

    @XmlAttribute(name = "Quantity")
    private String quantity;

    @XmlElement(name = "Charge")
    private Charge charge;
}
