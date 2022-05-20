package com.alex.javacamp.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Setter
@Getter
@Builder
@EqualsAndHashCode
public class Application {
    private int id;
    private int collegeId;
    private int candidateId;
    private Set<String> examId;
    private String status;
    // status : accepted , rejected
}
