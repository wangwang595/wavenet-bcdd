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
@ApiModel(value = "EventDisposalQueryVo对象", description = "查询参数")
public class EventDisposalQueryVo implements Serializable {
    private static final long serialVersionUID = 1L;

private String disposalCode;

private String dispatchCode;

private String solverCode;

private String solverName;

private String town;

private String company;

private Date solveStart;

private Date solveEnd;

private String solveDesc;

private String attBefore;

private String attOngoing;

private String attAfter;

private String roadCode;

private String roadName;

private String roadSectionCode;

private String roadSectionStart;

private String roadSectionEnd;

private String disposalState;

}