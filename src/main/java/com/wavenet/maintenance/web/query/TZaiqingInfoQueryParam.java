package com.wavenet.maintenance.web.query;

import com.baomidou.mybatisplus.annotation.TableField;
import com.wavenet.maintenance.web.vo.TZaiqingTpQueryVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import com.wavenetframework.boot.common.param.OrderQueryParam;

import java.math.BigDecimal;
import java.util.List;

/**
 * <pre>
 * 险情信息表 查询参数对象
 * </pre>
 *
 * @author zll
 * @date 2020-05-11
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "TZaiqingInfoQueryParam对象", description = "险情信息表查询参数")
public class TZaiqingInfoQueryParam extends OrderQueryParam {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("区名")
    private String sQx;

    @ApiModelProperty("泵车状态")
    private String prooject;

//    @ApiModelProperty("突击队名称")
//    private String dwmc;
//
//    @ApiModelProperty(value = "车牌号")
//
//    private String sPz;
//
//    @ApiModelProperty("联系人")
//    private String lxr;
//
//    @ApiModelProperty("联系电话")
//    private String lxdh;

//    @ApiModelProperty("排水量")
//    private BigDecimal sPtFlow;
   // List<TZaiqingTpQueryVo> TuJiXinXi;

    @ApiModelProperty("灾情id")
    private String sId;



}
