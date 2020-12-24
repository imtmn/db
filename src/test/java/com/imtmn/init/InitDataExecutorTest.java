package com.imtmn.init;

import org.junit.Test;

/**
 * 初始化数据测试
 */
public class InitDataExecutorTest {

    @Test
    public void thread(){
        InitTaskDataThread t = new InitTaskDataThread();
        t.run();
    }

    @Test
    public void initData() {
        InitDataExecutor initDataExecutor = new InitDataExecutor();
        initDataExecutor.init();
    }

}