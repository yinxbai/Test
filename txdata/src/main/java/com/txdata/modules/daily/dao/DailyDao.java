package com.txdata.modules.daily.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.txdata.modules.daily.domain.DailyDO;
import com.txdata.common.persistence.proxy.CrudDao;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 工作日报信息表
 * @author 3xdata
 * @email 3xdata@3xdata.cn
 * @date 2021-07-21 18:47:56
 */
@Mapper
public interface DailyDao extends CrudDao<DailyDO> {

	DailyDO get(String id);
	
	Page<DailyDO> list(Page<DailyDO> page, @Param("entity")Map<String,Object> map);
	
	List<DailyDO> list(@Param("entity")Map<String,Object> map);
	
	int insert(DailyDO daily);
	
	int update(DailyDO daily);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
	
	int delete(String id);
	
	int batchDelete(String[] ids);
	
	int batchInsert(List<DailyDO> dailys);
	
	int batchUpdate(List<DailyDO> dailys);
	
	int updateByWhere(@Param("param")DailyDO daily, @Param("where")Map<String,Object> whereMap);
	
	int removeByWhere(@Param("where")Map<String,Object> whereMap);
	
	int deleteByWhere(@Param("where")Map<String,Object> whereMap);
}
