package com.vrtrain.springboot.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.vrtrain.springboot.service.IAnswerService;
import com.vrtrain.springboot.entity.Answer;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author huibing
 * @since 2022-09-07
 */
@RestController
@RequestMapping("/answer")
public class AnswerController {

    @Resource
    private IAnswerService answerService;

    // 新增或者更新
    @PostMapping
    public boolean save(@RequestBody Answer answer) {
        return answerService.saveOrUpdate(answer);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return answerService.removeById(id);
    }

    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids) {
        return answerService.removeByIds(ids);
    }

    @GetMapping
    public List<Answer> findAll() {
        return answerService.list();
    }

    @GetMapping("/{id}")
    public Answer findOne(@PathVariable Integer id) {
        return answerService.getById(id);
    }

    @GetMapping("/page")
    public Page<Answer> findPage(@RequestParam Integer pageNum,
                                    @RequestParam Integer pageSize,
                                    @RequestParam String scene) {
        QueryWrapper<Answer> queryWrapper = new QueryWrapper<>();
        if (!"".equals(scene)) {
            queryWrapper.eq("scene", scene);
        }
        queryWrapper.orderByDesc("id");
        return answerService.page(new Page<>(pageNum, pageSize), queryWrapper);
    }

    @GetMapping("/user")
    public List<Answer> getUserAnswer(@RequestParam String username) {
        QueryWrapper<Answer> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        queryWrapper.orderByAsc("id");
        return answerService.list(queryWrapper);
    }
}

