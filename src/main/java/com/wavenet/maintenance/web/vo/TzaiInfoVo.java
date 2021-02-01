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
@ApiModel(value = "TZaiqingInfoQueryVo对象", description = "险情信息表查询参数")

public class TzaiInfoVo implements Serializable {

    //车联系人 车联系电话 车 id 排水量


    @ApiModelProperty(value = "泵车联系人")
    @TableField("S_PT_CONTACTS")
    private String sPtContacts;

    @ApiModelProperty(value = "泵车联系人电话")
    @TableField("S_PT_CONTACTPHONE")
    private String sPtContactphone;

    @ApiModelProperty(value = "泵车编号")
    private String sPtId;

    @ApiModelProperty(value = "泵车流量")
    @TableField("S_PT_FLOW")
    private BigDecimal sPtFlow;

}
