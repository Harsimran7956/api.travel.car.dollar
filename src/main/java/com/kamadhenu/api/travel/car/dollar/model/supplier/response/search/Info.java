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
public class Info {

    @XmlElement(name = "VendorMessages")
    private VendorMessages vendorMessages;

    @XmlElement(name = "LocationDetails")
    private List<LocationDetails> locationDetailsList;

    @XmlElement(name = "TourInfo")
    private TourInfo tourInfo;
}
