package com.txdata.modules.daily.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.txdata.modules.daily.domain.DailyArrangeDO;
import com.txdata.modules.daily.dao.DailyArrangeDao;
import com.txdata.common.persistence.CrudService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

/**
 * 日报下一步安排表
 * 
 * @author 3xdata
 * @email 3xdata@3xdata.cn
 * @date 2021-07-21 18:48:38
 */
 @Service
public class DailyArrangeService extends CrudService<DailyArrangeDao, DailyArrangeDO> {

    @Autowired
    private DailyArrangeDao dailyArrangeDao;
    
    /**
	 * 通过id查找数据
	 */
    public DailyArrangeDO get(String id){
        return dailyArrangeDao.get(id);
    }
    
    /**
	 * 分页查询列表
	 */
    public Page<DailyArrangeDO> page(Page<DailyArrangeDO> page, Map<String, Object> map){
        return dailyArrangeDao.list(page, map);
    }
    
    /**
	 * 查询列表
	 */
    public List<DailyArrangeDO> list(Map<String, Object> map){
        return dailyArrangeDao.list(map);
    }
    
    /**
	 * 保存/修改
	 */
    @Transactional(readOnly=false)
    public int save(DailyArrangeDO dailyArrange){
        return super.save(dailyArrange);
    }
    
    /**
	 * 通过id逻辑删除
	 */
    @Transactional(readOnly=false)
    public int remove(String id){
        return dailyArrangeDao.remove(id);
    }
    
    /**
	 * 通过ids批量逻辑删除
	 */
    @Transactional(readOnly=false)
    public int batchRemove(String[] ids){
        return dailyArrangeDao.batchRemove(ids);
    }
    
    /**
	 * 通过id物理删除
	 */
    @Transactional(readOnly=false)
    public int delete(String id){
        return dailyArrangeDao.delete(id);
    }
    
    /**
	 * 通过ids物理删除
	 */
    @Transactional(readOnly=false)
    public int batchDelete(String[] ids){
        return dailyArrangeDao.batchDelete(ids);
    }
    
    /**
	 * 批量插入
	 */
    @Transactional(readOnly=false)
    public int batchInsert(List<DailyArrangeDO> dailyArranges){
    	return dailyArrangeDao.batchInsert(dailyArranges);
    }
    
    /**
	 * 批量修改
	 */
	@Transactional(readOnly=false)
	public int batchUpdate(List<DailyArrangeDO> dailyArranges){
		return dailyArrangeDao.batchUpdate(dailyArranges);
	}
    
    /**
	 * 通过id复制一条相同的数据
	 */
    @Transactional(readOnly=false)
    public int copy(String id){
    	int result = 0;
    	DailyArrangeDO dailyArrange = dailyArrangeDao.get(id);
    	if (dailyArrange != null){
    		dailyArrange.setId(null);
    		dailyArrange.preInsert();
    		//表结构中name字段不一定存在，故此自动生成代码时注释下列代码，存在时取消注释即可
//    		if (StrUtil.isNotBlank(dailyArrange.getName())){ 
//    			dailyArrange.setName(dailyArrange.getName() + "-复制");
//    		}
    		result = dailyArrangeDao.insert(dailyArrange);
    	}
        return result;
    }
    
    /**
	 * 
	 * @Description: 修改（通过自定义的条件进行修改操作）
	 * @param dailyArrange 要被修改的参数
	 * @param whereMap 修改条件
	 * @return: 返回修改数量
	 */
	@Transactional(readOnly=false)
    public int updateByWhere(DailyArrangeDO dailyArrange, Map<String,Object> whereMap){
    	return dailyArrangeDao.updateByWhere(dailyArrange, whereMap);
    }
    
    /**
	 * 
	 * @Description: 逻辑删除（通过自定义的条件进行逻辑删除操作）
	 * @param whereMap 逻辑删除条件
	 * @return: 返回逻辑删除数量
	 */
	@Transactional(readOnly=false)
    public int removeByWhere(Map<String,Object> whereMap){
    	return dailyArrangeDao.removeByWhere(whereMap);
    }
	
	/**
	 * 
	 * @Description: 物理删除（通过自定义的条件进行物理删除操作）慎用
	 * @param whereMap 物理删除条件
	 * @return: 返回物理删除数量
	 */
	@Transactional(readOnly=false) 
	public int deleteByWhere(Map<String,Object> whereMap){
		return dailyArrangeDao.deleteByWhere(whereMap);
	}
}
