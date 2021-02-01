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
@TableName("PATROL_INFO")
@ApiModel(value = "PatrolInfo对象", description = "")
public class PatrolInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

@TableId(value = "patrol_code", type = IdType.UUID)
    private String patrolCode;

private String roadCode;

private String roadName;

private String roadSectionCode;

private String roadSectionStart;

private String roadSectionEnd;

private Date dateStart;

private Date dateEnd;

private Double mileage;

private String type;

private String personCode;

private String personName;

private String company;

private String town;

private Double state;

}
