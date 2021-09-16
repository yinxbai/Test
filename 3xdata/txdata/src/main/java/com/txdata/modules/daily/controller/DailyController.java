package com.txdata.modules.daily.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.txdata.common.utils.DateUtils;
import com.txdata.common.utils.Query;
import com.txdata.common.utils.R;
import com.txdata.modules.daily.entity.*;
import com.txdata.modules.daily.service.DailyService;
import com.txdata.modules.daily.service.ProjectService;
import com.txdata.modules.daily.service.TasktypeService;
import com.txdata.modules.project.domain.ProjectDO;
import com.txdata.system.utils.UserUtils;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 工作日报信息表(TDaily)表控制层
 *
 * @author makejava
 * @since 2021-07-22 13:26:44
 */
@RestController
@RequestMapping("/daily")
public class DailyController {
    /**
     * 服务对象
     */
    @Autowired
    private DailyService dailyService;
    @Autowired
    private TasktypeService tasktypeService;
    @Autowired
    private ProjectService projectServicepr;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ResponseBody
    @PostMapping("/form")
    public Daily selectOne(String id) {
        return this.dailyService.queryById(id);
    }


    @ResponseBody
    @PostMapping("/Taskform")
    public DailyTask QueryByTask(String id){
        return dailyService.QueryByTask(id);
    }

    @ResponseBody
    @PostMapping("/taskList")
    public List<DailyTask> taskList(String projectId,String writeUser){
        return this.dailyService.queryByProject(projectId,writeUser);
    }

