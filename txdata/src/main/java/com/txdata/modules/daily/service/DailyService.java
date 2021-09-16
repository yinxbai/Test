package com.txdata.modules.daily.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.txdata.modules.daily.domain.DailyDO;
import com.txdata.modules.daily.dao.DailyDao;
import com.txdata.common.persistence.CrudService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

/**
 * 工作日报信息表
 * 
 * @author 3xdata
 * @email 3xdata@3xdata.cn
 * @date 2021-07-21 18:47:56
 */
 @Service
public class DailyService extends CrudService<DailyDao, DailyDO> {

    @Autowired
    private DailyDao dailyDao;
    
    /**
	 * 通过id查找数据
	 */
    public DailyDO get(String id){
        return dailyDao.get(id);
    }
    
    /**
	 * 分页查询列表
	 */
    public Page<DailyDO> page(Page<DailyDO> page, Map<String, Object> map){
        return dailyDao.list(page, map);
    }
    
    /**
	 * 查询列表
	 */
    public List<DailyDO> list(Map<String, Object> map){
        return dailyDao.list(map);
    }
    
    /**
	 * 保存/修改
	 */
    @Transactional(readOnly=false)
    public int save(DailyDO daily){
        return super.save(daily);
    }
    
    /**
	 * 通过id逻辑删除
	 */
    @Transactional(readOnly=false)
    public int remove(String id){
        return dailyDao.remove(id);
    }
    
    /**
	 * 通过ids批量逻辑删除
	 */
    @Transactional(readOnly=false)
    public int batchRemove(String[] ids){
        return dailyDao.batchRemove(ids);
    }
    
    /**
	 * 通过id物理删除
	 */
    @Transactional(readOnly=false)
    public int delete(String id){
        return dailyDao.delete(id);
    }
    
    /**
	 * 通过ids物理删除
	 */
    @Transactional(readOnly=false)
    public int batchDelete(String[] ids){
        return dailyDao.batchDelete(ids);
    }
    
    /**
	 * 批量插入
	 */
    @Transactional(readOnly=false)
    public int batchInsert(List<DailyDO> dailys){
    	return dailyDao.batchInsert(dailys);
    }
    
    /**
	 * 批量修改
	 */
	@Transactional(readOnly=false)
	public int batchUpdate(List<DailyDO> dailys){
		return dailyDao.batchUpdate(dailys);
	}
    
    /**
	 * 通过id复制一条相同的数据
	 */
    @Transactional(readOnly=false)
    public int copy(String id){
    	int result = 0;
    	DailyDO daily = dailyDao.get(id);
    	if (daily != null){
    		daily.setId(null);
    		daily.preInsert();
    		//表结构中name字段不一定存在，故此自动生成代码时注释下列代码，存在时取消注释即可
//    		if (StrUtil.isNotBlank(daily.getName())){ 
//    			daily.setName(daily.getName() + "-复制");
//    		}
    		result = dailyDao.insert(daily);
    	}
        return result;
    }
    
    /**
	 * 
	 * @Description: 修改（通过自定义的条件进行修改操作）
	 * @param daily 要被修改的参数
	 * @param whereMap 修改条件
	 * @return: 返回修改数量
	 */
	@Transactional(readOnly=false)
    public int updateByWhere(DailyDO daily, Map<String,Object> whereMap){
    	return dailyDao.updateByWhere(daily, whereMap);
    }
    
    /**
	 * 
	 * @Description: 逻辑删除（通过自定义的条件进行逻辑删除操作）
	 * @param whereMap 逻辑删除条件
	 * @return: 返回逻辑删除数量
	 */
	@Transactional(readOnly=false)
    public int removeByWhere(Map<String,Object> whereMap){
    	return dailyDao.removeByWhere(whereMap);
    }
	
	/**
	 * 
	 * @Description: 物理删除（通过自定义的条件进行物理删除操作）慎用
	 * @param whereMap 物理删除条件
	 * @return: 返回物理删除数量
	 */
	@Transactional(readOnly=false) 
	public int deleteByWhere(Map<String,Object> whereMap){
		return dailyDao.deleteByWhere(whereMap);
	}
}
