package com.vrtrain.springboot.service;

import com.vrtrain.springboot.controller.dto.AnswerDetailDTO;
import com.vrtrain.springboot.entity.AnswerSheet;
import com.baomidou.mybatisplus.extension.service.IService;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author huibing
 * @since 2022-10-14
 */
public interface IAnswerSheetService extends IService<AnswerSheet> {
    public int calculateScore(AnswerSheet answerSheet) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException;
}
