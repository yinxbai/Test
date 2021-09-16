package com.yq.myspringboot.service;

import com.yq.myspringboot.pojo.Student;

import java.util.List;

/**
 * @author InRoota
 * @date 2021-06-19  16:18
 */
public interface IStudentService {

     List<Student> findAll();

     void save(Student student);
}
