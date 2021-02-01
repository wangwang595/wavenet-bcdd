package com.wavenet.maintenance.web.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data


@ApiModel(value = "TZaiqingsQueryParam对象", description = "险情信息表查询参数")
public class TZaiqingsQueryParam  {


    @ApiModelProperty("灾情id")
    private String sId;

    @ApiModelProperty(value = "车的id")
    private String  sPtId;

    @ApiModelProperty(value = "车牌号")
    private String sPz;
}