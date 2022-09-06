package com.vrtrain.springboot.service.impl;

import com.vrtrain.springboot.entity.Completion;
import com.vrtrain.springboot.mapper.CompletionMapper;
import com.vrtrain.springboot.service.ICompletionService;
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
public class CompletionServiceImpl extends ServiceImpl<CompletionMapper, Completion> implements ICompletionService {

}
