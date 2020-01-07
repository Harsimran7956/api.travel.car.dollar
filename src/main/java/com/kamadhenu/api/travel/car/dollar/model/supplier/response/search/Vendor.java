package com.kamadhenu.api.travel.car.dollar.model.supplier.response.search;

import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.*;

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
