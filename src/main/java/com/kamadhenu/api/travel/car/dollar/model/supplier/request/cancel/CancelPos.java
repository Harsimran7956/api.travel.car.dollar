package com.kamadhenu.api.travel.car.dollar.model.supplier.request.cancel;

import com.kamadhenu.api.travel.car.dollar.model.supplier.request.search.SearchSource;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.*;

@Data
@ToString
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class CancelPos {

    @XmlElement(name = "Source")
    private SearchSource source;
}
