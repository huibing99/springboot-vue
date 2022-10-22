package com.vrtrain.springboot.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.vrtrain.springboot.common.Constants;
import com.vrtrain.springboot.common.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.vrtrain.springboot.service.IAudioService;
import com.vrtrain.springboot.entity.Audio;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author huibing
 * @since 2022-10-20
 */
@RestController
@CrossOrigin(origins = "http://vr-exam.metastar-health.com")
@RequestMapping("/audio")
public class AudioController {

    @Resource
    private IAudioService audioService;

    // 新增或者更新
    @PostMapping
    public boolean save(@RequestBody Audio audio) {
        return audioService.saveOrUpdate(audio);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return audioService.removeById(id);
    }

    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids) {
        return audioService.removeByIds(ids);
    }

    @GetMapping
    public List<Audio> findAll() {
        return audioService.list();
    }

    @GetMapping("/{id}")
    public Audio findOne(@PathVariable Integer id) {
        return audioService.getById(id);
    }

    @GetMapping("/page")
    public Page<Audio> findPage(@RequestParam Integer pageNum,
                                    @RequestParam Integer pageSize,
                                    @RequestParam String scene) {
        QueryWrapper<Audio> queryWrapper = new QueryWrapper<>();
        if (!"".equals(scene)) {
            queryWrapper.eq("scene", scene);
        }
        queryWrapper.orderByDesc("id");
        return audioService.page(new Page<>(pageNum, pageSize), queryWrapper);
    }

    // 将 yml 中的自定义配置注入到这里
    @Value("${vrtrain.file.root.path}")
    private String filePath;
    @PostMapping("/upload")
    public Result fileUploads(@RequestParam MultipartFile file,
                              @RequestParam String scene) {
        // 获取上传的文件名称
        String fileName = scene + ".wav";
        // 得到文件保存的位置以及新文件名
        File dest = new File(filePath + fileName);
        if (!dest.exists()){
            dest.mkdirs();
        }
        try {
            // 上传的文件被保存了
            file.transferTo(dest);
            // 自定义返回的统一的 JSON 格式的数据，可以直接返回这个字符串也是可以的。
            return Result.success();
        } catch (IOException e) {
            return Result.error(Constants.CODE_400, "上传失败");
        }
    }
}

