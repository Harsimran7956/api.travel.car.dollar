package com.kamadhenu.api.travel.car.dollar.model.supplier.request.cancel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.*;

@Data
@ToString
@AllArgsConstructor
@XmlRootElement(name = "soapenv:Envelope")
@XmlAccessorType(XmlAccessType.FIELD)
public class CancelEnvelope {

    CancelEnvelope(){}

    @XmlAttribute(name = "xmlns:soapenv")
    private String xmlSoapEnv;

    @XmlAttribute(name = "xmlns:ns")
    private String xmlns;

    @XmlElement(name = "soapenv:Header")
    private CancelHeader header;

    @XmlElement(name = "soapenv:Body")
    private CancelBody body;
}
