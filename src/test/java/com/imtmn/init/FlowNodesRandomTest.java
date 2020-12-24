package com.imtmn.init;

import cn.hutool.core.lang.Assert;
import com.imtmn.constants.FlowNodeDefEnum;
import com.imtmn.entity.FlowNodeDef;
import org.junit.Test;

import java.util.List;

/**
 * 随机流程数据
 */
public class FlowNodesRandomTest {

    /**
     * 测试生成随机流程的数量
     */
    public static final int size = 1000;

    @Test
    public void getRandomFlowNodes() {
        int computedCount = 0;
        int unComputedCount = 0;
        //研发任务获取随机数量
        List<FlowNodeDef> nodeList = FlowNodeDefEnum.DEVELOPMENT_FLOW.getNodeList();
        FlowNodesRandom random = new FlowNodesRandom(nodeList);
        for (int i = 0; i < size; i++) {
            List<FlowNodeDef> randomFlowNodes = random.getRandomFlowNodes();
            if (randomFlowNodes.size() == nodeList.size()) {
                computedCount++;
            } else {
                unComputedCount++;
            }
        }
        System.out.println("测试结果，完成流程数量为：" + computedCount);
        System.out.println("测试结果，未完成流程数量为：" + unComputedCount);
        //以下测试是根据随机概率进行测试, 完成率5%,理论上不会超过10%，所以测试结果不一样百分百准确
        Assert.isTrue(computedCount > size * 0.90, "默认完成率为95%,完成的流程数量理论上要大于90%");
        Assert.isTrue(unComputedCount < size * 0.1, "默认完成率为95%,未完成的数量理论上要小于10%");
    }
}