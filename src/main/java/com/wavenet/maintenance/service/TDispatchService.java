package com.wavenet.maintenance.service;

import com.wavenet.maintenance.dao.entity.TDispatch;
import com.wavenetframework.boot.common.service.BaseService;
import com.wavenet.maintenance.web.query.TDispatchQueryParam;
import com.wavenet.maintenance.web.vo.TDispatchQueryVo;
import com.wavenetframework.boot.common.vo.Paging;

import java.io.Serializable;

/**
 * <pre>
 * 任务信息表 服务类
 * </pre>
 *
 * @author zll
 * @since 2020-05-11
 */
public interface TDispatchService extends BaseService<TDispatch> {

    /**
     * 保存
     *
     * @param tDispatch
     * @return
     * @throws Exception
     */
    boolean saveTDispatch(TDispatch tDispatch) throws Exception;

    /**
     * 修改
     *
     * @param tDispatch
     * @return
     * @throws Exception
     */
    boolean updateTDispatch(TDispatch tDispatch) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteTDispatch(Long id) throws Exception;

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    TDispatchQueryVo getTDispatchById(Serializable id) throws Exception;

    /**
     * 获取分页对象
     *
     * @param tDispatchQueryParam
     * @return
     * @throws Exception
     */
    Paging<TDispatchQueryVo> getTDispatchPageList(TDispatchQueryParam tDispatchQueryParam) throws Exception;

}
