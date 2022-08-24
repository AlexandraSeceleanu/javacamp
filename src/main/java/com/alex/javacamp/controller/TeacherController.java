package com.alex.javacamp.controller;

import com.alex.javacamp.domain.Teacher;
import com.alex.javacamp.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class TeacherController {

        @Autowired
        private TeacherRepository teacherRepository;

        @GetMapping("/api/teachers")
        public List<Teacher> list() { return teacherRepository.findAll();
        }

        @GetMapping("/api/teachers/{id}")
        public Teacher getById(@PathVariable("id") int id) {
            return teacherRepository.findById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Teacher with id=%s not found", id)));
        }
    }

