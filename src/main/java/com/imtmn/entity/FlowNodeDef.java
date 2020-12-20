package com.imtmn.entity;

/**
 * 流程节点
 *
 * @author mtmn
 * @date 2020/12/16 7:35
 */
public class FlowNodeDef {

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

    public FlowNodeDef(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public FlowNodeDef(String code, String name, Department department) {
        this.code = code;
        this.name = name;
        this.department = department;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
