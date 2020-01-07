package com.kamadhenu.api.travel.car.dollar.model.supplier.response.search;

import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@Data
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class RateDistance {

    @XmlAttribute(name = "Unlimited")
    private String unlimited;

    @XmlAttribute(name = "DistUnitName")
    private String distUnitName;

    @XmlAttribute(name = "VehiclePeriodUnitName")
    private String vehiclePeriodUnitName;
}
