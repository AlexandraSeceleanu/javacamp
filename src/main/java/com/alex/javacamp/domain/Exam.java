package com.alex.javacamp.domain;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.SecondaryTable;

@Setter
@Getter
@Builder
@EqualsAndHashCode
@Data

public class Exam {
@GeneratedValue
    private String note;
    private int id;
    private String subject;
    private String status;
    private int applicationId;

    //status: present, absent

}
