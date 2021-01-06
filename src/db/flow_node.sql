/*
Navicat MySQL Data Transfer

Source Server         : 89_test
Source Server Version : 50649
Source Host           : 192.168.3.89:3306
Source Database       : test_partition

Target Server Type    : MYSQL
Target Server Version : 50649
File Encoding         : 65001

Date: 2020-12-28 07:02:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for flow_node
-- ----------------------------
DROP TABLE IF EXISTS `flow_node`;
CREATE TABLE `flow_node` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `task_id` varchar(16) DEFAULT NULL COMMENT '任务ID',
  `task_name` varchar(128) DEFAULT NULL COMMENT '关联任务名称',
  `info_id` varchar(32) DEFAULT NULL COMMENT '关联信息ID',
  `processing_time` datetime DEFAULT NULL COMMENT '处理时间',
  `modification_time` datetime DEFAULT NULL COMMENT '修改时间',
  `process_node_code` varchar(16) DEFAULT NULL COMMENT '流程节点编码',
  `process_node_name` varchar(32) DEFAULT NULL COMMENT '流程节点名称',
  `current_node_code` varchar(16) DEFAULT NULL COMMENT '当前关联数据流程节点编码',
  `current_node_name` varchar(32) DEFAULT NULL COMMENT '当前关联数据流程节点名称',
  `handler` varchar(128) DEFAULT NULL COMMENT '处理人',
  `handler_group_code` varchar(16) DEFAULT NULL COMMENT '处理部门编码',
  `handler_group_name` varchar(32) DEFAULT NULL COMMENT '处理部门名称',
  `receive_group_code` varchar(16) DEFAULT NULL COMMENT '接收部门编码',
  `receive_group_name` varchar(32) DEFAULT NULL COMMENT '接收部门名称',
  PRIMARY KEY (`id`),
  KEY `idx_info_id` (`info_id`),
  KEY `idx_processing_time` (`processing_time`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1493384 DEFAULT CHARSET=utf8;
