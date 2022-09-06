package com.vrtrain.springboot.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.vrtrain.springboot.entity.Qanda;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.vrtrain.springboot.service.ITrueorfalseService;
import com.vrtrain.springboot.entity.Trueorfalse;

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
@RequestMapping("/trueorfalse")
public class TrueorfalseController {

    @Resource
    private ITrueorfalseService trueorfalseService;

    // 新增或者更新
    @PostMapping
    public boolean save(@RequestBody Trueorfalse trueorfalse) {
        return trueorfalseService.saveOrUpdate(trueorfalse);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return trueorfalseService.removeById(id);
    }

    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids) {
        return trueorfalseService.removeByIds(ids);
    }

    @GetMapping
    public List<Trueorfalse> findAll() {
        return trueorfalseService.list();
    }

    @GetMapping("/{id}")
    public Trueorfalse findOne(@PathVariable Integer id) {
        return trueorfalseService.getById(id);
    }

    @GetMapping("/page")
    public Page<Trueorfalse> findPage(@RequestParam Integer pageNum,
                                    @RequestParam Integer pageSize,
                                    @RequestParam String question,
                                    @RequestParam String scene) {
        QueryWrapper<Trueorfalse> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("question", question);
        if (!"".equals(scene)) {
            queryWrapper.eq("scene", scene);
        }
        queryWrapper.orderByDesc("id");
        return trueorfalseService.page(new Page<>(pageNum, pageSize), queryWrapper);
    }

}

