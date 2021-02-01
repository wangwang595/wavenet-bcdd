package com.wavenet.maintenance.service;

import java.io.Serializable;

import com.wavenet.maintenance.dao.entity.MaintenanceDetail;
import com.wavenet.maintenance.web.query.MaintenanceDetailQueryParam;
import com.wavenet.maintenance.web.vo.MaintenanceDetailQueryVo;
import com.wavenetframework.boot.common.service.BaseService;
import com.wavenetframework.boot.common.vo.Paging;

/**
 * <pre>
 *  服务类
 * </pre>
 *
 * @author zll
 * @since 2020-03-13
 */
public interface MaintenanceDetailService extends BaseService<MaintenanceDetail> {

    /**
     * 保存
     *
     * @param maintenanceDetail
     * @return
     * @throws Exception
     */
    boolean saveMaintenanceDetail(MaintenanceDetail maintenanceDetail) throws Exception;

    /**
     * 修改
     *
     * @param maintenanceDetail
     * @return
     * @throws Exception
     */
    boolean updateMaintenanceDetail(MaintenanceDetail maintenanceDetail) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteMaintenanceDetail(String id) throws Exception;

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    MaintenanceDetailQueryVo getMaintenanceDetailById(Serializable id) throws Exception;

    /**
     * 获取分页对象
     *
     * @param maintenanceDetailQueryParam
     * @return
     * @throws Exception
     */
    Paging<MaintenanceDetailQueryVo> getMaintenanceDetailPageList(MaintenanceDetailQueryParam maintenanceDetailQueryParam) throws Exception;


    /**
     * 根据roadCode，年月获取查询对象
     *
     * @param maintenanceDetailQueryParam
     * @return
     * @throws Exception
     */
    MaintenanceDetailQueryVo getMaintenanceDetail(MaintenanceDetailQueryParam maintenanceDetailQueryParam) throws Exception;
}
