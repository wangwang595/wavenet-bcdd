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
 * 
 * </pre>
 *
 * @author zll
 * @since 2020-05-10
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@TableName("T_PUMPTRUCK")
@ApiModel(value = "TPumptruck对象", description = "")
public class TPumptruck extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "泵车编号")
    @TableId(value = "S_PT_ID", type = IdType.UUID)
    private String sPtId;

    @ApiModelProperty(value = "突击队主键")
        @TableField("S_SYSCOMMANDOID")
private String sSyscommandoid;

    @ApiModelProperty(value = "泵车名称")
        @TableField("S_PT_NAME")
private String sPtName;

    @ApiModelProperty(value = "所属区县")
        @TableField("S_QX")
private String sQx;

    @ApiModelProperty(value = "车牌号")
        @TableField("S_PZ")
private String sPz;

    @ApiModelProperty(value = "泵车流量")
        @TableField("S_PT_FLOW")
private BigDecimal sPtFlow;

    @ApiModelProperty(value = "泵车扬程")
        @TableField("S_PT_LIFT")
private BigDecimal sPtLift;

    @ApiModelProperty(value = "抢险单位主键")
        @TableField("S_MANAGEUNITID")
private String sManageunitid;

    @ApiModelProperty(value = "停放地址")
        @TableField("S_ADD")
private String sAdd;

    @ApiModelProperty(value = "泵车联系人")
        @TableField("S_PT_CONTACTS")
private String sPtContacts;

    @ApiModelProperty(value = "泵车联系人电话")
        @TableField("S_PT_CONTACTPHONE")
private String sPtContactphone;

    @ApiModelProperty(value = "保障范围")
        @TableField("S_PT_AREA")
private String sPtArea;

    @ApiModelProperty(value = "泵车分类")
        @TableField("N_PT_CLASS")
private String nPtClass;

    @ApiModelProperty(value = "泵车型号")
        @TableField("S_PT_MODEL")
private String sPtModel;

    @ApiModelProperty(value = "泵车类型")
        @TableField("S_PT_TYPE")
private String sPtType;

    @ApiModelProperty(value = "泵车服役时间")
        @TableField("T_PT_SERVICETIME")
private Date tPtServicetime;

    @ApiModelProperty(value = "泵车评价")
        @TableField("N_PT_ASSESS")
private String nPtAssess;

    @ApiModelProperty(value = "泵车队长")
        @TableField("S_PT_CAPTAIN")
private String sPtCaptain;

    @ApiModelProperty(value = "泵车人数")
        @TableField("N_PT_PERCOUNT")
private BigDecimal nPtPercount;

    @ApiModelProperty(value = "分管负责人")
        @TableField("S_PT_CHARGE")
private String sPtCharge;

    @ApiModelProperty(value = "分管负责人电话")
        @TableField("S_PT_CHARGEPHONE")
private String sPtChargephone;

    @ApiModelProperty(value = "是否有附件")
        @TableField("S_ISPIC")
private String sIspic;

    @ApiModelProperty(value = "备注")
        @TableField("S_BZ")
private String sBz;

    @ApiModelProperty(value = "创建时间")
        @TableField("T_CREATTIME")
private Date tCreattime;

    @ApiModelProperty(value = "创建人")
        @TableField("S_CREATPER")
private String sCreatper;

    @ApiModelProperty(value = "编辑时间")
        @TableField("T_EDITTIME")
private Date tEdittime;

    @ApiModelProperty(value = "编辑人")
        @TableField("S_EDITPER")
private String sEditper;

    @ApiModelProperty(value = "是否有视屏")
        @TableField("S_SP")
private String sSp;

    @ApiModelProperty(value = "视屏编号")
        @TableField("S_SPBH")
private String sSpbh;

    @ApiModelProperty(value = "使用范围")
        @TableField("S_SYFW")
private String sSyfw;

    @ApiModelProperty(value = "审核状态")
        @TableField("N_ISSH")
private BigDecimal nIssh;

    @ApiModelProperty(value = "审核人")
        @TableField("S_SHR")
private String sShr;

    @ApiModelProperty(value = "审核时间")
        @TableField("T_SHSJ")
private Date tShsj;

    @ApiModelProperty(value = "停放坐标X")
        @TableField("S_X")
private BigDecimal sX;

    @ApiModelProperty(value = "停放坐标Y")
        @TableField("S_Y")
private BigDecimal sY;

    @ApiModelProperty(value = "是否驻点保障")
        @TableField("S_ZDBZ")
private String sZdbz;

    @ApiModelProperty(value = "驻点保障地址")
        @TableField("S_ZDBZ_ADDRESS")
private String sZdbzAddress;

}
