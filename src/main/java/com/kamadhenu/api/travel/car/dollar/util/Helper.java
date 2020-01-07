package com.kamadhenu.api.travel.car.dollar.util;

import com.kamadhenu.api.travel.car.dollar.exception.ApiResponseException;
import com.kamadhenu.api.travel.car.dollar.model.supplier.response.error.Errors;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.http.client.HttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.*;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Helper class to help with common functionality
 */
public class Helper {

    private static final Logger LOGGER = LoggerFactory.getLogger(Helper.class);

    /**
     * Get String by Marshalling
     *
     * @param t
     * @param <T>
     * @return
     * @throws JAXBException
     */
    public static <T> String getStringByMarshalling(T t) {
        String xmlContent = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(t.getClass());
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            StringWriter sw = new StringWriter();
            jaxbMarshaller.marshal(t, sw);
            xmlContent = sw.toString();
        } catch (JAXBException ex) {
        }
        return xmlContent;
    }

    /**
     * @param url
     * @param request
     * @param soapAction
     * @return
     * @throws IOException
     */
    public static String transaction(String url, String request, String soapAction) {

        LOGGER.info("xml request url {}", url);
        LOGGER.info("xml request {}", request);
        String response = null;
        try {
            StringEntity stringEntity = new StringEntity(request, "UTF-8");
            HttpPost httpPost = new HttpPost(url);
            httpPost.setEntity(stringEntity);
            httpPost.addHeader("Content-Type", "text/xml");
            httpPost.addHeader("SOAPAction", soapAction);
            HttpClient httpClient = HttpClients.custom().build();
            HttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity entity = httpResponse.getEntity();
            LOGGER.info("xml response status {}", httpResponse.getStatusLine().getStatusCode());
            if (entity != null) {
                response = EntityUtils.toString(entity);
            }
            LOGGER.info("xml response {}", response);
        } catch (IOException ex) {
            LOGGER.error(ex.getMessage());
        }

        return response;
    }

    /**
     * Get Object by unmarshalling
     *
     * @param t
     * @param <T>
     * @return
     * @throws JAXBException
     */
    public static <T> T getObjectByUnmarshalling(String response, T t, String tag) {
        T obj = null;
        try {
            XMLInputFactory xif = XMLInputFactory.newFactory();
            StreamSource xml = new StreamSource(new StringReader(response));
            XMLStreamReader xsr = xif.createXMLStreamReader(xml);
            xsr.nextTag();
            while (!xsr.getLocalName().equals(tag)) {
                xsr.nextTag();
            }
            JAXBContext jc = JAXBContext.newInstance(t.getClass());
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            JAXBElement<T> jb = (JAXBElement<T>) unmarshaller.unmarshal(xsr, t.getClass());
            xsr.close();
            obj = jb.getValue();
        } catch (XMLStreamException | JAXBException ex) {
           LOGGER.error(ex.getMessage());
        }
        return obj;
    }

    /**
     * Get Formatted Date
     *
     * @param dateString
     * @return
     * @throws ParseException
     */
    public static String getFormattedDate(String dateString) {

        String formattedTime = null;
        try {
            SimpleDateFormat output = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = sdf.parse(dateString);
            formattedTime = output.format(date);
        } catch (ParseException ex) {
            LOGGER.error(ex.getMessage());
        }
        return formattedTime;
    }

    /**
     * Check for api response error found
     *
     * @param response
     * @throws ApiResponseException
     */
    public static void isErrorFound(String response) throws ApiResponseException {
        Errors errors = new Errors();
        if (response.contains("<Errors>")) {
            errors = getObjectByUnmarshalling(response, errors, "Errors");
            throw new ApiResponseException(errors);
        }
    }

    /**
     * Get LocalDateTime Object
     *
     * @param dateString
     * @return
     * @throws ParseException
     */
    public static LocalDateTime getLocalDateTime(String dateString) throws ParseException {

        Date date;
        LocalDateTime dateTime = null;
        String format = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        if (!dateString.isBlank()) {
            date = sdf.parse(dateString);
            if (!dateString.equals(sdf.format(date))) {
                return null;
            } else {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                dateTime = LocalDateTime.parse(dateString, formatter);
            }
        }
        return dateTime;
    }
}
