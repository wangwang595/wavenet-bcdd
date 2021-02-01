package com.wavenet.maintenance.web.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ProjectName: wavenet-maintenance1
 * @Package: com.wavenet.maintenance.web.vo
 * @ClassName: TZaiqingTpQueryVo
 * @Author: Tiny
 * @Description: ${description}
 * @Date: 2020/5/12 16:58
 * @Version: 1.0
 */
//返回给前端的数据vo
@Data
@Accessors(chain = true)
@ApiModel(value = "TPumptruckQueryVo对象", description = "查询参数")

public class TZaiqingTpQueryVo implements Serializable {


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



}
