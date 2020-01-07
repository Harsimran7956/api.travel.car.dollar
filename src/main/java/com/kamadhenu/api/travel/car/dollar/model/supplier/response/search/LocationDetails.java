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
public class LocationDetails {

    @XmlAttribute(name = "AtAirport")
    private String atAirport;

    @XmlAttribute(name = "Code")
    private String code;

    @XmlAttribute(name = "Name")
    private String name;

    @XmlAttribute(name = "ExtendedLocationCode")
    private String extendedLocationCode;

    @XmlElement(name = "Address")
    private Address address;

    @XmlElement(name = "Telephone")
    private TelephoneNum telephoneNum;

    @XmlElement(name = "AdditionalInfo")
    private AdditionalInfo additionalInfo;
}
