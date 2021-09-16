package com.yq.myspringboot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author InRoota
 * @date 2021-06-19  16:09
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student implements Serializable {

    private String id;
    private String account;
    private String password;
    private String name;
    private String birthday;
}

