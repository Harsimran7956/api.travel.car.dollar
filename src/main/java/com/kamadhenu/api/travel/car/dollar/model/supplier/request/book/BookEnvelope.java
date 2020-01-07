package com.kamadhenu.api.travel.car.dollar.model.supplier.request.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.*;

@Data
@ToString
@AllArgsConstructor
@XmlRootElement(name = "soapenv:Envelope")
@XmlAccessorType(XmlAccessType.FIELD)
public class BookEnvelope {

    BookEnvelope(){}

    @XmlAttribute(name = "xmlns:soapenv")
    private String xmlSoapEnv;

    @XmlAttribute(name = "xmlns:ns")
    private String xmlns;

    @XmlElement(name = "soapenv:Header")
    private BookHeader header;

    @XmlElement(name = "soapenv:Body")
    private BookBody body;
}
