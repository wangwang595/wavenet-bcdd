package com.wavenet.maintenance.dao.entity;

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
 * @since 2020-03-24
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@TableName("EVENT_TYPE")
@ApiModel(value = "EventType对象", description = "")
public class EventType extends BaseEntity {

private static final long serialVersionUID = 1L;

@TableId(value = "event_type_code", type = IdType.UUID)

private String eventTypeCode;

private String eventTypePcode;

private String eventStandard;

private String name;

private String unit;

private String note;

private Double sort;

private String state;
}
