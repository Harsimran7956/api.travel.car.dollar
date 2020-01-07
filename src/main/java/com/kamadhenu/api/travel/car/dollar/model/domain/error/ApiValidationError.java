package com.kamadhenu.api.travel.car.dollar.model.domain.error;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class ApiValidationError extends SubError {

    private String object;

    private String field;

    private Object rejectedValue;

    private String message;
}