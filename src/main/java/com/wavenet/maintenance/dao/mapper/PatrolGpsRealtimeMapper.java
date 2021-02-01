package com.wavenet.maintenance.dao.mapper;

import java.io.Serializable;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wavenet.maintenance.dao.entity.PatrolGpsRealtime;
import com.wavenet.maintenance.web.query.PatrolGpsRealtimeQueryParam;
import com.wavenet.maintenance.web.vo.PatrolGpsRealtimeQueryVo;

/**
 * <pre>
 *  Mapper 接口
 * </pre>
 *
 * @author zll
 * @since 2020-03-13
 */
@Repository
public interface PatrolGpsRealtimeMapper extends BaseMapper<PatrolGpsRealtime> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    PatrolGpsRealtimeQueryVo getPatrolGpsRealtimeById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param patrolGpsRealtimeQueryParam
     * @return
     */
    IPage<PatrolGpsRealtimeQueryVo> getPatrolGpsRealtimePageList(@Param("page") Page page, @Param("param") PatrolGpsRealtimeQueryParam patrolGpsRealtimeQueryParam);

}
