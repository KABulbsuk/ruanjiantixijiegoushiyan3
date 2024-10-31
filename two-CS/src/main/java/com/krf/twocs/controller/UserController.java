package com.krf.twocs.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.krf.twocs.domain.po.User;
import com.krf.twocs.domain.po.dto.PageQuery;
import com.krf.twocs.mapper.UserMapper;
import com.krf.twocs.result.PageResult;
import com.krf.twocs.result.Result;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

// 使用RestController注解声明这是一个控制器类，并且返回的数据会自动作为HTTP响应体
@RestController
// 定义类处理请求的基本路径
@RequestMapping("/user")
// 使用@Slf4j注解自动注入一个日志对象
@Slf4j
// 使用@RequiredArgsConstructor注解自动生成构造函数，用于注入依赖
@RequiredArgsConstructor
// 允许跨域请求
@CrossOrigin("*")
public class UserController {
    // 注入UserMapper，用于数据库操作
    private final UserMapper userMapper;

    // 处理POST请求，添加新用户
    @PostMapping("/add")
    public Result add(@RequestBody User user){
        // 记录日志信息
        log.info("新增联系人：{}",user);

        // 将用户信息插入数据库
        userMapper.insert(user);

        // 返回操作成功的结果
        return Result.success();
    }

    // 处理GET请求，进行分页查询
    @GetMapping("/page")
    public Result<PageResult> pageQueryByName(PageQuery pageQuery){
        // 记录分页查询的日志信息
        log.info("分页条件查询：{}",pageQuery);

        // 创建分页对象
        Page<User> page = Page.of(pageQuery.getPageNum(), pageQuery.getPageSize());

        // 创建查询条件包装器
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        // 添加查询条件，根据姓名模糊查询
        wrapper.like(User::getName,pageQuery.getName());
        // 执行分页查询
        Page<User> p = userMapper.selectPage(page,wrapper);

        // 创建PageResult对象，用于封装分页查询结果
        PageResult pageResult = new PageResult();

        // 设置查询结果记录和总记录数
        pageResult.setRecords(p.getRecords());
        pageResult.setTotal(p.getTotal());

        // 返回分页查询结果
        return Result.success(pageResult);
    }

    // 处理GET请求，根据ID查询用户信息
    @GetMapping("/get/{id}")
    public Result<User> getById(@PathVariable Long id){
        // 记录根据ID查询的日志信息
        log.info("根据id查询：{}",id);

        // 根据ID查询用户信息
        User user = userMapper.selectById(id);

        // 返回查询结果
        return Result.success(user);
    }
    // 处理PUT请求，更新用户信息
    @PutMapping("/update")
    public Result update(@RequestBody User user){
        // 记录更新用户信息的日志信息
        log.info("修改联系人信息:{}",user);
        // 更新用户信息
        userMapper.updateById(user);

        // 返回操作成功的结果
        return Result.success();
    }

    // 处理DELETE请求，根据ID删除用户
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Long id){
        // 记录根据ID删除的日志信息
        log.info("根据id删除联系人：{}",id);
        // 创建User对象，设置ID
        User user = new User();
        user.setId(id);
        // 根据ID删除用户
        userMapper.deleteById(user);

        // 返回操作成功的结果
        return Result.success();
    }
}