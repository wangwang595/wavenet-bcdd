package com.wavenet.maintenance.web.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;


@Data
    @Accessors(chain = true)
    @ApiModel(value = "TPumptruckControlhisQueryVos对象", description = "查询参数")
    public class TPumptruckControlhisQueryVos implements Serializable {
        private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "泵车位置X")
    @TableField("N_P_X")
    private String nPX;

    @ApiModelProperty(value = "泵车位置Y")
    @TableField("N_P_Y")
    private String nPY;


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
