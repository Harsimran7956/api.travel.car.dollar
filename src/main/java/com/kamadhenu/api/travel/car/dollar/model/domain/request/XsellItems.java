package com.kamadhenu.api.travel.car.dollar.model.domain.request;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

/**
 * XSellItem Request Model
 */
@Data
@ToString
public class XsellItems extends Base {

    @NotEmpty
//    @Size(min = 3, max = 3)
    private String tourNumber;

    @NotEmpty

    private String rateQualifier;
}
