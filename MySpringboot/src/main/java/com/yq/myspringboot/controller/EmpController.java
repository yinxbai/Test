package com.yq.myspringboot.controller;

import com.yq.myspringboot.pojo.Dept;
import com.yq.myspringboot.pojo.Emp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author InRoota
 * @date 2021-06-19  11:47
 */
@Controller
public class EmpController {

    List<Emp> empList = new ArrayList<>();
    List<Dept> deptList = new ArrayList<>();
    public EmpController() throws ParseException {
        empList.add(new Emp("E1001", "Kotlin", 7839, "MANAGER", "2010-05-12", 2450.0, null,10,"ACCOUNTING"));
        empList.add(new Emp("E1002", "CLARK", null, "PRESIDENT", "2018-07-25", 5000.0, null,10,"ACCOUNTING"));
        empList.add(new Emp("E1003", "KING", 7782, "CLERK", "2016-05-18", 1300.0, null,10,"ACCOUNTING"));
        empList.add(new Emp("E1004", "MILLER", 7902, "CLERK", "2020-03-14", 800.0, null,20,"RESEARCH"));
        empList.add(new Emp("E1005", "SMITH", 7839, "MANAGER", "2019-06-22", 2975.0, null,20,"RESEARCH"));
        empList.add(new Emp("E1006", "JONES", 7566, "ANALYST", "2020-08-12", 3000.0, null,20,"RESEARCH"));
        empList.add(new Emp("E1007", "SCOTT", 7788, "CLERK", "2016-03-15", 1100.0, null,20,"RESEARCH"));
        empList.add(new Emp("E1008", "CAMS", 7566, "ANALYST", "2016-04-23", 3000.0, null,20,"RESEARCH"));
        empList.add(new Emp("E1009", "FORD", 7698, "SALESMAN", "2019-05-12", 1600.0, 300.0,30,"SALES"));
        empList.add(new Emp("E1010", "ALLEN", 7698, "SALESMAN", "2020-08-26", 1250.0, 500.0,30,"SALES"));
        empList.add(new Emp("E1011", "WARD", 7698, "SALESMAN", "2017-05-19", 1250.0, 1400.0,30,"SALES"));
        empList.add(new Emp("E1012", "MARTIN", 7839, "CLERK", "2012-03-25", 1800.0, null,30,"SALES"));
        empList.add(new Emp("E1013", "BLAKE", 7698, "MANAGER", "2015-09-11", 2850.0, null,30,"SALES"));
        empList.add(new Emp("E1014", "JAMES", 7698, "SALESMAN", "2016-04-16", 1500.0, null,30,"SALES"));
        empList.add(new Emp("E1015", "TURNER", 7698, "CLERK", "2020-09-10", 960.0, null,30,"SALES"));
        deptList.add(new Dept(10, "ACCOUNTING"));
        deptList.add(new Dept(20, "RESEARCH"));
        deptList.add(new Dept(30, "SALES"));
    }

    @RequestMapping("/index")
    public String index(HttpServletRequest request, Model model) {
        String keywords = request.getParameter("keywords");
        List<Emp> result = new ArrayList<Emp>();
        if (keywords == null) {
            result = empList;
        } else {
            for (Emp e : empList) {
                if (e.getName().toLowerCase().contains(keywords.toLowerCase())) {
                    result.add(e);
                }
            }
        }
        model.addAttribute("empList", result);
        return "index";
    }
}
