//package com.kamadhenu.api.travel.car.dollar.model.domain.request;
//
//import static org.junit.Assert.assertEquals;
//
//import java.util.Properties;
//import java.util.Set;
//
//import com.kamadhenu.api.travel.car.dollar.util.Config;
//import org.junit.Before;
//import org.junit.Test;
//
//import javax.validation.ConstraintViolation;
//import javax.validation.Validation;
//import javax.validation.Validator;
//
//public class BookTest {
//
//    private Validator validator;
//
//    private static Properties properties = Config.config().getProperties();
//
//    @Before
//    public void setUp() {
//        validator = Validation.buildDefaultValidatorFactory().getValidator();
//    }
//
//    /**
//     * Test suceess scenario of Book request
//     */
//    @Test
//    public void success() {
//
//        Book bookRequest = new Book("2020-08-10 15:00:00", "2020-08-15 15:00:00", "MCO", "MCO", "Mr", "test", "USD",
//                "GB", "test", "IT1005256PSL", "test", "123456789", "ACH-20200106", "Mr", "harsimranjeet.singh@kamadhenu.co.in",
//                "", "ZR", "");
//        Set<ConstraintViolation<Book>> errors = validator.validate(bookRequest);
//        assertEquals(errors.size(), 0);
//    }
//
//
//    /**
//     * Tests Date and Time validations constraints
//     */
//    @Test
//    public void DateAndTimevalidationsFailure() {
//
//        Book bookRequest = new Book("220-08-10 15:00:00", "2020-08-15 15:00:00", "MCO", "MCO", "Mr", "test", "USD",
//                "GB", "test", "IT1005256PSL", "test", "123456789", "ACH-20200106", "Mr", "harsimranjeet.singh@kamadhenu.co.in",
//                "", "ZR", "");
//        Set<ConstraintViolation<Book>> errors = validator.validate(bookRequest);
//        assertEquals(errors.iterator().next().getMessage(), properties.getProperty("validation-datetime"));
//    }
//
//    /**
//     * Tests Date and Time validations constraints
//     */
//    @Test
//    public void DateAndTimevalidationsSuccess() {
//
//        Book bookRequest = new Book("2020-08-10 15:00:00", "2020-08-15 15:00:00", "MCO", "MCO", "Mr", "test", "USD",
//                "GB", "test", "IT1005256PSL", "test", "123456789", "ACH-20200106", "Mr", "harsimranjeet.singh@kamadhenu.co.in",
//                "", "ZR", "");
//        Set<ConstraintViolation<Book>> errors = validator.validate(bookRequest);
//        assertEquals(errors.size(), 0);
//    }
//
//    /**
//     * Tests email constraints
//     */
//    @Test
//    public void email() {
//
//        Book bookRequest = new Book("2020-08-10 15:00:00", "2020-08-15 15:00:00", "MCO", "MCO", "Mr", "test", "USD",
//                "GB", "test", "IT1005256PSL", "test", "123456789", "ACH-20200106", "Mr", "harsimranjeet.singhkamadhenu.co.in",
//                "", "ZR", "");
//        Set<ConstraintViolation<Book>> errors = validator.validate(bookRequest);
//        assertEquals(errors.iterator().next().getMessage(), "must be a well-formed email address");
//    }
//}
