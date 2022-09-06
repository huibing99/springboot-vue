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
 * @since 2022-09-05
 */
@Getter
@Setter
@ApiModel(value = "Trueorfalse对象", description = "")
public class Trueorfalse implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("id")
        @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      private String type = "TrueOrFalse";

      @ApiModelProperty("所在场景")
      private String scene;

      @ApiModelProperty("问题")
      private String question;

      @ApiModelProperty("答案")
      private String answer;


}
