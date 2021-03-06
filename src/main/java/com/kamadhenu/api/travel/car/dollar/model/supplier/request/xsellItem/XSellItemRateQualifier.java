package com.kamadhenu.api.travel.car.dollar.model.supplier.request.xsellItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.*;

@Data
@ToString
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class XSellItemRateQualifier {

    @XmlAttribute( name= "RateQualifier")
    private String rateQualifier;
}
