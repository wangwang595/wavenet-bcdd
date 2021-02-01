package com.wavenet.maintenance.service;

import com.wavenet.maintenance.dao.entity.EventDisposal;
import com.wavenetframework.boot.common.service.BaseService;
import com.wavenet.maintenance.web.query.EventDisposalQueryParam;
import com.wavenet.maintenance.web.vo.EventDisposalQueryVo;
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
public interface EventDisposalService extends BaseService<EventDisposal> {

    /**
     * 保存
     *
     * @param eventDisposal
     * @return
     * @throws Exception
     */
    String saveEventDisposal(EventDisposal eventDisposal) throws Exception;

    /**
     * 修改
     *
     * @param eventDisposal
     * @return
     * @throws Exception
     */
    boolean updateEventDisposal(EventDisposal eventDisposal) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteEventDisposal(Long id) throws Exception;

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    EventDisposalQueryVo getEventDisposalById(Serializable id) throws Exception;

    /**
     * 获取分页对象
     *
     * @param eventDisposalQueryParam
     * @return
     * @throws Exception
     */
    Paging<EventDisposalQueryVo> getEventDisposalPageList(EventDisposalQueryParam eventDisposalQueryParam) throws Exception;

}
