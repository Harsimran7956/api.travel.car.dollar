package com.kamadhenu.api.travel.car.dollar.model.supplier.response.search;

import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@Data
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class Calculation {

    @XmlAttribute(name = "UnitCharge")
    private String unitCharge;

    @XmlAttribute(name = "UnitName")
    private String unitName;

    @XmlAttribute(name = "Quantity")
    private String quantity;
}
