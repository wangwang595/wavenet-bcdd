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
@ApiModel(value = "EventDispatchQueryVo对象", description = "查询参数")
public class EventDispatchQueryVo implements Serializable {
    private static final long serialVersionUID = 1L;

private String dispatchCode;

private String dispatcherCode;

private String dispatcherName;

private Date dispatcherDate;

private String dispatcherDesc;

private String recipientCode;

private String recipientName;

private String town;

private String company;

private String type;

private String roadCode;

private String roadName;

private String roadSectionCode;

private String roadSectionStart;

private String roadSectionEnd;

private String dispatchState;

private String attBefore;

private String attOngoing;

private String attAfter;

private String disposalCode;

}