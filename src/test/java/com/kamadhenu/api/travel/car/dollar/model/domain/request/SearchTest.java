package com.kamadhenu.api.travel.car.dollar.model.domain.request;

import static org.junit.Assert.assertEquals;

import java.util.Properties;
import java.util.Set;

import com.kamadhenu.api.travel.car.dollar.util.Config;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;


/**
 * SearchTest class to check the working of validations applied on Search parmeters
 */
public class SearchTest {

    private Validator validator;

    private static Properties properties = Config.config().getProperties();

    @Before
    public void setUp() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    /**
     * Tests Date and Time validations constraints
     */
    @Test
    public void DateAndTimevalidationsFailure() {

        Search searchRequest = new Search("200-08-10 15:00:00", "2020-08-15 15:00:00",
                "MCO", "MCO", "IT1005256PSL", 23, "USD", "GB");
        Set<ConstraintViolation<Search>> errors = validator.validate(searchRequest);
        assertEquals(errors.iterator().next().getMessage(), properties.getProperty("validation-datetime"));
    }

    /**
     * Tests Date and Time validations constraints
     */
    @Test
    public void DateAndTimevalidationsSuccess() {

        Search searchRequest = new Search("2020-08-10 15:00:00", "2020-08-15 15:00:00",
                "MCO", "MCO", "IT1005256PSL", 23, "USD", "GB");
        Set<ConstraintViolation<Search>> errors = validator.validate(searchRequest);
        assertEquals(errors.size(), 0);
    }

    /**
     * Tests whether driver age is not less than 18 or greater than 99
     */

    @Test
    public void ageRangeFailureTest() {
        Search searchRequest = new Search("200-08-10 15:00:00", "2020-08-15 15:00:00",
                "MCO", "MCO", "IT1005256PSL", 10, "USD", "GB");
        Set<ConstraintViolation<Search>> errors = validator.validate(searchRequest);
        assertEquals(errors.iterator().next().getMessage(), "Age should not be less than 21");
        searchRequest = new Search("200-08-10 15:00:00", "2020-08-15 15:00:00",
                "MCO", "MCO", "IT1005256PSL", 100, "USD", "GB");
        errors = validator.validate(searchRequest);
        assertEquals(errors.iterator().next().getMessage(), "Age should not be greater than 99");
    }

    /**
     * Tests for empty parameter constraint
     */

    @Test
    public void emptyParametrs() {
        Search searchRequest = new Search("200-08-10 15:00:00", "2020-08-15 15:00:00",
                null, "MCO", "", 10, "USD", "GB");
        Set<ConstraintViolation<Search>> errors = validator.validate(searchRequest);
        assertEquals(errors.iterator().next().getMessage(), "must not be empty");
    }

    /**
     * Tests whether pickupLocation and dropOffLocation is in alphanumric format
     */

    @Test
    public void alpanumricPattern() {
        Search searchRequest = new Search("2020-08-10 15:00:00", "2020-08-15 15:00:00",
                "MC##O", "MCO", "IT1005255GPS", 23, "USD", "GB");
        Set<ConstraintViolation<Search>> errors = validator.validate(searchRequest);
        assertEquals(errors.iterator().next().getMessage(), "pickUpLocationCode should be a alphanumeric");
        searchRequest = new Search("2020-08-10 15:00:00", "2020-08-15 15:00:00",
                "MCO", "MC@#O", "IT1005255GPS", 23, "USD", "GB");
        errors = validator.validate(searchRequest);
        assertEquals(errors.iterator().next().getMessage(), "dropOffLocationCode should be a alphanumeric");
    }

    /**
     * Tests constraints applied on currencyCode
     */

    @Test
    public void currencyCode() {
        Search searchRequest = new Search("2020-08-10 15:00:00", "2020-08-15 15:00:00",
                "MCO", "MCO", "IT1005255GPS", 23, "UD", "GB");
        Set<ConstraintViolation<Search>> errors = validator.validate(searchRequest);
        assertEquals(errors.iterator().next().getMessage(), "size must be between 3 and 3");
    }

    /**
     * Tests constraints applied on countryCode
     */

    @Test
    public void countryCode() {
        Search searchRequest = new Search("2020-08-10 15:00:00", "2020-08-15 15:00:00",
                "MCO", "MCO", "IT1005255GPS", 23, "USD", "GSB");
        Set<ConstraintViolation<Search>> errors = validator.validate(searchRequest);
        assertEquals(errors.iterator().next().getMessage(), "size must be between 2 and 2");
    }
}

