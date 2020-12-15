package com.imtmn.constants;

import com.imtmn.entity.Department;

/**
 *
 * 部门枚举类
 * @author mtmn
 * @date 2020/12/17 7:29
 */
public enum DepartmentEnum {

    CEO_OFFICE(new Department("01","总裁办")),
    //支持中心
    SUPPORT_CENTER(new Department("0101","支持中心")),
    MANAGER(new Department("010101","管理部")),
    ACCOUNTING(new Department("010102","财务部")),
    //研发中心
    R_D_CENTER(new Department("0102","研发中心")),
    PRODUCT(new Department("010201","产品部")),
    TEST(new Department("010202","测试部")),
    DEVELOPMENT(new Department("010203","研发部")),
    //运营中心
    OPERATING_CENTER(new Department("0103","运营中心")),
    LOGISTICS(new Department("010301","物流部")),
    PERSONNEL(new Department("010302","人事部")),
    SALES(new Department("010303","营销部")),
    PURCHASING(new Department("010304","采购部"));


    /**
     * 部门
     */
    private Department department;

    DepartmentEnum(Department department) {
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }
}
