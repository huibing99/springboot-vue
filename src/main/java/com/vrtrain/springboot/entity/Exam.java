package com.vrtrain.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;
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
 * @since 2022-10-27
 */
@Getter
@Setter
  @ApiModel(value = "Exam对象", description = "")
public class Exam implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("id")
      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      @ApiModelProperty("试卷名")
      private String name;

      @ApiModelProperty("考试开始时间")
      private LocalDateTime startTime;

      @ApiModelProperty("考试结束时间")
      private LocalDateTime endTime;

      @ApiModelProperty("考试时长限制(s)")
      private Integer timeLimit;

      @ApiModelProperty("是否已发布")
      private Boolean isPosted;

      @ApiModelProperty("创建时间")
      private LocalDateTime createdTime;

    private Integer questionId1;

    private Integer questionId2;

    private Integer questionId3;

    private Integer questionId4;

    private Integer questionId5;

    private Integer questionId6;

    private Integer questionId7;

    private Integer questionId8;

    private Integer questionId9;

    private Integer questionId10;

    private Integer questionId11;

    private Integer questionId12;

    private Integer questionId13;

    private Integer questionId14;

    private Integer questionId15;

    private Integer questionId16;

    private Integer questionId17;

    private Integer questionId18;

    private Integer questionId19;

    private Integer questionId20;

    private Integer questionId21;

    private Integer questionId22;

    private Integer questionId23;

    private Integer questionId24;

    private Integer questionId25;

    private Integer questionId26;

    private Integer questionId27;

    private Integer questionId28;

    private Integer questionId29;

    private Integer questionId30;

    private Integer questionId31;

    private Integer questionId32;

    private Integer questionId33;

    private Integer questionId34;

    private Integer questionId35;

    private Integer questionId36;

    private Integer questionId37;

    private Integer questionId38;

    private Integer questionId39;

    private Integer questionId40;


}
