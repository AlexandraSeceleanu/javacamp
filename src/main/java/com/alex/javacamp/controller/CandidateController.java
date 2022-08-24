package com.alex.javacamp.controller;

import com.alex.javacamp.domain.Candidate;
import com.alex.javacamp.repository.CandidateRepository;
import com.alex.javacamp.services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping
public class CandidateController {

    @Autowired
    private CandidateRepository candidateRepository;
    private CandidateService candidateService;

    @GetMapping("/api/candidates")
    public List<Candidate> list() {
        return candidateRepository.findAll();
    }

    @GetMapping("/api/candidates/{candidateId}")
    public Candidate getBycandidateId(@PathVariable("candidateId") int candidateId) {
        return candidateRepository.findById(candidateId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Canditate with candidateId=%s not found", candidateId)));
    }
    @PostMapping("/api/candidates/add")
    public Candidate addCandidate(@RequestBody Candidate newcandidate){
        Candidate c = this.candidateService.addCandidate(newcandidate);
        System.out.println(newcandidate);
        return c;
    }

    @DeleteMapping("/api/candidates/{candidateId}/delete")
    public void deleteCandidate(@PathVariable ("candidateId") int candidateId){
        this.candidateService.deleteCandidate(candidateId);

    }
}
