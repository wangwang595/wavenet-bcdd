package com.wavenet.maintenance.service;

import com.wavenet.maintenance.dao.entity.TPumptruck;
import com.wavenet.maintenance.web.query.ShiQuVoQueryParm;
import com.wavenet.maintenance.web.vo.PumptruckAllInfoVo;

import com.wavenet.maintenance.web.vo.TPumptruckControlQueryVo;
import com.wavenetframework.boot.common.service.BaseService;
import com.wavenet.maintenance.web.query.TPumptruckQueryParam;
import com.wavenet.maintenance.web.vo.TPumptruckQueryVo;
import com.wavenetframework.boot.common.vo.Paging;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 *  服务类
 * </pre>
 *
 * @author zll
 * @since 2020-05-10
 */
public interface TPumptruckService extends BaseService<TPumptruck> {

    /**
     * 保存
     *
     * @param tPumptruck
     * @return
     * @throws Exception
     */
    boolean saveTPumptruck(TPumptruck tPumptruck) throws Exception;

    /**
     * 修改
     *
     * @param tPumptruck
     * @return
     * @throws Exception
     */
    boolean updateTPumptruck(TPumptruck tPumptruck) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteTPumptruck(Long id) throws Exception;

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    TPumptruckQueryVo getTPumptruckById(Serializable id) throws Exception;

    /**
     * 获取分页对象
     *
     * @param tPumptruckQueryParam
     * @return
     * @throws Exception
     */
    Paging<TPumptruckQueryVo> getTPumptruckPageList(TPumptruckQueryParam tPumptruckQueryParam) throws Exception;

   List<String> getshiqu();


    List<PumptruckAllInfoVo> getPumptruckAllInfo(String sPtId);
}
