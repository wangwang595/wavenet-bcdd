package com.wavenet.maintenance.service;

import com.wavenet.maintenance.dao.entity.EventDisposalRel;
import com.wavenetframework.boot.common.service.BaseService;
import com.wavenet.maintenance.web.query.EventDisposalRelQueryParam;
import com.wavenet.maintenance.web.vo.EventDisposalRelQueryVo;
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
public interface EventDisposalRelService extends BaseService<EventDisposalRel> {

    /**
     * 保存
     *
     * @param eventDisposalRel
     * @return
     * @throws Exception
     */
    boolean saveEventDisposalRel(EventDisposalRel eventDisposalRel) throws Exception;

    /**
     * 修改
     *
     * @param eventDisposalRel
     * @return
     * @throws Exception
     */
    boolean updateEventDisposalRel(EventDisposalRel eventDisposalRel) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteEventDisposalRel(Long id) throws Exception;

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    EventDisposalRelQueryVo getEventDisposalRelById(Serializable id) throws Exception;

    /**
     * 获取分页对象
     *
     * @param eventDisposalRelQueryParam
     * @return
     * @throws Exception
     */
    Paging<EventDisposalRelQueryVo> getEventDisposalRelPageList(EventDisposalRelQueryParam eventDisposalRelQueryParam) throws Exception;

}
