package com.alex.javacamp.repository;

import com.alex.javacamp.domain.Candidate;
import com.alex.javacamp.domain.College;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class CandidateRepository {
    private static ConcurrentHashMap<Integer, Candidate> storage = new ConcurrentHashMap<>();
    static {
        storage.put(10, Candidate.builder()
                .nume("Ioana")
                .candidateId(10)
                .address("Craiova")
                .average("9.20")
                .phoneNumber("0788534091")
                .build());
        storage.put(11, Candidate.builder()
                .nume("Alex")
                .candidateId(11)
                .address("Iasi")
                .average("8.70")
                .phoneNumber("0734534091")
                .build());
    }

    public List<Candidate> findAll() {
        return new ArrayList<>(storage.values());
    }

    public Optional<Candidate> findById(int candidateId) {
        return Optional.ofNullable(storage.get(candidateId));
    }

    public Candidate save(Candidate candidate) {
        candidate.setCandidateId(candidate.hashCode());
        return storage.put(candidate.hashCode(), candidate);
    }
}
