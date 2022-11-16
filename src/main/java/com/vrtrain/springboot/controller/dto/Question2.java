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
public class Question2 {
      private Question question;
      private Integer opsCount;

      public void setQuestion2(Question question) {
            this.question = question;
            this.question.setId(question.getId());
            this.question.setType(question.getType());
            this.question.setAnswer(question.getAnswer());
            this.question.setScene(question.getScene());
            this.question.setOp1(question.getOp1());
            this.question.setOp2(question.getOp2());
            this.question.setOp3(question.getOp3());
            this.question.setOp4(question.getOp4());
            this.question.setOp5(question.getOp5());
            this.question.setOp6(question.getOp6());
      }

      public void setOpsCount(Integer opsCount) {
            this.opsCount = opsCount;
      }
}
