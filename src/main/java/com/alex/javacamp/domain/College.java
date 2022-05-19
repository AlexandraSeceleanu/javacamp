package com.alex.javacamp.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
@EqualsAndHashCode
public class College {
    private String name;
    private int id;
    private String address;
    private String city;

}
