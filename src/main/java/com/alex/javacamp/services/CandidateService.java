package com.alex.javacamp.services;

import com.alex.javacamp.domain.Candidate;
import com.alex.javacamp.controller.CandidateController;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CandidateService {
    private static List<Candidate> list = new ArrayList<>();
    static  {
        list.add(new Candidate("Marinete Andrei",345 , "Constanta", "0788673214","9.67"));
        list.add(new Candidate("Popescu Ioana",  387 ,"Grigorescu", "0723845727", "9.54"));
        list.add(new Candidate("Andreescu Marius", 356 , "Minulescu", "0756692200","9.62"));
        list.add(new Candidate("Simionescu Cosma",  381 ,"Secembrie ", "0754789023", "9.58"));
    }

    //get all candidates

    public static List<Candidate> getAllCandidates() {
        return list;
    }

    //get single candidate by id
    public Candidate getCandidateById(int id){
        Candidate newcandidate= null;
        newcandidate = list.stream().filter(e -> e.getCandidateId()== id).findFirst().get();
                return newcandidate;}

    //adding the candidate
    public Candidate addCandidate(Candidate c) {
        list.add(c);
        return c;
    }

    public void deleteCandidate(int cId) {
        list = list.stream().filter(candidate -> candidate.getCandidateId()!= cId).
                collect(Collectors.toList());

    }

    //update candidate
    public void updateCandidate(Candidate candidate, int candidateId) {
        list = (List<Candidate>) list.stream().map(c ->{
            if(c.getCandidateId() ==candidateId )
            {   c.setName(candidate.getName());
                c.setAddress(candidate.getAddress());
                c.setPhoneNumber(candidate.getPhoneNumber());
                c.setAverage(candidate.getAverage());
            }
            return c;
        }).collect(Collectors.toList());

    }
}
