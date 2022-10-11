package com.vrtrain.springboot.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.vrtrain.springboot.common.Constants;
import com.vrtrain.springboot.common.Result;
import com.vrtrain.springboot.controller.dto.TraineeDTO;
import com.vrtrain.springboot.entity.Trainee;
import com.vrtrain.springboot.service.ITraineeService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.List;

@CrossOrigin(origins = "http://vr-scene.metastar-health.com")
@RestController
@RequestMapping("/trainee")
public class TraineeController {
    @Resource
    private ITraineeService traineeService;

    @PostMapping("/login")
    public Result login(@RequestBody TraineeDTO traineeDTO) {
        String username = traineeDTO.getUsername();
        String password = traineeDTO.getPassword();
        if(StrUtil.isBlank(username) || StrUtil.isBlank(password)){
            return Result.error(Constants.CODE_400, "参数错误");
        }
        TraineeDTO dto = traineeService.login(traineeDTO);
        return Result.success(dto);
    }


    @PostMapping("/register")
    public Result register(@RequestBody Trainee trainee){
        System.out.println(trainee.getUsername());
        System.out.println(trainee.getPassword());
        System.out.println(trainee.getCompany());
        System.out.println(trainee.getPhonenumber());
        System.out.println("______________________________________");
        String username = trainee.getUsername();
        String password = trainee.getPassword();
        if(StrUtil.isBlank(username) || StrUtil.isBlank(password)){
            return Result.error(Constants.CODE_400, "参数错误");
        }
        return Result.success(traineeService.register(trainee));
    }
    // 新增或者更新
    @PostMapping
    public boolean save(@RequestBody Trainee trainee) {
        return traineeService.saveOrUpdate(trainee);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return traineeService.removeById(id);
    }

    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids) {
        return traineeService.removeByIds(ids);
    }

    @GetMapping
    public List<Trainee> findAll() {
        return traineeService.list();
    }

    @GetMapping("/{id}")
    public Trainee findOne(@PathVariable Integer id) {
        return traineeService.getById(id);
    }

    @GetMapping("/page")
    public Page<Trainee> findPage(@RequestParam Integer pageNum,
                               @RequestParam Integer pageSize,
                               @RequestParam String username) {
        QueryWrapper<Trainee> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("username", username);
        queryWrapper.orderByDesc("id");
        return traineeService.page(new Page<>(pageNum, pageSize), queryWrapper);
    }

    /**
     * 导出接口
     */
    @GetMapping("/export")
    public void export(HttpServletResponse response) throws Exception {
        // 从数据库查询出所有的数据
        List<Trainee> list = traineeService.list();
        // 通过工具类创建writer 写出到磁盘路径
//        ExcelWriter writer = ExcelUtil.getWriter(filesUploadPath + "/用户信息.xlsx");
        // 在内存操作，写出到浏览器
        ExcelWriter writer = ExcelUtil.getWriter(true);
        // 一次性写出list内的对象到excel，使用默认样式，强制输出标题
        writer.write(list, true);

        // 设置浏览器响应的格式
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        String fileName = URLEncoder.encode("用户信息", "UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");

        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        out.close();
        writer.close();
    }

    /**
     * excel 导入
     * @param file
     * @throws Exception
     */
    @PostMapping("/import")
    public Boolean imp(MultipartFile file) throws Exception {
        InputStream inputStream = file.getInputStream();
        ExcelReader reader = ExcelUtil.getReader(inputStream);
        List<Trainee> trainees = reader.readAll(Trainee.class);

        traineeService.saveBatch(trainees);
        return true;
    }
}
