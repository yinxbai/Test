package com.txdata.modules.daily.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.txdata.modules.daily.domain.DailyTaskDO;
import com.txdata.modules.daily.dao.DailyTaskDao;
import com.txdata.common.persistence.CrudService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

/**
 * 工作日报任务明细表
 * 
 * @author 3xdata
 * @email 3xdata@3xdata.cn
 * @date 2021-07-21 18:50:40
 */
 @Service
public class DailyTaskService extends CrudService<DailyTaskDao, DailyTaskDO> {

    @Autowired
    private DailyTaskDao dailyTaskDao;
    
    /**
	 * 通过id查找数据
	 */
    public DailyTaskDO get(String id){
        return dailyTaskDao.get(id);
    }
    
    /**
	 * 分页查询列表
	 */
    public Page<DailyTaskDO> page(Page<DailyTaskDO> page, Map<String, Object> map){
        return dailyTaskDao.list(page, map);
    }
    
    /**
	 * 查询列表
	 */
    public List<DailyTaskDO> list(Map<String, Object> map){
        return dailyTaskDao.list(map);
    }
    
    /**
	 * 保存/修改
	 */
    @Transactional(readOnly=false)
    public int save(DailyTaskDO dailyTask){
        return super.save(dailyTask);
    }
    
    /**
	 * 通过id逻辑删除
	 */
    @Transactional(readOnly=false)
    public int remove(String id){
        return dailyTaskDao.remove(id);
    }
    
    /**
	 * 通过ids批量逻辑删除
	 */
    @Transactional(readOnly=false)
    public int batchRemove(String[] ids){
        return dailyTaskDao.batchRemove(ids);
    }
    
    /**
	 * 通过id物理删除
	 */
    @Transactional(readOnly=false)
    public int delete(String id){
        return dailyTaskDao.delete(id);
    }
    
    /**
	 * 通过ids物理删除
	 */
    @Transactional(readOnly=false)
    public int batchDelete(String[] ids){
        return dailyTaskDao.batchDelete(ids);
    }
    
    /**
	 * 批量插入
	 */
    @Transactional(readOnly=false)
    public int batchInsert(List<DailyTaskDO> dailyTasks){
    	return dailyTaskDao.batchInsert(dailyTasks);
    }
    
    /**
	 * 批量修改
	 */
	@Transactional(readOnly=false)
	public int batchUpdate(List<DailyTaskDO> dailyTasks){
		return dailyTaskDao.batchUpdate(dailyTasks);
	}
    
    /**
	 * 通过id复制一条相同的数据
	 */
    @Transactional(readOnly=false)
    public int copy(String id){
    	int result = 0;
    	DailyTaskDO dailyTask = dailyTaskDao.get(id);
    	if (dailyTask != null){
    		dailyTask.setId(null);
    		dailyTask.preInsert();
    		//表结构中name字段不一定存在，故此自动生成代码时注释下列代码，存在时取消注释即可
//    		if (StrUtil.isNotBlank(dailyTask.getName())){ 
//    			dailyTask.setName(dailyTask.getName() + "-复制");
//    		}
    		result = dailyTaskDao.insert(dailyTask);
    	}
        return result;
    }
    
    /**
	 * 
	 * @Description: 修改（通过自定义的条件进行修改操作）
	 * @param dailyTask 要被修改的参数
	 * @param whereMap 修改条件
	 * @return: 返回修改数量
	 */
	@Transactional(readOnly=false)
    public int updateByWhere(DailyTaskDO dailyTask, Map<String,Object> whereMap){
    	return dailyTaskDao.updateByWhere(dailyTask, whereMap);
    }
    
    /**
	 * 
	 * @Description: 逻辑删除（通过自定义的条件进行逻辑删除操作）
	 * @param whereMap 逻辑删除条件
	 * @return: 返回逻辑删除数量
	 */
	@Transactional(readOnly=false)
    public int removeByWhere(Map<String,Object> whereMap){
    	return dailyTaskDao.removeByWhere(whereMap);
    }
	
	/**
	 * 
	 * @Description: 物理删除（通过自定义的条件进行物理删除操作）慎用
	 * @param whereMap 物理删除条件
	 * @return: 返回物理删除数量
	 */
	@Transactional(readOnly=false) 
	public int deleteByWhere(Map<String,Object> whereMap){
		return dailyTaskDao.deleteByWhere(whereMap);
	}
}
