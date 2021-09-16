package com.yq.controller;

import com.yq.po.Clazz;
import com.yq.service.IClazzService;
import com.yq.service.IStudentService;
import com.yq.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/clazz")
public class ClazzController {

    @Autowired
    private IClazzService clazzService;
    @Resource
    private ITeacherService teacherService;
    @Resource
    private IStudentService studentService;

    @RequestMapping("/list")
    public ModelAndView list(){
        List<Clazz> list = clazzService.findAll();
        return new ModelAndView("clazz/clazz_list","list",list);
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public List<Clazz> findAll(HttpServletResponse response){
        List<Clazz> list = clazzService.findAll();
        return list;
    }

    @RequestMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") String id){
        clazzService.deleteById(id);
        return list();
    }

    @RequestMapping("/check/{id}")
    public void check(@PathVariable("id") String id,HttpServletResponse response){
        int studentNum = studentService.findCount(id);
        int teacherNum = teacherService.findCount(id);
        boolean isExist = false;
        if(studentNum>0 && teacherNum>0){
            isExist = true;
        }
        try {
            PrintWriter out = response.getWriter();
            out.print(isExist);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/update")
    public ModelAndView update(Clazz clazz){
        clazzService.update(clazz);
        return list();
    }

    @RequestMapping("/save")
    public ModelAndView save(String name){
        String id = UUID.randomUUID().toString();
        Clazz clazz = new Clazz(id,name);
        clazzService.save(clazz);
        return list();
    }

    @RequestMapping("/batchDelete")
    public ModelAndView batchDelete(@RequestParam("check")String[] ids) {
        try {
            clazzService.bacthDelete(ids);
        } catch (Exception e) {
            System.err.println("删除失败");
        }
        return list();
    }

    @RequestMapping("/searchByName")
    public void searchByName(String name, HttpServletResponse response){
        Clazz clazz = clazzService.findByName(name);
        boolean isExist = false;
        if (null!=clazz){
            isExist = true;
        }
        try {
            PrintWriter out = response.getWriter();
            out.print(isExist);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
