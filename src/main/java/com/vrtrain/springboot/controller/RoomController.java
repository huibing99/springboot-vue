package com.vrtrain.springboot.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.vrtrain.springboot.service.IRoomService;
import com.vrtrain.springboot.entity.Room;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author huibing
 * @since 2023-10-04
 */
@RestController
@RequestMapping("/room")
public class RoomController {

    @Resource
    private IRoomService roomService;

    // 新增或者更新
    @PostMapping
    public boolean save(@RequestBody Room room) {
        return roomService.saveOrUpdate(room);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return roomService.removeById(id);
    }

    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids) {
        return roomService.removeByIds(ids);
    }

    @GetMapping
    public List<Room> findAll() {
        return roomService.list();
    }

    @GetMapping("/{id}")
    public Room findOne(@PathVariable Integer id) {
        return roomService.getById(id);
    }

}

