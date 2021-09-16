package com.txdata.modules.daily.domain;

import com.txdata.common.domain.DataEntity;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 工作日报任务明细表
 * 
 * @author 3xdata
 * @email 3xdata@3xdata.cn
 * @date 2021-07-21 18:50:40
 */
public class DailyTaskDO extends DataEntity<DailyTaskDO> {
	private static final long serialVersionUID = 1L;

	private String dailyId;  //日报id 
	private String projectId;  //项目id 
	private String dailyTaskType;  //任务类型（1:软件开发、2:产品测试、3:UI设计、4:平面设计、5:项目实施、6:项目运维、7:技术支持、8:技术研究、9:需求沟通、10:售前支持、11:项目投标、12:材料编写、13:客户交流、14:厂商交流、15:培训学习、16:参加会议、17:其他工作） 
	private BigDecimal usetime;  //花费工时 
	private Integer percentComplete;  //任务完成度 
	private String sort;  // 
	
	public void setDailyId(String dailyId) {
		this.dailyId = dailyId;
	}
	
	public String getDailyId() {
		return dailyId;
	} 
	
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	
	public String getProjectId() {
		return projectId;
	} 
	
	public void setDailyTaskType(String dailyTaskType) {
		this.dailyTaskType = dailyTaskType;
	}
	
	public String getDailyTaskType() {
		return dailyTaskType;
	} 
	
	public void setUsetime(BigDecimal usetime) {
		this.usetime = usetime;
	}
	
	public BigDecimal getUsetime() {
		return usetime;
	} 
	
	public void setPercentComplete(Integer percentComplete) {
		this.percentComplete = percentComplete;
	}
	
	public Integer getPercentComplete() {
		return percentComplete;
	} 
	
	public void setSort(String sort) {
		this.sort = sort;
	}
	
	public String getSort() {
		return sort;
	} 
}
