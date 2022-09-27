package com.paigu.interview.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.paigu.interview.entity.Employee;
import com.paigu.interview.mapper.EmployeeMapper;
import com.paigu.interview.service.IEmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {
}
