package com.wavenet.maintenance.dao.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wavenet.maintenance.dao.entity.TDispatch;
import com.wavenet.maintenance.web.query.TDispatchQueryParam;
import com.wavenet.maintenance.web.vo.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 * 任务信息表 Mapper 接口
 * </pre>
 *
 * @author zll
 * @since 2020-05-11
 */
@Repository
public interface TDispatchMapper extends BaseMapper<TDispatch> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    TDispatchQueryVo getTDispatchById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param tDispatchQueryParam
     * @return
     */
    IPage<TDispatchQueryVo> getTDispatchPageList(@Param("page") Page page, @Param("param") TDispatchQueryParam tDispatchQueryParam);

    List<TZaiqingInfoQueryVoS> tDispatchInfo(@Param("id") String id);

    List<TDispatchQueryVoCdValueSpz> getRenWuInfoById(@Param("id") String id);
}
