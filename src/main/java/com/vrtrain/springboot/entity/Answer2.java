package com.vrtrain.springboot.entity;

import java.util.HashMap;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Answer2 {
    String username;
    List<Integer> questionOrder;
    HashMap<Integer, String> question2Answer;
}
