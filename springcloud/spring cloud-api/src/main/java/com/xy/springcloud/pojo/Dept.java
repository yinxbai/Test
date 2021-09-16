package com.xy.springcloud.pojo;

import com.sun.xml.internal.bind.v2.model.core.ID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author InRoota
 */
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Dept implements Serializable {

    private Integer id;
    private String deptName;
    private String dbSource;

    public Integer getId() {
        return id;
    }

    public Dept setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getDeptName() {
        return deptName;
    }

    public Dept setDeptName(String deptName) {
        this.deptName = deptName;
        return this;
    }

    public String getDbSource() {
        return dbSource;
    }

    public Dept setDbSource(String dbSource) {
        this.dbSource = dbSource;
        return this;
    }



    /**
     * 链式写法
     *
     * dept.setXX().setYY().setZZ()
     */

}
