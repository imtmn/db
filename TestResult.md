# 测试结果
## 树莓派上测试，数据量：1493353（由于树莓派性能较差，到达千万级可能连查都查不出来，因此在百万数据上做测试，比对性能）
### 查询每个部门的处理量
mysql> select handler_group_code,handler_group_name,count(1) from flow_node group by handler_group_code;<br/>
mysql> show profiles;<br/>
| Query_ID | Duration | Query |
| -------- | -------- | ----- |
| 1        | 17.9779625 | 略 |
| 2        | 18.0560555 | 略 |
| 3       | 17.986291 | 略 |
| 4        | 18.05946575 | 略 |
| 5        | 18.11107825 | 略 |
| 6        | 18.0766465 | 略 |
| 7        | 18.079958 | 略 |
| 8        | 18.111092 | 略 |
| 9        | 18.1046355 | 略 |
| 10        | 18.128368 | 略 |
> 查询耗时:18s左右
### 查询每个中心底下的数据量
select left(handler_group_code, 4),count(1) from flow_node group by left(handler_group_code, 4);<br/>
| Query_ID | Duration | Query |
| -------- | -------- | ----- |
| 1 |  2.98614525 | 略 |
| 2 |  2.76252375 | 略 |
| 3 |    2.718279 | 略 |
| 4 |  2.78667325 | 略 |
| 5 |   2.7113055 | 略 |
| 6 |  2.76278175 | 略 |
| 7 |  2.75386025 | 略 |
| 8 |   2.7422705 | 略 |
| 9 |    2.738488 | 略 |
| 10 |   2.7296975 | 略 |
> 平均耗时：2.8s左右
### 查询每个任务底下 每个流程的数据量
mysql> select task_name,process_node_name,count(1) from flow_node group by task_id,process_node_code;<br/>
| Query_ID | Duration   | Query                                                                                         |
| -------- | -------- | ----- |
| 1 | 9.13049575 | 略  |
| 2 | 9.15516575 | 略  |
| 3 | 9.18218975 | 略  |
| 4 |  9.1390335 | 略  |
| 5 |   9.287013 | 略  |
| 6 |  9.3267245 | 略  |
| 7 | 9.36356425 | 略  |
| 8 |   9.235578 | 略  |
| 9 |   9.296024 | 略  |
| 10 | 9.21241325 | 略  |
> 平均耗时：9.2s左右
### 查看每个部门在每个任务底下数据量
 mysql> select handler_group_name,task_name,count(1) from flow_node group by handler_group_code,task_id;<br/>
| Query_ID | Duration   | Query                                                                                         |
| -------- | -------- | ----- |
| 1 | 9.37044675 | 略  |
| 2 |  9.4700405 | 略  |
| 3 |   9.427579 | 略  |
| 4 |   9.366811 | 略  |
| 5 |  9.4707085 | 略  |
| 6 |  9.3761685 | 略  |
| 7 |   9.359458 | 略  |
| 8 |  9.3506635 | 略  |
| 9 |   9.421226 | 略  |
| 10 |  9.3958625 | 略  |
> 平均9.4s左右
