package com.alex.javacamp.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.util.Set;

@Setter
@Getter
@Builder
@EqualsAndHashCode
public class Teacher {

    private String name;
    private int id;
    private Set<String> classes;
    private int collegeId;
//    private College college;
}
