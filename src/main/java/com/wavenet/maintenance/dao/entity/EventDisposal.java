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
@TableName("EVENT_DISPOSAL")
@ApiModel(value = "EventDisposal对象", description = "")
public class EventDisposal extends BaseEntity {

    private static final long serialVersionUID = 1L;

@TableId(value = "disposal_code", type = IdType.UUID)
    private String disposalCode;

private String dispatchCode;

private String solverCode;

private String solverName;

private String town;

private String company;

private String solveStart;

private String solveEnd;

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
