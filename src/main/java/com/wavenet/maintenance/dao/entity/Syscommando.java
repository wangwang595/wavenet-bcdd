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
@TableName("SYSCOMMANDO")
@ApiModel(value = "Syscommando对象", description = "")
public class Syscommando extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "ID", type = IdType.UUID)
    private String id;

    @ApiModelProperty(value = "抢险范围")
        @TableField("QXFW")
private String qxfw;

    @ApiModelProperty(value = "单位名称")
        @TableField("DWMC")
private String dwmc;

    @ApiModelProperty(value = "传真")
        @TableField("CZ")
private String cz;

    @ApiModelProperty(value = "公司电话")
        @TableField("GSDH")
private String gsdh;

    @ApiModelProperty(value = "负责人")
        @TableField("FZR")
private String fzr;

    @ApiModelProperty(value = "负责人手机")
        @TableField("FZRSJ")
private String fzrsj;

    @ApiModelProperty(value = "职务")
        @TableField("ZW")
private String zw;

    @ApiModelProperty(value = "联系人")
        @TableField("LXR")
private String lxr;

    @ApiModelProperty(value = "联系人电话")
        @TableField("LXDH")
private String lxdh;

    @ApiModelProperty(value = "集结地点")
        @TableField("JJDD")
private String jjdd;

    @ApiModelProperty(value = "公司介绍")
        @TableField("GSJS")
private String gsjs;

    @ApiModelProperty(value = "状态")
        @TableField("ZT")
private String zt;

    @ApiModelProperty(value = "备注")
        @TableField("REMARK")
private String remark;

    @ApiModelProperty(value = "创建时间")
        @TableField("CREATETIME")
private Date createtime;

    @ApiModelProperty(value = "创建人")
        @TableField("CREATEPERSON")
private String createperson;

    @ApiModelProperty(value = "编辑时间")
        @TableField("UPDATETIME")
private Date updatetime;

    @ApiModelProperty(value = "编辑人")
        @TableField("UPDATEPERSON")
private String updateperson;

    @ApiModelProperty(value = "区ID")
        @TableField("DISTID")
private String distid;

    @ApiModelProperty(value = "等级")
        @TableField("GRADE")
private String grade;

    @ApiModelProperty(value = "审核状态")
        @TableField("N_ISSH")
private BigDecimal nIssh;

    @ApiModelProperty(value = "审核人")
        @TableField("S_SHR")
private String sShr;

    @ApiModelProperty(value = "审核时间")
        @TableField("T_SHSJ")
private Date tShsj;

    @ApiModelProperty(value = "集结坐标X")
        @TableField("S_X")
private BigDecimal sX;

    @ApiModelProperty(value = "集结坐标Y")
        @TableField("S_Y")
private BigDecimal sY;

}
