package com.txdata.modules.daily.domain;

import com.txdata.common.domain.DataEntity;
import java.util.Date;
import java.util.List;

/**
 * 工作日报信息表
 *
 * @author 3xdata
 * @email 3xdata@3xdata.cn
 * @date 2021-07-21 18:47:56
 */
public class DailyDO extends DataEntity<DailyDO> {
	private static final long serialVersionUID = 1L;

	private String title;  //日报名称
	private String writeUser;  //填写人
	private Date writeDate;  //填写日期
	private String post;  //职位
	private String status;  //状态（（0:待审核1：通过，2：不通过））
	private Date reportDate;  //汇报日期
	private String filePath;  //

	private List<DailyTaskDO> dailyTaskDOS; //  任务明细
	private List<DailyArrangeDO> dailyArrangeDOS; //  下一步安排
	private List<DailyProblemDO> dailyProblemDOS; // 项目问题

	private String dailyTaskDOSList; //
	private String dailyArrangeDOSList; //
	private String dailyProblemDOSList; //

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setWriteUser(String writeUser) {
		this.writeUser = writeUser;
	}

	public String getWriteUser() {
		return writeUser;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getPost() {
		return post;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFilePath() {
		return filePath;
	}

	public List<DailyArrangeDO> getDailyArrangeDOS() {
		return dailyArrangeDOS;
	}

	public void setDailyArrangeDOS(List<DailyArrangeDO> dailyArrangeDOS) {
		this.dailyArrangeDOS = dailyArrangeDOS;
	}

	public List<DailyProblemDO> getDailyProblemDOS() {
		return dailyProblemDOS;
	}

	public void setDailyProblemDOS(List<DailyProblemDO> dailyProblemDOS) {
		this.dailyProblemDOS = dailyProblemDOS;
	}

	public List<DailyTaskDO> getDailyTaskDOS() {
		return dailyTaskDOS;
	}

	public void setDailyTaskDOS(List<DailyTaskDO> dailyTaskDOS) {
		this.dailyTaskDOS = dailyTaskDOS;
	}

	public String getDailyArrangeDOSList() {
		return dailyArrangeDOSList;
	}

	public void setDailyArrangeDOSList(String dailyArrangeDOSList) {
		this.dailyArrangeDOSList = dailyArrangeDOSList;
	}

	public String getDailyProblemDOSList() {
		return dailyProblemDOSList;
	}

	public void setDailyProblemDOSList(String dailyProblemDOSList) {
		this.dailyProblemDOSList = dailyProblemDOSList;
	}

	public String getDailyTaskDOSList() {
		return dailyTaskDOSList;
	}

	public void setDailyTaskDOSList(String dailyTaskDOSList) {
		this.dailyTaskDOSList = dailyTaskDOSList;
	}
}
