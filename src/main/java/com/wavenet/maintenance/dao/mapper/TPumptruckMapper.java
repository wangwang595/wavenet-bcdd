package com.wavenet.maintenance.dao.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wavenet.maintenance.dao.entity.MaintenanceDetail;
import com.wavenet.maintenance.dao.entity.TPumptruck;
import com.wavenet.maintenance.dao.entity.TZaiqingInfo;
import com.wavenet.maintenance.web.query.ShiQuVoQueryParm;
import com.wavenet.maintenance.web.query.TPumptruckQueryParam;
import com.wavenet.maintenance.web.vo.PumptruckAllInfoVo;

import com.wavenet.maintenance.web.vo.TPumptruckControlhisQueryVo;
import com.wavenet.maintenance.web.vo.TPumptruckControlhisQueryVos;
import com.wavenet.maintenance.web.vo.TPumptruckQueryVo;
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
 * @since 2020-05-10
 */
@Repository
public interface TPumptruckMapper extends BaseMapper<TPumptruck> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    TPumptruckQueryVo getTPumptruckById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param tPumptruckQueryParam
     * @return
     */
    IPage<TPumptruckQueryVo> getTPumptruckPageList(@Param("page") Page page, @Param("param") TPumptruckQueryParam tPumptruckQueryParam);


    List<String> getshijikongxian ();


    List<PumptruckAllInfoVo> getPumptruckAllInfo(@Param ("sPtId") String sPtId);


    List<TPumptruckControlhisQueryVos> historicalTrack(@Param("sPtId") String sPtId, @Param("startTime")String startTime, @Param("endTime")String endTime
            , @Param("name")String name);

    List<TPumptruckControlhisQueryVo> pumpTruckTrajectory(@Param("id")String id);

    List<TZaiqingInfo> riskManagement(String city, Integer dispatch, Integer seal, Integer source, Integer category, String startTime, String endTime);


    List<TPumptruckControlhisQueryVos> nowlTrack(@Param("sPtId") String sPtId, @Param("startTime")String startTime, @Param("endTime")String endTime
            , @Param("sId")String sId);


}