package com.kamadhenu.api.travel.car.dollar.model.supplier.request.xsellItem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@Data
@ToString
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class VehAvailRQCoreX {

    @XmlAttribute(name = "Status")
    private String status;

    @XmlElement(name = "VehRentalCore")
    private VehRentalCoreX vehRentalCoreX;

    @XmlElement(name = "VendorPrefs")
    private VendorPrefsX vendorPrefsX;

    @XmlElement(name = "VehPrefs")
    private VehPrefsX vehPrefsX;

    @XmlElement(name = "RateQualifier")
    private RateQualifier rateQualifier;
}
