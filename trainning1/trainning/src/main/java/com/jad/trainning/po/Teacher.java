package com.jad.trainning.po;

import lombok.Data;

@Data
public class Teacher {
    private String id;
    private String account;
    private String password;
    private String name;
    private Clazz clazz;
    private String role;
}
