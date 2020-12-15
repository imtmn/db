package com.imtmn.constants;

import com.imtmn.entity.FlowNode;

import java.util.Arrays;
import java.util.List;

/**
 * 流程节点数据枚举
 *
 *
 * @author mtmn
 * @date 2020/12/17 8:10
 */
public enum  FlowNodeEnum {
    //任务1：项目研发 申请（产品部）-> 管理审批（管理部）-> 财务审批（财务部）-> 确认（产品部）->研发（研发部）->测试（测试部）
    DEVELOPMENT_FLOW(Arrays.asList(
            new FlowNode("DEV_01", "申请", DepartmentEnum.PRODUCT.getDepartment()),
            new FlowNode("DEV_02", "管理审批", DepartmentEnum.MANAGER.getDepartment()),
            new FlowNode("DEV_03", "财务审批", DepartmentEnum.ACCOUNTING.getDepartment()),
            new FlowNode("DEV_04", "确认", DepartmentEnum.PRODUCT.getDepartment()),
            new FlowNode("DEV_05", "研发", DepartmentEnum.DEVELOPMENT.getDepartment()),
            new FlowNode("DEV_06", "测试", DepartmentEnum.TEST.getDepartment())
            )),
    //任务2：项目外包 申请（产品部）-> 管理审批（管理部）-> 财务审批（财务部）-> 采购（采购部）-> 确认（物流部）
    OUTSOURCING_FLOW(Arrays.asList(
            new FlowNode("OUT_01", "申请", DepartmentEnum.PRODUCT.getDepartment()),
            new FlowNode("OUT_02", "管理审批", DepartmentEnum.MANAGER.getDepartment()),
            new FlowNode("OUT_03", "财务审批", DepartmentEnum.ACCOUNTING.getDepartment()),
            new FlowNode("OUT_04", "采购", DepartmentEnum.PURCHASING.getDepartment()),
            new FlowNode("OUT_05", "确认", DepartmentEnum.LOGISTICS.getDepartment())
    )),
    //任务3：招聘 申请（所有部门）->  管理审批（管理部）-> 财务审批（财务部）-> 招人（职场部）
    RECRUITMENT_FLOW(Arrays.asList(
            new FlowNode("REC_01","申请"),
            new FlowNode("REC_02","管理审批",DepartmentEnum.MANAGER.getDepartment()),
            new FlowNode("REC_03","财务审批",DepartmentEnum.ACCOUNTING.getDepartment()),
            new FlowNode("REC_04","招人",DepartmentEnum.PERSONNEL.getDepartment())
    ))
    ;

    private List<FlowNode> nodeList;

    FlowNodeEnum(List<FlowNode> nodeList) {
        this.nodeList = nodeList;
    }

    public List<FlowNode> getNodeList() {
        return nodeList;
    }
}
