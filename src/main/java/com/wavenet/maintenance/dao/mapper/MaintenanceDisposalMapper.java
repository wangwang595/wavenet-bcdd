package com.wavenet.maintenance.dao.mapper;

import java.io.Serializable;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wavenet.maintenance.dao.entity.MaintenanceDisposal;
import com.wavenet.maintenance.web.query.MaintenanceDisposalQueryParam;
import com.wavenet.maintenance.web.vo.MaintenanceDisposalQueryVo;

/**
 * <pre>
 *  Mapper 接口
 * </pre>
 *
 * @author zll
 * @since 2020-03-13
 */
@Repository
public interface MaintenanceDisposalMapper extends BaseMapper<MaintenanceDisposal> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    MaintenanceDisposalQueryVo getMaintenanceDisposalById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param maintenanceDisposalQueryParam
     * @return
     */
    IPage<MaintenanceDisposalQueryVo> getMaintenanceDisposalPageList(@Param("page") Page page, @Param("param") MaintenanceDisposalQueryParam maintenanceDisposalQueryParam);

    /**
     * 查询总长度
     */

    Long getLengthCount(@Param("param") MaintenanceDisposalQueryParam maintenanceDisposalQueryParam);


}
