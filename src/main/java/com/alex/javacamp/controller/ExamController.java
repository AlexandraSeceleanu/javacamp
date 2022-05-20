package com.alex.javacamp.controller;

import com.alex.javacamp.domain.Exam;
import com.alex.javacamp.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class ExamController {
    @Autowired
    private ExamRepository examRepository;

    @GetMapping("/api/exams")
    public List<Exam> list() {
        return examRepository.findAll();
    }

    @GetMapping("/api/exams/{id}")
    public Exam getById(@PathVariable("id") int id) {
        return examRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Exam with id=%s not found", id)));
    }
}
