package com.kamadhenu.api.travel.car.dollar.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kamadhenu.api.travel.car.dollar.model.domain.request.Book;
import com.kamadhenu.api.travel.car.dollar.model.domain.request.Cancel;
import com.kamadhenu.api.travel.car.dollar.model.domain.request.Search;
import com.kamadhenu.api.travel.car.dollar.model.domain.request.XsellItems;
import com.kamadhenu.api.travel.car.dollar.service.DollarService;
import com.kamadhenu.api.travel.car.dollar.util.StringToNumber;
import com.kamadhenu.api.travel.car.dollar.util.ValidatorUtil;
import io.javalin.http.Handler;

/**
 * Handles all the dollar api calls
 */
public class DollarController {

    /**
     * Handle Search Request
     */
    public static Handler search = ctx -> {
        Gson gson = new GsonBuilder().registerTypeAdapter(Integer.class, new StringToNumber()).create();
        Search searchRequest = gson.fromJson(ctx.body(), Search.class);
        ValidatorUtil.validate(searchRequest);
        ctx.json(DollarService.search(searchRequest));
    };

    /**
     * Handle XsellItem Request
     */
    public static Handler xsellitem = ctx -> {
        XsellItems xsellItemsRequest = new Gson().fromJson(ctx.body(), XsellItems.class);
//        ctx.json(DollarService.xsellItem(xsellItemsRequest));
//        DollarService.xsellItem(xsellItemsRequest);
    };

    /**
     * Handle Book Request
     */
    public static Handler book = ctx -> {
        Book bookRequest = new Gson().fromJson(ctx.body(), Book.class);
        ValidatorUtil.validate(bookRequest);
        ctx.json(DollarService.book(bookRequest));
    };

    /**
     * Handle Cancel Request
     */
    public static Handler cancel = ctx -> {
        Cancel cancelRequest = new Gson().fromJson(ctx.body(), Cancel.class);
        ValidatorUtil.validate(cancelRequest);
        ctx.json(DollarService.cancel(cancelRequest));
    };
}
