package com.txdata.modules.daily.entity;

import java.util.Date;
import java.io.Serializable;
import java.util.List;

/**
 * 工作日报信息表(TDaily)实体类
 *
 * @author makejava
 * @since 2021-07-22 13:26:39
 */
public class Daily implements Serializable {
    private static final long serialVersionUID = -66445252796047085L;

    private String id;

    private String title;

    private String dept;
    /**
     * 填写人
     */
    private String writeUser;
    /**
     * 填写日期
     */
    private Date writeDate;

    private String createBy;
    /**
     * 职位
     */
    private String post;

    private Date createDate;

    private String updateBy;

    private Date updateDate;
    /**
     * 状态（（0:待审核1：通过，2：不通过））
     */
    private String status;
    /**
     * 汇报日期
     */
    private Date reportDate;

    private String remarks;
    /**
     * 删除标识  0：正常；1：删除
     */
    private String delFlag;

    private String filePath;

    private List<DailyTask> dailyTasks;
    private List<DailyArrange> dailyArranges;
    private List<Project> projects;
    private List<DailyProblem> problemLis;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getWriteUser() {
        return writeUser;
    }

    public void setWriteUser(String writeUser) {
        this.writeUser = writeUser;
    }

    public Date getWriteDate() {
        return writeDate;
    }

    public void setWriteDate(Date writeDate) {
        this.writeDate = writeDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }


    public List<DailyTask> getDailyTasks() {
        return dailyTasks;
    }

    public void setDailyTasks(List<DailyTask> dailyTasks) {
        this.dailyTasks = dailyTasks;
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

    public List<DailyProblem> getProblemLis() {
        return problemLis;
    }

    public void setProblemLis(List<DailyProblem> problemLis) {
        this.problemLis = problemLis;
    }
}
