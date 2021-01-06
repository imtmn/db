# 测试结果
## 树莓派上测试，数据量：1493353（由于树莓派性能较差，到达千万级可能连查都查不出来，因此在百万数据上做测试，比对性能）
### 查询每个部门的处理量
mysql> select handler_group_code,handler_group_name,count(1) from flow_node group by handler_group_code;<br/>
mysql> show profiles;<br/>
| Query_ID | Duration   | Query |
| -------- | -------- | ----- |
|        1 |   6.182648 | 略 |
|        2 |   6.209443 | 略 |
|        3 | 6.19930875 | 略 |
|        4 | 6.17186125 | 略 |
|        5 |  6.1832225 | 略 |
|        6 | 6.25690775 | 略 |
|        7 | 6.18599075 | 略 |
|        8 | 6.18654625 | 略 |
|        9 | 6.22117425 | 略 |
|       10 |   6.171694 | 略 |
> 查询耗时:6.20s左右
### 查询每个部门处理量（下半年）
mysql> select handler_group_code,handler_group_name,count(1) from flow_node where processing_time>'2020-07-01 00:00:00'group by handler_group_code;<br/>
| Query_ID | Duration   | Query |
| -------- | -------- | ----- |
|       1 |  4.9848415 | 略 |
|       2 | 4.97804025 | 略 |
|       3 |   4.970329 | 略 |
|       4 |  4.9918695 | 略 |
|       5 |   4.995391 | 略 |
|       6 |   4.989174 | 略 |
|       7 | 4.95907625 | 略 |
|       8 | 4.97990225 | 略 |
|       9 | 4.96556675 | 略 |
|      10 | 4.95555475 | 略 |
> 查询耗时:4.97s左右
### 查询每个中心底下的数据量
mysql> select left(handler_group_code, 4),count(1) from flow_node group by left(handler_group_code, 4);<br/>
| Query_ID | Duration   | Query | 
| -------- | -------- | ----- |
|       1 |  5.2228465 | 略  |
|       2 | 5.25864825 | 略  |
|       3 | 5.18450475 | 略  |
|       4 | 5.23883425 | 略  |
|       5 | 5.19392225 | 略  |
|       6 | 5.18073825 | 略  |
|       7 |   5.211877 | 略  |
|       8 | 5.19076025 | 略  |
|       9 |   5.199934 | 略  |
|       10 | 5.23943475 | 略  |
> 平均耗时：5.21s左右
### 查询每个中心底下的数据量(下半年)
mysql> select left(handler_group_code, 4),count(1) from flow_node where processing_time>'2020-07-01 00:00:00' group by left(handler_group_code, 4);<br/>
| Query_ID | Duration   | Query |
| -------- | -------- | ----- |
|       1 | 4.48916675 | 略   |
|       2 | 4.49006625 | 略   |
|       3 | 4.47495225 | 略   |
|       4 | 4.46872425 | 略   |
|       5 | 4.51446475 | 略   |
|       6 | 4.48860175 | 略   |
|       7 | 4.49046025 | 略   |
|       8 | 4.49469975 | 略   |
|       9 | 4.47850225 | 略   |
|       10 |  4.5053725 | 略   |
> 平均耗时：4.49s左右
### 查询每个任务底下 每个流程的数据量
mysql> select task_name,process_node_name,count(1) from flow_node group by task_id,process_node_code;<br/>
| Query_ID | Duration   | Query |
| -------- | -------- | ----- |
|        1 |   9.8716945 | 略 |
|        2 |  9.54707825 | 略 |
|        3 |  9.58079175 | 略 |
|        4 |  9.58559975 | 略 |
|        5 |  9.52963575 | 略 |
|        6 |  9.59779875 | 略 |
|        7 |  9.53241775 | 略 |
|        8 |   9.9998825 | 略 |
|        9 |   9.6421555 | 略 |
|       10 |   9.5461855 | 略 |
> 平均耗时：9.64s左右
### 查询每个任务底下 每个流程的数据量(下半年)
mysql> select task_name,process_node_name,count(1) from flow_node where processing_time>'2020-07-01 00:00:00' group by task_id,process_node_code;<br/>
| Query_ID | Duration   | Query |
| -------- | -------- | ----- |
|       1 | 6.87562425 | 略  |
|       2 |   6.790524 | 略  |
|       3 |   6.835815 | 略  |
|       4 | 6.82178425 | 略  |
|       5 |  6.8023585 | 略  |
|       6 |  6.8134425 | 略  |
|       7 |   6.835443 | 略  |
|       8 |   6.834422 | 略  |
|       9 |   6.811076 | 略  |
|       10 | 6.82712925 | 略   |
> 平均耗时：6.824s左右
### 查看每个部门在每个任务底下数据量
 mysql> select handler_group_name,task_name,count(1) from flow_node group by handler_group_code,task_id;<br/>
