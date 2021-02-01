package com.wavenet.maintenance.web.query;

import com.wavenetframework.boot.common.param.OrderQueryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

@Data


@ApiModel(value = "TZaiqingQueryParam对象", description = "险情信息表查询参数")
public class TZaiqingQueryParam  {


    @ApiModelProperty("灾情id")
    private String sId;

    @ApiModelProperty(value = "车牌号")
     private List<String> sPz;
}
