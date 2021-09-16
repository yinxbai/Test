package com.txdata.modules.daily.entity;

import java.util.Date;
import java.io.Serializable;
import java.util.List;

/**
 * 项目备案基本信息表(Project)实体类
 *
 * @author makejava
 * @since 2021-07-23 09:43:59
 */
public class Project implements Serializable {
    private static final long serialVersionUID = 771010299920792195L;

    private String id;
    /**
     * 项目编号
     */
    private String code;
    /**
     * 项目名称
     */
    private String name;
    /**
     * 项目类型
     */
    private String projectType;
    /**
     * 备案人
     */
    private String recordPeopel;
    /**
     * 备案时间
     */
    private Date recordTime;
    /**
     * 项目干系人(关联客户)
     */
    private String customers;

    private Date createDate;

    private String createBy;

    private Date updateDate;

    private String updateBy;
    /**
     * 项目状态
     */
    private String status;
    /**
     * 删除标志 1-已删除 0-未删除
     */
    private String delFlag;
    /**
     * 所属地区
     */
    private String areaId;

    private List<DailyTask> dailyTasks;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getRecordPeopel() {
        return recordPeopel;
    }

    public void setRecordPeopel(String recordPeopel) {
        this.recordPeopel = recordPeopel;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    public String getCustomers() {
        return customers;
    }

    public void setCustomers(String customers) {
        this.customers = customers;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public void setDailyTasks(List<DailyTask> dailyTasks) {
        this.dailyTasks = dailyTasks;
    }

    public List<DailyTask> getDailyTasks() {
        return dailyTasks;
    }
}
