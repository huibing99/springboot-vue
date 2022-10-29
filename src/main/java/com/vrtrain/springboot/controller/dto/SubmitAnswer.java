package com.vrtrain.springboot.controller.dto;

import java.util.HashMap;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class SubmitAnswer {
    String username;
    List<Integer> questionOrder;
    HashMap<Integer, String> question2Answer;
}
