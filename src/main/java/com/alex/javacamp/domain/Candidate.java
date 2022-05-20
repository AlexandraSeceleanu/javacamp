package com.alex.javacamp.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
@EqualsAndHashCode
public class Candidate {
    private String nume;
    private int candidateId;
    private String address;
    private String phoneNumber;
    private int average;
}
