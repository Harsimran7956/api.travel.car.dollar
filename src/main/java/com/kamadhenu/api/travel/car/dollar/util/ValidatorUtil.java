package com.kamadhenu.api.travel.car.dollar.util;

import com.kamadhenu.api.travel.car.dollar.exception.FieldValidationException;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * ValidatorUtil to validate various constraints applied on various requests models
 */
@Data
@ToString
@EqualsAndHashCode
public class ValidatorUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidatorUtil.class);

    private static Validator validator;

    /**
     * Validate class field as well as field level constraints
     *
     * @param <T>
     * @param t
     */
    public static <T> void validate(T t) {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<? extends ConstraintViolation<?>> errors = validator.validate(t);
        LOGGER.info("Constraint Validator {}", errors);
        if (CollectionUtils.isNotEmpty(errors)) {
            throw new FieldValidationException(errors);
        }
    }
}
