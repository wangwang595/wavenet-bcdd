package com.wavenet.maintenance.service;

import com.wavenet.maintenance.dao.entity.EventDispatch;
import com.wavenet.maintenance.web.vo.EventDispatchYhInfoVo;
import com.wavenetframework.boot.common.service.BaseService;
import com.wavenet.maintenance.web.query.EventDispatchQueryParam;
import com.wavenet.maintenance.web.vo.EventDispatchQueryVo;
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
public interface EventDispatchService extends BaseService<EventDispatch> {

    /**
     * 保存
     *
     * @param eventDispatch
     * @return
     * @throws Exception
     */
    boolean saveEventDispatch(EventDispatch eventDispatch) throws Exception;

    /**
     * 修改
     *
     * @param eventDispatch
     * @return
     * @throws Exception
     */
    boolean updateEventDispatch(EventDispatch eventDispatch) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteEventDispatch(Long id) throws Exception;

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    EventDispatchQueryVo getEventDispatchById(Serializable id) throws Exception;

    /**
     * 获取分页对象
     *
     * @param eventDispatchQueryParam
     * @return
     * @throws Exception
     */
    Paging<EventDispatchQueryVo> getEventDispatchPageList(EventDispatchQueryParam eventDispatchQueryParam) throws Exception;
    /**
     * 养护详情列表
     */
    EventDispatchYhInfoVo getYhInfo(String dispatchCode,String disposalCode);

}
