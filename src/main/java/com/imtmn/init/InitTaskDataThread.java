package com.imtmn.init;

import com.imtmn.entity.FlowNode;
import com.imtmn.entity.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * 初始化任务数据线程
 *
 * @author mtmn
 * @date 2020/12/22 6:33
 */
public class InitTaskDataThread implements Runnable{

    /**
     * 关联任务
     */
    private Task task;

    public InitTaskDataThread(Task task) {
        this.task = task;
    }

    public void run() {
        // 初始化流程数据
        List<FlowNode> flowNodeList = initFlowNodes();
    }

    /**
     * 初始化流程数据
     * @return
     */
    private List<FlowNode> initFlowNodes() {
        //获取任务流程定义
        //随机流程流转情况，假设未走完流程的概率5%
        return null;
    }
}
