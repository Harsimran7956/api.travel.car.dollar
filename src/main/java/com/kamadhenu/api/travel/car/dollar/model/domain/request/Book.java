package com.kamadhenu.api.travel.car.dollar.model.domain.request;

import lombok.Data;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Book Request Model
 */
@Data
@ToString
public class Book extends Base {

    @NotEmpty
    @Size(min = 2, max = 255)
    private String bookingReference;

    @Valid
    private Customer customer;

    @Valid
    private FlightDetails flightDetails;

    @Valid
    private Supplier supplier;

    @NotEmpty
    private String sipp;

    @NotNull
    private Boolean arriveByFlight;

    public Book(@NotEmpty String pickUpDateTime, @NotEmpty String dropOffDateTime, @NotEmpty @Size(min = 3, max = 3) String currencyCode,
                          @NotEmpty @Size(min = 2, max = 2) String pos, @NotEmpty String pickUpLocationCode, @NotEmpty String dropOffLocationCode,
                          @NotEmpty @Size(min = 2, max = 255) String bookingReference,
                          @NotNull Customer customer, FlightDetails flightDetails, @NotNull Supplier supplier, @NotEmpty String sipp) {
        super (pickUpDateTime,dropOffDateTime, currencyCode, pos, pickUpLocationCode,dropOffLocationCode);
        this.bookingReference = bookingReference;
        this.customer = customer;
        this.flightDetails = flightDetails;
        this.supplier = supplier;
        this.sipp = sipp;
    }
}

