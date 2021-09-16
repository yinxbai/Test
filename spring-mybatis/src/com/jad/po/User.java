package com.jad.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author InRoota
 * @date 2021-05-26  21:30
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User implements Serializable {

    private Integer id;
    private Integer number;
    private String name;
    private String gender;
    private Integer age;
    private Integer cityId;

}
