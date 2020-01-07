package com.kamadhenu.api.travel.car.dollar.model.supplier.response.book;

import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.*;

@Data
@ToString
@XmlRootElement(name = "s:Envelope")
@XmlAccessorType(XmlAccessType.FIELD)
public class BookEnvelope {

    @XmlAttribute(name = "xmlns:s")
    private String xmlns;

    @XmlElement(name = "s:Body")
    private BookBody body;
}
