package com.wavenet.maintenance.dao.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wavenet.maintenance.dao.entity.EventDispatchRel;
import com.wavenet.maintenance.web.query.EventDispatchRelQueryParam;
import com.wavenet.maintenance.web.vo.EventDispatchRelQueryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <pre>
 *  Mapper 接口
 * </pre>
 *
 * @author zll
 * @since 2020-03-30
 */
@Repository
public interface EventDispatchRelMapper extends BaseMapper<EventDispatchRel> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    EventDispatchRelQueryVo getEventDispatchRelById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param eventDispatchRelQueryParam
     * @return
     */
    IPage<EventDispatchRelQueryVo> getEventDispatchRelPageList(@Param("page") Page page, @Param("param") EventDispatchRelQueryParam eventDispatchRelQueryParam);

}
