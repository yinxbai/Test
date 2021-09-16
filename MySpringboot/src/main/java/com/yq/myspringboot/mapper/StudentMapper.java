package com.yq.myspringboot.mapper;

import com.yq.myspringboot.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author InRoota
 * @date 2021-06-19  16:10
 */
@Mapper
public interface StudentMapper {

    List<Student> findAll();

    void save(Student student);
}
