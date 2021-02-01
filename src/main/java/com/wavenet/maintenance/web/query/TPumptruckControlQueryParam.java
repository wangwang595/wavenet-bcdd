package com.wavenet.maintenance.web.query;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import com.wavenetframework.boot.common.param.OrderQueryParam;

/**
 * <pre>
 * 泵车状态表 查询参数对象
 * </pre>
 *
 * @author zll
 * @date 2020-05-10
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "TPumptruckControlQueryParam对象", description = "泵车状态表查询参数")
public class TPumptruckControlQueryParam extends OrderQueryParam {
    private static final long serialVersionUID = 1L;
}
