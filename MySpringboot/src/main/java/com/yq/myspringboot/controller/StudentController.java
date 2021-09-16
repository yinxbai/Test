package com.yq.myspringboot.controller;

import com.yq.myspringboot.pojo.Student;
import com.yq.myspringboot.service.IStudentService;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * @author InRoota
 * @date 2021-06-19  16:33
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @Resource
    private IStudentService studentService;

    @RequestMapping("/list")
    @ResponseBody
    public List<Student> findAll(){

        List<Student> list = studentService.findAll();

        return list;
    }

    @RequestMapping("/save")
    public String save(){
        String id = UUID.randomUUID().toString();
        Student student = new Student(id,"1213","123","da","2020-00-00");
        studentService.save(student);
        return "index";
    }
}
