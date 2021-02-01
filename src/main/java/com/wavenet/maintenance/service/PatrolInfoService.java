package com.wavenet.maintenance.service;

import com.wavenet.maintenance.dao.entity.PatrolInfo;
import com.wavenetframework.boot.common.service.BaseService;
import com.wavenet.maintenance.web.query.PatrolInfoQueryParam;
import com.wavenet.maintenance.web.vo.PatrolInfoQueryVo;
import com.wavenetframework.boot.common.vo.Paging;

import java.io.Serializable;

/**
 * <pre>
 *  服务类
 * </pre>
 *
 * @author zll
 * @since 2020-03-30
 */
public interface PatrolInfoService extends BaseService<PatrolInfo> {

    /**
     * 保存
     *
     * @param patrolInfo
     * @return
     * @throws Exception
     */
    String savePatrolInfo(PatrolInfo patrolInfo) throws Exception;

    /**
     * 修改
     *
     * @param patrolInfo
     * @return
     * @throws Exception
     */
    boolean updatePatrolInfo(PatrolInfo patrolInfo) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deletePatrolInfo(Long id) throws Exception;

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    PatrolInfoQueryVo getPatrolInfoById(Serializable id) throws Exception;

    /**
     * 获取分页对象
     *
     * @param patrolInfoQueryParam
     * @return
     * @throws Exception
     */
    Paging<PatrolInfoQueryVo> getPatrolInfoPageList(PatrolInfoQueryParam patrolInfoQueryParam) throws Exception;

}
