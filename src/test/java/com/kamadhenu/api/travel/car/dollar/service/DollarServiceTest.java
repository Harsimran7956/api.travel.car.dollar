//package com.kamadhenu.api.travel.car.dollar.service;
//
//import static org.junit.Assert.assertEquals;
//
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.Properties;
//
//import com.kamadhenu.api.travel.car.dollar.exception.FieldValidationException;
//import com.kamadhenu.api.travel.car.dollar.model.domain.request.Book;
//import com.kamadhenu.api.travel.car.dollar.model.domain.request.Search;
//import com.kamadhenu.api.travel.car.dollar.util.Config;
//import org.junit.Test;
//
///**
// * DollarServiceTest class to check the functionality of DollarService class
// */
//public class DollarServiceTest {
//
//    private final String SUR_NAME = "test";
//
//    private final LocalDateTime PICK_DATE = LocalDateTime.now().plusMonths(6);
//
//    private static Properties properties = Config.config().getProperties();
//
//    private LocalDateTime DROP_DATE = LocalDateTime.now().plusMonths(7);
//
//    private final String GIVEN_NAME = "test";
//
//    /**
//     * Tests Search functionality
//     */
//    @Test
//    public void search() {
//
//        String pickUpDate = PICK_DATE.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//        String dropOffUpdate = DROP_DATE.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//        Search searchRequest = new Search(pickUpDate, dropOffUpdate, "CAD",
//                "MCO", "MCO", "IT1005255SPG", "GB",21);
//        Object object = DollarService.search(searchRequest);
//        assertEquals("Search", object.getClass().getSimpleName());
//    }

    /**
     * Tests Book and Cancel functionality
     */
//    @Test
//    public void bookAndCancel() {
//        String pickUpDate = PICK_DATE.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//        String dropOffUpdate = DROP_DATE.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//        BookRequest bookRequest = new BookRequest("USD", pickUpDate, dropOffUpdate, "MLBC01",
//                "MCO", "test", GIVEN_NAME, SUR_NAME, "IT1005256PSL", "GB", null, "123456789",
//                "ACH-2-20191211", "Mr", "harsimranjeet.singh@kamadhenu.co.in", null , "ZR", null);
//        Object obj = DollarService.book(bookRequest);
//        if (obj.getClass().getSimpleName().equals("Booking")) {
//            String bookingRefNo = ((Booking) obj).getConfirnationId();
//            CancelRequest cancelRequest = new CancelRequest("USD", "GB", SUR_NAME, GIVEN_NAME, bookingRefNo, "ZR");
//            Object object = DollarService.cancel(cancelRequest);
//            assertEquals("Cancel", object.getClass().getSimpleName());
//        }
//    }

    /**
     * Tests Date and Time validations constraints for SearchRequest
     */
//    @Test
//    public void DateAndTimevalidationsForSearch() {
//
//        try {
//            Search searchRequest = new Search("2012-04-14 15:00:00", "2020-04-21 09:00:00", "CAD",
//                    "MCO", "MCO", "IT1005255SPG", "GB",21);
//            DollarService.search(searchRequest);
//
//        } catch (FieldValidationException ex) {
//            if (ex.getMessage().contains(properties.getProperty("validation-datetime"))) {
//                assertEquals(1, 1);
//            } else {
//                assertEquals(1, 2);
//            }
//        }
//    }
//
//    /**
//     * Tests Date and Time validations constraints for BookRequest
//     */
//    @Test
//    public void DateAndTimevalidationsForBook() {
//
//        try {
//            Book bookRequest = new Book("USD", "2012-07-10 15:00:00", "2012-07-14 15:00:00", "MLBC01",
//                    "MCO", "test", GIVEN_NAME, SUR_NAME, "IT1005256PSL", "GB", null, "123456789",
//                    "ACH-2-20191211", "Mr", "harsimranjeet.singh@kamadhenu.co.in", null, "ZR", null);
//            DollarService.book(bookRequest);
//
//        } catch (FieldValidationException ex) {
//            if (ex.getMessage().contains(properties.getProperty("validation-datetime"))) {
//                assertEquals(1, 1);
//            } else {
//                assertEquals(1, 2);
//            }
//        }
//    }
//
//    /**
//     * Location Code Validations for SearchRequest
//     */
//    @Test
//    public void LocationCodeValidationForSearch() {
//
//        try {
//            Search searchRequest = new Search("2020-07-14 15:00:00", "2020-07-21 09:00:00", "CAD",
//                    "MCOZ", "", "IT1005255SPG", "GB",21);
//            DollarService.search(searchRequest);
//
//        } catch (FieldValidationException ex) {
//            if (ex.getMessage().contains("size must be between 3 and 2147483647")) {
//                assertEquals(1, 1);
//            } else {
//                assertEquals(1, 2);
//            }
//        }
//    }
//
//    /**
//     * Location Code Validations for BookRequest
//     */
//    @Test
//    public void LocationCodeValidationForBook() {
//        String pickUpDate = PICK_DATE.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//        String dropOffUpdate = DROP_DATE.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//        try {
//            Book bookRequest = new Book("USD", pickUpDate, dropOffUpdate, "",
//                    "MC", "test", GIVEN_NAME, SUR_NAME, "IT1005256PSL", "GB", null, "123456789",
//                    "ACH-2-20191211", "Mr", "harsimranjeet.singh@kamadhenu.co.in", null, "ZR", null);
//            DollarService.book(bookRequest);
//        } catch (FieldValidationException ex) {
//            if (ex.getMessage().contains("size must be between 3 and 2147483647")) {
//                assertEquals(1, 1);
//            } else {
//                assertEquals(1, 2);
//            }
//        }
//    }
//
//    /**
//     * Person Detail Validations for BookRequest
//     */
//    @Test
//    public void PersonDetialForBook() {
//        String pickUpDate = PICK_DATE.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//        String dropOffUpdate = DROP_DATE.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//        try {
//            Book bookRequest = new Book("USD", pickUpDate, dropOffUpdate, "MLBC01",
//                    "MCO", "test", "", "", "IT1005256PSL", "GB", null, "123456789",
//                    "ACH-2-20191211", "Mr", "harsimranjeet.singh@kamadhenu.co.in", null, "ZR", null);
//            DollarService.book(bookRequest);
//        } catch (FieldValidationException ex) {
//            if (ex.getMessage().contains("size must be between 2 and 255")) {
//                assertEquals(1, 1);
//            } else {
//                assertEquals(1, 2);
//            }
//        }
//    }
//}
