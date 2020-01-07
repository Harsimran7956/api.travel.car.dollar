package com.kamadhenu.api.travel.car.dollar.model.supplier.response.book;

import com.kamadhenu.api.travel.car.dollar.model.supplier.request.search.VehRentalCore;
import com.kamadhenu.api.travel.car.dollar.model.supplier.response.search.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@Data
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class VehSegmentCore {

    @XmlElement(name = "ConfID")
    private List<ConfID> confID;

    @XmlElement(name = "Vendor")
    private Vendor vendor;

    @XmlElement(name = "VehRentalCore")
    private VehRentalCore vehRentalCore;

    @XmlElement(name = "Vehicle")
    private Vehicle vehicle;

    @XmlElement(name = "RentalRate")
    private RentalRate rentalRate;

    @XmlElement(name = "Fees")
    private Fees fees;

    @XmlElement(name = "TotalCharge")
    private TotalCharge totalCharge;

    @XmlElement(name = "TPA_Extensions")
    private TpaExtensions tpaExtensions;
}
