package com.kamadhenu.api.travel.car.dollar.model.domain.error;

import com.kamadhenu.api.travel.car.dollar.model.supplier.response.error.Errors;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Response Error Class
 */
@Data
@AllArgsConstructor
public class ApiResponseError extends SubError {

    private Errors errors;
}
