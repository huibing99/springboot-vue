package com.vrtrain.springboot.service.impl;

import com.vrtrain.springboot.entity.Item;
import com.vrtrain.springboot.mapper.ItemMapper;
import com.vrtrain.springboot.service.IItemService;
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
public class ItemServiceImpl extends ServiceImpl<ItemMapper, Item> implements IItemService {

}
