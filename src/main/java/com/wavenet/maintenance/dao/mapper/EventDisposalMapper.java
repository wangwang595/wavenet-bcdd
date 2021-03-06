package com.wavenet.maintenance.dao.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wavenet.maintenance.dao.entity.EventDisposal;
import com.wavenet.maintenance.web.query.EventDisposalQueryParam;
import com.wavenet.maintenance.web.vo.EventDisposalQueryVo;
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
public interface EventDisposalMapper extends BaseMapper<EventDisposal> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    EventDisposalQueryVo getEventDisposalById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param eventDisposalQueryParam
     * @return
     */
    IPage<EventDisposalQueryVo> getEventDisposalPageList(@Param("page") Page page, @Param("param") EventDisposalQueryParam eventDisposalQueryParam);

}
