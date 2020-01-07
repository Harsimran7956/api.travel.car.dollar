package com.kamadhenu.api.travel.car.dollar.model.domain.response.search;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * Vechile Additional Rate Response Model
 */
@Data
@ToString
@AllArgsConstructor
public class AdditionalRate {

    private String description;

    private Double amount;

    private String currency;

    private Boolean taxInclusive;

}
