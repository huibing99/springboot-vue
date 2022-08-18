package com.vrtrain.springboot.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.log.Log;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vrtrain.springboot.controller.dto.UserDTO;
import com.vrtrain.springboot.entity.User;
import com.vrtrain.springboot.mapper.UserMapper;
import com.vrtrain.springboot.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    private static final Log LOG = Log.get();
    @Override
    public UserDTO login(UserDTO userDTO) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", userDTO.getUsername());
        queryWrapper.eq("password", userDTO.getPassword());
        try{
            User one = getOne(queryWrapper);
            if (one != null){
                BeanUtil.copyProperties(one);
            }
        }
        catch (Exception e){
            LOG.error(e);
            return false;
        }
    }

}