package com.kamadhenu.api.travel.car.dollar.model.supplier.response.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

@Data
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class Vendor {

    @XmlAttribute(name = "CompanyShortName")
    private String companyShortName;

    @XmlAttribute(name = "TravelSector")
    private String travelSector;

    @XmlAttribute(name = "Code")
    private String code;

    @XmlValue
    private String value;
}
