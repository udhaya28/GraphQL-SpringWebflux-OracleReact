package com.example.springwebflux.graphql.service;

import com.example.springwebflux.graphql.exception.EntityMappingException;
import com.example.springwebflux.graphql.model.Application;
import com.example.springwebflux.graphql.repository.ApplicationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Slf4j
@Service
public class ApplicationServiceImpl implements ApplicationService{

    private final ApplicationRepository repository;

    @Autowired
    public ApplicationServiceImpl(ApplicationRepository repository) {
        this.repository = repository;
    }



    @Override
    public Mono<Application> getApplicationById(Integer id) {
        final String errorMessage = String.format("There is no Application with id: '%d'", id);
        return processWithErrorCheck(this.repository.findById(id.longValue()), errorMessage);
    }

    @Override
    public Mono<Application> getApplicationByName(String name) {
        final String errorMessage = String.format("There is no Application with name: '%s'", name);
        return processWithErrorCheck(this.repository.findByName(name), errorMessage);
    }

    @Override
    public Flux<Application> getAllApplications() {
        final String errorMessage = "There is an issue getting all of Application.";
        return processWithErrorCheck(this.repository.findAll(), errorMessage);
    }



    private <T> Mono<T> processWithErrorCheck(Mono<T> monoToCheck, String errorMessage) {
        return monoToCheck.switchIfEmpty(Mono.defer(() -> {
            log.error(errorMessage);
            return Mono.error(new EntityMappingException(errorMessage));
        }));
    }

    private <T> Flux<T> processWithErrorCheck(Flux<T> fluxToCheck, String errorMessage) {
        return fluxToCheck.switchIfEmpty(Flux.defer(() -> {
            log.error(errorMessage);
            return Flux.error(new EntityMappingException(errorMessage));
        }));
    }
}
