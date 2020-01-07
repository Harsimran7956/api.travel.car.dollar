package com.kamadhenu.api.travel.car.dollar.model.domain.error;

import com.kamadhenu.api.travel.car.dollar.model.domain.request.Book;
import com.kamadhenu.api.travel.car.dollar.model.domain.request.Search;
import com.kamadhenu.api.travel.car.dollar.model.supplier.response.error.Errors;
import com.kamadhenu.api.travel.car.dollar.util.Config;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintViolation;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

@Data
public class ApiError {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiError.class);

    private static Properties properties = Config.config().getProperties();

    private Integer status;

    private String message;

    private List<SubError> subErrors;

    private void addSubError(SubError subError) {
        if (subErrors == null) {
            subErrors = new ArrayList<>();
        }
        subErrors.add(subError);
    }

    private void addValidationError(String object, String field, Object rejectedValue, String message) {
        addSubError(new ApiValidationError(object, field, rejectedValue, message));
    }

    /**
     * Add constraint violation related to pickupDateTime and dropOffDateTime
     *
     * @param object
     * @param field
     * @param rejectedValue
     * @param message
     */
    private void addDatesValidationError(String object, String field, RejectedValues rejectedValue, String message) {
        addSubError(new ApiValidationError(object, field, rejectedValue, message));
    }

    /**
     * Add constraint violation validation errors
     *
     * @param constraintViolations
     */
    public void addValidationErrors(Set<ConstraintViolation<?>> constraintViolations) {

        constraintViolations.forEach(cv -> {
            if (cv.getMessage().contains(properties.getProperty("validation-datetime"))) {
                String RequestType = cv.getRootBeanClass().getSimpleName();
                RejectedValues rejectedValues = new RejectedValues();
                if (RequestType.contains("Search")) {
                    rejectedValues.setPickUpDateTime(((Search) cv.getInvalidValue()).getPickUpDateTime());
                    rejectedValues.setDropOffDateTime(((Search) cv.getInvalidValue()).getDropOffDateTime());
                } else {
                    rejectedValues.setPickUpDateTime(((Book) cv.getInvalidValue()).getPickUpDateTime());
                    rejectedValues.setDropOffDateTime(((Book) cv.getInvalidValue()).getDropOffDateTime());
                }
                this.addDatesValidationError(
                        cv.getRootBeanClass().getSimpleName(),
                        cv.getPropertyPath().toString(),
                        rejectedValues,
                        cv.getMessage());
            } else {
                this.addValidationError(cv.getRootBeanClass().getSimpleName(),
                        cv.getPropertyPath().toString(),
                        cv.getInvalidValue(),
                        cv.getMessage());
            }
        });
    }

    /**
     * Add Api Response Error
     *
     * @param errors
     */
    public void addApiResponseError(Errors errors) {
        addSubError(new ApiResponseError(errors));

    }
}
