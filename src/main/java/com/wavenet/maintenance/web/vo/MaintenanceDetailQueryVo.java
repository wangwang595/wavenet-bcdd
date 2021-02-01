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
 * @date 2020-03-13
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "MaintenanceDetailQueryVo对象", description = "查询参数")
public class MaintenanceDetailQueryVo implements Serializable {
    private static final long serialVersionUID = 1L;


private String detailCode;

private String planCode;

private String roadCode;

private String roadName;

private String roadSectionCode;

private String roadSectionStart;

private String roadSectionEnd;

private String type;

private Double year;

private Double month;

private String curingState;

private String company;

private Double pipeTotal;

private Double pipeMain;

private Double pipeBranch;

private Double manhole;

private Double catchBasin;

private String town;

private String projectTeam;

private String source;

private String plans;

private String enclosure;


}