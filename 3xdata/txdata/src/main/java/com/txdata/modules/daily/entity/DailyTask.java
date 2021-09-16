package com.txdata.modules.daily.entity;

import java.util.Date;
import java.io.Serializable;
import java.util.List;

/**
 * 工作日报任务明细表(DailyTask)实体类
 *
 * @author makejava
 * @since 2021-07-22 13:26:50
 */
public class DailyTask implements Serializable {
    private static final long serialVersionUID = -67305309958341652L;

    private String id;
    /**
     * 日报id
     */
    private String dailyId;
    /**
     * 项目id
     */
    private String projectId;
    /**
     * 任务类型（1:软件开发、2:产品测试、3:UI设计、4:平面设计、5:项目实施、6:项目运维、7:技术支持、8:技术研究、9:需求沟通、10:售前支持、11:项目投标、12:材料编写、13:客户交流、14:厂商交流、15:培训学习、16:参加会议、17:其他工作）
     */
    private String dailyTaskType;
    /**
     * 花费工时
     */
    private Double usetime;
    /**
     * 任务完成度
     */
    private Integer percentComplete;
    /**
     * 工作任务描述
     */
    private String remarks;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private String sort;

    private List<DailyArrange> dailyArranges;
    private List<Project> projects;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDailyId() {
        return dailyId;
    }

    public void setDailyId(String dailyId) {
        this.dailyId = dailyId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getDailyTaskType() {
        return dailyTaskType;
    }

    public void setDailyTaskType(String dailyTaskType) {
        this.dailyTaskType = dailyTaskType;
    }

    public Double getUsetime() {
        return usetime;
    }

    public void setUsetime(Double usetime) {
        this.usetime = usetime;
    }

    public Integer getPercentComplete() {
        return percentComplete;
    }

    public void setPercentComplete(Integer percentComplete) {
        this.percentComplete = percentComplete;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public List<DailyArrange> getDailyArranges() {
        return dailyArranges;
    }

    public void setDailyArranges(List<DailyArrange> dailyArranges) {
        this.dailyArranges = dailyArranges;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
