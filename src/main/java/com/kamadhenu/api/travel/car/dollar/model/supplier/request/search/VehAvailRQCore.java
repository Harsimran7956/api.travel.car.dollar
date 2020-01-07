package com.kamadhenu.api.travel.car.dollar.model.supplier.request.search;

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
public class VehAvailRQCore {

    @XmlAttribute(name = "Status")
    private String status;

    @XmlElement(name = "VehRentalCore")
    private VehRentalCore vehRentalCore;

    @XmlElement(name = "VendorPrefs")
    private VendorPrefs vendorPrefs;

    @XmlElement(name = "VehPrefs")
    private VehPrefs vehPrefs;
}
