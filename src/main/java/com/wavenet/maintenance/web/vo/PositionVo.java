package com.wavenet.maintenance.web.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@ApiModel(value = "PositionVo对象", description = "查询参数")
public class PositionVo implements Serializable {
    private static final long serialVersionUID = 1L;



    @ApiModelProperty(value = "泵车位置X")
    @TableField("N_P_X")
    private String nPX;

    @ApiModelProperty(value = "泵车位置Y")
    @TableField("N_P_Y")
    private String nPY;
}
