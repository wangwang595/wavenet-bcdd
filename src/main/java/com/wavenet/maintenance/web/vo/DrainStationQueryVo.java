package com.wavenet.maintenance.web.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;

import java.util.Date;

/**
 * <pre>
 *  查询结果对象
 * </pre>
 *
 * @author zll
 * @date 2020-05-06
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "DrainStationQueryVo对象", description = "查询参数")
public class DrainStationQueryVo implements Serializable {
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