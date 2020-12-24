package com.imtmn.dao;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.imtmn.entity.FlowNode;

import java.sql.SQLException;

/**
 * 持久化操作
 *
 * @author mtmn
 * @date 2020/12/18 7:37
 */
public class FlowDao {

    private static final Log log = LogFactory.get();

    /**
     * 保存流程节点
     */
    public static void save(FlowNode flowNode) {
        try {
            Db.use().insert(
                    Entity.create("flow_node")
                            .set("task_id", flowNode.getTaskId())
                            .set("task_name", flowNode.getTaskName())
                            .set("info_id", flowNode.getInfoId())
                            .set("processing_time", flowNode.getProcessingTime())
                            .set("modification_time", flowNode.getModificationTime())
                            .set("process_node_code", flowNode.getProcessNodeCode())
                            .set("process_node_name", flowNode.getProcessNodeName())
                            .set("current_node_code", flowNode.getCurrentNodeCode())
                            .set("current_node_name", flowNode.getCurrentNodeName())
                            .set("handler", flowNode.getHandler())
                            .set("handler_group_code", flowNode.getHandlerGroupCode())
                            .set("handler_group_name", flowNode.getHandlerGroupName())
                            .set("receive_group_code", flowNode.getReceiveGroupCode())
                            .set("receive_group_name", flowNode.getReceiveGroupName())

            );
        } catch (SQLException e) {
            log.error("insert error ", e);
        }
    }

    public static int count() {
        try {
            return Db.use().count(Entity.create("flow_node"));
        } catch (SQLException e) {
            log.error("count error", e);
        }
        return -1;
    }
}
