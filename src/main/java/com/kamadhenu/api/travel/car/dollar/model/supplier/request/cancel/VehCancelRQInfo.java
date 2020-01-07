package com.kamadhenu.api.travel.car.dollar.model.supplier.request.cancel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.*;

@Data
@ToString
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class VehCancelRQInfo {

    @XmlElement(name = "Vendor")
    private Vendor vendor;
}
