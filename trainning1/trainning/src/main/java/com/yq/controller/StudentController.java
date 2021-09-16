package com.yq.controller;


import com.github.pagehelper.PageInfo;
import com.yq.po.Student;
import com.yq.service.IStudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Resource
    private IStudentService studentService;

    @RequestMapping("/list")
    public ModelAndView list(){
        List<Student> list = studentService.findAll();
        return new ModelAndView("student/student_list","list",list);
    }

    @RequestMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") String id){
        studentService.deleteById(id);
        return list();
    }

    @RequestMapping("/update")
    public ModelAndView update(Student student){
        studentService.update(student);
        return list();
    }

    @RequestMapping("/save")
    public ModelAndView save(String name){
        String id = UUID.randomUUID().toString();
        return list();
    }

    @RequestMapping("info/{pageNum}")
    public ModelAndView info(@PathVariable("pageNum") Integer pageNum){
        if(null==pageNum){
            pageNum=1;
        }
        PageInfo list = studentService.info(pageNum,6);
        return new ModelAndView("student/student_list","list",list);
    }
}
