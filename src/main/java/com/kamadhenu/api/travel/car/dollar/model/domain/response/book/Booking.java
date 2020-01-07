package com.kamadhenu.api.travel.car.dollar.model.domain.response.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * Booking Response Model
 */
@Data
@ToString
@AllArgsConstructor
public class Booking {

    private BookRate rate;

    private Boolean isSuccess;

    private String confirnationId;
}
