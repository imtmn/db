/*
Navicat MySQL Data Transfer

Source Server         : 89_test
Source Server Version : 50649
Source Host           : 192.168.3.89:3306
Source Database       : test_partition

Target Server Type    : MYSQL
Target Server Version : 50649
File Encoding         : 65001

Date: 2020-12-16 07:20:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for flow
-- ----------------------------
DROP TABLE IF EXISTS `flow`;
CREATE TABLE `flow` (
  `id` bigint(20) NOT NULL,
  `task_id` int(11) DEFAULT NULL COMMENT '任务ID',
  `info_id` varchar(32) DEFAULT NULL COMMENT '关联信息ID',
  `processing_time` datetime DEFAULT NULL COMMENT '处理时间',
  `modification_time` datetime DEFAULT NULL COMMENT '修改时间',
  `process_node` varchar(255) DEFAULT NULL COMMENT '流程节点',
  `current_node` varchar(255) DEFAULT NULL COMMENT '关联信息当前流程节点',
  `handler` varchar(255) DEFAULT NULL COMMENT '处理人',
  `handler_group` varchar(16) DEFAULT NULL COMMENT '处理分组',
  `receive_group` varchar(255) DEFAULT NULL COMMENT '接收分组',
  PRIMARY KEY (`id`),
  KEY `idx_info_id` (`info_id`),
  KEY `idx_processing_time` (`processing_time`),
  KEY `idx_handle_group` (`handler_group`),
  KEY `idx_receive_group` (`receive_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
