package com.vrtrain.springboot.controller.dto;

import com.vrtrain.springboot.entity.Question;
import lombok.Data;

import java.util.List;

@Data
public class UnityApi {
    String audio;
    String lawUrl;
    List<Question> exam;
}
