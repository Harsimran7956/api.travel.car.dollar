package com.kamadhenu.api.travel.car.dollar.model.supplier.response.search;

import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@Data
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class PricedCoverages {

    @XmlElement(name = "PricedCoverage")
    private List<PricedCoverage> pricedCoverageList;
}
