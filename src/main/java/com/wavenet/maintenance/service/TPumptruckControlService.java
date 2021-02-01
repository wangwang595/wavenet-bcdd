package com.wavenet.maintenance.service;

import com.wavenet.maintenance.dao.entity.TPumptruckControl;
import com.wavenetframework.boot.common.service.BaseService;
import com.wavenet.maintenance.web.query.TPumptruckControlQueryParam;
import com.wavenet.maintenance.web.vo.TPumptruckControlQueryVo;
import com.wavenetframework.boot.common.vo.Paging;

import java.io.Serializable;

/**
 * <pre>
 * 泵车状态表 服务类
 * </pre>
 *
 * @author zll
 * @since 2020-05-10
 */
public interface TPumptruckControlService extends BaseService<TPumptruckControl> {

    /**
     * 保存
     *
     * @param tPumptruckControl
     * @return
     * @throws Exception
     */
    boolean saveTPumptruckControl(TPumptruckControl tPumptruckControl) throws Exception;

    /**
     * 修改
     *
     * @param tPumptruckControl
     * @return
     * @throws Exception
     */
    boolean updateTPumptruckControl(TPumptruckControl tPumptruckControl) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteTPumptruckControl(Long id) throws Exception;

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    TPumptruckControlQueryVo getTPumptruckControlById(Serializable id) throws Exception;

    /**
     * 获取分页对象
     *
     * @param tPumptruckControlQueryParam
     * @return
     * @throws Exception
     */
    Paging<TPumptruckControlQueryVo> getTPumptruckControlPageList(TPumptruckControlQueryParam tPumptruckControlQueryParam) throws Exception;

}
