package com.txdata.modules.daily.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.txdata.modules.daily.domain.TasktypeDO;
import com.txdata.common.persistence.proxy.CrudDao;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * @author 3xdata
 * @email 3xdata@3xdata.cn
 * @date 2021-07-21 18:51:36
 */
@Mapper
public interface TasktypeDao extends CrudDao<TasktypeDO> {

	TasktypeDO get(String id);
	
	Page<TasktypeDO> list(Page<TasktypeDO> page, @Param("entity")Map<String,Object> map);
	
	List<TasktypeDO> list(@Param("entity")Map<String,Object> map);
	
	int insert(TasktypeDO tasktype);
	
	int update(TasktypeDO tasktype);
	
	int remove(String Id);
	
	int batchRemove(String[] ids);
	
	int delete(String Id);
	
	int batchDelete(String[] ids);
	
	int batchInsert(List<TasktypeDO> tasktypes);
	
	int batchUpdate(List<TasktypeDO> tasktypes);
	
	int updateByWhere(@Param("param")TasktypeDO tasktype, @Param("where")Map<String,Object> whereMap);
	
	int removeByWhere(@Param("where")Map<String,Object> whereMap);
	
	int deleteByWhere(@Param("where")Map<String,Object> whereMap);
}
