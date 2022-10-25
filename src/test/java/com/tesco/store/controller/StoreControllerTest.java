package com.tesco.store.controller;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class StoreControllerTest extends BaseMysqlTest {

    // VLD TODO - test each CRUD operation separately
//    @Test
//    public void testStoreCrudOperations() {
//
//
//    }

//
//    @Test
//    public void testGetStore() {
//
//        HttpRequest<?> request = HttpRequest.POST("/genres", Collections.singletonMap("name", "DevOps")); // <2>
//        HttpResponse<?> response = httpClient.toBlocking().exchange(request);
//        genreIds.add(entityId(response));
//
//        assertEquals(HttpStatus.CREATED, response.getStatus());
//
//        request = HttpRequest.POST("/genres", Collections.singletonMap("name", "Microservices")); // <3>
//        response = httpClient.toBlocking().exchange(request);
//
//        assertEquals(HttpStatus.CREATED, response.getStatus());
//
//        Long id = entityId(response);
//        genreIds.add(id);
//        request = HttpRequest.GET("/genres/" + id);
//
//
    }

