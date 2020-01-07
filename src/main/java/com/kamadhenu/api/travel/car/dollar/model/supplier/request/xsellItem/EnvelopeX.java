package com.kamadhenu.api.travel.car.dollar.model.supplier.request.xsellItem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.*;

@Data
@ToString
@AllArgsConstructor
@XmlRootElement(name = "soapenv:Envelope")
@XmlAccessorType(XmlAccessType.FIELD)
public class EnvelopeX {

     EnvelopeX(){}

    @XmlAttribute(name ="xmlns:soapenv")
    private String xmlSoapEnv;

    @XmlAttribute(name ="xmlns:ns")
    private String xmlns;

    @XmlElement(name ="soapenv:Header")
    private HeaderX header;

    @XmlElement(name ="soapenv:Body")
    private BodyX body;

}
