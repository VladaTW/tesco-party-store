package com.tesco;

import io.micronaut.runtime.Micronaut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        LOGGER.info("Hello Micronaut World");
        Micronaut.run(Application.class, args);
        System.out.println("Hello from Tesco Micronaut Store!");
    }
}
