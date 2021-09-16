package com.yq.controller;

import com.github.pagehelper.PageInfo;
import com.yq.po.Student;
import com.yq.service.ExerciseService;
import com.yq.service.impl.ExerciseServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * @author InRoota
 * @date 2021-06-21  18:21
 */
@Controller
@RequestMapping("/exercise")
public class ExerciseController {

    @Resource
    private ExerciseServiceImpl exerciseService;

    @RequestMapping("/list/{pageNum}")
    public ModelAndView info(@PathVariable("pageNum")Integer pageNum) {

        if (null==pageNum){
            pageNum = 1;
        }
        PageInfo list = exerciseService.findAll(pageNum,6);

        return new ModelAndView("exercise/Exercise_list","list",list);
    }
}
