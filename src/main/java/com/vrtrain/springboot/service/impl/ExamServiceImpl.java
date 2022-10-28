package com.vrtrain.springboot.service.impl;

import com.vrtrain.springboot.entity.Exam;
import com.vrtrain.springboot.mapper.ExamMapper;
import com.vrtrain.springboot.service.IExamService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author huibing
 * @since 2022-10-27
 */
@Service
public class ExamServiceImpl extends ServiceImpl<ExamMapper, Exam> implements IExamService {

}
