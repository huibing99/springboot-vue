package com.vrtrain.springboot.service.impl;

import com.vrtrain.springboot.entity.Choice;
import com.vrtrain.springboot.mapper.ChoiceMapper;
import com.vrtrain.springboot.service.IChoiceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author huibing
 * @since 2022-09-05
 */
@Service
public class ChoiceServiceImpl extends ServiceImpl<ChoiceMapper, Choice> implements IChoiceService {

}
