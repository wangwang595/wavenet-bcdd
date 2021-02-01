package com.wavenet.maintenance.web.query;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import com.wavenetframework.boot.common.param.OrderQueryParam;

/**
 * <pre>
 * 字典表 查询参数对象
 * </pre>
 *
 * @author zll
 * @date 2020-05-14
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "TDictianoryQueryParam对象", description = "字典表查询参数")
public class TDictianoryQueryParam extends OrderQueryParam {
    private static final long serialVersionUID = 1L;
}
