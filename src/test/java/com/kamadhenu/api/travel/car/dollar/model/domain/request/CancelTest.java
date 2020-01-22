//package com.kamadhenu.api.travel.car.dollar.model.domain.request;
//
//import static org.junit.Assert.assertEquals;
//
//import java.util.Set;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import javax.validation.ConstraintViolation;
//import javax.validation.Validation;
//import javax.validation.Validator;
//
//public class CancelTest {
//
//    private Validator validator;
//
//    @Before
//    public void setUp() {
//        validator = Validation.buildDefaultValidatorFactory().getValidator();
//    }
//
//    /**
//     * Tests for empty parameter constraint
//     */
//
//    @Test
//    public void emptyParametrs() {
//        Cancel cancelRequest = new Cancel("USD","GB","","","J2684506309","ZR");
//        Set<ConstraintViolation<Cancel>> errors = validator.validate(cancelRequest);
//        assertEquals(errors.size(), 2);
//    }
//
//    /**
//     * Tests constraints applied on currencyCode
//     */
//
//    @Test
//    public void currencyCode() {
//        Cancel cancelRequest = new Cancel("USD","GB","","","J2684506309","ZR");
//        Set<ConstraintViolation<Cancel>> errors = validator.validate(cancelRequest);
//        assertEquals(errors.iterator().next().getMessage(), "size must be between 3 and 3");
//    }
//
//    /**
//     * Tests constraints applied on countryCode
//     */
//
//    @Test
//    public void countryCode() {
//        Cancel cancelRequest = new Cancel("USD","GB","","","J2684506309","ZR");
//        Set<ConstraintViolation<Cancel>> errors = validator.validate(cancelRequest);
//        assertEquals(errors.iterator().next().getMessage(), "size must be between 2 and 2");
//    }
//}
