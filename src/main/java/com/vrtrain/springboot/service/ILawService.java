package com.vrtrain.springboot.service;

import com.vrtrain.springboot.entity.Law;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author huibing
 * @since 2022-10-19
 */
public interface ILawService extends IService<Law> {
    List<Law> findAllByScene(String scene);
}
