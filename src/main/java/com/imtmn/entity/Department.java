package com.imtmn.entity;

/**
 * 部门
 *
 * @author mtmn
 * @date 2020/12/17 7:47
 */
public class Department {

    /**
     * 部门编码
     */
    private String code;

    /**
     * 部门名称
     */
    private String name;

    public Department(String code, String name) {
        this.code = code;
        this.name = name;
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
}
