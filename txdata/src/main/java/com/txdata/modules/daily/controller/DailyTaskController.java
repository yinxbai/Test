package com.txdata.modules.daily.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.txdata.common.controller.BaseController;
import com.txdata.modules.daily.domain.DailyTaskDO;
import com.txdata.modules.daily.service.DailyTaskService;
import com.txdata.common.utils.Query;
import com.txdata.common.utils.R;
import com.alibaba.fastjson.JSONObject;

/**
 * 工作日报任务明细表
 * 
 * @author 3xdata
 * @email 3xdata@3xdata.cn
 * @date 2021-07-21 18:50:40
 */
@RestController
@RequestMapping("/dailyTask")
public class DailyTaskController extends BaseController {
	@Autowired
	private DailyTaskService dailyTaskService;
	
	@PostMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
        Page<DailyTaskDO> page = new Page<DailyTaskDO>(query.getPageNo(), query.getPageSize());
		page = dailyTaskService.page(page, query);
		// 封装分页数据
		JSONObject jsonMap = new JSONObject();
        jsonMap.put("rows", page.getRecords());
        jsonMap.put("pageSize", page.getSize());
        jsonMap.put("pageNo", page.getCurrent());
        jsonMap.put("count", page.getTotal());
        return R.success(jsonMap);
	}
	
    @PostMapping("/form")
    public R form(@RequestParam(required = true)String id){
        DailyTaskDO dailyTask = dailyTaskService.get(id);
        JSONObject jsonMap = new JSONObject();
        jsonMap.put("formObject", dailyTask);
        return R.success(jsonMap);
    }
	
	@PostMapping("/save")
	public R save(DailyTaskDO dailyTask){
		if (dailyTaskService.save(dailyTask) > 0){
			return R.success();
		}
		return R.error();
	}
	
	@PostMapping("/remove")
	public R remove(String id){
		if (dailyTaskService.remove(id) > 0){ //逻辑删除
		    return R.success();
		}
		return R.error();
	}
	
	@PostMapping("/batchRemove")
	public R batchRemove(@RequestParam("ids[]") String[] ids){
		dailyTaskService.batchRemove(ids);//批量逻辑删除
		return R.success();
	}
	
	@PostMapping("/delete")
	public R delete(String id){
		if (dailyTaskService.delete(id) > 0){//物理删除
		    return R.success();
		}
		return R.error();
	}
	
	@PostMapping("/batchDelete")
	public R batchDelete(@RequestParam("ids[]") String[] ids){
		dailyTaskService.batchDelete(ids);//批量物理删除
		return R.success();
	}
	
	@PostMapping("/copy")
	public R copy(String id){
		if (dailyTaskService.copy(id) > 0){
			return R.success();
		}
		return R.error();
	}
}
