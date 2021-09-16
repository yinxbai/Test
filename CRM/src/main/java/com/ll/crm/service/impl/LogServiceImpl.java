package com.ll.crm.service.impl;

import com.ll.crm.entity.Log;
import com.ll.crm.dao.LogDao;
import com.ll.crm.service.LogService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * (Log)表服务实现类
 *
 * @author makejava
 * @since 2021-06-30 09:53:00
 */
@Service("logService")
public class LogServiceImpl implements LogService {
    @Resource
    private LogDao logDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Log queryById(String id) {
        return this.logDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @return 对象列表
     */
    @Override
    @Cacheable(cacheNames = "Log",key = "02",unless = "{#result==null}")
    public List<Log> queryAll() {
        return this.logDao.queryAll();
    }

    /**
     * 新增数据
     *
     * @param log 实例对象
     * @return 实例对象
     */
    @Override
    @CacheEvict(cacheNames = "Log",key = "02")
    public void insert(Log log) {

        logDao.insert(log);

    }

    /**
     * 修改数据
     *
     * @param log 实例对象
     * @return 实例对象
     */
    @Override
    public Log update(Log log) {
        this.logDao.update(log);
        return this.queryById(log.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.logDao.deleteById(id) > 0;
    }

    @Override
    @Scheduled(cron = "0 0 20 1 * *")
    public void exportExcel() throws IOException {
        List<Log> list = logDao.queryAll();
        String path = "upload/"+new SimpleDateFormat("yyyy-MM").format(new Date());
        File file = new File(path);
        if (!file.exists()){
            file.mkdirs();
        }
        String fileName = UUID.randomUUID().toString().replace("_","")+".txt";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(path,fileName)));
        bufferedWriter.write("序号\t创建事件\t用户名\tIP\t行为");
        bufferedWriter.newLine();
        if (null!=list&&list.size()>0){
            for (int i = 0; i < list.size(); i++) {
                Log log =list.get(i);
                bufferedWriter.write((i+1)+"\t"+log.getCreateTime()+"\t"+log.getUserId()+"\t"+log.getIp()+"\t"+log.getDescription());
                bufferedWriter.newLine();
            }
        }
        bufferedWriter.close();
    }
}
