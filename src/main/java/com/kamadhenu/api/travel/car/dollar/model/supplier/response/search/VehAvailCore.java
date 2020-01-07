package com.kamadhenu.api.travel.car.dollar.model.supplier.response.search;

import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@Data
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class VehAvailCore {

    @XmlAttribute(name = "Status")
    private String status;

    @XmlElement(name = "Vehicle")
    private Vehicle vehicle;

    @XmlElement(name = "RentalRate")
    private RentalRate rentalRate;

    @XmlElement(name = "TotalCharge")
    private TotalCharge totalCharge;

    @XmlElement(name = "PricedEquips")
    private PricedEquips pricedEquips;

    @XmlElement(name = "Fees")
    private Fees fees;

    @XmlElement(name = "Reference")
    private Reference reference;

    @XmlElement(name = "TPA_Extensions")
    private TpaExtensions tpaExtensions;
}
