package com.vrtrain.springboot.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.vrtrain.springboot.common.Result;
import com.vrtrain.springboot.controller.dto.Question2;
import com.vrtrain.springboot.controller.dto.UnityApi;
import com.vrtrain.springboot.entity.Law;
import com.vrtrain.springboot.service.IAnswerSheetService;
import com.vrtrain.springboot.service.ILawService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.*;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.vrtrain.springboot.service.IQuestionService;
import com.vrtrain.springboot.entity.Question;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author huibing
 * @since 2022-09-07
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/question")
public class QuestionController {

    @Resource
    private IQuestionService questionService;
    @Resource
    private ILawService lawService;

    // 新增或者更新

    @PostMapping
    public boolean save(@RequestBody Question question) {
        return questionService.saveOrUpdate(question);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return questionService.removeById(id);
    }

    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids) {
        return questionService.removeByIds(ids);
    }

    @GetMapping
    public List<Question> findAll() {
        return questionService.list();
    }

    @GetMapping("/getRandomByScene")
    public Question findByScene(@RequestParam String scene){
        QueryWrapper<Question> queryWrapper = new QueryWrapper<>();
        if (!"".equals(scene)) {
            queryWrapper.eq("scene", scene);
        }
        int sz = questionService.list(queryWrapper).size();
        Random r = new Random();
        return questionService.list(queryWrapper).get(r.nextInt(sz));
    }

    @GetMapping("/getAllByScene")
    public List<Question> findAllByScene(@RequestParam String scene){
        QueryWrapper<Question> queryWrapper = new QueryWrapper<>();
        if (!"".equals(scene)) {
            queryWrapper.eq("scene", scene);
        }
        return questionService.list(queryWrapper);
    }

    @GetMapping("/getRandomTestPaper")
    public List<Question> getRandomTestPaper(){
        QueryWrapper<Question> singleChoiceQuestions = new QueryWrapper<>();
        singleChoiceQuestions.eq("type", "单选");
        QueryWrapper<Question> multiChoiceQuestions = new QueryWrapper<>();
        multiChoiceQuestions.eq("type", "多选");
        QueryWrapper<Question> judgmentQuestions = new QueryWrapper<>();
        judgmentQuestions.eq("type", "判断");
        List<Question> singleChoiceList = questionService.list(singleChoiceQuestions);
        List<Question> multiChoiceList = questionService.list(multiChoiceQuestions);
        List<Question> judgementList = questionService.list(judgmentQuestions);
        Collections.shuffle(singleChoiceList);
        Collections.shuffle(multiChoiceList);
        Collections.shuffle(judgementList);
        List<Question> subSingleChoiceList = new ArrayList<>(), subMultiChoiceList = new ArrayList<>(),
                subJudgementList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            subSingleChoiceList.add(singleChoiceList.get(i));
        }
        for (int i = 0; i < 10; i++) {
            subMultiChoiceList.add(multiChoiceList.get(i));
        }
        for (int i = 0; i < 10; i++) {
            subJudgementList.add(judgementList.get(i));
        }
        List<Question> testPaper = new ArrayList<>();
        testPaper.addAll(subSingleChoiceList);
        testPaper.addAll(subMultiChoiceList);
        testPaper.addAll(subJudgementList);
        return testPaper;
    }
    @GetMapping("/{id}")
    public Question findOne(@PathVariable Integer id) {
        return questionService.getById(id);
    }

    @GetMapping("/page")
    public Page<Question> findPage(@RequestParam Integer pageNum,
                                    @RequestParam Integer pageSize,
                                    @RequestParam String question,
                                    @RequestParam String scene,
                                    @RequestParam String type) {
        QueryWrapper<Question> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("question", question);
        if (!"".equals(scene)) {
            queryWrapper.eq("scene", scene);
        }
        if (!"".equals(type)) {
            queryWrapper.eq("type", type);
        }
        queryWrapper.orderByDesc("id");
        return questionService.page(new Page<>(pageNum, pageSize), queryWrapper);
    }
    // unity交互
    @GetMapping("/getByScene")
    public UnityApi getByScene(@RequestParam String scene){
        UnityApi ret = new UnityApi();
        ret.setAudio("true");
        List<Law> law = lawService.findAllByScene(scene);
        ret.setLawUrl("false");
        if(law.size() > 0){
            ret.setLawUrl("http://vr-scene.metastar-health.com/law?scene=" + scene);
        }
        QueryWrapper<Question> queryWrapper = new QueryWrapper<>();
        if (!"".equals(scene)) {
            queryWrapper.eq("scene", scene);
        }

//        List<Question> questionList = questionService.list(queryWrapper);
//
//        for(int i = 0; i < questionList.size(); ++i){
//            if(questionList.get(i).getOp1() == null){
//                questionList.get(i).setOpsCount(0);
//            }else if(questionList.get(i).getOp2() == null){
//                questionList.get(i).setOpsCount(1);
//            }else if(questionList.get(i).getOp3() == null){
//                questionList.get(i).setOpsCount(2);
//            }else if(questionList.get(i).getOp4() == null){
//                questionList.get(i).setOpsCount(3);
//            }else if(questionList.get(i).getOp5() == null){
//                questionList.get(i).setOpsCount(4);
//            }else if(questionList.get(i).getOp6() == null){
//                questionList.get(i).setOpsCount(5);
//            }
//            else {
//                questionList.get(i).setOpsCount(6);
//            }
//        }
        ret.setExam(questionService.list(queryWrapper));
        return ret;
    }
}

