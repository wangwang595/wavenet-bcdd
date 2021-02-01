package com.wavenet.maintenance.dao.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wavenet.maintenance.dao.entity.TPumptruckControl;
import com.wavenet.maintenance.web.query.ShiQuVoQueryParm;
import com.wavenet.maintenance.web.query.TPumptruckControlQueryParam;
import com.wavenet.maintenance.web.vo.TPumptruckControlQueryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 * 泵车状态表 Mapper 接口
 * </pre>
 *
 * @author zll
 * @since 2020-05-10
 */
@Repository
public interface TPumptruckControlMapper extends BaseMapper<TPumptruckControl> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    TPumptruckControlQueryVo getTPumptruckControlById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param tPumptruckControlQueryParam
     * @return
     */
    IPage<TPumptruckControlQueryVo> getTPumptruckControlPageList(@Param("page") Page page, @Param("param") TPumptruckControlQueryParam tPumptruckControlQueryParam);


    Integer getTPumpInfo();
    Integer getrenwujizhing();
    Integer getzhudianbaozhang();
    Integer getkongxian();

    Integer getshijidaiming(@Param("city") String city);
    Integer getshijirenwujizhing(@Param("city")String city);
    Integer getshijizhudianbaozhang(@Param("city")String city);
    Integer getshijikongxian(@Param("city")String city);



}
