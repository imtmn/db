package com.imtmn.entity;

import java.util.List;

/**
 * 任务
 *
 * @author mtmn
 * @date 2020/12/16 7:25
 */
public class Task {

    /**
     * 任务ID
     */
    private String taskId;

    /**
     * 任务名称
     */
    private String taskName;

    /**
     * 任务的流程节点定义
     */
    private List<FlowNode> nodeList;

    public Task() {
    }

    public Task(String taskId, String taskName) {
        this.taskId = taskId;
        this.taskName = taskName;
    }

    public Task(String taskId, String taskName, List<FlowNode> nodeList) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.nodeList = nodeList;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public List<FlowNode> getNodeList() {
        return nodeList;
    }

    public void setNodeList(List<FlowNode> nodeList) {
        this.nodeList = nodeList;
    }
}
