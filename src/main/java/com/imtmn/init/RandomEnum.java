package com.imtmn.init;

import com.imtmn.constants.DepartmentEnum;
import com.imtmn.constants.TaskEnum;
import com.imtmn.entity.Department;
import com.imtmn.entity.Task;

import java.util.Random;

/**
 * 随机获取任务
 *
 * @author mtmn
 * @date 2020/12/24 7:07
 */
public class RandomEnum {

    /**
     * 随机生成一个任务
     * @return
     */
    public static Task randomTask() {
        Random random = new Random();
        TaskEnum[] tasks = TaskEnum.values();
        int i = random.nextInt(tasks.length);
        return tasks[i].getTask();
    }

    /**
     * 随机生成一个部门
     * @return
     */
    public static Department randomDepartment(){
        Random random = new Random();
        DepartmentEnum[] departments= DepartmentEnum.values();
        int i = random.nextInt(departments.length);
        return departments[i].getDepartment();
    }


}
