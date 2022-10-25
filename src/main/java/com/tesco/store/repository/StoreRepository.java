package com.tesco.store.repository;

import com.tesco.store.cqrs.Store;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.data.exceptions.DataAccessException;
import io.micronaut.data.repository.reactive.ReactorPageableRepository;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;
import javax.validation.constraints.NotBlank;

public interface StoreRepository extends ReactorPageableRepository<Store, Long> { // <2>
    Mono<Store> save(@NonNull @NotBlank String name);  // VLD TODO  - extend the Entity class

    @Transactional
    default Mono<Store> saveWithException(@NonNull @NotBlank String name) {
        return save(name)
            .handle((genre, sink) -> {
                sink.error(new DataAccessException("test exception"));
            });
    }
}
