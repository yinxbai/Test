package com.yq.controller;


import com.github.pagehelper.PageInfo;
import com.yq.po.Clazz;
import com.yq.po.Teacher;
import com.yq.service.IClazzService;
import com.yq.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Resource
    private ITeacherService teacherService;
    @Autowired
    private IClazzService clazzService;

    @RequestMapping("/queryList/{pageNum}")
    public ModelAndView queryList(@PathVariable Integer pageNum){

        PageInfo pageInfo = teacherService.queryByPage(pageNum,5);

        return new ModelAndView("teacher/teacher_list","pageInfo",pageInfo);
    }

    @RequestMapping("/list")
    public ModelAndView list(){
        List<Teacher> list = teacherService.findAll();
        List<Clazz> clazzList = clazzService.findAll();
        ModelAndView mv = new ModelAndView("teacher/teacher_list");
        mv.addObject(list);
        mv.addObject(clazzList);
        System.out.println(clazzList);
        return mv;
    }

    @RequestMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") String id){
        teacherService.deleteById(id);
        return list();
    }

    @RequestMapping("/update")
    public ModelAndView update(Teacher teacher){
        teacherService.update(teacher);
        return list();
    }

    @RequestMapping("/save")
    public ModelAndView save(Teacher teacher){

        String id = UUID.randomUUID().toString();
        teacher.setId(id);
        teacherService.save(teacher);
        List<Teacher> list = teacherService.findAll();
        list.add(teacher);
        System.out.println(teacher);
        return list();
    }
}
