package com.kamadhenu.api.travel.car.dollar.model.domain.request;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.*;

/**
 * Search Request Model
 */
@Data
@ToString
public class Search extends Base {

    @NotEmpty
//    @Size(min = 3, max = 3)
    private String tourCode;

    @NotNull
    @Min(value = 21, message = "Age should not be less than 21")
    @Max(value = 99, message = "Age should not be greater than 99")
    private Integer driverAge;

    public Search(String pickUpDateTime, String dropOffDateTime, String pickUpLocationCode, String dropOffLocationCode, String tourCode,
                  Integer driverAge, String currencyCode, String countryCode) {
        super(pickUpDateTime, dropOffDateTime, currencyCode, countryCode, pickUpLocationCode, dropOffLocationCode);
        this.tourCode = tourCode;
        this.driverAge = driverAge;
    }
}

