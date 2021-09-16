package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;


/**
 * @author InRoota
 * @date 2021-06-24  13:31
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Province implements Serializable {

    private String id;
    private String name;

}
