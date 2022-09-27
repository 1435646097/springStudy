package com.paigu.interview.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 部门表
 *
 * @author liao
 * @date 2022/09/25
 */
@Data
@TableName("department")
public class Department {
    /**
     * 部门id
     */
    private Integer departmentId;
    /**
     * 部门名称
     */
    private String departmentName;
    /**
     * 部门地址
     */
    private String departmentAddress;
    /**
     * 部门父id
     */
    private Integer departmentPid;
}