| Query_ID | Duration   | Query |
| -------- | -------- | ----- |
|       1 | 9.64091125 | 略 |
|       2 |  9.6141055 | 略 |
|       3 | 9.66447675 | 略 |
|       4 | 9.73899325 | 略 |
|       5 | 9.74521925 | 略 |
|       6 | 9.73841075 | 略 |
|       7 |   9.646872 | 略 |
|       8 | 9.68180075 | 略 |
|       9 |   9.696033 | 略 |
|       10 |   9.621659 | 略 |
> 平均9.68s左右
### 查看每个部门在每个任务底下数据量(下半年)
mysql> select handler_group_name,task_name,count(1) from flow_node where processing_time>'2020-07-01 00:00:00' group by handler_group_code,task_id;
| Query_ID | Duration   | Query |
| -------- | -------- | ----- |
|        1 |  6.9147365 | 略 |
|        2 | 6.92819275 | 略 |
|        3 |  6.9001905 | 略 |
|        4 | 6.97361175 | 略 |
|        5 |   6.905323 | 略 |
|        6 | 6.92038225 | 略 |
|        7 |  6.9800245 | 略 |
|        8 |   6.863595 | 略 |
|        9 | 6.89899975 | 略 |
|       10 | 6.94971275 | 略 |
> 平均6.92s左右
## 复制一张表（flow_node_range）进行分区测试
### 按日期进行分区
```
ALTER TABLE `flow_node_range`
DROP PRIMARY KEY,
ADD PRIMARY KEY (`id`, `processing_time`);
```
> 分区向前需要先重建主键，因为分区字段必须为主键
```
ALTER TABLE flow_node_range ADD PARTITION BY RANGE (to_days(processing_time))
  (
    PARTITION p_202001 VALUES LESS THAN (to_days('2020-02-01')),
    PARTITION p_202002 VALUES LESS THAN (to_days('2020-03-01')),
    PARTITION p_202003 VALUES LESS THAN (to_days('2020-04-01')),
    PARTITION p_202004 VALUES LESS THAN (to_days('2020-05-01')),
    PARTITION p_202005 VALUES LESS THAN (to_days('2020-06-01')),
    PARTITION p_202006 VALUES LESS THAN (to_days('2020-07-01')),
    PARTITION p_202007 VALUES LESS THAN (to_days('2020-08-01')),
    PARTITION p_202008 VALUES LESS THAN (to_days('2020-09-01')),
    PARTITION p_202009 VALUES LESS THAN (to_days('2020-10-01')),
    PARTITION p_202010 VALUES LESS THAN (to_days('2020-11-01')),
    PARTITION p_202011 VALUES LESS THAN (to_days('2020-12-01')),
    PARTITION p_202012 VALUES LESS THAN (to_days('2021-01-01')),
    PARTITION p_other  VALUES LESS THAN (MAXVALUE)
  );
```
### 查询每个部门的处理量
mysql> select handler_group_code,handler_group_name,count(1) from flow_node_range group by handler_group_code;<br/>
mysql> show profiles;<br/>
| Query_ID | Duration   | Query |
| -------- | -------- | ----- |
|       0 | 5.28898175 | 略|
|       1 |   5.275427 | 略|
|       2 |  5.2671755 | 略|
|       3 | 5.24748375 | 略|
|       4 | 5.28356775 | 略|
|       5 |  5.2607305 | 略|
|       6 | 5.26234275 | 略|
|       7 | 5.26923075 | 略|
|       8 | 5.28564125 | 略|
|       9 |   5.279343 | 略|
|       10 | 5.29546325 | 略 |
> 查询耗时:5.27s左右
### 查询每个部门处理量（下半年）
mysql> select handler_group_code,handler_group_name,count(1) from flow_node_range where processing_time>'2020-07-01 00:00:00'group by handler_group_code;<br/>
| Query_ID | Duration   | Query |
| -------- | -------- | ----- |
|       1 | 3.04269425 | 略 |
|       2 | 3.05542875 | 略 |
|       3 |  3.0354975 | 略 |
|       4 |  3.0401255 | 略 |
|       5 |  3.0394215 | 略 |
|       6 | 3.04583125 | 略 |
|       7 |  3.0353195 | 略 |
|       8 | 3.05833475 | 略 |
|       9 | 3.02265725 | 略 |
|      10 | 3.01553175 | 略 |
> 查询耗时:3.03s左右
### 查询每个中心底下的数据量
mysql> select left(handler_group_code, 4),count(1) from flow_node group by left(handler_group_code, 4);<br/>
| Query_ID | Duration   | Query |
| -------- | -------- | ----- |
|        1 |    5.05259 | 略   |
|        2 | 5.06213325 | 略   |
|        3 | 5.05884525 | 略   |
|        4 |  5.0790225 | 略   |
|        5 |  5.0848775 | 略   |
|        6 |   5.109943 | 略   |
|        7 | 5.07334125 | 略   |
|        8 | 5.08773225 | 略   |
|        9 | 5.07048675 | 略   |
|       10 |   5.081104 | 略   |
> 平均耗时：5.07s左右
### 查询每个中心底下的数据量(下半年)
mysql> select left(handler_group_code, 4),count(1) from flow_node where processing_time>'2020-07-01 00:00:00' group by left(handler_group_code, 4);<br/>
> 平均耗时：4.49s左右
### 查询每个任务底下 每个流程的数据量
mysql> select task_name,process_node_name,count(1) from flow_node group by task_id,process_node_code;<br/>
> 平均耗时：9.64s左右
### 查询每个任务底下 每个流程的数据量(下半年)
mysql> select task_name,process_node_name,count(1) from flow_node where processing_time>'2020-07-01 00:00:00' group by task_id,process_node_code;<br/>
> 平均耗时：6.824s左右
### 查看每个部门在每个任务底下数据量
 mysql> select handler_group_name,task_name,count(1) from flow_node group by handler_group_code,task_id;<br/>
> 平均9.68s左右
### 查看每个部门在每个任务底下数据量(下半年)
mysql> select handler_group_name,task_name,count(1) from flow_node where processing_time>'2020-07-01 00:00:00' group by handler_group_code,task_id;
> 平均6.92s左右
