package com.txdata.modules.daily.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.txdata.modules.daily.domain.TasktypeDO;
import com.txdata.modules.daily.dao.TasktypeDao;
import com.txdata.common.persistence.CrudService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

/**
 * 
 * 
 * @author 3xdata
 * @email 3xdata@3xdata.cn
 * @date 2021-07-21 18:51:36
 */
 @Service
public class TasktypeService extends CrudService<TasktypeDao, TasktypeDO> {

    @Autowired
    private TasktypeDao tasktypeDao;
    
    /**
	 * 通过id查找数据
	 */
    public TasktypeDO get(String id){
        return tasktypeDao.get(id);
    }
    
    /**
	 * 分页查询列表
	 */
    public Page<TasktypeDO> page(Page<TasktypeDO> page, Map<String, Object> map){
        return tasktypeDao.list(page, map);
    }
    
    /**
	 * 查询列表
	 */
    public List<TasktypeDO> list(Map<String, Object> map){
        return tasktypeDao.list(map);
    }
    
    /**
	 * 保存/修改
	 */
    @Transactional(readOnly=false)
    public int save(TasktypeDO tasktype){
        return super.save(tasktype);
    }
    
    /**
	 * 通过id逻辑删除
	 */
    @Transactional(readOnly=false)
    public int remove(String id){
        return tasktypeDao.remove(id);
    }
    
    /**
	 * 通过ids批量逻辑删除
	 */
    @Transactional(readOnly=false)
    public int batchRemove(String[] ids){
        return tasktypeDao.batchRemove(ids);
    }
    
    /**
	 * 通过id物理删除
	 */
    @Transactional(readOnly=false)
    public int delete(String id){
        return tasktypeDao.delete(id);
    }
    
    /**
	 * 通过ids物理删除
	 */
    @Transactional(readOnly=false)
    public int batchDelete(String[] ids){
        return tasktypeDao.batchDelete(ids);
    }
    
    /**
	 * 批量插入
	 */
    @Transactional(readOnly=false)
    public int batchInsert(List<TasktypeDO> tasktypes){
    	return tasktypeDao.batchInsert(tasktypes);
    }
    
    /**
	 * 批量修改
	 */
	@Transactional(readOnly=false)
	public int batchUpdate(List<TasktypeDO> tasktypes){
		return tasktypeDao.batchUpdate(tasktypes);
	}
    
    /**
	 * 通过id复制一条相同的数据
	 */
    @Transactional(readOnly=false)
    public int copy(String id){
    	int result = 0;
    	TasktypeDO tasktype = tasktypeDao.get(id);
    	if (tasktype != null){
    		tasktype.setId(null);
    		tasktype.preInsert();
    		//表结构中name字段不一定存在，故此自动生成代码时注释下列代码，存在时取消注释即可
//    		if (StrUtil.isNotBlank(tasktype.getName())){ 
//    			tasktype.setName(tasktype.getName() + "-复制");
//    		}
    		result = tasktypeDao.insert(tasktype);
    	}
        return result;
    }
    
    /**
	 * 
	 * @Description: 修改（通过自定义的条件进行修改操作）
	 * @param tasktype 要被修改的参数
	 * @param whereMap 修改条件
	 * @return: 返回修改数量
	 */
	@Transactional(readOnly=false)
    public int updateByWhere(TasktypeDO tasktype, Map<String,Object> whereMap){
    	return tasktypeDao.updateByWhere(tasktype, whereMap);
    }
    
    /**
	 * 
	 * @Description: 逻辑删除（通过自定义的条件进行逻辑删除操作）
	 * @param whereMap 逻辑删除条件
	 * @return: 返回逻辑删除数量
	 */
	@Transactional(readOnly=false)
    public int removeByWhere(Map<String,Object> whereMap){
    	return tasktypeDao.removeByWhere(whereMap);
    }
	
	/**
	 * 
	 * @Description: 物理删除（通过自定义的条件进行物理删除操作）慎用
	 * @param whereMap 物理删除条件
	 * @return: 返回物理删除数量
	 */
	@Transactional(readOnly=false) 
	public int deleteByWhere(Map<String,Object> whereMap){
		return tasktypeDao.deleteByWhere(whereMap);
	}
}
