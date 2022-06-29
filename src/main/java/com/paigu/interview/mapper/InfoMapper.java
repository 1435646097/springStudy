package com.paigu.interview.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.paigu.interview.entity.Info;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author PaiGu
 * @description 人员信息Mapper
 * @date 2022/1/29 23:09
 */
@Mapper
public interface InfoMapper extends BaseMapper<Info> {
    List<Info> findByName(@Param("name") String name);
}
