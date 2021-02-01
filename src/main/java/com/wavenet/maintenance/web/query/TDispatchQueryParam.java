package com.wavenet.maintenance.web.query;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import com.wavenetframework.boot.common.param.OrderQueryParam;

/**
 * <pre>
 * 任务信息表 查询参数对象
 * </pre>
 *
 * @author zll
 * @date 2020-05-11
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "TDispatchQueryParam对象", description = "任务信息表查询参数")
public class TDispatchQueryParam extends OrderQueryParam {
    private static final long serialVersionUID = 1L;
}
