package com.kamadhenu.api.travel.car.dollar.model.supplier.response.cancel;

import com.kamadhenu.api.travel.car.dollar.model.supplier.response.book.VehReservation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Data
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class VehCancelRSInfo {

    @XmlElement(name ="VehReservation")
    private VehReservation vehReservation;
}
