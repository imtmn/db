package com.imtmn.constants;

import com.imtmn.entity.Task;

/**
 *
 * 任务枚举类
 * @author mtmn
 * @date 2020/12/17 7:29
 */
public enum TaskEnum {
    PROJECT_DEVELOPMENT(new Task("TASK_NUM_0001","项目研发", FlowNodeDefEnum.DEVELOPMENT_FLOW.getNodeList())),
    PROJECT_OUTSOURCING(new Task("TASK_NUM_0002","项目外包", FlowNodeDefEnum.OUTSOURCING_FLOW.getNodeList())),
    RECRUIT(new Task("TASK_NUM_0003","招聘", FlowNodeDefEnum.RECRUITMENT_FLOW.getNodeList()));

    private Task task;

    TaskEnum(Task task) {
        this.task = task;
    }

    public Task getTask() {
        return task;
    }
}
