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
@ApiModel(value = "EventInfoQueryVo对象", description = "查询参数")
public class EventInfoQueryVo implements Serializable {
    private static final long serialVersionUID = 1L;

private String eventCode;

private String patrolCode;

private String eventTypeCode;

private String eventType;

private String eventTypeLarge;

private String eventTypeSmall;

private String eventDesc;

private String address;

private Double x;

private Double y;

private String personCode;

private String personName;

private String company;

private String town;

private Date reportDate;

private String roadCode;

private String roadName;

private String roadSectionCode;

private String roadSectionStart;

private String roadSectionEnd;

private String attachment;

private String eventState;

private Double deleteState;

}