package com.yq.myspringboot.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author InRoota
 * @date 2021-06-19  11:45
 */
@Data
@NoArgsConstructor
@ToString
public class Emp {

    private String id;
    private String name;
    private Integer mgr;
    private String job;
    private Date hireDate;
    private Double salary;
    private Double comm;
    private Integer deptNo;
    private String deptName;

    public Emp(String id, String name, Integer mgr, String job, String hireDate, Double salary, Double comm, Integer deptNo, String deptName) throws  ParseException {
        this.id = id;
        this.name = name;
        this.mgr = mgr;
        this.job = job;
        if (null!=hireDate){
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            this.hireDate = sf.parse(hireDate);
        }
        this.salary = salary;
        this.comm = comm;
        this.deptNo = deptNo;
        this.deptName = deptName;
    }

}
