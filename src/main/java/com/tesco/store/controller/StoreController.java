package com.tesco.store.controller;

import com.tesco.store.cqrs.Store;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;


@Controller("/store")
public class StoreController {
    private Logger LOGGER = LoggerFactory.getLogger(StoreController.class);

    @Get("/")
    public String getStores() {
        return "The getter works (sort of)";
    }
}
