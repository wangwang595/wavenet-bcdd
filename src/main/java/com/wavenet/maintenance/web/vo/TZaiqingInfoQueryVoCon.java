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
 * 险情信息表 查询结果对象
 * </pre>
 *
 * @author zll
 * @date 2020-05-11
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "TZaiqingInfoQueryVoCon", description = "险情信息表查询参数")
public class TZaiqingInfoQueryVoCon implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private String sId;

    @ApiModelProperty(value = "所属区")
        @TableField("S_DEPTID")
private String sDeptid;

    @ApiModelProperty(value = "地址")
        @TableField("S_ADD")
private String sAdd;

    @ApiModelProperty(value = "发布时间")
        @TableField("T_PUBLISH_TIME")
private Date tPublishTime;

    @ApiModelProperty(value = "发布人")
        @TableField("S_PUBLISHER")
private String sPublisher;

    @ApiModelProperty(value = "灾情来源")
        @TableField("N_SOURCE")
private BigDecimal nSource;

    @ApiModelProperty(value = "灾情位置X")
    @TableField("N_S_X")
private BigDecimal nSX;

    @ApiModelProperty(value = "灾情位置Y")
        @TableField("N_S_Y")
private BigDecimal nSY;

    @ApiModelProperty(value = "是否关闭")
        @TableField("N_CANCEL")
private BigDecimal nCancel;

    @ApiModelProperty(value = "是否派单")
        @TableField("N_PAIDAN")
private BigDecimal nPaidan;

    @ApiModelProperty(value = "是否支援")
        @TableField("N_ZHIYUAN")
private BigDecimal nZhiyuan;

    @ApiModelProperty(value = "备注")
        @TableField("S_BZ")
private String sBz;

    @ApiModelProperty(value = "是否封交")
        @TableField("N_ISCLOSE")
private BigDecimal nIsclose;

    @ApiModelProperty(value = "站点编号")
        @TableField("S_NO")
private String sNo;

    @ApiModelProperty(value = "险情名称")
        @TableField("S_NAME")
private String sName;

    @ApiModelProperty(value = "积水深度")
        @TableField("N_VALUE")
private BigDecimal nValue;

    @ApiModelProperty(value = "灾情类别")
        @TableField("S_TYPE")
private String sType;

    @ApiModelProperty(value = "灾情百度位置X")
        @TableField("N_PB_X")
private BigDecimal nPbX;

    @ApiModelProperty(value = "灾情百度位置Y")
        @TableField("N_PB_Y")
private BigDecimal nPbY;

    @ApiModelProperty(value = "关闭人")
        @TableField("S_CANCELPER")
private String sCancelper;

    @ApiModelProperty(value = "关闭时间")
        @TableField("T_CANCELTIME")
private Date tCanceltime;

    @ApiModelProperty(value = "现场联系人")
        @TableField("S_LXR")
private String sLxr;

    @ApiModelProperty(value = "现场联系人电话")
        @TableField("S_LXDH")
private String sLxdh;

    @ApiModelProperty(value = "是否处置完成0--未完成；1--已完成")
        @TableField("N_COMPLETE")
private BigDecimal nComplete;

    @TableField("CON")
    private Integer con;

}