package com.kamadhenu.api.travel.car.dollar.model.supplier.response.book;

import com.kamadhenu.api.travel.car.dollar.model.supplier.request.book.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Data
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class VehReservation {

    @XmlElement(name = "Customer")
    private Customer customer;

    @XmlElement(name = "VehSegmentCore")
    private VehSegmentCore vehSegmentCore;

    @XmlElement(name = "VehSegmentInfo")
    private VehSegmentInfo vehSegmentInfo;
}
