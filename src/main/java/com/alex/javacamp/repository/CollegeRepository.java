package com.alex.javacamp.repository;

import com.alex.javacamp.domain.College;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class CollegeRepository {
    private static ConcurrentHashMap<Integer, College> storage = new ConcurrentHashMap<>();
    static {
        storage.put(1, College.builder()
                .address("Splai")
                .id(1)
                .city("Bucharest")
                .name("ACS")
                .build());
        storage.put(2, College.builder()
                .address("Splai")
                .id(2)
                .city("Bucharest")
                .name("ETTI")
                .build());
    }

    public List<College> findAll() {
        return new ArrayList<>(storage.values());
    }

    public Optional<College> findById(int id) {
        return Optional.ofNullable(storage.get(id));
    }

    public College save(College college) {
        college.setId(college.hashCode());
        return storage.put(college.hashCode(), college);
    }
}
