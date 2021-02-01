package com.wavenet.maintenance.web.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@ApiModel(value = "TPumptruckControlhisQueryVoArr对象", description = "查询参数")
public class TPumptruckControlhisQueryVoArr implements Serializable {
    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "泵车位置X")
    @TableField("DATA")
    private Object[]  data;




    @ApiModelProperty(value = "任务编号")
    @TableField("S_TAST_ID")
    private String sTastId;


    //开始时间
    private String starttime;


    //结束时间
    private  String endtime;
    //灾情名称
    private String sName;







}