package com.wavenet.maintenance.dao.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wavenet.maintenance.dao.entity.EventDispatch;
import com.wavenet.maintenance.web.query.EventDispatchQueryParam;
import com.wavenet.maintenance.web.vo.EventDispatchQueryVo;
import com.wavenet.maintenance.web.vo.EventDispatchYhInfoVo;
import com.wavenet.maintenance.web.vo.EventDisposalWorkloadQueryVo;
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
public interface EventDispatchMapper extends BaseMapper<EventDispatch> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    EventDispatchQueryVo getEventDispatchById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param eventDispatchQueryParam
     * @return
     */
    IPage<EventDispatchQueryVo> getEventDispatchPageList(@Param("page") Page page, @Param("eventDispatchQueryParam") EventDispatchQueryParam eventDispatchQueryParam);

    /**
     * 病害信息查询
     * @param code
     * @return
     */
    List<EventInfoQueryVo> selectInfoByCode(String code);

    /**
     * 养护主表查询
     * @param code
     * @return
     */
    EventDispatchYhInfoVo selectDispatchInfo(String code);

    /**
     * 查询工作量
     */
    List<EventDisposalWorkloadQueryVo> selectWorkLoad(String disposalCode);

    /**
     * 条件查询dispatch表
     */
    List<EventDispatch> selectDispatList(@Param("town")String town);

}
