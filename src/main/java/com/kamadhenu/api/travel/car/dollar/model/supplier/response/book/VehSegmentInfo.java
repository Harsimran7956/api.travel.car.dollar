package com.kamadhenu.api.travel.car.dollar.model.supplier.response.book;

import com.kamadhenu.api.travel.car.dollar.model.supplier.request.search.TourInfo;
import com.kamadhenu.api.travel.car.dollar.model.supplier.response.search.LocationDetails;
import com.kamadhenu.api.travel.car.dollar.model.supplier.response.search.PricedCoverages;
import com.kamadhenu.api.travel.car.dollar.model.supplier.response.search.TpaExtensions;
import com.kamadhenu.api.travel.car.dollar.model.supplier.response.search.VendorMessages;
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
public class VehSegmentInfo {

    @XmlElement(name = "RentalPaymentAmount")
    private RentalPaymentAmount rentalPaymentAmount;

    @XmlElement(name = "PricedCoverages")
    private PricedCoverages pricedCoverages;

    @XmlElement(name = "VendorMessages")
    private VendorMessages vendorMessages;

    @XmlElement(name = "LocationDetails")
    private List<LocationDetails> locationDetails;

    @XmlElement(name = "TourInfo")
    private TourInfo tourInfo;

    @XmlElement(name = "TPA_Extensions")
    private TpaExtensions tpaExtensions;
}
