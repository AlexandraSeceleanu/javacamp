package com.alex.javacamp.repository;

import com.alex.javacamp.domain.Application;
import com.google.common.collect.ImmutableSet;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ApplicationRepository {
    private static ConcurrentHashMap<Integer, Application> storage = new ConcurrentHashMap<>();
    static {
        storage.put(30, Application.builder()
                .candidateId(11)
                .collegeId(1)
                .examId(ImmutableSet.of("21"))
                .id(30)
                .status("rejected")
                .build());
        storage.put(31, Application.builder()
                .candidateId(10)
                .collegeId(1)
                .examId(ImmutableSet.of("20"))
                .id(31)
                .status("accepted")
                .build());
    }

    public List<Application> findAll() {
        return new ArrayList<>(storage.values());
    }

    public Optional<Application> findById(int id) {
        return Optional.ofNullable(storage.get(id));
    }

    public Application save(Application application) {
        application.setId(application.hashCode());
        return storage.put(application.hashCode(), application);
    }
}
