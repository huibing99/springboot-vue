package com.vrtrain.springboot.service.impl;

import com.vrtrain.springboot.entity.Law;
import com.vrtrain.springboot.mapper.LawMapper;
import com.vrtrain.springboot.service.ILawService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author huibing
 * @since 2022-10-19
 */
@Service
public class LawServiceImpl extends ServiceImpl<LawMapper, Law> implements ILawService {

}
