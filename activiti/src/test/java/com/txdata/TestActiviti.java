package com.txdata;

import com.txdata.config.DemoApplicationConfig;
import com.txdata.utils.SercurityUtil;
import org.activiti.api.process.model.ProcessDefinition;
import org.activiti.api.process.model.ProcessInstance;
import org.activiti.api.process.model.builders.ProcessPayloadBuilder;
import org.activiti.api.process.runtime.ProcessRuntime;
import org.activiti.api.runtime.shared.query.Page;
import org.activiti.api.runtime.shared.query.Pageable;
import org.activiti.api.task.model.Task;
import org.activiti.api.task.model.builders.TaskPayloadBuilder;
import org.activiti.api.task.runtime.TaskRuntime;
import org.apache.catalina.security.SecurityUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestActiviti {

    private Logger logger = LoggerFactory.getLogger(TestActiviti.class);

    @Autowired
    private ProcessRuntime processRuntime;
    @Autowired
    private TaskRuntime taskRuntime;

    @Autowired
    private SercurityUtil sercurityUtil;

    /**
     * 查看流程定义
     */
    @Test
    public void contextLoads() {
        sercurityUtil.logInAs("admin");
        Page<ProcessDefinition> processDefinitionPage = processRuntime.processDefinitions(Pageable.of(0,10));
        logger.info("可用流程定义总数： {}",processDefinitionPage.getTotalItems());
        for (ProcessDefinition processDefinition: processDefinitionPage.getContent()){
            System.out.println("++++++++++++++++++++++++++++");
            logger.info("流程定义内容：{}",processDefinition);
            System.out.println("++++++++++++++++++++++++++++");
        }
    }

    @Test
    public void startProcess(){
        ProcessInstance processInstance = processRuntime.start(ProcessPayloadBuilder.
                start().
                withProcessDefinitionKey("mydemo").
                build());
        logger.info("流程的实例内容：{}",processInstance);
    }

    @Test
    public void doTask(){
        sercurityUtil.logInAs("tom");
        Page<Task> taskPage = taskRuntime.tasks(Pageable.of(0,10));
        if (taskPage != null && taskPage.getTotalItems()>0){
            for (Task task: taskPage.getContent()) {
                taskRuntime.claim(TaskPayloadBuilder.
                        claim().
                        withTaskId(task.getId()).
                        build());
                logger.info("任务内容，{}",task);
                taskRuntime.complete(TaskPayloadBuilder.
                        complete().
                        withTaskId(task.getId()).
                        build());
            }
        }
    }
}
