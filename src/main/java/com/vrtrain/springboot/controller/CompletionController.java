package com.vrtrain.springboot.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.vrtrain.springboot.entity.Choice;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.vrtrain.springboot.service.ICompletionService;
import com.vrtrain.springboot.entity.Completion;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author huibing
 * @since 2022-09-05
 */
@RestController
@RequestMapping("/completion")
public class CompletionController {

    @Resource
    private ICompletionService completionService;

    // 新增或者更新
    @PostMapping
    public boolean save(@RequestBody Completion completion) {
        return completionService.saveOrUpdate(completion);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return completionService.removeById(id);
    }

    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids) {
        return completionService.removeByIds(ids);
    }

    @GetMapping
    public List<Completion> findAll() {
        return completionService.list();
    }

    @GetMapping("/{id}")
    public Completion findOne(@PathVariable Integer id) {
        return completionService.getById(id);
    }

    @GetMapping("/page")
    public Page<Completion> findPage(@RequestParam Integer pageNum,
                                    @RequestParam Integer pageSize,
                                    @RequestParam String question,
                                    @RequestParam String scene) {
        QueryWrapper<Completion> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("question", question);
        if (!"".equals(scene)) {
            queryWrapper.eq("scene", scene);
        }
        queryWrapper.orderByDesc("id");
        return completionService.page(new Page<>(pageNum, pageSize), queryWrapper);
    }

}

