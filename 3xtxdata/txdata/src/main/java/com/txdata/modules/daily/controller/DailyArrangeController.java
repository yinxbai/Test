package com.txdata.modules.daily.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.txdata.common.controller.BaseController;
import com.txdata.modules.daily.domain.DailyArrangeDO;
import com.txdata.modules.daily.service.DailyArrangeService;
import com.txdata.common.utils.Query;
import com.txdata.common.utils.R;
import com.alibaba.fastjson.JSONObject;

/**
 * 日报下一步安排表
 * 
 * @author 3xdata
 * @email 3xdata@3xdata.cn
 * @date 2021-07-21 18:48:38
 */
@RestController
@RequestMapping("/dailyArrange")
public class DailyArrangeController extends BaseController {
	@Autowired
	private DailyArrangeService dailyArrangeService;
	
	@PostMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
        Page<DailyArrangeDO> page = new Page<DailyArrangeDO>(query.getPageNo(), query.getPageSize());
		page = dailyArrangeService.page(page, query);
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
        DailyArrangeDO dailyArrange = dailyArrangeService.get(id);
        JSONObject jsonMap = new JSONObject();
        jsonMap.put("formObject", dailyArrange);
        return R.success(jsonMap);
    }
	
	@PostMapping("/save")
	public R save(DailyArrangeDO dailyArrange){
		if (dailyArrangeService.save(dailyArrange) > 0){
			return R.success();
		}
		return R.error();
	}
	
	@PostMapping("/remove")
	public R remove(String id){
		if (dailyArrangeService.remove(id) > 0){ //逻辑删除
		    return R.success();
		}
		return R.error();
	}
	
	@PostMapping("/batchRemove")
	public R batchRemove(@RequestParam("ids[]") String[] ids){
		dailyArrangeService.batchRemove(ids);//批量逻辑删除
		return R.success();
	}
	
	@PostMapping("/delete")
	public R delete(String id){
		if (dailyArrangeService.delete(id) > 0){//物理删除
		    return R.success();
		}
		return R.error();
	}
	
	@PostMapping("/batchDelete")
	public R batchDelete(@RequestParam("ids[]") String[] ids){
		dailyArrangeService.batchDelete(ids);//批量物理删除
		return R.success();
	}
	
	@PostMapping("/copy")
	public R copy(String id){
		if (dailyArrangeService.copy(id) > 0){
			return R.success();
		}
		return R.error();
	}
}
