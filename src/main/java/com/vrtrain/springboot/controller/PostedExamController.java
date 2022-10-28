package com.vrtrain.springboot.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.vrtrain.springboot.service.IPostedExamService;
import com.vrtrain.springboot.entity.PostedExam;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author huibing
 * @since 2022-10-28
 */
@RestController
@RequestMapping("/posted-exam")
public class PostedExamController {

    @Resource
    private IPostedExamService postedExamService;

    // 新增或者更新
    @PostMapping
    public boolean save(@RequestBody PostedExam postedExam) {
        return postedExamService.saveOrUpdate(postedExam);
    }

    @GetMapping("/{id}")
    public PostedExam findOne(@PathVariable Integer id) {
        return postedExamService.getById(id);
    }

}

