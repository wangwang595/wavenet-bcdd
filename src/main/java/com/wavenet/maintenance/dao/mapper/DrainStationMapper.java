package com.wavenet.maintenance.dao.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wavenet.maintenance.dao.entity.DrainStation;
import com.wavenet.maintenance.dao.entity.MaintenanceDetail;
import com.wavenet.maintenance.web.query.DrainStationQueryParam;
import com.wavenet.maintenance.web.vo.DrainStationQueryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 *  Mapper 接口
 * </pre>
 *
 * @author zll
 * @since 2020-05-06
 */
@Repository
public interface DrainStationMapper extends BaseMapper<DrainStation> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    DrainStationQueryVo getDrainStationById(Serializable id);

    /**
     * 根据雨量站id查询
     */
      List<DrainStationQueryVo> selectDrainById(@Param("stStationid") String stStationid) ;

    /**
     * 获取分页对象
     *
     * @param page
     * @param drainStationQueryParam
     * @return
     */
    IPage<DrainStationQueryVo> getDrainStationPageList(@Param("page") Page page, @Param("param") DrainStationQueryParam drainStationQueryParam);

}
