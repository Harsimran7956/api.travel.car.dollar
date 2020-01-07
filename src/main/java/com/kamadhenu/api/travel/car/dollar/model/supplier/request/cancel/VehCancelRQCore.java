package com.kamadhenu.api.travel.car.dollar.model.supplier.request.cancel;

import com.kamadhenu.api.travel.car.dollar.model.supplier.request.book.PersonName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.*;

@Data
@ToString
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class VehCancelRQCore {

    @XmlElement(name = "UniqueID")
    private UniqueId uniqueId;

    @XmlElement(name = "PersonName")
    private PersonName personName;
}
