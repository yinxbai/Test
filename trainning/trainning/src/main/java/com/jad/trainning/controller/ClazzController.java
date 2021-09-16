package com.jad.trainning.controller;

import com.github.pagehelper.PageInfo;
import com.jad.trainning.po.Clazz;
import com.jad.trainning.po.Student;
import com.jad.trainning.service.IClazzService;
import org.aopalliance.intercept.Joinpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/clazz")
public class ClazzController {

    @Autowired
    private IClazzService clazzService;

    @RequestMapping("/list")
    public ModelAndView list(){
        List<Clazz> list = clazzService.findAll();
        return new ModelAndView("clazz/clazz_list","list",list);
    }

    @RequestMapping("/add")
    public ModelAndView add(){
        String id = UUID.randomUUID().toString();
        return new ModelAndView("clazz/clazz_add","id",id);
    }

    @RequestMapping("/save")
    public ModelAndView save(Clazz clazz){
        clazzService.save(clazz);
        return list();
    }

    @RequestMapping("/queryByPage/{pageNum}")
    public ModelAndView queryByPage(@PathVariable("pageNum") Integer pageNum){
        if(null==pageNum){
            pageNum = 1;
        }
        PageInfo pageInfo = clazzService.queryByPage(pageNum,10);
        return new ModelAndView("clazz/clazz_list","pageInfo",pageInfo);
    }

    @RequestMapping("/saveOrUpdate")
    public ModelAndView saveOrUpdate(Clazz clazz){
        System.out.println(clazz);
        if(null==clazz.getId() || StringUtils.isEmpty(clazz.getId())){
            clazz.setId(UUID.randomUUID().toString().replace("-",""));
            clazzService.save(clazz);
        }else{
            clazzService.update(clazz);
        }
        return queryByPage(1);
    }

    @RequestMapping("/queryJson")
    @ResponseBody
    public List<Clazz> queryJson(){
        return clazzService.findAll();
    }

    @RequestMapping("/findById")
    @ResponseBody
    public Clazz findById(String id){
        Clazz clazz = clazzService.findById(id);
        return clazz;
    }

    @RequestMapping("/delete")
    public ModelAndView delete(String id){
        clazzService.delete(id);
        return queryByPage(1);
    }

    @RequestMapping("/deleteAll")
    public ModelAndView deleteAll(String ids){
        clazzService.deleteAll(ids);
        return queryByPage(1);
    }

}
