package com.yq.myspringboot.service.impl;

import com.yq.myspringboot.mapper.StudentMapper;
import com.yq.myspringboot.pojo.Student;
import com.yq.myspringboot.service.IStudentService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author InRoota
 * @date 2021-06-19  16:19
 */
@Service
public class StudentServiceImpl implements IStudentService {

    @Resource
    private StudentMapper studentMapper;

    @Override
//    @CacheEvict(cacheNames = "student" ,key = "10086")
    @Cacheable(cacheNames = "student" , key = "10086" ,unless = "{#result=null}")
    public List<Student> findAll() {
        System.out.println("query database");
        return studentMapper.findAll();
    }

    @Override
    @CachePut(cacheNames = "student",key = "10086")
    public void save(Student student) {

        studentMapper.save(student);
    }
}
