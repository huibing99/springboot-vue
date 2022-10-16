package com.vrtrain.springboot.controller.dto;

import com.vrtrain.springboot.entity.Question;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerDetailDTO {
    Question question;
    String answer;
}
