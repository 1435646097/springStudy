package com.paigu.interview.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("auto_test")
@Data
public class AutoTest {
    /**
     * id
     */
    @TableId(value = "id",type = IdType.INPUT)
    private Integer id;
    /**
     * 名字
     */
    private String name;
}
