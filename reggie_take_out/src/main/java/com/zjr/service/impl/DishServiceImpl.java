package com.zjr.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zjr.entity.Dish;
import com.zjr.mapper.DishMapper;
import com.zjr.service.DishService;
import org.springframework.stereotype.Service;

@Service
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService {
}
