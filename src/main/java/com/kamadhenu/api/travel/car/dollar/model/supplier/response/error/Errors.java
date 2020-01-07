package com.kamadhenu.api.travel.car.dollar.model.supplier.response.error;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Errors Response Model for Unmarshalling
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Errors")
public class Errors {

    @XmlElement(name = "Error")
    private List<Error> error;
}
