package com.jad.po;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @author InRoota
 * @date 2021-05-26  18:44
 */

@Data
@ToString
public class City implements Serializable {
    private int id;
    private String name;
    private List<User> users;

}
