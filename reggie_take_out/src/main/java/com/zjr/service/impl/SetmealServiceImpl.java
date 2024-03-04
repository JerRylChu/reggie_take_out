package com.zjr.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zjr.entity.Setmeal;
import com.zjr.mapper.SetmealMapper;
import com.zjr.service.SetmealService;
import org.springframework.stereotype.Service;

@Service
public class SetmealServiceImpl extends ServiceImpl<SetmealMapper, Setmeal> implements SetmealService {
}
