package com.kamadhenu.api.travel.car.dollar.exception;

import com.kamadhenu.api.travel.car.dollar.model.supplier.response.error.Errors;
import lombok.Data;

@Data
public class ApiResponseException extends Exception {

    public Errors errors;

    public ApiResponseException(Errors errors) {
        this.errors = errors;
    }
}
