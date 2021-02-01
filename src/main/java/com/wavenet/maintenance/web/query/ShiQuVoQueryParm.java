/*
 * Copyright 2020 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.wavenet.maintenance.web.query;

import com.wavenetframework.boot.common.param.OrderQueryParam;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author 48564
 * @date 2020/5/10 19:35
 */
@Data
@Accessors(chain = true)

@ApiModel(value = "ShiQuVoQueryParm对象", description = "查询参数")
public class ShiQuVoQueryParm {
    private static final long serialVersionUID = 1L;

    private String shiqu;
}

