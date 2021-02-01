package com.wavenet.maintenance.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
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
@TableName("EVENT_DISPOSAL_WORKLOAD")
@ApiModel(value = "EventDisposalWorkload对象", description = "")
public class EventDisposalWorkload extends BaseEntity {

    private static final long serialVersionUID = 1L;

@TableId(value = "workload_code", type = IdType.UUID)
private String workloadCode;

private String disposalCode;

private String eventType;

private String eventTypeLarge;

private String eventTypeSmall;

private Double planValue;

private String unit;

private String describe;

private Double process;

private String auditor;

}
