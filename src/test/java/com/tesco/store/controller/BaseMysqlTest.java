package com.tesco.store.controller;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.util.CollectionUtils;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import io.micronaut.test.support.TestPropertyProvider;
import jakarta.inject.Inject;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.TestInstance;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.utility.DockerImageName;

import java.util.Map;

@MicronautTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseMysqlTest implements TestPropertyProvider {

    static GenericContainer mysqlContainer;

    @Inject
    @Client("/")
    HttpClient httpClient;

    void startMySql(){
        if(mysqlContainer == null) {
            mysqlContainer = new GenericContainer<>(DockerImageName.parse("mysql:8"))
                .withExposedPorts(3306)
                .withEnv("MYSQL_ROOT_PASSWORD", "tesco-rules")
                .withEnv("MYSQL_DATABASE", "tesco")
                .waitingFor(Wait.forLogMessage(".*/usr/sbin/mysqld: ready for connections.*\\n", 2));
        }
        if (!mysqlContainer.isRunning()){
            mysqlContainer.start();
        }
    }


    String getMySQLDbUri(){
        if (mysqlContainer == null || mysqlContainer.isRunning()){
            startMySql();
        }
        return "jdbc:mysql://localhost:" + mysqlContainer.getMappedPort(3306) + "/db";
    }

    @Override
    @NonNull
    public Map<String, String> getProperties() {
        return CollectionUtils.mapOf(
            "jpa.default.properties.hibernate.connection.url", getMySQLDbUri(),
            "datasources.migration.url", getMySQLDbUri(),
            "datasources.migration.driverClassName", "com.mysql.cj.jdbc.Driver"
        );
    }

    @AfterAll
    public static void stop(){
        mysqlContainer.close();
    }
}
