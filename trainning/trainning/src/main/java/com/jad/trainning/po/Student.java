package com.jad.trainning.po;

import lombok.Data;

@Data
public class Student {
    private String id;
    private String account;
    private String password;
    private String name;
    private String sex;
    private String telphone;
    private String birthday;
    private Clazz clazz;


}
