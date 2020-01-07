package com.kamadhenu.api.travel.car.dollar.model.supplier.request.search;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.*;

@Data
@ToString
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class VehAvailRQInfo {

    @XmlElement(name = "TourInfo")
    private TourInfo tourInfo;

    @XmlElement(name = "TourOperator")
    private TourOperator tourOperator;
}
