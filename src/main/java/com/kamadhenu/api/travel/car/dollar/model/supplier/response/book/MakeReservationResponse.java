package com.kamadhenu.api.travel.car.dollar.model.supplier.response.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Data
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class MakeReservationResponse {

    @XmlElement(name = "OTA_VehResRS")
    private OtaVehResRs otaVehResRs;
}
