package com.imtmn.init;

import com.imtmn.entity.FlowNodeDef;
import com.imtmn.entity.Task;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * 流程节点完成情况随机
 *
 * @author mtmn
 * @date 2020/12/22 6:49
 */
public class FlowNodesRandom {
    /**
     * 任务流程定义
     */
    private final List<FlowNodeDef> flowNodeDefs;

    /**
     * 完成率
     * 如果完成率为99% 就设置为 99
     * 默认95
     */
    private int completionRate = 95;

    public FlowNodesRandom(List<FlowNodeDef> flowNodeDefs) {
        this.flowNodeDefs = flowNodeDefs;
    }

    public int getCompletionRate() {
        return completionRate;
    }

    public void setCompletionRate(int completionRate) {
        assert completionRate >= 0 && completionRate <= 100 : "完成率应该介于0-100之间";
        this.completionRate = completionRate;
    }

    /**
     * 获取随机的完成的流程节点定义
     *
     * @return
     */
    public LinkedList<FlowNodeDef> getRandomFlowNodes() {
        //根据完成率 随机获取当前节点是否完成
        boolean isComputed = getRandomComputed();
        if (isComputed) {
            //已完成节点直接返回所有流程定义
            return new LinkedList<>(flowNodeDefs);
        } else {
            Random r = new Random();
            //随机未完成的节点下标
            int i = r.nextInt(flowNodeDefs.size() - 1);
            //至少有一个节点
            i = (i == 0 ? 1 : i);
            return new LinkedList<>(flowNodeDefs.subList(0, i));
        }

    }

    /**
     * 根据完成率获取 随机结果：是否已经完成
     *
     * @return
     */
    private boolean getRandomComputed() {
        Random r = new Random();
        int i = r.nextInt(100);
        if (i < completionRate) {
            return true;
        }
        return false;
    }
}
