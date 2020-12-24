package com.imtmn.init;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.imtmn.dao.FlowDao;
import com.imtmn.entity.Department;
import com.imtmn.entity.FlowNode;
import com.imtmn.entity.FlowNodeDef;
import com.imtmn.entity.Task;

import java.util.*;

/**
 * 初始化任务数据线程
 *
 * @author mtmn
 * @date 2020/12/22 6:33
 */
public class InitTaskDataThread implements Runnable {

    private static final Log log = LogFactory.get();

    public void run() {
        while (true) {
            initData();
        }
    }

    private void initData() {
        Task task = RandomEnum.randomTask();
        log.info("任务数据初始化线程开始,任务编号为{}", task.getTaskId());
        // 根据任务随机生成流程定义数据
        FlowNodesRandom random = new FlowNodesRandom(task.getNodeList());
        LinkedList<FlowNodeDef> flowNodeDefs = random.getRandomFlowNodes();
        // 初始化流程数据
        List<FlowNode> flowNodes = initFlowNodesByDefs(task, flowNodeDefs);
        // 保存流程数据
        for (FlowNode flowNode : flowNodes) {
            FlowDao.save(flowNode);
        }
    }

    /**
     * 流程定义列表初始化流程数据列表
     *
     * @param task
     * @param flowNodeDefs
     * @return
     */
    public List<FlowNode> initFlowNodesByDefs(Task task, LinkedList<FlowNodeDef> flowNodeDefs) {
        // 随机生成一个业务ID
        String id = UUID.randomUUID().toString().replaceAll("-", "");
        FlowNodeDef lastNode = flowNodeDefs.getLast();
        List<FlowNode> list = new ArrayList<>();
        DateTime dateTime = DateUtil.beginOfYear(new Date());
        Random random = new Random();
        // 随机生成一个流程最新时间
        DateTime lastTime = DateUtil.offsetDay(dateTime, random.nextInt(365));
        lastTime = DateUtil.offsetMinute(lastTime, random.nextInt(60 * 24));
        int lastIndex = flowNodeDefs.size();
        while (flowNodeDefs.peek() != null) {
            FlowNodeDef nodeDef = flowNodeDefs.poll();
            FlowNode flowNode = new FlowNode();
            flowNode.setTaskId(task.getTaskId());
            flowNode.setTaskName(task.getTaskName());
            flowNode.setInfoId(id);
            flowNode.setProcessNodeName(nodeDef.getName());
            flowNode.setProcessNodeCode(nodeDef.getCode());
            flowNode.setCurrentNodeName(lastNode.getName());
            flowNode.setCurrentNodeCode(lastNode.getCode());
            Department department = nodeDef.getDepartment() == null ? RandomEnum.randomDepartment() : nodeDef.getDepartment();
            flowNode.setHandlerGroupCode(department.getCode());
            flowNode.setHandlerGroupName(department.getName());
            FlowNodeDef nextNodeDef = flowNodeDefs.peek();
            if (nextNodeDef != null) {
                flowNode.setReceiveGroupCode(nextNodeDef.getCode());
                flowNode.setReceiveGroupName(nextNodeDef.getName());
            }
            flowNode.setHandler("测试人员");
            DateTime processTime = DateUtil.offsetDay(lastTime, -(lastIndex--));
            processTime = DateUtil.offsetMinute(processTime, random.nextInt(60 * 24));
            flowNode.setProcessingTime(processTime);
            flowNode.setModificationTime(lastTime);
            list.add(flowNode);
        }
        return list;
    }


}
