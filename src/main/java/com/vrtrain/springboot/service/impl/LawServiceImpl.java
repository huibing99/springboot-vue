package com.vrtrain.springboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vrtrain.springboot.entity.Law;
import com.vrtrain.springboot.mapper.LawMapper;
import com.vrtrain.springboot.service.ILawService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
    @Resource
    private ILawService lawService;
    @Override
    public List<Law> findAllByScene(String scene) {
        QueryWrapper<Law> queryWrapper = new QueryWrapper<>();
        if (!"".equals(scene)) {
            queryWrapper.eq("scene", scene);
        }
        return lawService.list(queryWrapper);
    }
}
