package com.alex.javacamp.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
@EqualsAndHashCode

public class Exam {

    private String note;
    private int id;
    private String subject;
    private String status;
    private int applicationId;

    //status: present, absent

}
