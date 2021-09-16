package com.txdata.modules.daily.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.txdata.modules.daily.domain.DailyArrangeDO;
import com.txdata.common.persistence.proxy.CrudDao;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 日报下一步安排表
 * @author 3xdata
 * @email 3xdata@3xdata.cn
 * @date 2021-07-21 18:48:38
 */
@Mapper
public interface DailyArrangeDao extends CrudDao<DailyArrangeDO> {

	DailyArrangeDO get(String id);
	
	Page<DailyArrangeDO> list(Page<DailyArrangeDO> page, @Param("entity")Map<String,Object> map);
	
	List<DailyArrangeDO> list(@Param("entity")Map<String,Object> map);
	
	int insert(DailyArrangeDO dailyArrange);
	
	int update(DailyArrangeDO dailyArrange);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
	
	int delete(String id);
	
	int batchDelete(String[] ids);
	
	int batchInsert(List<DailyArrangeDO> dailyArranges);
	
	int batchUpdate(List<DailyArrangeDO> dailyArranges);
	
	int updateByWhere(@Param("param")DailyArrangeDO dailyArrange, @Param("where")Map<String,Object> whereMap);
	
	int removeByWhere(@Param("where")Map<String,Object> whereMap);
	
	int deleteByWhere(@Param("where")Map<String,Object> whereMap);
}
