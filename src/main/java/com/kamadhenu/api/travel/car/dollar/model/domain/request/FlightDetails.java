package com.kamadhenu.api.travel.car.dollar.model.domain.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Size;

/**
 * Booking Flight Detail Request Model
 */
@Data
@ToString
@AllArgsConstructor
public class FlightDetails {

    @Size(min = 3, max = 255)
    private String flightNumber;

    @Size(min = 3, max = 255)
    private String airlineCode;
}

