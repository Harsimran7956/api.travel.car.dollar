package com.kamadhenu.api.travel.car.dollar.model.supplier.request.book;

import com.kamadhenu.api.travel.car.dollar.model.supplier.request.search.VehPref;
import com.kamadhenu.api.travel.car.dollar.model.supplier.request.search.VehRentalCore;
import com.kamadhenu.api.travel.car.dollar.model.supplier.request.search.VendorPref;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.*;

@Data
@ToString
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class VehResRQCore {

    VehResRQCore(){}

    @XmlAttribute(name = "Status")
    private String status;

    @XmlElement(name = "VehRentalCore")
    private VehRentalCore vehRentalCore;

    @XmlElement(name = "Customer")
    private Customer customer;

    @XmlElement(name = "VendorPref")
    private VendorPref vendorPref;

    @XmlElement(name = "VehPref")
    private VehPref vehPref;

}
