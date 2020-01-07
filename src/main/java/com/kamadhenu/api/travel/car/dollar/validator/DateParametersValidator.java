package com.kamadhenu.api.travel.car.dollar.validator;

import com.kamadhenu.api.travel.car.dollar.model.domain.request.Book;
import com.kamadhenu.api.travel.car.dollar.model.domain.request.Search;
import com.kamadhenu.api.travel.car.dollar.util.Config;
import com.kamadhenu.api.travel.car.dollar.util.Helper;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Properties;

/**
 * Validates pickUp and dropOff dates
 */
@Data
public class DateParametersValidator implements ConstraintValidator<ValidDateParameters, Object> {

    private static final Logger LOGGER = LoggerFactory.getLogger(DateParametersValidator.class);
    private static Properties properties = Config.config().getProperties();
    ValidDateParameters validDateParameters;
    private Boolean isValid;

    @Override
    public void initialize(ValidDateParameters validDate) {
    }

    /**
     * First Validates pickUp and dropOff dates matches yyyy-MM-dd HH:mm:ss and then compares the pickUp and dropOff dates
     *
     * @param obj
     * @param constraintValidatorContext
     * @return
     */
    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext constraintValidatorContext) {

        LocalDateTime pickUp = null;
        LocalDateTime dropOff = null;
        try {
            if (obj.getClass().getSimpleName().equals("Search")) {
                pickUp = Helper.getLocalDateTime(((Search) obj).getPickUpDateTime());
                dropOff = Helper.getLocalDateTime(((Search) obj).getDropOffDateTime());
                if (pickUp == null || dropOff == null) {
                    addCustomConstraint(constraintValidatorContext);
                    return isValid;
                }
            } else if (obj.getClass().getSimpleName().equals("Book")) {
                pickUp = Helper.getLocalDateTime(((Book) obj).getPickUpDateTime());
                dropOff = Helper.getLocalDateTime(((Book) obj).getDropOffDateTime());
                if (pickUp == null || dropOff == null) {
                    addCustomConstraint(constraintValidatorContext);
                    return isValid;
                }
            }

        } catch (ParseException ex) {
            addCustomConstraint(constraintValidatorContext);
            return isValid;
        }
        isValid = (pickUp).isAfter(LocalDateTime.now()) && dropOff.isAfter(LocalDateTime.now())
                && (pickUp.isBefore(dropOff));
        if (!isValid) {
            addCustomConstraint(constraintValidatorContext);
        }
        return isValid;
    }

    private void addCustomConstraint(ConstraintValidatorContext constraintValidatorContext) {
        constraintValidatorContext.disableDefaultConstraintViolation();
        constraintValidatorContext
                .buildConstraintViolationWithTemplate(properties.getProperty("validation-datetime"))
                .addPropertyNode("pickUpDateTime OR dropOffDateTime").addConstraintViolation();
        isValid = false;
    }
}



