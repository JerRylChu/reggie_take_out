package com.zjr.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zjr.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
}
