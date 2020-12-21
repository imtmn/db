package com.imtmn.init;

import com.imtmn.constants.TaskEnum;
import com.imtmn.entity.FlowNodeDef;
import com.imtmn.entity.Task;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 初始化测试数据
 *
 * @author mtmn
 * @date 2020/12/16 7:14
 */
public class InitData {

    /**
     * 初始化数据
     */
    public static void initData(){
        //根据任务初始化数据
        //每个任务分配线程数量 A任务 10个线程 B任务10个 C任务10个
        initTaskData(TaskEnum.PROJECT_DEVELOPMENT.getTask(),20);
    }

    /**
     * 根据任务初始化数据
     * @param task
     * @param threadNum
     */
    private static void initTaskData(Task task, int threadNum) {
        ExecutorService executorService = Executors.newCachedThreadPool();
//        executorService.execute(new Jo);
        List<FlowNodeDef> nodeList = task.getNodeList();

    }
}
