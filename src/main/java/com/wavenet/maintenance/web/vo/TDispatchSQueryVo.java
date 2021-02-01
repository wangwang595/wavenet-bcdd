package com.wavenet.maintenance.web.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Data
@Accessors(chain = true)
@ApiModel(value = "TDispatchSQueryVo", description = "任务信息表查询参数")
public class TDispatchSQueryVo implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键")
    private String sId;

    @ApiModelProperty(value = "灾情编号")
    @TableField("S_ZAIQING_ID")
    private String sZaiqingId;

    @ApiModelProperty(value = "任务紧急程度")
    @TableField("N_EMERGENT")
    private BigDecimal nEmergent;

    @ApiModelProperty(value = "任务要求执行时间")
    @TableField("T_TIME")
    private Date tTime;

    @ApiModelProperty(value = "任务状态")
    @TableField("N_STATE")
    private BigDecimal nState;

    @ApiModelProperty(value = "任务描述")
    @TableField("S_DESCRIBE")
    private String sDescribe;

    @ApiModelProperty(value = "任务种类")
    @TableField("S_TYPE")
    private String sType;

    @ApiModelProperty(value = "任务目标地址")
    @TableField("S_ADDRESS")
    private String sAddress;

    @ApiModelProperty(value = "任务目标市")
    @TableField("S_CITY")
    private String sCity;

    @ApiModelProperty(value = "任务目标区")
    @TableField("S_AREA")
    private String sArea;

    @ApiModelProperty(value = "任务目标县")
    @TableField("S_VILLAGE")
    private String sVillage;

    @ApiModelProperty(value = "任务目标坐标X")
    @TableField("N_X")
    private BigDecimal nX;

    @ApiModelProperty(value = "任务目标坐标Y")
    @TableField("N_Y")
    private BigDecimal nY;

    @ApiModelProperty(value = "任务发布时间")
    @TableField("T_STIME")
    private Date tStime;

    @ApiModelProperty(value = "发布单位")
    @TableField("S_AREANAME")
    private String sAreaname;

    @ApiModelProperty(value = "发布人")
    @TableField("S_PERNAME")
    private String sPername;

    @ApiModelProperty(value = "现场联系人")
    @TableField("S_CONTACTS")
    private String sContacts;

    @ApiModelProperty(value = "现场联系电话")
    @TableField("S_CONTACTPHONE")
    private String sContactphone;

    @ApiModelProperty(value = "负责人")
    @TableField("S_CHARGE")
    private String sCharge;

    @ApiModelProperty(value = "负责人联系电话")
    @TableField("S_CHARGEPHONE")
    private String sChargephone;

    @ApiModelProperty(value = "任务时间开始")
    @TableField("T_START_TIME")
    private Date tStartTime;

    @ApiModelProperty(value = "任务时间结束")
    @TableField("T_END_TIME")
    private Date tEndTime;

    @ApiModelProperty(value = "任务时长")
    @TableField("N_SHICHANG")
    private BigDecimal nShichang;

    @ApiModelProperty(value = "泵车ID")
    @TableField("S_PT_ID")
    private String sPtId;

    @ApiModelProperty(value = "出动人数")
    @TableField("N_RENSHU")
    private BigDecimal nRenshu;

    @ApiModelProperty(value = "任务结果")
    @TableField("N_RESULT")
    private BigDecimal nResult;

    @ApiModelProperty(value = "完成人员")
    @TableField("S_REALIZER")
    private String sRealizer;

    @ApiModelProperty(value = "完成人联系电话")
    @TableField("S_REALIZERPHONE")
    private String sRealizerphone;

    @ApiModelProperty(value = "备注")
    @TableField("S_BZ")
    private String sBz;

    @ApiModelProperty(value = "是否填写报告")
    @TableField("N_ISREPORT")
    private BigDecimal nIsreport;

    @ApiModelProperty(value = "更新时间")
    @TableField("T_UPDATETIME")
    private Date tUpdatetime;

    @ApiModelProperty(value = "排水量")
    @TableField("N_PSL")
    private BigDecimal nPsl;

    @ApiModelProperty(value = "拒绝缘由")
    @TableField("S_REFUSE")
    private String sRefuse;

    @ApiModelProperty(value = "中止任务原因")
    @TableField("S_BREAK")
    private String sBreak;

    @ApiModelProperty(value = "任务名称")
    @TableField("S_NAME")
    private String sName;

    @ApiModelProperty(value = "任务百度位置X")
    @TableField("N_PB_X")
    private BigDecimal nPbX;

    @ApiModelProperty(value = "任务百度位置Y")
    @TableField("N_PB_Y")
    private BigDecimal nPbY;

    @ApiModelProperty(value = "灾情类别")
    @TableField("S_CD_VALUE")
    private String sCdValue;

}