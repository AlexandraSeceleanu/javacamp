package com.alex.javacamp.repository;

import com.alex.javacamp.domain.Exam;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ExamRepository {
        private static ConcurrentHashMap<Integer, Exam> storage = new ConcurrentHashMap<>();
        static {
            storage.put(20, Exam.builder()
                    .id(20)
                    .note("9.50")
                    .status("present")
                    .subject("matematica")
                    .build());
            storage.put(21, Exam.builder()
                    .id(21)
                    .note("0.00")
                    .status("absent")
                    .subject("matematica")
                    .build());
        }

        public List<Exam> findAll() {
            return new ArrayList<>(storage.values());
        }

        public Optional<Exam> findById(int id) {
            return Optional.ofNullable(storage.get(id));
        }

        public Exam save(Exam exam) {
            exam.setId(exam.hashCode());
            return storage.put(exam.hashCode(), exam);
        }
    }
