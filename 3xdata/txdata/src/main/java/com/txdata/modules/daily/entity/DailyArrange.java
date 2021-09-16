package com.txdata.modules.daily.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 日报下一步安排表(TDailyArrange)实体类
 *
 * @author makejava
 * @since 2021-07-22 13:26:45
 */
public class DailyArrange implements Serializable {
    private static final long serialVersionUID = -35197316764504815L;

    private String id;
    /**
     * 日报id
     */
    private String dailyId;
    /**
     * 任务类型（1:软件开发、2:产品测试、3:UI设计、4:平面设计、5:项目实施、6:项目运维、7:技术支持、8:技术研究、9:需求沟通、10:售前支持、11:项目投标、12:材料编写、13:客户交流、14:厂商交流、15:培训学习、16:参加会议、17:其他工作）
     */
    private String dailyTaskType;
    /**
     * 下一步工作安排
     */
    private String remarks;
    /**
     * 计划完成时间
     */
    private Date finishDate;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private String sort;


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

    public String getDailyTaskType() {
        return dailyTaskType;
    }

    public void setDailyTaskType(String dailyTaskType) {
        this.dailyTaskType = dailyTaskType;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
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

}
