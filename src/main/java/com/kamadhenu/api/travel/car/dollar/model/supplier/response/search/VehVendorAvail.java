package com.kamadhenu.api.travel.car.dollar.model.supplier.response.search;

import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Data
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class VehVendorAvail {

    @XmlElement(name = "Vendor")
    private Vendor vedor;

    @XmlElement(name = "VehAvails")
    private VehAvails vehAvails;

    @XmlElement(name = "Info")
    private Info info;
}
