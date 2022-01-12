package com.spring.mvc.basic.controller.v2;

import lombok.*;

@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
public class UserBmi {

    private String userName;
    private double height;
    private double weight;

}
