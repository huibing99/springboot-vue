package com.vrtrain.springboot.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.log.Log;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vrtrain.springboot.common.Constants;
import com.vrtrain.springboot.controller.dto.UserDTO;
import com.vrtrain.springboot.entity.User;
import com.vrtrain.springboot.exception.ServiceException;
import com.vrtrain.springboot.mapper.UserMapper;
import com.vrtrain.springboot.service.IUserService;
import com.vrtrain.springboot.utils.TokenUtils;
import org.apache.ibatis.ognl.Token;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    private static final Log LOG = Log.get();
    @Override
    public UserDTO login(UserDTO userDTO) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", userDTO.getUsername());
        queryWrapper.eq("password", userDTO.getPassword());
        User one;
        try{
            one = getOne(queryWrapper);
        }
        catch (Exception e){
            LOG.error(e);
            throw new ServiceException(Constants.CODE_500, "系统错误");
        }
        if (one != null){
            BeanUtil.copyProperties(one, userDTO, true);
            String token = TokenUtils.genToken(one.getId().toString(), one.getPassword());
            userDTO.setToken(token);
            return userDTO;
        } else {
            throw new ServiceException(Constants.CODE_600, "用户名或密码错误");
        }
    }

}