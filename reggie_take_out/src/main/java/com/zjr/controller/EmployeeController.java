package com.zjr.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zjr.common.Result;
import com.zjr.entity.Employee;
import com.zjr.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/login")
    public Result<Employee> login(HttpSession session, @RequestBody Employee employee){
        String password = employee.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());

        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Employee::getUsername, employee.getUsername());
        Employee emp = employeeService.getOne(queryWrapper);

        if(emp == null){
            return Result.error("用户不存在");
        }

        if(!emp.getPassword().equals(password)){
            return Result.error("密码错误");
        }

        if(emp.getStatus() == 0){
            return Result.error("账号已禁用");
        }

        session.setAttribute("employee", emp.getId());
        return Result.success(emp);
    }

    @PostMapping("/logout")
    public Result<String> logout(HttpSession session){
        session.removeAttribute("employee");
        return Result.success("退出成功");
    }

    @PostMapping()
    public Result<String> save(HttpSession session, @RequestBody Employee employee){
        log.info("新增员工，员工信息：{}", employee.toString());
        employee.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
        employee.setCreateTime(LocalDateTime.now());
        employee.setUpdateTime(LocalDateTime.now());

        Long empId = (Long)session.getAttribute("employee");
        employee.setCreateUser(empId);
        employee.setUpdateUser(empId);

        employeeService.save(employee);
        return Result.success("新增员工成功");
    }

}
