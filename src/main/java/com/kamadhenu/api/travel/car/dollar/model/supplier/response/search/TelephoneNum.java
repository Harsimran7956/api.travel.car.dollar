package com.kamadhenu.api.travel.car.dollar.model.supplier.response.search;

import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@Data
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class TelephoneNum {

    @XmlAttribute(name = "PhoneTechType")
    private String phoneTechType;

    @XmlAttribute(name = "PhoneNumber")
    private String phoneNumber;
}
