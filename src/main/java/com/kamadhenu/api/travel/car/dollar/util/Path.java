package com.kamadhenu.api.travel.car.dollar.util;

import lombok.Data;

/**
 * Setup paths to be used by routes
 */
@Data
public class Path {

    public static final String API_BASE = "/api";

    // Search route
    public static final String SEARCH = API_BASE + "/search";

    //  Book route
    public static final String BOOK = API_BASE + "/book";

    //  Cancel route
    public static final String CANCEL = API_BASE + "/cancel";

    //  XsellItems route
    public static final String XSELLITEMS = API_BASE + "/xsellitems";

    // Prometheus route
    public static final String PROMETHEUS = API_BASE + "/prometheus";

}
