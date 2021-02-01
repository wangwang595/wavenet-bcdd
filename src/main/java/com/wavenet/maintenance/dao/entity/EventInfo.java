package com.wavenet.maintenance.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.wavenetframework.boot.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * <pre>
 * 
 * </pre>
 *
 * @author zll
 * @since 2020-03-30
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@TableName("EVENT_INFO")
@ApiModel(value = "EventInfo对象", description = "")
public class EventInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

@TableId(value = "event_code", type = IdType.UUID)
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
