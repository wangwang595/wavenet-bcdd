package com.wavenet.maintenance.web.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
@ApiModel(value = "MaintenanceDisposalQueryVo对象", description = "查询参数")
public class MaintenanceDisposalQueryVo implements Serializable {
    private static final long serialVersionUID = 1L;

private String disposalCode;

private String detailCode;

private String roadCode;

private String roadName;

private String roadSectionCode;

private String roadSectionStart;

private String roadSectionEnd;

private String type;

private Date dateStart;

private Date dateEnd;

private String personCode;

private String personName;

private String company;

private String town;

private String way;

private String deleteState;

private String attBefore;

private String attOngoing;

private String attAfter;

private String curingState;

private Double curingLength;

private Double pipeTotal;

private String pipeGrade;

private String projectTeam;

private String source;

private String plans;

private String enclosure;

}