package com.wavenet.maintenance.web.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;

import java.util.Date;

/**
 * <pre>
 *  查询结果对象
 * </pre>
 *
 * @author zll
 * @date 2020-03-30
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "EventDisposalRelQueryVo对象", description = "查询参数")
public class EventDisposalRelQueryVo implements Serializable {
    private static final long serialVersionUID = 1L;

private String eventDisposalCode;

private String eventCode;

private String disposalCode;

}