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
 * @since 2022-10-19
 */
@Getter
@Setter
  @ApiModel(value = "Law对象", description = "")
public class Law implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("id")
        @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      @ApiModelProperty("场景")
      private String scene;

      @ApiModelProperty("义务条款")
      private String obligation;

      @ApiModelProperty("责任条款")
      private String liability;


}
