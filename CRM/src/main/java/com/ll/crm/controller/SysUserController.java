package com.ll.crm.controller;

import com.ll.crm.entity.SysUser;
import com.ll.crm.service.CityService;
import com.ll.crm.service.SysUserService;
import org.apache.catalina.LifecycleState;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.security.PublicKey;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * (SysUser)表控制层
 *
 * @author makejava
 * @since 2021-06-30 09:53:32
 */
@RestController
@RequestMapping("sysUser")
public class SysUserController {
    /**
     * 服务对象
     */
    @Resource
    private SysUserService sysUserService;

    /**
     * 通过主键查询单条数据
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public SysUser selectOne(String id) {
        return this.sysUserService.queryById(id);
    }

    @GetMapping("/myself")
    public ModelAndView mySelf(HttpServletRequest request){
        SysUser user = (SysUser) request.getSession().getAttribute("user");
//        String id = UUID.randomUUID().toString().replace("_","");
//        request.getSession().setAttribute("id",id);
        return new ModelAndView("Susses/sysUser_info","user",user);
    }

    @RequestMapping("/modify")
    public ModelAndView modify(SysUser sysUser){
        sysUserService.update(sysUser);
        System.out.println(sysUser);
        return list();
    }
    @RequestMapping("/list")
    public ModelAndView list(){
        List<SysUser> list = sysUserService.findAll();
        String id = UUID.randomUUID().toString().replace("_","");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("id",id);
        modelAndView.setViewName("Susses/sysUser_list");
        modelAndView.addObject("list",list);
        return modelAndView;
    }

    @RequestMapping("/delete/{ids}")
    public ModelAndView deleteAll(@PathVariable("ids")String ids){
        sysUserService.deleteAll(ids);
        return list();
    }

    @RequestMapping("/del")
    public ModelAndView deleteById(HttpServletRequest request){
        String id = request.getParameter("id");
        sysUserService.deleteById(id);
        return list();
    }
    @RequestMapping("/add")
    public ModelAndView add(SysUser sysUser, HttpServletRequest request, MultipartFile photoName){
        String id = UUID.randomUUID().toString().replace("_","");
        sysUser.setId(id);
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String uploadPath ="static/upload/"+sf.format(new Date()).substring(0,7);
        File parent =new File(request.getServletContext().getRealPath(uploadPath));
        if (!parent.exists()){
            parent.mkdirs();
        }
        String photo =photoName.getOriginalFilename();
        String uploadFileName =UUID.randomUUID().toString()+photo.substring(photo.lastIndexOf("."));
        sysUser.setPhoto(uploadPath+"/"+uploadFileName);
        try {
            photoName.transferTo(new File(parent,photo));
        } catch (IOException e) {
            e.printStackTrace();

        } sysUserService.insert(sysUser);
        System.out.println(sysUser);
        return list();
    }
    @RequestMapping("/queryName")
    public ModelAndView findByName(HttpServletRequest request){
        String name = request.getParameter("keywords");
        List<SysUser> list = sysUserService.findAll();
        List<SysUser> sysUsers = new ArrayList<SysUser>();
        if (list == null){
            sysUsers = list;
        }else {
            for (SysUser s:list) {
                if (s.getName().toLowerCase().contains(name.toLowerCase())){
                    sysUsers.add(s);
                }
            }
        }
        return new ModelAndView("Susses/sysUser_list","list",sysUsers);
    }
}
