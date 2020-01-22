package com.kamadhenu.api.travel.car.dollar.model.domain.request;

import com.kamadhenu.api.travel.car.dollar.validator.ValidDateParameters;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.*;


/**
 * Base Request Model i.e contains common parameters
 */
@Data
@AllArgsConstructor
@ValidDateParameters
public class Base {

    Base(){}

    @NotEmpty
    public String pickUpDateTime;

    @NotEmpty
    public String dropOffDateTime;

    @NotEmpty
    @Size(min = 3, max = 3)
    private String currency;

    @NotEmpty
    @Size(min = 2, max = 2)
    private String pos;

    @NotEmpty
    @Size(min = 3)
    @Pattern(regexp = "^[\\p{Alnum}]{3,32}$", message = "pickUpLocationCode should be a alphanumeric")
    private String pickUpLocation;

    @NotEmpty
    @Size(min = 3)
    @Pattern(regexp = "^[\\p{Alnum}]{3,32}$", message = "dropOffLocationCode should be a alphanumeric")
    private String dropOffLocation;
}
