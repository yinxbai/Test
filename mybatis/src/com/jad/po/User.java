package com.jad.po;

import lombok.*;

import java.io.Serializable;


/**
 * @author 54020
 */
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private int id;
    private int number;
    private String name;
    private String gender;
    private int age;
    private int cityId;
    private City city;
}
