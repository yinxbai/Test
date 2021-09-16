package com.yq.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student implements Serializable {

    private String id;
    private String account;
    private String password;
    private String name;
    private Clazz clazz;
    private String sex;
    private String telephone;
    private String birthday;


}
