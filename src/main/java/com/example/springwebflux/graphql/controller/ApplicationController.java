package com.example.springwebflux.graphql.controller;

import com.example.springwebflux.graphql.model.Application;

import com.example.springwebflux.graphql.repository.ApplicationRepository;
import com.example.springwebflux.graphql.service.ApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.SignalType;

import java.util.logging.Level;

@Controller
@Slf4j
public class ApplicationController {

    private final ApplicationService appService;

    @Autowired
    public ApplicationController(ApplicationService appService) {
        this.appService = appService;
    }


    @QueryMapping("getAllApplication")
    Flux<Application> getAllApplications() {
        return processWithLog(this.appService.getAllApplications());
    }

    @QueryMapping("getApplicationById")
    Mono<Application> getApplicationById(@Argument Integer appId) {
        return processWithLog(this.appService.getApplicationById(appId));
    }

    @QueryMapping("getApplicationByName")
    Mono<Application> getApplicationByName(@Argument String name) {
        return processWithLog(this.appService.getApplicationByName(name));
    }

    private <T> Mono<T> processWithLog(Mono<T> monoToLog) {
        return monoToLog
                .log("ApplicationController.", Level.INFO, SignalType.ON_NEXT, SignalType.ON_COMPLETE);
    }

    private <T> Flux<T> processWithLog(Flux<T> fluxToLog) {
        return fluxToLog
                .log("ApplicationController.", Level.INFO, SignalType.ON_NEXT, SignalType.ON_COMPLETE);
    }


}
