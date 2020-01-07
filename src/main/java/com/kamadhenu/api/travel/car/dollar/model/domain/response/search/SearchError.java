package com.kamadhenu.api.travel.car.dollar.model.domain.response.search;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class SearchError {

    SearchError(){}

    private String code;

    private String error;
}
