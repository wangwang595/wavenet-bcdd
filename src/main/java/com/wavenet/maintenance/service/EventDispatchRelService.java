package com.wavenet.maintenance.service;

import com.wavenet.maintenance.dao.entity.EventDispatchRel;
import com.wavenetframework.boot.common.service.BaseService;
import com.wavenet.maintenance.web.query.EventDispatchRelQueryParam;
import com.wavenet.maintenance.web.vo.EventDispatchRelQueryVo;
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
public interface EventDispatchRelService extends BaseService<EventDispatchRel> {

    /**
     * 保存
     *
     * @param eventDispatchRel
     * @return
     * @throws Exception
     */
    boolean saveEventDispatchRel(EventDispatchRel eventDispatchRel) throws Exception;

    /**
     * 修改
     *
     * @param eventDispatchRel
     * @return
     * @throws Exception
     */
    boolean updateEventDispatchRel(EventDispatchRel eventDispatchRel) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteEventDispatchRel(Long id) throws Exception;

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    EventDispatchRelQueryVo getEventDispatchRelById(Serializable id) throws Exception;

    /**
     * 获取分页对象
     *
     * @param eventDispatchRelQueryParam
     * @return
     * @throws Exception
     */
    Paging<EventDispatchRelQueryVo> getEventDispatchRelPageList(EventDispatchRelQueryParam eventDispatchRelQueryParam) throws Exception;

}
