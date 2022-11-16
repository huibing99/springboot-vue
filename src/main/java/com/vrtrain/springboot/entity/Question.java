package com.vrtrain.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author huibing
 * @since 2022-09-07
 */
@Getter
@Setter
  @ApiModel(value = "Question对象", description = "")
public class Question implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("id")
      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      @ApiModelProperty("类型")
      private String type;

      @ApiModelProperty("所在场景")
      private String scene;

      @ApiModelProperty("问题")
      private String question;

      @ApiModelProperty("答案")
      private String answer;

      @ApiModelProperty("选项1")
      private String op1;

      @ApiModelProperty("选项2")
      private String op2;

      @ApiModelProperty("选项3")
      private String op3;

      @ApiModelProperty("选项4")
      private String op4;

      @ApiModelProperty("选项5")
      private String op5;

      @ApiModelProperty("选项6")
      private String op6;

      private int opsCount;

}
