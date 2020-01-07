package com.kamadhenu.api.travel.car.dollar.model.domain.response.search;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * Vechile Rate Response Model
 */
@Data
@ToString
@AllArgsConstructor
public class Rate {

    private Double totalRate;

    private String currency;

    private List<AdditionalRate> additionalRates;

}

