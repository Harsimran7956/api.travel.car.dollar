package com.kamadhenu.api.travel.car.dollar.model.supplier.request.cancel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.*;

@Data
@ToString
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class CancelReservation {

    @XmlElement(name = "OTA_VehCancelRQ")
    private OTAVehCancelRQ otaVehCancelRQ;
}
