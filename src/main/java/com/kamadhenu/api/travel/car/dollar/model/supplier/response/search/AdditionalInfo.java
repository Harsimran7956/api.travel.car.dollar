package com.kamadhenu.api.travel.car.dollar.model.supplier.response.search;

import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Data
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class AdditionalInfo {

    @XmlElement(name ="CounterLocation")
    private CounterLocation counterLocation;

    @XmlElement(name ="OperationSchedules")
    private OperationSchedules operationSchedules;
}
