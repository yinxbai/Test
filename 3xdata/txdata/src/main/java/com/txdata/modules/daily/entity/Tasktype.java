package com.txdata.modules.daily.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 职位表(TTasktype)实体类
 *
 * @author makejava
 * @since 2021-07-23 09:24:04
 */
public class Tasktype implements Serializable {
    private static final long serialVersionUID = -93675697640822311L;

    private String id;
    /**
     * 职位类型
     */
    private String name;

    private List<DailyArrange> dailyArranges;

    private List<DailyTask> dailyTasks;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DailyArrange> getDailyArranges() {
        return dailyArranges;
    }

    public void setDailyArranges(List<DailyArrange> dailyArranges) {
        this.dailyArranges = dailyArranges;
    }

    public List<DailyTask> getDailyTasks() {
        return dailyTasks;
    }

    public void setDailyTasks(List<DailyTask> dailyTasks) {
        this.dailyTasks = dailyTasks;
    }
}
