package com.wavenet.maintenance.web.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;


    @Data
    @Accessors(chain = true)
    @ApiModel(value = "CountByCarVoS对象", description = "查询参数")
    public class CountByCarVoS implements Serializable {
        private static final long serialVersionUID = 1L;


        @TableField("RWZX")
        private Integer rwzx;

        @TableField("ZDBZ")
        private Integer zdbz;

        @TableField("JJDM")
        private Integer jjdm;

    }
