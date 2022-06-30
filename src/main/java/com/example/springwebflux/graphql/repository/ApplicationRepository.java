package com.example.springwebflux.graphql.repository;

import com.example.springwebflux.graphql.model.Application;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface ApplicationRepository extends ReactiveCrudRepository<Application, Long> {
    Mono<Application> findByName(String name);
}
