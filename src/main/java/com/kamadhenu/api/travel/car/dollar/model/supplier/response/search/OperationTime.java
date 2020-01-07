package com.kamadhenu.api.travel.car.dollar.model.supplier.response.search;

import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@Data
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class OperationTime {

    @XmlAttribute(name = "Mon")
    private Boolean mon;

    @XmlAttribute(name = "Tue")
    private Boolean tue;

    @XmlAttribute(name = "Weds")
    private Boolean weds;

    @XmlAttribute(name = "Thur")
    private Boolean thur;

    @XmlAttribute(name = "Fri")
    private Boolean fri;

    @XmlAttribute(name = "Sat")
    private Boolean sat;

    @XmlAttribute(name = "Sun")
    private Boolean sun;

    @XmlAttribute(name = "Start")
    private String start;

    @XmlAttribute(name = "End")
    private String end;
}
