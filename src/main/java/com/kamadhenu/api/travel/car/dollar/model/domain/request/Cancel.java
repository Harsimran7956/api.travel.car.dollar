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
public class Cancel extends Base{

    @NotEmpty
    private String driverFirstName;

    @NotEmpty
    private String driverLastName;

    @NotEmpty
    private String bookingReference;

    @NotEmpty
    private String supplierCode;

    @NotEmpty
    @Size(min = 2, max = 255)
    private String driverTitle;

}
