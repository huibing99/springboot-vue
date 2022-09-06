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
 * @since 2022-09-06
 */
@Getter
@Setter
  @ApiModel(value = "Qanda对象", description = "")
public class Qanda implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("id")
        @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      @ApiModelProperty("所在场景")
      private String scene;

    private String type = "QAndA";

      @ApiModelProperty("问题")
      private String question;

    private String answer;


}
