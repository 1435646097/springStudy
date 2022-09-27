package com.paigu.interview.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 员工表
 *
 * @author liao
 * @date 2022/09/25
 */
@Data
@TableName("employee")
public class Employee {
    /**
     * 员工id
     */
    private Integer employeeId;
    /**
     * 员工名字
     */
    private String employeeName;
    /**
     * 员工工作
     */
    private String word;
    /**
     * 直属领导id
     */
    private Integer lineManagerId;
    /**
     * 入职时间
     */
    private LocalDateTime entryTime;
    /**
     * 工资
     */
    private Integer salary;
    /**
     * 所属部门id
     */
    private Integer departmentId;
}
