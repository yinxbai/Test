package com.txdata.modules.daily.domain;

import com.txdata.common.domain.DataEntity;

/**
 * 
 * 
 * @author 3xdata
 * @email 3xdata@3xdata.cn
 * @date 2021-07-21 18:51:36
 */
public class TasktypeDO extends DataEntity<TasktypeDO> {
	private static final long serialVersionUID = 1L;

	private String name;  //职位类型 
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	} 
}
