package com.kamadhenu.api.travel.car.dollar.exception;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

public class FieldValidationException extends ConstraintViolationException {

    private static final long serialVersionUID = 1L;

    public FieldValidationException(Set<? extends ConstraintViolation<?>> constraintViolations) {
        super(constraintViolations);
    }
}
