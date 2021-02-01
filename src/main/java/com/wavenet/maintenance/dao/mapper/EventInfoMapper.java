package com.wavenet.maintenance.dao.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wavenet.maintenance.dao.entity.EventDisposalRel;
import com.wavenet.maintenance.dao.entity.EventInfo;
import com.wavenet.maintenance.web.query.EventInfoQueryParam;
import com.wavenet.maintenance.web.vo.EventInfoQueryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 *  Mapper 接口
 * </pre>
 *
 * @author zll
 * @since 2020-03-30
 */
@Repository
public interface EventInfoMapper extends BaseMapper<EventInfo> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    EventInfoQueryVo getEventInfoById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param eventInfoQueryParam
     * @return
     */
    IPage<EventInfoQueryVo> getEventInfoPageList(@Param("page") Page page, @Param("eventInfoQueryParam") EventInfoQueryParam eventInfoQueryParam);

    /**
     * 根据code关联查询
     */
    List<EventInfoQueryVo> selectInfoByCode(String code);

    /**
     * 根据路段名查询DispatchCode
     */
    List<EventDisposalRel> selectDispatchCode(String code);
}
