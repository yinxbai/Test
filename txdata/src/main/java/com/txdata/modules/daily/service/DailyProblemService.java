package com.txdata.modules.daily.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.txdata.modules.daily.domain.DailyProblemDO;
import com.txdata.modules.daily.dao.DailyProblemDao;
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
 * @date 2021-07-21 18:49:54
 */
 @Service
public class DailyProblemService extends CrudService<DailyProblemDao, DailyProblemDO> {

    @Autowired
    private DailyProblemDao dailyProblemDao;
    
    /**
	 * 通过id查找数据
	 */
    public DailyProblemDO get(String id){
        return dailyProblemDao.get(id);
    }
    
    /**
	 * 分页查询列表
	 */
    public Page<DailyProblemDO> page(Page<DailyProblemDO> page, Map<String, Object> map){
        return dailyProblemDao.list(page, map);
    }
    
    /**
	 * 查询列表
	 */
    public List<DailyProblemDO> list(Map<String, Object> map){
        return dailyProblemDao.list(map);
    }
    
    /**
	 * 保存/修改
	 */
    @Transactional(readOnly=false)
    public int save(DailyProblemDO dailyProblem){
        return super.save(dailyProblem);
    }
    
    /**
	 * 通过id逻辑删除
	 */
    @Transactional(readOnly=false)
    public int remove(String id){
        return dailyProblemDao.remove(id);
    }
    
    /**
	 * 通过ids批量逻辑删除
	 */
    @Transactional(readOnly=false)
    public int batchRemove(String[] ids){
        return dailyProblemDao.batchRemove(ids);
    }
    
    /**
	 * 通过id物理删除
	 */
    @Transactional(readOnly=false)
    public int delete(String id){
        return dailyProblemDao.delete(id);
    }
    
    /**
	 * 通过ids物理删除
	 */
    @Transactional(readOnly=false)
    public int batchDelete(String[] ids){
        return dailyProblemDao.batchDelete(ids);
    }
    
    /**
	 * 批量插入
	 */
    @Transactional(readOnly=false)
    public int batchInsert(List<DailyProblemDO> dailyProblems){
    	return dailyProblemDao.batchInsert(dailyProblems);
    }
    
    /**
	 * 批量修改
	 */
	@Transactional(readOnly=false)
	public int batchUpdate(List<DailyProblemDO> dailyProblems){
		return dailyProblemDao.batchUpdate(dailyProblems);
	}
    
    /**
	 * 通过id复制一条相同的数据
	 */
    @Transactional(readOnly=false)
    public int copy(String id){
    	int result = 0;
    	DailyProblemDO dailyProblem = dailyProblemDao.get(id);
    	if (dailyProblem != null){
    		dailyProblem.setId(null);
    		dailyProblem.preInsert();
    		//表结构中name字段不一定存在，故此自动生成代码时注释下列代码，存在时取消注释即可
//    		if (StrUtil.isNotBlank(dailyProblem.getName())){ 
//    			dailyProblem.setName(dailyProblem.getName() + "-复制");
//    		}
    		result = dailyProblemDao.insert(dailyProblem);
    	}
        return result;
    }
    
    /**
	 * 
	 * @Description: 修改（通过自定义的条件进行修改操作）
	 * @param dailyProblem 要被修改的参数
	 * @param whereMap 修改条件
	 * @return: 返回修改数量
	 */
	@Transactional(readOnly=false)
    public int updateByWhere(DailyProblemDO dailyProblem, Map<String,Object> whereMap){
    	return dailyProblemDao.updateByWhere(dailyProblem, whereMap);
    }
    
    /**
	 * 
	 * @Description: 逻辑删除（通过自定义的条件进行逻辑删除操作）
	 * @param whereMap 逻辑删除条件
	 * @return: 返回逻辑删除数量
	 */
	@Transactional(readOnly=false)
    public int removeByWhere(Map<String,Object> whereMap){
    	return dailyProblemDao.removeByWhere(whereMap);
    }
	
	/**
	 * 
	 * @Description: 物理删除（通过自定义的条件进行物理删除操作）慎用
	 * @param whereMap 物理删除条件
	 * @return: 返回物理删除数量
	 */
	@Transactional(readOnly=false) 
	public int deleteByWhere(Map<String,Object> whereMap){
		return dailyProblemDao.deleteByWhere(whereMap);
	}
}
