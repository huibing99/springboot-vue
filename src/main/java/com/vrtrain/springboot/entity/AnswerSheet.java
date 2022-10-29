package com.vrtrain.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
 * @since 2022-10-29
 */
@Getter
@Setter
  @TableName("answer_sheet")
@ApiModel(value = "AnswerSheet对象", description = "")
public class AnswerSheet implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("id")
        @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      @ApiModelProperty("试卷id")
      private Integer examId;

      @ApiModelProperty("用户名")
        private String username;

      @ApiModelProperty("题目1")
      private Integer questionId1;

      @ApiModelProperty("题目1用户答案")
      private String answer1;

      @ApiModelProperty("题目2")
      private Integer questionId2;

      @ApiModelProperty("题目2用户答案")
      private String answer2;

      @ApiModelProperty("题目3")
      private Integer questionId3;

      @ApiModelProperty("题目3用户答案")
      private String answer3;

      @ApiModelProperty("题目4")
      private Integer questionId4;

      @ApiModelProperty("题目4用户答案")
      private String answer4;

      @ApiModelProperty("题目5")
      private Integer questionId5;

      @ApiModelProperty("题目5用户答案")
      private String answer5;

      @ApiModelProperty("题目6")
      private Integer questionId6;

      @ApiModelProperty("题目6用户答案")
      private String answer6;

      @ApiModelProperty("题目7")
      private Integer questionId7;

      @ApiModelProperty("题目7用户答案")
      private String answer7;

      @ApiModelProperty("题目8")
      private Integer questionId8;

      @ApiModelProperty("题目8用户答案")
      private String answer8;

      @ApiModelProperty("题目9")
      private Integer questionId9;

      @ApiModelProperty("题目9用户答案")
      private String answer9;

      @ApiModelProperty("题目10")
      private Integer questionId10;

      @ApiModelProperty("题目10用户答案")
      private String answer10;

      @ApiModelProperty("题目11")
      private Integer questionId11;

      @ApiModelProperty("题目11用户答案")
      private String answer11;

      @ApiModelProperty("题目12")
      private Integer questionId12;

      @ApiModelProperty("题目12用户答案")
      private String answer12;

      @ApiModelProperty("题目13")
      private Integer questionId13;

      @ApiModelProperty("题目13用户答案")
      private String answer13;

      @ApiModelProperty("题目14")
      private Integer questionId14;

      @ApiModelProperty("题目14用户答案")
      private String answer14;

      @ApiModelProperty("题目15")
      private Integer questionId15;

      @ApiModelProperty("题目15用户答案")
      private String answer15;

      @ApiModelProperty("题目16")
      private Integer questionId16;

      @ApiModelProperty("题目16用户答案")
      private String answer16;

      @ApiModelProperty("题目17")
      private Integer questionId17;

      @ApiModelProperty("题目17用户答案")
      private String answer17;

      @ApiModelProperty("题目18")
      private Integer questionId18;

      @ApiModelProperty("题目18用户答案")
      private String answer18;

      @ApiModelProperty("题目19")
      private Integer questionId19;

      @ApiModelProperty("题目19用户答案")
      private String answer19;

      @ApiModelProperty("题目20")
      private Integer questionId20;

      @ApiModelProperty("题目20用户答案")
      private String answer20;

      @ApiModelProperty("题目21")
      private Integer questionId21;

      @ApiModelProperty("题目21用户答案")
      private String answer21;

      @ApiModelProperty("题目22")
      private Integer questionId22;

      @ApiModelProperty("题目22用户答案")
      private String answer22;

      @ApiModelProperty("题目23")
      private Integer questionId23;

      @ApiModelProperty("题目23用户答案")
      private String answer23;

      @ApiModelProperty("题目24")
      private Integer questionId24;

      @ApiModelProperty("题目24用户答案")
      private String answer24;

      @ApiModelProperty("题目25")
      private Integer questionId25;

      @ApiModelProperty("题目25用户答案")
      private String answer25;

      @ApiModelProperty("题目26")
      private Integer questionId26;

      @ApiModelProperty("题目26用户答案")
      private String answer26;

      @ApiModelProperty("题目27")
      private Integer questionId27;

      @ApiModelProperty("题目27用户答案")
      private String answer27;

      @ApiModelProperty("题目28")
      private Integer questionId28;

      @ApiModelProperty("题目28用户答案")
      private String answer28;

      @ApiModelProperty("题目29")
      private Integer questionId29;

      @ApiModelProperty("题目29用户答案")
      private String answer29;

      @ApiModelProperty("题目30")
      private Integer questionId30;

      @ApiModelProperty("题目30用户答案")
      private String answer30;

      @ApiModelProperty("题目31")
      private Integer questionId31;

      @ApiModelProperty("题目31用户答案")
      private String answer31;

      @ApiModelProperty("题目32")
      private Integer questionId32;

      @ApiModelProperty("题目32用户答案")
      private String answer32;

      @ApiModelProperty("题目33")
      private Integer questionId33;

      @ApiModelProperty("题目33用户答案")
      private String answer33;

      @ApiModelProperty("题目34")
      private Integer questionId34;

      @ApiModelProperty("题目34用户答案")
      private String answer34;

      @ApiModelProperty("题目35")
      private Integer questionId35;

      @ApiModelProperty("题目35用户答案")
      private String answer35;

      @ApiModelProperty("题目36")
      private Integer questionId36;

      @ApiModelProperty("题目36用户答案")
      private String answer36;

      @ApiModelProperty("题目37")
      private Integer questionId37;

      @ApiModelProperty("题目37用户答案")
      private String answer37;

      @ApiModelProperty("题目38")
      private Integer questionId38;

      @ApiModelProperty("题目38用户答案")
      private String answer38;

      @ApiModelProperty("题目39")
      private Integer questionId39;

      @ApiModelProperty("题目39用户答案")
      private String answer39;

      @ApiModelProperty("题目40")
      private Integer questionId40;

      @ApiModelProperty("题目40用户答案")
      private String answer40;

      @ApiModelProperty("答题时间")
      private LocalDateTime answertime;

      @ApiModelProperty("得分")
      private Integer score;


}
