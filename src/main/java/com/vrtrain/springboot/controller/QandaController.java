package com.vrtrain.springboot.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.vrtrain.springboot.service.IQandaService;
import com.vrtrain.springboot.entity.Qanda;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author huibing
 * @since 2022-09-06
 */
@RestController
@RequestMapping("/qanda")
public class QandaController {

    @Resource
    private IQandaService qandaService;

    // 新增或者更新
    @PostMapping
    public boolean save(@RequestBody Qanda qanda) {
        return qandaService.saveOrUpdate(qanda);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return qandaService.removeById(id);
    }

    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids) {
        return qandaService.removeByIds(ids);
    }

    @GetMapping
    public List<Qanda> findAll() {
        return qandaService.list();
    }

    @GetMapping("/{id}")
    public Qanda findOne(@PathVariable Integer id) {
        return qandaService.getById(id);
    }

    @GetMapping("/page")
    public Page<Qanda> findPage(@RequestParam Integer pageNum,
                                    @RequestParam Integer pageSize,
                                    @RequestParam String question,
                                    @RequestParam String scene) {
        QueryWrapper<Qanda> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("question", question);
        if (!"".equals(scene)) {
            queryWrapper.eq("scene", scene);
        }
        queryWrapper.orderByDesc("id");
        return qandaService.page(new Page<>(pageNum, pageSize), queryWrapper);
    }

}

