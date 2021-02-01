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
@ApiModel(value = "TZaiqingTpQueryVoS对象", description = "查询参数")

public class TZaiqingTpQueryVoS implements Serializable {


    @ApiModelProperty(value = "单位名称")
    @TableField("DWMC")
    private String dwmc;

    @ApiModelProperty(value = "泵车联系人")
    @TableField("S_PT_CONTACTS")
    private String sPtContacts;

    @ApiModelProperty(value = "泵车联系人电话")
    @TableField("S_PT_CONTACTPHONE")
    private String sPtContactphone;

    @ApiModelProperty(value = "车牌号")
    @TableField("S_PZ")
    private String sPz;

    private String sPtId;

    @ApiModelProperty(value = "泵车流量")
    @TableField("S_PT_FLOW")
    private BigDecimal sPtFlow;

    @ApiModelProperty(value = "车的状态")
    @TableField("PUMPSTATE")
    private  String PumpState;

    //private BigDecimal sPtFlow;


    @ApiModelProperty(value = "泵车当前位置X")
    @TableField("N_P_X")
    private BigDecimal nPX;

    @ApiModelProperty(value = "泵车当前位置Y")
    @TableField("N_P_Y")
    private BigDecimal nPY;

    @ApiModelProperty(value = "所属区县")
    @TableField("S_QX")
    private String sQx;


}
