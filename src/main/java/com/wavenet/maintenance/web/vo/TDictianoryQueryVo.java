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
 * 字典表 查询结果对象
 * </pre>
 *
 * @author zll
 * @date 2020-05-14
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "TDictianoryQueryVo对象", description = "字典表查询参数")
public class TDictianoryQueryVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "流水号")
    private String nId;

    @ApiModelProperty(value = "字典号")
        @TableField("S_CD_KEY")
private BigDecimal sCdKey;

    @ApiModelProperty(value = "字典值")
        @TableField("S_CD_VALUE")
private String sCdValue;

    @ApiModelProperty(value = "备注")
        @TableField("S_BZ")
private String sBz;

    @ApiModelProperty(value = "字典类别")
        @TableField("S_TYPE")
private String sType;

}