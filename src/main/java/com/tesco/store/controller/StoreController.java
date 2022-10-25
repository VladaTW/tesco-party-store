package com.tesco.store.controller;

import com.tesco.store.cqrs.Store;
import com.tesco.store.repository.StoreRepository;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Controller("/store")
public class StoreController {
    private Logger LOGGER = LoggerFactory.getLogger(StoreController.class);

    protected final StoreRepository storeRepository;

    public StoreController(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Get("/")
    public List<Store> getStores() {
        return new ArrayList<Store>();
    }

    @Get("/{id}")
    public Mono<Store> getStore(Long id) {
        return storeRepository.findById(id);
    }
}
