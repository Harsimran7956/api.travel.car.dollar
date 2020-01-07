package com.kamadhenu.api.travel.car.dollar.model.supplier.response.search;

import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Data
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class Address {

    @XmlElement(name = "AddressLine")
    private AddressLine addressLine;

    @XmlElement(name = "CityName")
    private CityName cityName;

    @XmlElement(name = "PostalCode")
    private PostalCode postalCode;

    @XmlElement(name = "County")
    private County county;

    @XmlElement(name = "CountryName")
    private CountryName countryName;
}
