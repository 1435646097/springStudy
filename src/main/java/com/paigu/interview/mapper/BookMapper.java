package com.paigu.interview.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.paigu.interview.entity.Book;
import org.apache.ibatis.annotations.Param;


public interface BookMapper extends BaseMapper<Book> {
    Book findById(@Param("id")Long id);






}
