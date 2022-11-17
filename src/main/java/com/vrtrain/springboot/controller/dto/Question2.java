package com.vrtrain.springboot.controller.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.vrtrain.springboot.entity.Question;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Data
public class Question2 extends Question {
//      private Question question;
      private Integer opsCount;

      public void setQuestion2(Question question) {
            this.setQuestion(question.getQuestion());
            this.setId(question.getId());
            this.setType(question.getType());
            this.setAnswer(question.getAnswer());
            this.setScene(question.getScene());
            this.setOp1(question.getOp1());
            this.setOp2(question.getOp2());
            this.setOp3(question.getOp3());
            this.setOp4(question.getOp4());
            this.setOp5(question.getOp5());
            this.setOp6(question.getOp6());
      }

      public void setOpsCount(Integer opsCount) {
            this.opsCount = opsCount;
      }
}
