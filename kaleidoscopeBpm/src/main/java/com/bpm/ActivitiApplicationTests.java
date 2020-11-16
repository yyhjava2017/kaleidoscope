package com.bpm;

import com.bpm.activiti.SecurityUtil;
import org.activiti.api.process.model.ProcessDefinition;
import org.activiti.api.process.model.ProcessInstance;
import org.activiti.api.process.model.builders.ProcessPayloadBuilder;
import org.activiti.api.process.runtime.ProcessRuntime;
import org.activiti.api.runtime.shared.query.Page;
import org.activiti.api.runtime.shared.query.Pageable;
import org.activiti.api.task.model.Task;
import org.activiti.api.task.model.builders.TaskPayloadBuilder;
import org.activiti.api.task.runtime.TaskRuntime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivitiApplicationTests {
    @Autowired
    private ProcessRuntime processRuntime;
    @Autowired
    private TaskRuntime taskRuntime;
    @Autowired
    private SecurityUtil securityUtil;



    //
//    /**
//     * 查看流程定义
//     */
    @Test
    public void contextLoads() {
        securityUtil.logInAs("salaboy");
        Page<ProcessDefinition> processDefinitionPage = processRuntime.processDefinitions(Pageable.of(0, 10));
        System.out.println("可用的流程定义数量：" + processDefinitionPage.getTotalItems());
        for (ProcessDefinition pd : processDefinitionPage.getContent()) {
            System.out.println("流程定义：" + pd);
        }
    }
    //
//    /**
//     * 启动流程实例
//     */
    @Test
    public void testStartProcess() {
        securityUtil.logInAs("salaboy");
        ProcessInstance pi = processRuntime.start(ProcessPayloadBuilder.start().withProcessDefinitionKey("myProcess_1")
                .build());
        System.out.println("流程实例ID：" + pi.getId());
        //流程实例ID：6d2a9bc1-0cee-11ea-acf5-f894c25ebadd
    }
//

    /**
     * 查询任务，并完成自己的任务
     */
    @Test
    public void testTask() {
        securityUtil.logInAs("ryandawsonuk"); //指定用户认证信息
        Page<Task> taskPage=taskRuntime.tasks(Pageable.of(0,10)); //分页查询列表
        if (taskPage.getTotalItems()>0){
            //说明有任务，进行遍历
            for (Task task:taskPage.getContent()){
                //拾取任务
                taskRuntime.claim(TaskPayloadBuilder.claim().withTaskId(task.getId()).build());
                System.out.println("任务："+task);
                //完成任务
                taskRuntime.complete(TaskPayloadBuilder.complete().withTaskId(task.getId()).build());
            }
        }
        Page<Task> taskPage2=taskRuntime.tasks(Pageable.of(0,10));
        if (taskPage2.getTotalItems()>0){
            System.out.println("任务："+taskPage2.getContent());
        }
        //任务：TaskImpl{id='6d310464-0cee-11ea-acf5-f894c25ebadd', owner='null', assignee='null', name='first', description='null', createdDate=Fri Nov 22 14:07:56 CST 2019, claimedDate=null, dueDate=null, priority=50, processDefinitionId='myProcess_1:1:7f72b399-0cec-11ea-8c61-f894c25ebadd', processInstanceId='6d2a9bc1-0cee-11ea-acf5-f894c25ebadd', parentTaskId='null', status=CREATED}
        //任务：[TaskImpl{id='b3cecc85-0cf0-11ea-89ae-f894c25ebadd', owner='null', assignee='null', name='second', description='null', createdDate=Fri Nov 22 14:24:13 CST 2019, claimedDate=null, dueDate=null, priority=50, processDefinitionId='myProcess_1:1:7f72b399-0cec-11ea-8c61-f894c25ebadd', processInstanceId='6d2a9bc1-0cee-11ea-acf5-f894c25ebadd', parentTaskId='null', status=CREATED}]
    }
}

