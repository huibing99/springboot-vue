package com.vrtrain.springboot.service.impl;

import com.vrtrain.springboot.controller.dto.AnswerDetailDTO;
import com.vrtrain.springboot.entity.AnswerSheet;
import com.vrtrain.springboot.entity.Question;
import com.vrtrain.springboot.mapper.AnswerSheetMapper;
import com.vrtrain.springboot.service.IAnswerSheetService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vrtrain.springboot.service.IQuestionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author huibing
 * @since 2022-10-14
 */


@Service
public class AnswerSheetServiceImpl extends ServiceImpl<AnswerSheetMapper, AnswerSheet> implements IAnswerSheetService {
    @Resource
    private IQuestionService questionService;
    public int calculateScore(AnswerSheet answerSheet) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        int retScore = 0;
        for(int i = 1; i <= 40; ++i){
            String getQuestionMethodName = "getQuestionId" + i;
            Method getQuestionMethod = answerSheet.getClass().getMethod(getQuestionMethodName);
            if (getQuestionMethod.invoke(answerSheet) == null){
                continue;
            }
            int questionId = (int) getQuestionMethod.invoke(answerSheet);
            String standardAnswer = questionService.getById(questionId).getAnswer();

            String getAnswerMethodName = "getAnswer" + i;
            Method getAnswerMethod = answerSheet.getClass().getMethod(getAnswerMethodName);
            if (getAnswerMethod.invoke(answerSheet) == null){
                continue;
            }
            String userAnswer = getAnswerMethod.invoke(answerSheet).toString();
            if(Objects.equals(standardAnswer, userAnswer)){
                if(i >= 21 && i <= 30){
                    retScore += 4;
                }
                else {
                    retScore += 2;
                }
            }
        }
        return retScore;
    }
}
