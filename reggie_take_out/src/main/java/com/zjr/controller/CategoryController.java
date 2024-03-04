package com.zjr.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zjr.common.Result;
import com.zjr.entity.Category;
import com.zjr.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/category")
@Slf4j
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public Result<String> save(@RequestBody Category category){
        log.info("category: {}", category);
        categoryService.save(category);
        return Result.success("新增分类成功");
    }

    @GetMapping("/page")
    public Result<Page> page(int page, int pageSize, String name){
        log.info("page = {}, pageSize = {}, name={}",page, pageSize, name);

        Page pageInfo = new Page(page, pageSize);

        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.isNotEmpty(name), Category::getName, name);

        queryWrapper.orderByDesc(Category::getUpdateTime);

        categoryService.page(pageInfo, queryWrapper);

        return Result.success(pageInfo);
    }

    @DeleteMapping
    public Result<String> delete(Long id){
        log.info("删除分类，id为：{}", id);

        //categoryService.removeById(id);
        categoryService.remove(id);

        return Result.success("分类信息删除成功");
    }

    @PutMapping
    public Result<String> udpate(@RequestBody Category category){
        log.info(category.toString());
        categoryService.updateById(category);
        return Result.success("菜品分类信息修改成功");
    }

}
