package com.wavenet.maintenance.service;

import java.io.Serializable;

import com.wavenet.maintenance.dao.entity.PatrolGpsRealtime;
import com.wavenet.maintenance.web.query.PatrolGpsRealtimeQueryParam;
import com.wavenet.maintenance.web.vo.PatrolGpsRealtimeQueryVo;
import com.wavenetframework.boot.common.service.BaseService;
import com.wavenetframework.boot.common.vo.Paging;

/**
 * <pre>
 *  服务类
 * </pre>
 *
 * @author zll
 * @since 2020-03-13
 */
public interface PatrolGpsRealtimeService extends BaseService<PatrolGpsRealtime> {

    /**
     * 保存
     *
     * @param patrolGpsRealtime
     * @return
     * @throws Exception
     */
    boolean savePatrolGpsRealtime(PatrolGpsRealtime patrolGpsRealtime) throws Exception;

    /**
     * 修改
     *
     * @param patrolGpsRealtime
     * @return
     * @throws Exception
     */
    boolean updatePatrolGpsRealtime(PatrolGpsRealtime patrolGpsRealtime) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deletePatrolGpsRealtime(Long id) throws Exception;

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    PatrolGpsRealtimeQueryVo getPatrolGpsRealtimeById(Serializable id) throws Exception;

    /**
     * 获取分页对象
     *
     * @param patrolGpsRealtimeQueryParam
     * @return
     * @throws Exception
     */
    Paging<PatrolGpsRealtimeQueryVo> getPatrolGpsRealtimePageList(PatrolGpsRealtimeQueryParam patrolGpsRealtimeQueryParam) throws Exception;

}
