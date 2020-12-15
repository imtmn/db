package com.imtmn.entity;

/**
 * 流程节点
 *
 * @author mtmn
 * @date 2020/12/16 7:35
 */
public class FlowNode {

    /**
     * 节点编号
     */
    private String code;

    /**
     * 节点名称
     */
    private String name;

    /**
     * 当前节点的责任部门
     */
    private Department department;

    public FlowNode(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public FlowNode(String code, String name, Department department) {
        this.code = code;
        this.name = name;
        this.department = department;
    }
}
