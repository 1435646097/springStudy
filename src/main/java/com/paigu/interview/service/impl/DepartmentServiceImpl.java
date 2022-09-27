package com.paigu.interview.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.paigu.interview.entity.Department;
import com.paigu.interview.mapper.DepartmentMapper;
import com.paigu.interview.service.IDepartmentService;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {
}
