package com.vrtrain.springboot.service.impl;

import com.vrtrain.springboot.entity.Answer;
import com.vrtrain.springboot.mapper.AnswerMapper;
import com.vrtrain.springboot.service.IAnswerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author huibing
 * @since 2022-09-07
 */
@Service
public class AnswerServiceImpl extends ServiceImpl<AnswerMapper, Answer> implements IAnswerService {

}
