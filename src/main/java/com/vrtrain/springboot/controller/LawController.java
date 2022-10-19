package com.vrtrain.springboot.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.vrtrain.springboot.service.ILawService;
import com.vrtrain.springboot.entity.Law;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author huibing
 * @since 2022-10-19
 */
@RestController
@RequestMapping("/law")
public class LawController {

    @Resource
    private ILawService lawService;

    // 新增或者更新
    @PostMapping
    public boolean save(@RequestBody Law law) {
        return lawService.saveOrUpdate(law);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return lawService.removeById(id);
    }

    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids) {
        return lawService.removeByIds(ids);
    }

    @GetMapping
    public List<Law> findAll() {
        return lawService.list();
    }

    @GetMapping("/{id}")
    public Law findOne(@PathVariable Integer id) {
        return lawService.getById(id);
    }

    @GetMapping("/page")
    public Page<Law> findPage(@RequestParam Integer pageNum,
                                    @RequestParam Integer pageSize,
                                    @RequestParam String question,
                                    @RequestParam String scene) {
        QueryWrapper<Law> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("question", question);
        if (!"".equals(scene)) {
            queryWrapper.eq("scene", scene);
        }
        queryWrapper.orderByDesc("id");
        return lawService.page(new Page<>(pageNum, pageSize), queryWrapper);
    }

}

