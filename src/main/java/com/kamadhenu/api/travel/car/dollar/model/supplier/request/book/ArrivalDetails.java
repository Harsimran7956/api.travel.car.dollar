package com.kamadhenu.api.travel.car.dollar.model.supplier.request.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.*;

@Data
@ToString
@AllArgsConstructor
@XmlRootElement(name = "OTA_VehResRQ")
@XmlAccessorType(XmlAccessType.FIELD)
public class ArrivalDetails {

    ArrivalDetails() {
    }

    @XmlAttribute(name = "TransportationCode")
    private String transportationCode;

    @XmlAttribute(name = "Number")
    private String flightCode;

    @XmlElement(name = "OperatingCompany")
    private OperatingCompany operatingCompany;
}
