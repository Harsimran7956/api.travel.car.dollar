package com.kamadhenu.api.travel.car.dollar.model.supplier.request.search;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.*;

@Data
@ToString
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class SearchPos {

    @XmlElement(name = "Source")
    private SearchSource searchSource;
}
