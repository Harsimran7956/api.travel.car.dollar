package com.kamadhenu.api.travel.car.dollar.model.domain.response.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class BookError {

    private String code;

    private String error;
}
