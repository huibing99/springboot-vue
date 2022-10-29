package com.vrtrain.springboot.controller.dto;
import com.vrtrain.springboot.entity.Question;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
public class ExamDTO {
    private Integer id;
    private String name;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Integer timeLimit;
    private Boolean isPosted;
    private LocalDateTime createdTime;
    private List<Question> questionList;
}
