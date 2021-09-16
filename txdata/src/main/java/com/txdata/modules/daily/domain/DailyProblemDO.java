package com.txdata.modules.daily.domain;

import com.txdata.common.domain.DataEntity;
import java.util.Date;

/**
 * 
 * 
 * @author 3xdata
 * @email 3xdata@3xdata.cn
 * @date 2021-07-21 18:49:54
 */
public class DailyProblemDO extends DataEntity<DailyProblemDO> {
	private static final long serialVersionUID = 1L;

	private String type;  //问题类型 
	private String name;  //项目名称 
	private Date recordTime;  //答复时间 
	private String support;  //支持 
	private String description;  //描述 
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	} 
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	} 
	
	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}
	
	public Date getRecordTime() {
		return recordTime;
	} 
	
	public void setSupport(String support) {
		this.support = support;
	}
	
	public String getSupport() {
		return support;
	} 
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	} 
}
