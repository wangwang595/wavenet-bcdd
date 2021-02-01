package com.wavenet.maintenance.web.vo;

import io.swagger.annotations.ApiModel;
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
 * @date 2020-03-13
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "PatrolGpsRealtimeQueryVo对象", description = "查询参数")
public class PatrolGpsRealtimeQueryVo implements Serializable {
    private static final long serialVersionUID = 1L;

private String gpsCode;

private String patrolCode;

private String personCode;

private Date uplaodDate;

private Double x;

private Double y;

private String type;

private String roadSectionCode;

private Double speed;

private Double mileage;

}