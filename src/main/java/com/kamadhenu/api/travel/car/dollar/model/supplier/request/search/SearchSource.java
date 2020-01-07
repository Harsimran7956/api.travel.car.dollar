package com.kamadhenu.api.travel.car.dollar.model.supplier.request.search;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.*;

@Data
@ToString
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class SearchSource {

    @XmlAttribute( name= "ISOCountry")
    private String isoCountry;

    @XmlAttribute( name= "ISOCurrency")
    private String isoCurrency;

    @XmlElement(name = "RequestorID")
    private RequestorID requestorID;
}
