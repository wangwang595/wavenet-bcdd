package com.wavenet.maintenance.service;

import com.wavenet.maintenance.dao.entity.TDictianory;
import com.wavenetframework.boot.common.service.BaseService;
import com.wavenet.maintenance.web.query.TDictianoryQueryParam;
import com.wavenet.maintenance.web.vo.TDictianoryQueryVo;
import com.wavenetframework.boot.common.vo.Paging;

import java.io.Serializable;

/**
 * <pre>
 * 字典表 服务类
 * </pre>
 *
 * @author zll
 * @since 2020-05-14
 */
public interface TDictianoryService extends BaseService<TDictianory> {

    /**
     * 保存
     *
     * @param tDictianory
     * @return
     * @throws Exception
     */
    boolean saveTDictianory(TDictianory tDictianory) throws Exception;

    /**
     * 修改
     *
     * @param tDictianory
     * @return
     * @throws Exception
     */
    boolean updateTDictianory(TDictianory tDictianory) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteTDictianory(Long id) throws Exception;

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    TDictianoryQueryVo getTDictianoryById(Serializable id) throws Exception;

    /**
     * 获取分页对象
     *
     * @param tDictianoryQueryParam
     * @return
     * @throws Exception
     */
    Paging<TDictianoryQueryVo> getTDictianoryPageList(TDictianoryQueryParam tDictianoryQueryParam) throws Exception;

}
