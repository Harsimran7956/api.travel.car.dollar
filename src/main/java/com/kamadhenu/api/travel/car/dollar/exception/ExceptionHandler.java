package com.kamadhenu.api.travel.car.dollar.exception;

import com.kamadhenu.api.travel.car.dollar.model.domain.error.ApiError;
import io.javalin.Javalin;
import org.eclipse.jetty.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandler.class);

    public static void handler(Javalin javalin) {

        /*
         * Exception handle for intenal server error
         */
        javalin.exception(ApiResponseException.class, (ex, ctx) -> {
            ApiError apiError = new ApiError();
            apiError.setMessage("Api error");
            apiError.addApiResponseError(ex.errors);
            ctx.status(HttpStatus.INTERNAL_SERVER_ERROR_500);
            ctx.json(apiError);
        });
        /*
         * Exception handle for invalid json request
         */
        javalin.exception(FieldValidationException.class, (ex, ctx) -> {
            ApiError apiError = new ApiError();
            apiError.setMessage("Validation error");
            apiError.addValidationErrors(ex.getConstraintViolations());
            ctx.status(HttpStatus.BAD_REQUEST_400);
            ctx.json(apiError);
        });
    }
}
