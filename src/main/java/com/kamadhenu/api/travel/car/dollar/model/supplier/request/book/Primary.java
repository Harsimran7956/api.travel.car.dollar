package com.kamadhenu.api.travel.car.dollar.model.supplier.request.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.*;

@Data
@ToString
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class Primary {

    Primary(){}

    @XmlElement(name = "PersonName")
    private PersonName personName;

    @XmlElement(name = "Email")
    private Email email;

    @XmlElement(name = "Telephone")
    private Telephone telephone;

}
