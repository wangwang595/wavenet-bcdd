package com.wavenet.maintenance.service;

import com.wavenet.maintenance.dao.entity.EventDisposalWorkload;
import com.wavenetframework.boot.common.service.BaseService;
import com.wavenet.maintenance.web.query.EventDisposalWorkloadQueryParam;
import com.wavenet.maintenance.web.vo.EventDisposalWorkloadQueryVo;
import com.wavenetframework.boot.common.vo.Paging;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 *  服务类
 * </pre>
 *
 * @author zll
 * @since 2020-03-30
 */
public interface EventDisposalWorkloadService extends BaseService<EventDisposalWorkload> {

    /**
     * 保存
     *
     * @param eventDisposalWorkload
     * @return
     * @throws Exception
     */
    boolean saveEventDisposalWorkload(EventDisposalWorkload eventDisposalWorkload) throws Exception;

    /**
     * 修改
     *
     * @param eventDisposalWorkload
     * @return
     * @throws Exception
     */
    boolean updateEventDisposalWorkload(EventDisposalWorkload eventDisposalWorkload) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteEventDisposalWorkload(Long id) throws Exception;

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    EventDisposalWorkloadQueryVo getEventDisposalWorkloadById(Serializable id) throws Exception;

    /**
     * 获取分页对象
     *
     * @param eventDisposalWorkloadQueryParam
     * @return
     * @throws Exception
     */
    Paging<EventDisposalWorkloadQueryVo> getEventDisposalWorkloadPageList(EventDisposalWorkloadQueryParam eventDisposalWorkloadQueryParam) throws Exception;

    /**
     * 批量新增
     */

    boolean saveWorkload(List<EventDisposalWorkload> eventDisposalWorkload) throws Exception;
}
