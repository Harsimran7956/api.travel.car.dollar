package com.kamadhenu.api.travel.car.dollar.model.domain.response.search;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Search Response Model
 */
@Data
@AllArgsConstructor
public class Search {

    private Boolean isSuccess;

    private String currencyCode;

    private String pickUpLocationCode;

    private String dropOffLocationCode;

    private String pickUpDateTime;

    private String dropOffDateTime;

    private String pickUpLocationName;

    private String dropOffLocationName;

    private Supplier supplier;
}
