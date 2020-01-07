package com.kamadhenu.api.travel.car.dollar.model.domain.request;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


/**
 * Book Request Model
 */
@Data
@ToString
public class Book extends Base {

    @NotEmpty
    @Size(min = 2, max = 255)
    private String title;

    @NotEmpty
    @Size(min = 2, max = 255)
    private String firstName;

    @NotEmpty
    @Size(min = 2, max = 255)
    private String surName;

    @NotEmpty
//    @Size(min = 3, max = 3)
    private String tourNumber;

    //    @NotBlank
//    @Size(min = 2, max = 2)
    private String rateCode;

    @NotEmpty
    private String telephoneNumber;

    @NotEmpty
    private String ourBookingRef;

    @NotEmpty
    private String driverTitle;

    @NotEmpty
    @Email
    private String email;

    //    @NotEmpty
    private String flightCarrier;

    @NotEmpty
    @Size(min = 2, max = 255)
    private String vehicleSipp;

    //    @NotEmpty
    private String rateQualifier;

    public Book(String pickUpDateTime, String dropOffDateTime, String pickUpLocationCode, String dropOffLocationCode, String title, String firstName, String currencyCode, String countryCode, String surName, String tourNumber, String rateCode,
                String telephoneNumber, String ourBookingRef, String driverTitle, String email, String flightCarrier, String vehicleSipp, String rateQualifier) {
        super(pickUpDateTime, dropOffDateTime, currencyCode, countryCode, pickUpLocationCode, dropOffLocationCode);
        this.tourNumber = tourNumber;
        this.title = title;
        this.firstName = firstName;
        this.surName = surName;
        this.rateCode = rateCode;
        this.telephoneNumber = telephoneNumber;
        this.ourBookingRef = ourBookingRef;
        this.driverTitle = driverTitle;
        this.email = email;
        this.flightCarrier = flightCarrier;
        this.vehicleSipp = vehicleSipp;
        this.rateQualifier = rateQualifier;
    }
}
