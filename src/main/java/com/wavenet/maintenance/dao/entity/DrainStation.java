package com.wavenet.maintenance.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
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
 * @since 2020-05-06
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@TableName("Drain_Station")
@ApiModel(value = "DrainStation对象", description = "")
public class DrainStation extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("ST_STATIONID")
private String stStationid;

    @TableField("ST_STATIONNAME")
private String stStationname;

    @TableField("ST_OLDID")
private String stOldid;

    @TableField("ST_TYPENAME")
private String stTypename;

    @TableField("ST_SOURCE")
private String stSource;

    @TableField("XX")
private Float xx;

    @TableField("YY")
private Float yy;

    @TableField("S_Dist")
private String sDist;


}
