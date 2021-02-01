package com.wavenet.maintenance.web.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <pre>
 *  查询结果对象
 * </pre>
 *
 * @author zll
 * @date 2020-05-26
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "TPumptruckControlhisQueryVo对象", description = "查询参数")
public class TPumptruckControlhisQueryVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableField("S_ID")
private String sId;

    @ApiModelProperty(value = "泵车ID")
    private String sPtId;

    @ApiModelProperty(value = "泵车位置X")
        @TableField("N_P_X")
private BigDecimal nPX;

    @ApiModelProperty(value = "泵车位置Y")
        @TableField("N_P_Y")
private BigDecimal nPY;

    @ApiModelProperty(value = "人位置X")
        @TableField("N_S_X")
private BigDecimal nSX;

    @ApiModelProperty(value = "人位置Y")
        @TableField("N_S_Y")
private BigDecimal nSY;

    @ApiModelProperty(value = "人车是否一致")
        @TableField("S_PS")
private String sPs;

    @ApiModelProperty(value = "泵车GPS状态")
        @TableField("N_GPS")
private BigDecimal nGps;

    @ApiModelProperty(value = "任务编号")
        @TableField("S_TAST_ID")
private String sTastId;

    @ApiModelProperty(value = "泵车百度位置X")
        @TableField("N_PB_X")
private BigDecimal nPbX;

    @ApiModelProperty(value = "泵车百度位置Y")
        @TableField("N_PB_Y")
private BigDecimal nPbY;

    @ApiModelProperty(value = "人百度位置X")
        @TableField("N_SB_X")
private BigDecimal nSbX;

    @ApiModelProperty(value = "人百度位置Y")
        @TableField("N_SB_Y")
private BigDecimal nSbY;

    @ApiModelProperty(value = "更新时间")
        @TableField("T_UPDATETIME")
private Date tUpdatetime;

}