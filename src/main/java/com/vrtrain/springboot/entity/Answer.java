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
 * @since 2022-09-07
 */
@Getter
@Setter
  @ApiModel(value = "Answer对象", description = "")
public class Answer implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("id")
        @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

    private Integer questionId;

      @ApiModelProperty("题目类型")
      private String type;

      @ApiModelProperty("场景")
      private String scene;

      @ApiModelProperty("用户名")
      private String username;

      @ApiModelProperty("答案")
      private String answer;

      @ApiModelProperty("答题时间")
      private LocalDateTime answerTime;


}
