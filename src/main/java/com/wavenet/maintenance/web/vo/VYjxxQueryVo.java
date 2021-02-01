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
 * @date 2020-05-15
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "VYjxxQueryVo对象", description = "查询参数")
public class VYjxxQueryVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableField("ST_AREANAME")
private String stAreaname;

    @TableField("DT_PUBLISHTIME")
private Date dtPublishtime;

    @TableField("DT_RELIEVETIME")
private Date dtRelievetime;

    @TableField("ST_LEVEL")
private String stLevel;

    @TableField("ST_COLOR")
private String stColor;

    @TableField("ST_STATUS")
private String stStatus;

}