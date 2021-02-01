package com.wavenet.maintenance.dao.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.wavenetframework.boot.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * <pre>
 * 泵车状态表
 * </pre>
 *
 * @author zll
 * @since 2020-05-10
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@TableName("T_PUMPTRUCK_CONTROL")
@ApiModel(value = "TPumptruckControl对象", description = "泵车状态表")
public class TPumptruckControl extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "S_ID", type = IdType.UUID)
    private String sId;

    @ApiModelProperty(value = "泵车ID")
        @TableField("S_PT_ID")
private String sPtId;

    @ApiModelProperty(value = "警报号")
        @TableField("N_ALARM_ID")
private BigDecimal nAlarmId;

    @ApiModelProperty(value = "发布单位")
        @TableField("S_AREANAME")
private String sAreaname;

    @ApiModelProperty(value = "人员名称")
        @TableField("S_PERNAME")
private String sPername;

    @ApiModelProperty(value = "待命状态")
        @TableField("N_DM_STATE")
private BigDecimal nDmState;

    @ApiModelProperty(value = "任务状态")
        @TableField("N_RW_STATE")
private BigDecimal nRwState;

    @ApiModelProperty(value = "泵车当前位置X")
        @TableField("N_P_X")
private BigDecimal nPX;

    @ApiModelProperty(value = "泵车当前位置Y")
        @TableField("N_P_Y")
private BigDecimal nPY;

    @ApiModelProperty(value = "人当前位置X")
        @TableField("N_S_X")
private BigDecimal nSX;

    @ApiModelProperty(value = "人当前位置Y")
        @TableField("N_S_Y")
private BigDecimal nSY;

    @ApiModelProperty(value = "人车是否一致")
        @TableField("S_PS")
private String sPs;

    @ApiModelProperty(value = "泵车GPS状态")
        @TableField("N_GPS")
private BigDecimal nGps;

    @ApiModelProperty(value = "当前任务编号")
        @TableField("S_TAST_ID")
private String sTastId;

    @ApiModelProperty(value = "泵车百度当前位置X")
        @TableField("N_PB_X")
private BigDecimal nPbX;

    @ApiModelProperty(value = "泵车百度当前位置Y")
        @TableField("N_PB_Y")
private BigDecimal nPbY;

    @ApiModelProperty(value = "人百度当前位置X")
        @TableField("N_SB_X")
private BigDecimal nSbX;

    @ApiModelProperty(value = "人百度当前位置Y")
        @TableField("N_SB_Y")
private BigDecimal nSbY;

    @ApiModelProperty(value = "车牌号")
        @TableField("S_PZ")
private String sPz;

    @ApiModelProperty(value = "更新时间")
        @TableField("T_UPDATETIME")
private Date tUpdatetime;

}
