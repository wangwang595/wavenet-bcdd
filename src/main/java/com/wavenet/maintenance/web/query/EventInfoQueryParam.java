package com.wavenet.maintenance.web.query;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import com.wavenetframework.boot.common.param.OrderQueryParam;

/**
 * <pre>
 *  查询参数对象
 * </pre>
 *
 * @author zll
 * @date 2020-03-30
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "EventInfoQueryParam对象", description = "查询参数")
public class EventInfoQueryParam extends OrderQueryParam {
    private static final long serialVersionUID = 1L;
    private String roadCode;
    private String time;
    private String type;
    private String typeLarge;
    private String typeSmall;
    private String personCode;

}
