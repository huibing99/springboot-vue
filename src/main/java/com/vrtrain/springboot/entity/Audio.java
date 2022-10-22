package com.vrtrain.springboot.entity;

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
 * @since 2022-10-20
 */
@Getter
@Setter
  @ApiModel(value = "Audio对象", description = "")
public class Audio implements Serializable {

    private static final long serialVersionUID = 1L;

      private Integer id;

    private String scene;

    private String address;


}