    /**
     *
     * @Description: 获取项目分页列表
     * 只查询项目主表
     *
     * @param: 查询参数
     * @return: 返回结果描述
     * @throws: 异常描述
     *
     * @author: huangmk
     * @date: 2018年12月27日 上午11:56:00
     */
    @ResponseBody
    @PostMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        Page<Daily> page = new Page<Daily>(query.getPageNo(), query.getPageSize());
        page = dailyService.list(page, query);
        // 封装分页数据
        Map<String,Object> jsonMap = new HashMap<String,Object>();
        jsonMap.put("rows", page.getRecords());
        jsonMap.put("pageSize", page.getSize());
        jsonMap.put("pageNo", page.getCurrent());
        jsonMap.put("count", page.getTotal());
        return R.success(jsonMap);
    }

    @PostMapping( "/approval")
    @ResponseBody
    public R updateStatus(String id, String status) {
        int row = dailyService.updateStatus(id, status);
        if(row > 0){
            return R.success();
        }
        return R.error();
    }

    @PostMapping( "/delete")
    @ResponseBody
    public R remove(String id){
        if(dailyService.deleteById(id)>0){
            return R.success();
        }
        return R.error();
    }

    @ResponseBody
    @PostMapping("/save")
    public R save(Daily daily){
        if(dailyService.insert(daily)!=null){
            return R.success();
        }
        return R.error();
    }

    @RequestMapping("/export")
    public void export(HttpServletResponse response){
        String fileName = UserUtils.getUser().getUsername()+"_"+ DateUtils.getDate("yyyy-MM-dd")+ "_日报.xlsx";
        SXSSFWorkbook wb = new SXSSFWorkbook();
        Sheet sheet = wb.createSheet("日报表");
        CellStyle style = wb.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        Font headerFont = wb.createFont();
        headerFont.setFontName("宋体");
        style.setBorderBottom(CellStyle.BORDER_THICK);
        style.setWrapText(true);

        // 设置第一行
        Row row1 = sheet.createRow(0);
        String[] title = {"序号","日报名称","日报编号","填写人","汇报日期","职位","任务明细"};
        row1.createCell(0).setCellStyle(style);
        row1.createCell(0).setCellValue("序号");
        row1.createCell(1).setCellValue("日报名称");
        row1.createCell(2).setCellValue("日报编号");
        row1.createCell(3).setCellValue("填写人");
        row1.createCell(4).setCellValue("汇报日期");
        row1.createCell(5).setCellValue("职位");
        row1.createCell(6).setCellValue("任务明细");
        row1.createCell(11).setCellValue("下一步工作安排");
        row1.createCell(14).setCellValue("项目问题");
        // 设置第二行
        Row row2 = sheet.createRow(1);
        row2.createCell(6).setCellValue("任务类型");
        row2.createCell(7).setCellValue("项目名称");
        row2.createCell(8).setCellValue("花费时间(时)");
        row2.createCell(9).setCellValue("任务完成度(%)");
        row2.createCell(10).setCellValue("工作任务描述");
        row2.createCell(11).setCellValue("任务类型");
        row2.createCell(12).setCellValue("计划完成日期");
        row2.createCell(13).setCellValue("下一步工作安排");
        row2.createCell(14).setCellValue("问题类型");
        row2.createCell(15).setCellValue("项目名称");
        row2.createCell(16).setCellValue("期望答复时间");
        row2.createCell(17).setCellValue("需要得到的支持");
        row2.createCell(18).setCellValue("问题描述");
        // 合并单元格生成表头
        CellRangeAddress region1 = new CellRangeAddress(0, 1, 0, 0);
        sheet.addMergedRegion(region1);
        CellRangeAddress region2 = new CellRangeAddress(0, 1, 1, 1);
        sheet.addMergedRegion(region2);
        CellRangeAddress region3 = new CellRangeAddress(0, 1, 2, 2);
        sheet.addMergedRegion(region3);
        CellRangeAddress region4 = new CellRangeAddress(0, 1, 3, 3);
        sheet.addMergedRegion(region4);
        CellRangeAddress region5 = new CellRangeAddress(0, 1, 4, 4);
        sheet.addMergedRegion(region5);
        CellRangeAddress region6 = new CellRangeAddress(0, 1, 5, 5);
        sheet.addMergedRegion(region6);
        CellRangeAddress region7 = new CellRangeAddress(0, 0, 6, 10);
        sheet.addMergedRegion(region7);
        CellRangeAddress region8 = new CellRangeAddress(0, 0, 11, 13);
        sheet.addMergedRegion(region8);
        CellRangeAddress region9 = new CellRangeAddress(0, 0, 14, 18);
        sheet.addMergedRegion(region9);

        // 获取数据

        int dailyArrangeSize = 0;
        int dailyProblemSize = 0;
        int dailyTaskSize = 0;
        int max = 0;
        int height = 2;
        List<Daily> list = dailyService.list();
        for(int i=0;i<list.size();i++) {
            Daily dailyDO = list.get(i);
            List<DailyArrange> dailyArrangeDOList = dailyDO.getDailyArranges();
            List<DailyTask> dailyTaskDOList = dailyDO.getDailyTasks();
            List<DailyProblem> dailyProblemDOList = dailyDO.getProblemLis();
            // 设置单元格高度
            dailyArrangeSize = dailyArrangeDOList.size();
            dailyProblemSize = dailyProblemDOList.size();
            dailyTaskSize = dailyTaskDOList.size();
            max = dailyArrangeSize > dailyProblemSize ? dailyArrangeSize : dailyProblemSize;
            max = max > dailyTaskSize ? max : dailyTaskSize;
            // 获取主表属性
            Row row3  = sheet.createRow(height);
            row3.createCell(0).setCellValue(i+1);
            row3.createCell(1).setCellValue(dailyDO.getTitle());
            row3.createCell(2).setCellValue(dailyDO.getId());
            row3.createCell(3).setCellValue(dailyDO.getWriteUser());
            row3.createCell(4).setCellValue(dailyDO.getReportDate().toLocaleString());
            row3.createCell(5).setCellValue(dailyDO.getPost());

            // 合并单元格
            CellRangeAddress rangeAddress1 = new CellRangeAddress(height, height+max-1, 0, 0);
            sheet.addMergedRegion(rangeAddress1);
            CellRangeAddress rangeAddress2 = new CellRangeAddress(height, height+max-1, 1, 1);
            sheet.addMergedRegion(rangeAddress2);
            CellRangeAddress rangeAddress3 = new CellRangeAddress(height, height+max-1, 2, 2);
            sheet.addMergedRegion(rangeAddress3);
            CellRangeAddress rangeAddress4 = new CellRangeAddress(height, height+max-1, 3, 3);
            sheet.addMergedRegion(rangeAddress4);
            CellRangeAddress rangeAddress5 = new CellRangeAddress(height, height+max-1, 4, 4);
            sheet.addMergedRegion(rangeAddress5);
            CellRangeAddress rangeAddress6 = new CellRangeAddress(height, height+max-1, 5, 5);
            sheet.addMergedRegion(rangeAddress6);
            // 创建一个行对象
            Row row;
            // 操作任务详细表
            for (int j=0;j<dailyTaskSize;j++) {
                DailyTask dailyTaskDO = dailyTaskDOList.get(j);
                if(sheet.getRow(height+j)==null) { // 判断是否存在行对象，防止数据的覆盖
                    row = sheet.createRow(height+j);
                }else {
                    row = row3;
                }
                row.createCell(6).setCellValue(dailyTaskDO.getDailyTaskType());
                row.createCell(7).setCellValue(dailyTaskDO.getProjectId());
                row.createCell(8).setCellValue(dailyTaskDO.getUsetime());
                row.createCell(9).setCellValue(dailyTaskDO.getPercentComplete());
                row.createCell(10).setCellValue(dailyTaskDO.getRemarks());
            }
            // 操作下一步安排表
            for (int j=0;j<dailyArrangeSize;j++) {
                DailyArrange dailyArrangeDO = dailyArrangeDOList.get(j);
                if(sheet.getRow(height+j)!=null) { // 判断是否存在行对象，防止数据的覆盖
                    row = row3;
                }else {
                    row = sheet.createRow(height+j);
                }
                row.createCell(11).setCellValue(dailyArrangeDO.getDailyTaskType());
                row.createCell(12).setCellValue(dailyArrangeDO.getFinishDate().toLocaleString());
                row.createCell(13).setCellValue(dailyArrangeDO.getRemarks());
            }
            // 操作任务问题表
            for (int j=0;j<dailyProblemSize;j++) {
                DailyProblem dailyProblemDO = dailyProblemDOList.get(j);
                if(sheet.getRow(height+j)!=null) { // 判断是否存在行对象，防止数据的覆盖
                    row = row3;
                }else {
                    row = sheet.createRow(height+j);
                }
                row.createCell(14).setCellValue(dailyProblemDO.getType());
                row.createCell(15).setCellValue(dailyProblemDO.getName());
                row.createCell(16).setCellValue(dailyProblemDO.getRecordTime().toLocaleString());
                row.createCell(17).setCellValue(dailyProblemDO.getSupport());
                row.createCell(18).setCellValue(dailyProblemDO.getDescription());
            }

            height = height+max;
            max = 0;
        }

        ServletOutputStream sos = null;
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            sos =  response.getOutputStream();
            fileName = URLEncoder.encode(fileName,"utf-8");
            response.setHeader("Content-Disposition", "attachment;filename="+fileName);
            wb.write(sos);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                sos.close();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
