package com.wavenet.maintenance.dao.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.wavenetframework.boot.common.entity.BaseEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * <pre>
 * 
 * </pre>
 *
 * @author zll
 * @since 2020-03-13
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@TableName("MAINTENANCE_DISPOSAL")
@ApiModel(value = "MaintenanceDisposal对象", description = "")
public class MaintenanceDisposal extends BaseEntity {

    private static final long serialVersionUID = 1L;

@TableId(value = "disposal_code", type = IdType.UUID)
    private String disposalCode;

    @ApiModelProperty("养护计划编号")
private String detailCode;

    @ApiModelProperty("道路编码")
private String roadCode;

    @ApiModelProperty("道路名称")
private String roadName;

    @ApiModelProperty("路段编号")
private String roadSectionCode;

    @ApiModelProperty("路段起始路名")
private String roadSectionStart;

    @ApiModelProperty("路段终止路名")
private String roadSectionEnd;

    @ApiModelProperty("养护类型")
private String type;

    @ApiModelProperty("开始时间")

private String dateStart;

    @ApiModelProperty("结束时间")
private String dateEnd;

    @ApiModelProperty("养护人编码")
private String personCode;

    @ApiModelProperty("养护人中文名")
private String personName;

    @ApiModelProperty("养护公司名称")
private String company;

    @ApiModelProperty("街镇/区域")
private String town;

    @ApiModelProperty("养护方式")
private String way;

    @ApiModelProperty("0 删除 1保留")
private String deleteState;

    @ApiModelProperty("附件(开工前)")
private String attBefore;

    @ApiModelProperty("附件(开工中)")
private String attOngoing;

    @ApiModelProperty("附件(开工后)")
private String attAfter;

    @ApiModelProperty("养护状态")
private String curingState;

    @ApiModelProperty("养护长度")
    private Double curingLength;

}
