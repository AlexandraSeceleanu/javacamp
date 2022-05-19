package com.alex.javacamp.controller;

import com.alex.javacamp.domain.College;
import com.alex.javacamp.repository.CollegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class CollegeController {

    @Autowired
    private CollegeRepository collegeRepository;

    @GetMapping("/api/colleges")
    public List<College> list() {
        return collegeRepository.findAll();
    }

    @GetMapping("/api/colleges/{id}")
    public College getById(@PathVariable("id") int id) {
        return collegeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("College with id=%s not found", id)));
    }
}
