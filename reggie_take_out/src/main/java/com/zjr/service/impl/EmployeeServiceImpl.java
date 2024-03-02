package com.zjr.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zjr.entity.Employee;
import com.zjr.mapper.EmployeeMapper;
import com.zjr.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
}
