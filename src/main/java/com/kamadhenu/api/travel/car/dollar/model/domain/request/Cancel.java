package com.kamadhenu.api.travel.car.dollar.model.domain.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Cancel Request Model
 */
@Data
@ToString
@AllArgsConstructor
public class Cancel {

    @NotEmpty
    @Size(min = 3, max = 3)
    private String currencyCode;

    @NotEmpty
    @Size(min = 2, max = 2)
    private String countryCode;

    @NotEmpty
    private String surName;

    @NotEmpty
    private String givenName;

    @NotEmpty
    private String bookingRef;

    @NotEmpty
    private String supplierCode;
}
