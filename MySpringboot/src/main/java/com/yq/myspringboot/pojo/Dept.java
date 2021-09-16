package com.yq.myspringboot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author InRoota
 * @date 2021-06-19  11:45
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Dept {
    private Integer id;
    private String name;
}
