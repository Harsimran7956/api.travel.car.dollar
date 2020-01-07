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
public class Vehicle {

    @XmlAttribute(name = "AirConditionInd")
    private Boolean airConditionInd;

    @XmlAttribute(name = "TransmissionType")
    private String transmissionType;

    @XmlAttribute(name = "PassengerQuantity")
    private String passengerQuantity;

    @XmlAttribute(name = "BaggageQuantity")
    private String baggageQuantity;

    @XmlAttribute(name = "VendorCarType")
    private String vendorCarType;

    @XmlAttribute(name = "Code")
    private String code;

    @XmlAttribute(name = "CodeContext")
    private String codeContext;

    @XmlElement(name = "VehType")
    private VehType vehType;

    @XmlElement(name = "VehClass")
    private VehClass vehClass;

    @XmlElement(name = "VehMakeModel")
    private VehMakeModel vehMakeModel;

    @XmlElement(name = "PictureURL")
    private PictureURL pictureURL;
}
