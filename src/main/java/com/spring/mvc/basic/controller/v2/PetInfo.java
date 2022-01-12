package com.spring.mvc.basic.controller.v2;

import lombok.*;

import java.util.*;

@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
public class PetInfo {

    private String kind;
    private String name;
    private int age;
    private boolean injection; // 예방접종
    private List<String> hobby; //좋아하는것
}
