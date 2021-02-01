package com.wavenet.maintenance.web.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <pre>
 *  查询结果对象
 * </pre>
 *
 * @author zll
 * @date 2020-03-24
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "EventTypeQueryVo对象", description = "查询参数")
public class EventTypeQueryVo implements Serializable {
    private static final long serialVersionUID = 1L;

private String eventTypeCode;

private String eventTypePcode;

private String eventStandard;

private String name;

private String unit;

private String note;

private Double sort;

private Integer lv;

}