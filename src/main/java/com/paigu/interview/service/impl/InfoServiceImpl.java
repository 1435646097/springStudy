package com.paigu.interview.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.paigu.interview.entity.Info;
import com.paigu.interview.mapper.InfoMapper;
import com.paigu.interview.service.IInfoService;
import org.springframework.stereotype.Service;

/**
 * @author PaiGu
 * @description TODO
 * @date 2022/1/29 23:10
 */
@Service
public class InfoServiceImpl extends ServiceImpl<InfoMapper, Info> implements IInfoService {
}
