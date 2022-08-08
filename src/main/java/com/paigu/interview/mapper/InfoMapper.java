package com.paigu.interview.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.paigu.interview.entity.Info;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 信息映射器
 *
 * @author liao
 * @date 2022/07/24
 */
@Mapper
public interface InfoMapper extends BaseMapper<Info> {
    List<Info> findByName(@Param("name") String name);
}
