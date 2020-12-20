package com.imtmn.dao;

import cn.hutool.core.date.DateUtil;
import com.imtmn.constants.DepartmentEnum;
import com.imtmn.constants.FlowNodeDefEnum;
import com.imtmn.constants.TaskEnum;
import com.imtmn.entity.FlowNode;
import com.imtmn.entity.FlowNodeDef;
import com.imtmn.entity.Task;
import org.junit.Test;

import java.util.Date;
import java.util.UUID;

import static org.junit.Assert.*;

public class FlowDaoTest {

    @Test
    public void save() {
        Task task = TaskEnum.PROJECT_DEVELOPMENT.getTask();
        FlowNode node = new FlowNode();
        // 关联任务ID
        node.setTaskId(task.getTaskId());
        // 关联任务名称
        node.setTaskName(task.getTaskName());
        // 关联业务数据ID
        node.setInfoId(UUID.randomUUID().toString().replace("-",""));
        // 当前节点处理时间
        node.setProcessingTime(new Date());
        // 随便设置个修改时间,用于测试存入数据是否准确
        node.setModificationTime(DateUtil.endOfWeek(new Date()));
        // 处理节点：申请
        node.setProcessNodeCode(FlowNodeDefEnum.DEVELOPMENT_FLOW.getNodeList().get(0).getCode());
        node.setProcessNodeName(FlowNodeDefEnum.DEVELOPMENT_FLOW.getNodeList().get(0).getName());
        // 当前节点：管理审批
        node.setCurrentNodeCode(FlowNodeDefEnum.DEVELOPMENT_FLOW.getNodeList().get(1).getCode());
        node.setCurrentNodeName(FlowNodeDefEnum.DEVELOPMENT_FLOW.getNodeList().get(1).getName());
        // 处理节点部门：产品部
        node.setHandlerGroupCode(DepartmentEnum.PRODUCT.getDepartment().getCode());
        node.setHandlerGroupName(DepartmentEnum.PRODUCT.getDepartment().getName());
        // 下个环节部门：管理部
        node.setReceiveGroupCode(DepartmentEnum.MANAGER.getDepartment().getCode());
        node.setReceiveGroupName(DepartmentEnum.MANAGER.getDepartment().getName());
        // 操作人
        node.setHandler("码头码农");
        FlowDao.save(node);
    }
}