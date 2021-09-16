package com.jad.trainning.controller;

import com.github.pagehelper.PageInfo;
import com.jad.trainning.po.Clazz;
import com.jad.trainning.po.Teacher;
import com.jad.trainning.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private ITeacherService teacherService;

    @RequestMapping("/list")
    public ModelAndView list(){
       List<Teacher> list = teacherService.findAll();
       return  new ModelAndView("teacher/teacher_list","list",list);
    }

    @RequestMapping("/queryList/{pageNum}")
    public ModelAndView queryList(@PathVariable(value = "pageNum") Integer pageNum){
        if(pageNum==null){
            pageNum = 1;
        }
        PageInfo pageInfo = teacherService.queryByPage(pageNum, 10);
        return  new ModelAndView("teacher/teacher_list","pageInfo",pageInfo);
    }

    @RequestMapping("/deleteAll/{ids}")
    public ModelAndView deleteAll(@PathVariable String ids){
        try {
            teacherService.deleteAll(ids);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return queryList(1);
    }

    @RequestMapping("/queryList")
    @ResponseBody
    public List<Teacher> queryList(){
        return teacherService.findAll();
    }

    @RequestMapping("/saveOrUpdate")
    public ModelAndView saveOrUpdate(Teacher teacher){
        if(null==teacher.getId() || StringUtils.isEmpty(teacher.getId())){
            teacher.setId(UUID.randomUUID().toString().replace("-",""));
            teacherService.save(teacher);
        }else {
            teacherService.update(teacher);
        }
        return queryList(1);
    }

    @RequestMapping("/findById")
    @ResponseBody
    public Teacher findById(String id){
        return teacherService.findById(id);
    }

    @RequestMapping("/del")
    public ModelAndView delete(String id){
        teacherService.delete(id);
        return queryList(1);
    }
}
