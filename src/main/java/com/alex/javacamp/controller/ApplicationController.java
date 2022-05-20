package com.alex.javacamp.controller;

import com.alex.javacamp.domain.Application;
import com.alex.javacamp.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class ApplicationController {
    @Autowired
    private ApplicationRepository applicationRepository;

    @GetMapping("/api/applications")
    public List<Application> list() {
        return applicationRepository.findAll();
    }

    @GetMapping("/api/applications/{applicationsId}")
    public Application getByapplicationsId(@PathVariable("applicationsId") int applicationsId) {
        return applicationRepository.findById(applicationsId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Application with applicationsId=%s not found", applicationsId)));
    }
}
