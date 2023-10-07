package com.vrtrain.springboot.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.vrtrain.springboot.common.Result;
import com.vrtrain.springboot.entity.Room;
import com.vrtrain.springboot.service.IRoomService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.vrtrain.springboot.service.IItemService;
import com.vrtrain.springboot.entity.Item;

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
@RequestMapping("/item")
public class ItemController {

    @Resource
    private IItemService itemService;
    @Resource
    private IRoomService roomService;

    // 新增或者更新
    @PostMapping
//    public boolean save(@RequestBody Item item) {
//        return itemService.saveOrUpdate(item);
//    }

//    @DeleteMapping("/{id}")
//    public Boolean delete(@PathVariable Integer id) {
//        return itemService.removeById(id);
//    }
//
//    @PostMapping("/del/batch")
//    public boolean deleteBatch(@RequestBody List<Integer> ids) {
//        return itemService.removeByIds(ids);
//    }

    @GetMapping
    public List<Item> findAll() {
        return itemService.list();
    }

//    @GetMapping("/{id}")
//    public Item findOne(@PathVariable Integer id) {
//        return itemService.getById(id);
//    }

//    @PostMapping
//    public boolean save(@RequestBody Item item) {
//        String filePath = constructFilePath(item);
//        byte[] fileBytes;
//        try {
//            fileBytes = Files.readAllBytes(Paths.get(filePath));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        String hash = calculateMD5(fileBytes);
//        item.setHash(hash);
//        return itemService.saveOrUpdate(item);
//    }
//    private String calculateMD5(byte[] fileBytes) {
//        try {
//            MessageDigest md = MessageDigest.getInstance("MD5");
//            md.update(fileBytes);
//            byte[] digest = md.digest();
//            StringBuilder sb = new StringBuilder();
//            for (byte b : digest) {
//                sb.append(String.format("%02x", b & 0xff));
//            }
//            return sb.toString().substring(0, 16); // 返回16位的哈希值
//        } catch (NoSuchAlgorithmException e) {
//            throw new RuntimeException(e);
//        }
//    }
//    private String constructFilePath(Item item) {
//        String baseDir = "/cache/data/";
//        String roomDir = item.getRoomId() + "/";
//        String fileName = item.getRoomIndex() + "_" + item.getHash() + "." + item.getFileExtension();
//        return baseDir + roomDir + fileName;
//    }

    @GetMapping("/item-list")
    public Result getItemList(@RequestParam("start_time") String startTimeStr){
        LocalDateTime startTime = LocalDateTime.parse(startTimeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        List<Room> rooms = roomService.list();
        List<Item> items = itemService.list();
        items = items.stream().filter(item -> item.getUpdateTime().isAfter(startTime)).collect(Collectors.toList());

        Map<String, Object> data = new HashMap<>();
        data.put("start_time", startTimeStr);
        data.put("end_time", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        data.put("rooms", rooms);
        data.put("items", items);

        return new Result("200", "Success", data);
    }
}

