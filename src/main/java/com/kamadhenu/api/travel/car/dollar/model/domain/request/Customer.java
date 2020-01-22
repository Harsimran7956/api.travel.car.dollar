package com.kamadhenu.api.travel.car.dollar.model.domain.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.*;

/**
 * Booking Customer Request Model
 */
@Data
@ToString
@AllArgsConstructor
public class Customer {

    @NotEmpty
    @Size(min = 2, max = 255)
    private String title;

    @NotEmpty
    @Size(min = 2, max = 255)
    private String firstName;

    @NotEmpty
    @Size(min = 2, max = 255)
    private String lastName;

    @NotEmpty
    @Size(min = 2, max = 255)
    private String phone;

    @NotEmpty
    @Email
    @Size(min = 2, max = 255)
    private String email;

    @NotEmpty
    @Size(min = 2, max = 255)
    private String address;

    @NotEmpty
    @Size(min = 2, max = 255)
    private String city;

    @NotEmpty
    @Size(min = 2, max = 255)
    private String zipCode;

    @NotEmpty
    @Size(min = 2, max = 2)
    private String pos;

    @NotNull
    @Min(value = 21)
    @Max(value = 99)
    private Integer driverAge;
}

