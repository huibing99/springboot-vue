package com.vrtrain.springboot.service.impl;

import com.vrtrain.springboot.entity.Audio;
import com.vrtrain.springboot.mapper.AudioMapper;
import com.vrtrain.springboot.service.IAudioService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author huibing
 * @since 2022-10-20
 */
@Service
public class AudioServiceImpl extends ServiceImpl<AudioMapper, Audio> implements IAudioService {

}
