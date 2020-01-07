package com.kamadhenu.api.travel.car.dollar.model.supplier.request.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Data
@ToString
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class MakeReservation {

    MakeReservation(){}

    @XmlElement(name = "OTA_VehResRQ")
    private OTAVehResRQ otaVehResRQ;
}
