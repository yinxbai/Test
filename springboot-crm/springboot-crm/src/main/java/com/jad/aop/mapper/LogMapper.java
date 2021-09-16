package com.jad.aop.mapper;

import com.jad.aop.po.Log;
import org.apache.ibatis.annotations.Mapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Mapper
public interface LogMapper {
    public List<HashMap<String,String>> findAll();

    public void save(Log log);


}
