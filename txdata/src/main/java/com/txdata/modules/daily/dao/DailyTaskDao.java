package com.txdata.modules.daily.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.txdata.modules.daily.domain.DailyTaskDO;
import com.txdata.common.persistence.proxy.CrudDao;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 工作日报任务明细表
 * @author 3xdata
 * @email 3xdata@3xdata.cn
 * @date 2021-07-21 18:50:40
 */
@Mapper
public interface DailyTaskDao extends CrudDao<DailyTaskDO> {

	DailyTaskDO get(String id);
	
	Page<DailyTaskDO> list(Page<DailyTaskDO> page, @Param("entity")Map<String,Object> map);
	
	List<DailyTaskDO> list(@Param("entity")Map<String,Object> map);
	
	int insert(DailyTaskDO dailyTask);
	
	int update(DailyTaskDO dailyTask);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
	
	int delete(String id);
	
	int batchDelete(String[] ids);
	
	int batchInsert(List<DailyTaskDO> dailyTasks);
	
	int batchUpdate(List<DailyTaskDO> dailyTasks);
	
	int updateByWhere(@Param("param")DailyTaskDO dailyTask, @Param("where")Map<String,Object> whereMap);
	
	int removeByWhere(@Param("where")Map<String,Object> whereMap);
	
	int deleteByWhere(@Param("where")Map<String,Object> whereMap);
}
