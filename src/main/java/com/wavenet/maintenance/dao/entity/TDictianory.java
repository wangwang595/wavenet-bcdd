package com.wavenet.maintenance.dao.entity;

import java.math.BigDecimal;
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
 * 字典表
 * </pre>
 *
 * @author zll
 * @since 2020-05-14
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@TableName("T_DICTIANORY")
@ApiModel(value = "TDictianory对象", description = "字典表")
public class TDictianory extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "流水号")
    @TableId(value = "N_ID", type = IdType.UUID)
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
