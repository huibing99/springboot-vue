package com.vrtrain.springboot.service;

import com.vrtrain.springboot.controller.dto.UserDTO;
import com.vrtrain.springboot.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author huibing
 * @since 2022-08-18
 */
public interface IUserService extends IService<User> {
    UserDTO login(UserDTO userDTO);
}
