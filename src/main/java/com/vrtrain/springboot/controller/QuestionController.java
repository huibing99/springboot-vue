package com.vrtrain.springboot.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.vrtrain.springboot.service.IQuestionService;
import com.vrtrain.springboot.entity.Question;

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
@RequestMapping("/question")
public class QuestionController {

    @Resource
    private IQuestionService questionService;

    // 新增或者更新

    @PostMapping
    public boolean save(@RequestBody Question question) {
        return questionService.saveOrUpdate(question);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return questionService.removeById(id);
    }

    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids) {
        return questionService.removeByIds(ids);
    }

    @GetMapping
    public List<Question> findAll() {
        return questionService.list();
    }

    @GetMapping("/getByScene")
    public List<Question> findByScene(@RequestParam String scene){
        QueryWrapper<Question> queryWrapper = new QueryWrapper<>();
        if (!"".equals(scene)) {
            queryWrapper.eq("scene", scene);
        }
        return questionService.list(queryWrapper);
    }

    @GetMapping("/{id}")
    public Question findOne(@PathVariable Integer id) {
        return questionService.getById(id);
    }

    @GetMapping("/page")
    public Page<Question> findPage(@RequestParam Integer pageNum,
                                    @RequestParam Integer pageSize,
                                    @RequestParam String question,
                                    @RequestParam String scene,
                                    @RequestParam String type) {
        QueryWrapper<Question> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("question", question);
        if (!"".equals(scene)) {
            queryWrapper.eq("scene", scene);
        }
        if (!"".equals(type)) {
            queryWrapper.eq("type", type);
        }
        queryWrapper.orderByDesc("id");
        return questionService.page(new Page<>(pageNum, pageSize), queryWrapper);
    }

}

