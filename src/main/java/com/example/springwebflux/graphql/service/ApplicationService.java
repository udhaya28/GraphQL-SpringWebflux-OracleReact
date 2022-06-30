package com.example.springwebflux.graphql.service;

import com.example.springwebflux.graphql.model.Application;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ApplicationService {
    Mono<Application> getApplicationById(Integer id);
    Mono<Application> getApplicationByName(String name);
    Flux<Application> getAllApplications();
}
