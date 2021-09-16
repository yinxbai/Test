package com.txdata.modules.daily.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (TDailyProblem)实体类
 *
 * @author makejava
 * @since 2021-07-22 13:26:49
 */
public class DailyProblem implements Serializable {
    private static final long serialVersionUID = 791236395228371544L;

    private String id;
    /**
     * 问题类型
     */
    private String type;
    /**
     * 项目名称
     */
    private String name;
    /**
     * 答复时间
     */
    private Date recordTime;
    /**
     * 支持
     */
    private String support;
    /**
     * 描述
     */
    private String description;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    public String getSupport() {
        return support;
    }

    public void setSupport(String support) {
        this.support = support;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
