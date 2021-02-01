package com.wavenet.maintenance.web.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@ApiModel(value = "SwrnQueryVo对象", description = "查询参数")
public class SwrnQueryVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableField("RWWC")
    private Integer rwwc;

    @TableField("RWZX")
    private Integer rwzx;

    public SwrnQueryVo(Integer rwwc, Integer rwzx) {
        this.rwwc = rwwc;
        this.rwzx = rwzx;
    }

    public SwrnQueryVo() {
    }
}