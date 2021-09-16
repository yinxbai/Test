package com.txdata.modules.daily.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.txdata.modules.daily.domain.DailyProblemDO;
import com.txdata.common.persistence.proxy.CrudDao;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * @author 3xdata
 * @email 3xdata@3xdata.cn
 * @date 2021-07-21 18:49:54
 */
@Mapper
public interface DailyProblemDao extends CrudDao<DailyProblemDO> {

	DailyProblemDO get(String id);
	
	Page<DailyProblemDO> list(Page<DailyProblemDO> page, @Param("entity")Map<String,Object> map);
	
	List<DailyProblemDO> list(@Param("entity")Map<String,Object> map);
	
	int insert(DailyProblemDO dailyProblem);
	
	int update(DailyProblemDO dailyProblem);
	
	int remove(String Id);
	
	int batchRemove(String[] ids);
	
	int delete(String Id);
	
	int batchDelete(String[] ids);
	
	int batchInsert(List<DailyProblemDO> dailyProblems);
	
	int batchUpdate(List<DailyProblemDO> dailyProblems);
	
	int updateByWhere(@Param("param")DailyProblemDO dailyProblem, @Param("where")Map<String,Object> whereMap);
	
	int removeByWhere(@Param("where")Map<String,Object> whereMap);
	
	int deleteByWhere(@Param("where")Map<String,Object> whereMap);
}
