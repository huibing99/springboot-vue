package com.vrtrain.springboot.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.log.Log;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vrtrain.springboot.common.Constants;
import com.vrtrain.springboot.controller.dto.TraineeDTO;
import com.vrtrain.springboot.entity.Trainee;
import com.vrtrain.springboot.exception.ServiceException;
import com.vrtrain.springboot.mapper.TraineeMapper;
import com.vrtrain.springboot.service.ITraineeService;
import com.vrtrain.springboot.utils.TokenUtils;
import org.springframework.stereotype.Service;

@Service
public class TraineeServiceImpl extends ServiceImpl<TraineeMapper, Trainee> implements ITraineeService {
    private static final Log LOG = Log.get();

    @Override
    public TraineeDTO login(TraineeDTO traineeDTO) {
        Trainee one = getTraineeInfo(traineeDTO);
        if (one != null) {
            BeanUtil.copyProperties(one, traineeDTO, true);
            String token = TokenUtils.genToken(one.getId().toString(), one.getPassword());
            traineeDTO.setToken(token);
            return traineeDTO;
        } else {
            throw new ServiceException(Constants.CODE_600, "用户名或密码错误");
        }
    }

    @Override
    public Trainee register(Trainee trainee) {
        QueryWrapper<Trainee> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", trainee.getUsername());
        Trainee one;
        try {
            one = getOne(queryWrapper); // 从数据库查询用户信息
        } catch (Exception e) {
            LOG.error(e);
            throw new ServiceException(Constants.CODE_500, "系统错误");
        }
        if (one == null) {
            one = new Trainee();
            BeanUtil.copyProperties(trainee, one, true);
            save(one);  // 把 copy完之后的用户对象存储到数据库
        } else {
            throw new ServiceException(Constants.CODE_600, "用户已存在");
        }
        return one;
    }

    private Trainee getTraineeInfo(TraineeDTO traineeDTO) {
        QueryWrapper<Trainee> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", traineeDTO.getUsername());
        queryWrapper.eq("password", traineeDTO.getPassword());
        Trainee one;
        try {
            one = getOne(queryWrapper); // 从数据库查询用户信息
        } catch (Exception e) {
            LOG.error(e);
            throw new ServiceException(Constants.CODE_500, "系统错误");
        }
        return one;
    }
}
