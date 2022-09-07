package com.vrtrain.springboot.service.impl;

import com.vrtrain.springboot.entity.Question;
import com.vrtrain.springboot.mapper.QuestionMapper;
import com.vrtrain.springboot.service.IQuestionService;
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
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements IQuestionService {

}
