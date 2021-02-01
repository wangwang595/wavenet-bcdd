package com.wavenet.maintenance.dao.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.wavenetframework.boot.common.entity.BaseEntity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <pre>
 * 
 * </pre>
 *
 * @author zll
 * @since 2020-03-13
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@TableName("PATROL_GPS_REALTIME")
@ApiModel(value = "PatrolGpsRealtime对象", description = "")
public class PatrolGpsRealtime extends BaseEntity {

    private static final long serialVersionUID = 1L;

@TableId(value = "gps_code", type = IdType.UUID)
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
