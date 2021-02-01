package com.wavenet.maintenance.dao.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wavenet.maintenance.dao.entity.TZaiqingInfo;
import com.wavenet.maintenance.web.query.TZaiqingInfoQueryParam;
import com.wavenet.maintenance.web.vo.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * <pre>
 * 险情信息表 Mapper 接口
 * </pre>
 *
 * @author zll
 * @since 2020-05-11
 */
@Repository
public interface TZaiqingInfoMapper extends BaseMapper<TZaiqingInfo> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    TZaiqingInfoQueryVo getTZaiqingInfoById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param tZaiqingInfoQueryParam
     * @return
     */
    IPage<TZaiqingInfoQueryVo> getTZaiqingInfoPageList(@Param("page") Page page, @Param("param") TZaiqingInfoQueryParam tZaiqingInfoQueryParam);

    Integer closeById(String id);

    Integer getNumberById(String id);


    List<TZaiqingTpQueryVo> getAllInfo(@Param("city")String city,@Param("id")Integer id);

    List<TZaiqingTpQueryVo> getAggregation(@Param("city")String city,@Param("id")Integer id);

    List<TZaiqingTpQueryVo> getGuarantee(@Param("city")String city,@Param("id")Integer id);

    List<TZaiqingTpQueryVo> getImplement(@Param("city")String city,@Param("id")Integer id);

    List<TZaiqingTpQueryVo> getFree(@Param("city")String city,@Param("id")Integer id);

    //查询灾难详情信息
    TZaiqingInfoQueryVo selectyId(@Param("sId") String sId);

    //得到突击队人数
    Integer getTuJiSum(@Param("sPtId")String sPtId);

    //查询返回结果集
    TzaiInfoVo getTzziInfo(@Param("spz") String spz);

    //改变派单的状态
    Integer updataBysId(@Param("sId")String sId);

    List<PumptruckAllInfoVo> getAllInfoS(@Param("city") String city, @Param("puckType") String puckType, @Param("sType") String sType, @Param("sId") String sId);

    List<PumptruckAllInfoVo> getAggregationS(@Param("city") String city, @Param("puckType") String puckType, @Param("sType") String sType, @Param("sId") String sId);

    List<PumptruckAllInfoVo> getGuaranteeS(@Param("city") String city, @Param("puckType") String puckType, @Param("sType") String sType, @Param("sId") String sId);

    List<PumptruckAllInfoVo> getImplementS(@Param("city") String city, @Param("puckType") String puckType, @Param("sType") String sType, @Param("sId") String sId);

    List<PumptruckAllInfoVo> getFreeS(@Param("city") String city, @Param("puckType") String puckType, @Param("sType") String sType, @Param("sId") String sId);

    List<VYjxxQueryVo> selectEarlyInfo();

    List<TZaiqingInfoQueryVoS> getZaiInfo(@Param("city")String city, @Param("danger")String danger, @Param("startTime")String startTime, @Param("endTime")String endTime, @Param("startLength")BigDecimal startLength,
                                         @Param("endLength")BigDecimal endLength,@Param("id")String id);

    List<String> disasterCome();

    List<TZaiqingInfoQueryVoCon> selectBySearch(@Param("crux") String crux) throws Exception;



    SwrnQueryVo getDispatchs();

    List<CountByCarVo> getCountByCar();


    CountByCarVoS getCarStateInfoCity();


    //市级调度情况
    List<TZaiqingInfoQueryVoCdValue> getDispatch();

    List<TZaiqingInfoQueryVoCdValue> getDispatchDo();

    List<TZaiqingInfoQueryVoCdValue> getDispatchClose();


    //各区调度情况
    List<TZaiqingInfoQueryVoCdValue>  getDispatcByCity(@Param("city") String city);

    List<TZaiqingInfoQueryVoCdValue>  getDispatchDoByCity(@Param("city")String city);

    List<TZaiqingInfoQueryVoCdValue>   getDispatchCloseByCity(@Param("city")String city);


    //全部调度情况
    List<TZaiqingInfoQueryVoCdValue> getCarRescue();

    List<TZaiqingInfoQueryVoCdValue> getCarRescueDo();

    List<TZaiqingInfoQueryVoCdValue> getDispatchcomplete();


    //获取视频
    List<String> getVideoById(@Param("id")String id);

    List<String> disasterCategory();

    //全部派单
    List<TZaiqingInfoQueryVoCon>  selectByDisaster();

    //市区派单
    List<TZaiqingInfoQueryVoCon> selectByDisasterCity();

    List<TZaiqingInfoQueryVoCon> selectByDisasterArea(@Param("city") String city);

    List<TPumptruckControlQueryVo> Carposition(@Param("id") String id);

    ;
}
