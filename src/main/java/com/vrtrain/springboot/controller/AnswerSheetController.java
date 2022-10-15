package com.vrtrain.springboot.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.vrtrain.springboot.entity.Answer;
import com.vrtrain.springboot.entity.Answer2;
import com.vrtrain.springboot.entity.AnswerSheet;
import com.vrtrain.springboot.service.IAnswerSheetService;
import com.vrtrain.springboot.service.IQuestionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author huibing
 * @since 2022-10-13
 */
@RestController
@RequestMapping("/answer-sheet")
public class AnswerSheetController {

    @Resource
    private IAnswerSheetService answerSheetService;


    // 新增或者更新
    @PostMapping
    public boolean save(@RequestBody AnswerSheet answerSheet) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        answerSheet.setScore(answerSheetService.calculateScore(answerSheet));
        return answerSheetService.saveOrUpdate(answerSheet);
    }

    @PostMapping("/save2")
    public boolean save2(@RequestBody Answer2 answer2) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String username = answer2.getUsername();
        List<Integer> questionOrder = answer2.getQuestionOrder();
        HashMap<Integer, String> question2Answer = answer2.getQuestion2Answer();
        HashMap<Integer, Integer> quesitonMp = new HashMap<>();
        for(int i = 0; i < questionOrder.size(); ++i){
            quesitonMp.put(questionOrder.get(i), i+1);
        }
        AnswerSheet answerSheet = new AnswerSheet();
        answerSheet.setUsername(username);
        for (Integer integer : questionOrder) {
            String setQuestionMethodName = "setQuestionId" + quesitonMp.get(integer);
            Method setQuestionMethod = answerSheet.getClass().getMethod(setQuestionMethodName, Integer.class);
            setQuestionMethod.invoke(answerSheet, integer);
            String setAnswerMethodName = "setAnswer" + quesitonMp.get(integer);
            Method setAnswerMethod = answerSheet.getClass().getMethod(setAnswerMethodName, String.class);
            setAnswerMethod.invoke(answerSheet, question2Answer.get(integer));
        }
        answerSheet.setScore(answerSheetService.calculateScore(answerSheet));
        return answerSheetService.saveOrUpdate(answerSheet);
    }
    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return answerSheetService.removeById(id);
    }

    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids) {
        return answerSheetService.removeByIds(ids);
    }

    @GetMapping
    public List<AnswerSheet> findAll() {
        return answerSheetService.list();
    }

    @GetMapping("/{id}")
    public AnswerSheet findOne(@PathVariable Integer id) {
        return answerSheetService.getById(id);
    }

    @GetMapping("/getByUser")
    public AnswerSheet findByUsername(@RequestParam String username) {
        QueryWrapper<AnswerSheet> queryWrapper = new QueryWrapper<>();
        if (!"".equals(username)) {
            queryWrapper.eq("username", username);
        }
        return answerSheetService.getOne(queryWrapper);
    }

    @GetMapping("/page")
    public Page<AnswerSheet> findPage(@RequestParam Integer pageNum,
                                      @RequestParam Integer pageSize,
                                      @RequestParam String username) {
        QueryWrapper<AnswerSheet> queryWrapper = new QueryWrapper<>();
        if (!"".equals(username)) {
            queryWrapper.eq("username", username);
        }
        queryWrapper.orderByDesc("id");
        return answerSheetService.page(new Page<>(pageNum, pageSize), queryWrapper);
    }
    @GetMapping("/score")
    public Integer getTotalScore(@RequestParam Integer id) {
        return findOne(id).getScore();
    }

    @GetMapping("/getScoreByUser")
    public Integer getTotalScore(@RequestParam String username) {
        return getTotalScore(findByUsername(username).getId());
    }
}

