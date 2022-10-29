package com.vrtrain.springboot.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.vrtrain.springboot.common.Constants;
import com.vrtrain.springboot.common.Result;
import com.vrtrain.springboot.controller.dto.AnswerDetailDTO;
import com.vrtrain.springboot.controller.dto.ExamDTO;
import com.vrtrain.springboot.entity.Question;
import com.vrtrain.springboot.service.IPostedExamService;
import com.vrtrain.springboot.service.IQuestionService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.vrtrain.springboot.service.IExamService;
import com.vrtrain.springboot.entity.Exam;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author huibing
 * @since 2022-10-27
 */
@RestController
@RequestMapping("/exam")
public class ExamController {

    @Resource
    private IExamService examService;
    @Resource
    private IQuestionService questionService;
    @Resource
    private IPostedExamService postedExamService;

    // 新增或者更新
    @PostMapping
    public boolean save(@RequestBody Exam exam) {
        return examService.saveOrUpdate(exam);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return examService.removeById(id);
    }

    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids) {
        return examService.removeByIds(ids);
    }

    @GetMapping
    public List<Exam> findAll() {
        return examService.list();
    }

    @GetMapping("/{id}")
    public Exam findOne(@PathVariable Integer id) {
        return examService.getById(id);
    }

    @GetMapping("/page")
    public Page<Exam> findPage(@RequestParam Integer pageNum,
                               @RequestParam Integer pageSize,
                               @RequestParam String examName) {
        QueryWrapper<Exam> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", examName);
        queryWrapper.orderByDesc("id");
        return examService.page(new Page<>(pageNum, pageSize), queryWrapper);
    }
    @GetMapping("/getQuestions")
    public Result getDetailExam(@RequestParam Integer id) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if(findOne(id) == null) {
            return Result.error(Constants.CODE_400, "用户成绩不存在");
        }
        List<Question> examQuestions = new ArrayList<>();
        Exam exam = findOne(id);
        for(int i = 1; i <= 40; ++i){
            String getQuestionMethodName = "getQuestionId" + i;
            Method getQuestionMethod = exam.getClass().getMethod(getQuestionMethodName);
            if (getQuestionMethod.invoke(exam) == null){
                continue;
            }
            int questionId = (int) getQuestionMethod.invoke(exam);
            Question question = questionService.getById(questionId);
            examQuestions.add(question);
        }
        return Result.success(examQuestions);
    }

    @GetMapping("/getCurrentExam")
    public Result getCurrentExam() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (postedExamService.getById(1) == null || postedExamService.getById(1).getPostedExamId() == null){
            return Result.error(Constants.CODE_500, "当前未发布考试！");
        }
        Integer examId = postedExamService.getById(1).getPostedExamId();
        Exam exam = examService.getById(examId);
        if (exam == null){
            return Result.error(Constants.CODE_500, "当前未发布考试！");
        }
        List<Question> questionList = new ArrayList<>();
        for(int i = 1; i <= 40; ++i){
            String getQuestionMethodName = "getQuestionId" + i;
            Method getQuestionMethod = exam.getClass().getMethod(getQuestionMethodName);
            if (getQuestionMethod.invoke(exam) == null){
                continue;
            }
            int questionId = (int) getQuestionMethod.invoke(exam);
            Question question = questionService.getById(questionId);
            questionList.add(question);
        }
        ExamDTO examDTO = new ExamDTO();
        examDTO.setId(exam.getId());
        examDTO.setName(exam.getName());
        examDTO.setStartTime(exam.getStartTime());
        examDTO.setEndTime(exam.getEndTime());
        examDTO.setTimeLimit(exam.getTimeLimit());
        examDTO.setIsPosted(exam.getIsPosted());
        examDTO.setCreatedTime(exam.getCreatedTime());
        examDTO.setQuestionList(questionList);
        return Result.success(examDTO);
    }
}

