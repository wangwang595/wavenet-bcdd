package com.wavenet.maintenance.web.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;


@Data
    @Accessors(chain = true)
    @ApiModel(value = "CountByCarVoo对象", description = "查询参数")
    public class CountByCarVo implements Serializable {
        private static final long serialVersionUID = 1L;

        @TableField("S_QX")
        private String sQx;

        @TableField("RWZX")
        private Integer rwzx;

        @TableField("ZDBZ")
        private Integer zdbz;

        @TableField("JJDM")
        private Integer jjdm;

    }
