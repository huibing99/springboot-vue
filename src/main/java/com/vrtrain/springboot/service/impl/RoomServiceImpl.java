package com.vrtrain.springboot.service.impl;

import com.vrtrain.springboot.entity.Room;
import com.vrtrain.springboot.mapper.RoomMapper;
import com.vrtrain.springboot.service.IRoomService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author huibing
 * @since 2023-10-04
 */
@Service
public class RoomServiceImpl extends ServiceImpl<RoomMapper, Room> implements IRoomService {

}
