package com.imtmn.init;

import cn.hutool.core.thread.ThreadUtil;
import com.imtmn.constants.TaskEnum;
import com.imtmn.entity.Task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 初始化测试数据
 *
 * @author mtmn
 * @date 2020/12/16 7:14
 */
public class InitDataExecutor {

    public static final int THREAD_NUM = 50;

    /**
     * 初始化数据
     */
    public void init() {
        //根据任务初始化数据
        ExecutorService executorService = ThreadUtil.newExecutor(THREAD_NUM);
        for (int i = 0; i < THREAD_NUM; i++) {
            executorService.execute(new InitTaskDataThread());
        }
    }


    public static void main(String[] args) {
        InitDataExecutor initDataExecutor = new InitDataExecutor();
        initDataExecutor.init();
    }
}
