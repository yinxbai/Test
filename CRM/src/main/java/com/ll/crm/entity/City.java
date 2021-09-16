package com.ll.crm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * (City)实体类
 *
 * @author makejava
 * @since 2021-06-30 09:47:36
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class City implements Serializable {
    private static final long serialVersionUID = -68796895418774931L;

    private String id;

    private String name;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
