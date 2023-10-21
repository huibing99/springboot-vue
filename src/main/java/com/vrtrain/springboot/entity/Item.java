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
 * @since 2023-10-04
 */
@Getter
@Setter
  @ApiModel(value = "Item对象", description = "")
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      @ApiModelProperty("room表外键")
      private Integer roomId;

      @ApiModelProperty("展品在房间里的位置索引")
      private Integer roomIndex;

      @ApiModelProperty("展品名")
      private String name;

      @ApiModelProperty("展品类型（0-图片，1-视频，2-PDF）")
      private Integer type;

      @ApiModelProperty("HASH值（通过MD5 16位计算）")
      private String hash;

      @ApiModelProperty("展品状态（0-active, 1-delete）")
      private Integer status;

      @ApiModelProperty("文件大小（KB）")
      private Integer size;

      @ApiModelProperty("创建时间戳")
      private LocalDateTime createTime;

      @ApiModelProperty("更新时间戳")
      private LocalDateTime updateTime;

//  public String getFileExtension() {
//    switch (this.type) {
//      case 0:
//        return "jpg";
//      case 1:
//        return "MP4";
//      case 2:
//        return "pdf";
//      default:
//        return "";
//    }
//  }
}
