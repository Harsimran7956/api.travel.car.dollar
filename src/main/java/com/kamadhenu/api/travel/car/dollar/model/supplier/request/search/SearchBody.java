package com.kamadhenu.api.travel.car.dollar.model.supplier.request.search;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.*;

@Data
@ToString
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class SearchBody {

    @XmlElement(name ="ns:GetRates")
    private GetRates getRates;
}
