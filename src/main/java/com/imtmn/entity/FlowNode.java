package com.imtmn.entity;

import java.util.Date;

/**
 * 流程节点信息
 *
 * @author mtmn
 * @date 2020/12/18 7:51
 */
public class FlowNode {

    private Long id;

    /**
     * 任务ID
     */
    private String taskId;

    /**
     * 任务名称
     */
    private String taskName;

    /**
     * 关联业务信息ID
     */
    private String infoId;

    /**
     * 处理时间
     */
    private Date processingTime;

    /**
     * 修改时间
     */
    private Date modificationTime;

    /**
     * 流程节点编码
     */
    private String processNodeCode;

    /**
     * 流程节点名称
     */
    private String processNodeName;

    /**
     * 当前流程节点编码
     */
    private String currentNodeCode;

    /**
     * 当前流程节点名称
     */
    private String currentNodeName;

    /**
     * 处理人
     */
    private String handler;

    /**
     * 处理单位编码
     */
    private String handlerGroupCode;

    /**
     * 处理单位名称
     */
    private String handlerGroupName;

    /**
     * 接收单位编码
     */
    private String receiveGroupCode;

    /**
     * 接受单位名称
     */
    private String receiveGroupName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getInfoId() {
        return infoId;
    }

    public void setInfoId(String infoId) {
        this.infoId = infoId;
    }

    public Date getProcessingTime() {
        return processingTime;
    }

    public void setProcessingTime(Date processingTime) {
        this.processingTime = processingTime;
    }

    public Date getModificationTime() {
        return modificationTime;
    }

    public void setModificationTime(Date modificationTime) {
        this.modificationTime = modificationTime;
    }

    public String getProcessNodeCode() {
        return processNodeCode;
    }

    public void setProcessNodeCode(String processNodeCode) {
        this.processNodeCode = processNodeCode;
    }

    public String getProcessNodeName() {
        return processNodeName;
    }

    public void setProcessNodeName(String processNodeName) {
        this.processNodeName = processNodeName;
    }

    public String getCurrentNodeCode() {
        return currentNodeCode;
    }

    public void setCurrentNodeCode(String currentNodeCode) {
        this.currentNodeCode = currentNodeCode;
    }

    public String getCurrentNodeName() {
        return currentNodeName;
    }

    public void setCurrentNodeName(String currentNodeName) {
        this.currentNodeName = currentNodeName;
    }

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }

    public String getHandlerGroupCode() {
        return handlerGroupCode;
    }

    public void setHandlerGroupCode(String handlerGroupCode) {
        this.handlerGroupCode = handlerGroupCode;
    }

    public String getHandlerGroupName() {
        return handlerGroupName;
    }

    public void setHandlerGroupName(String handlerGroupName) {
        this.handlerGroupName = handlerGroupName;
    }

    public String getReceiveGroupCode() {
        return receiveGroupCode;
    }

    public void setReceiveGroupCode(String receiveGroupCode) {
        this.receiveGroupCode = receiveGroupCode;
    }

    public String getReceiveGroupName() {
        return receiveGroupName;
    }

    public void setReceiveGroupName(String receiveGroupName) {
        this.receiveGroupName = receiveGroupName;
    }
}
