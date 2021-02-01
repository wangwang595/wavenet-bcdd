package com.wavenet.maintenance.service;

import com.wavenet.maintenance.dao.entity.DrainStation;
import com.wavenet.maintenance.web.vo.PlanTableVo;
import com.wavenetframework.boot.common.service.BaseService;
import com.wavenet.maintenance.web.query.DrainStationQueryParam;
import com.wavenet.maintenance.web.vo.DrainStationQueryVo;
import com.wavenetframework.boot.common.vo.Paging;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 *  服务类
 * </pre>
 *
 * @author zll
 * @since 2020-05-06
 */
public interface DrainStationService extends BaseService<DrainStation> {

    /**
     * 保存
     *
     * @param drainStation
     * @return
     * @throws Exception
     */
    boolean saveDrainStation(DrainStation drainStation) throws Exception;

    /**
     * 修改
     *
     * @param drainStation
     * @return
     * @throws Exception
     */
    boolean updateDrainStation(DrainStation drainStation) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteDrainStation(Long id) throws Exception;

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    DrainStationQueryVo getDrainStationById(Serializable id) throws Exception;

    /**
     * 获取分页对象
     *
     * @param drainStationQueryParam
     * @return
     * @throws Exception
     */
    Paging<DrainStationQueryVo> getDrainStationPageList(DrainStationQueryParam drainStationQueryParam) throws Exception;


    List<DrainStationQueryVo> selectDrainById(String stStationid) throws Exception;

}
