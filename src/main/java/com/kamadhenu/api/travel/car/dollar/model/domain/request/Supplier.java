package com.kamadhenu.api.travel.car.dollar.model.domain.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

/**
 * Booking or Rental Condition Supplier Request Model
 */
@Data
@ToString
@AllArgsConstructor
public class Supplier {

    @NotEmpty
    private String id;

    @NotEmpty
    private String contextId;

    @NotEmpty
    private String url;
}

