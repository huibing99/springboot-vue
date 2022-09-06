package com.vrtrain.springboot.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.vrtrain.springboot.service.IChoiceService;
import com.vrtrain.springboot.entity.Choice;

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
@RequestMapping("/choice")
public class ChoiceController {

    @Resource
    private IChoiceService choiceService;

    // 新增或者更新
    @PostMapping
    public boolean save(@RequestBody Choice choice) {
        return choiceService.saveOrUpdate(choice);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return choiceService.removeById(id);
    }

    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids) {
        return choiceService.removeByIds(ids);
    }

    @GetMapping
    public List<Choice> findAll() {
        return choiceService.list();
    }

    @GetMapping("/{id}")
    public Choice findOne(@PathVariable Integer id) {
        return choiceService.getById(id);
    }

    @GetMapping("/page")
    public Page<Choice> findPage(@RequestParam Integer pageNum,
                                    @RequestParam Integer pageSize,
                                    @RequestParam String question,
                                    @RequestParam String type,
                                    @RequestParam String scene) {
        QueryWrapper<Choice> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("question", question);
        if (!"".equals(type)) {
            queryWrapper.eq("type", type);
        }
        if (!"".equals(scene)) {
            queryWrapper.eq("scene", scene);
        }
        queryWrapper.orderByDesc("id");
        return choiceService.page(new Page<>(pageNum, pageSize), queryWrapper);
    }

}

