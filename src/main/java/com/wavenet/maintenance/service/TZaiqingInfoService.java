package com.wavenet.maintenance.service;

import com.wavenet.maintenance.dao.entity.TDispatch;
import com.wavenet.maintenance.dao.entity.TZaiqingInfo;
import com.wavenet.maintenance.web.query.TZaiqingQueryParam;
import com.wavenet.maintenance.web.query.TZaiqingsQueryParam;
import com.wavenet.maintenance.web.vo.*;
import com.wavenetframework.boot.common.service.BaseService;
import com.wavenet.maintenance.web.query.TZaiqingInfoQueryParam;
import com.wavenetframework.boot.common.vo.Paging;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 * 险情信息表 服务类
 * </pre>
 *
 * @author zll
 * @since 2020-05-11
 */
public interface TZaiqingInfoService extends BaseService<TZaiqingInfo> {

    /**
     * 保存
     *
     * @param tZaiqingInfo
     * @return
     * @throws Exception
     */
    boolean saveTZaiqingInfo(TZaiqingInfo tZaiqingInfo) throws Exception;

    /**
     * 修改
     *
     * @param tZaiqingInfo
     * @return
     * @throws Exception
     */
    boolean updateTZaiqingInfo(TZaiqingInfo tZaiqingInfo) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteTZaiqingInfo(Long id) throws Exception;

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    TZaiqingInfoQueryVo getTZaiqingInfoById(Serializable id) throws Exception;

    /**
     * 获取分页对象
     *
     * @param tZaiqingInfoQueryParam
     * @return
     * @throws Exception
     */
    Paging<TZaiqingInfoQueryVo> getTZaiqingInfoPageList(TZaiqingInfoQueryParam tZaiqingInfoQueryParam) throws Exception;

    //关闭派单
    boolean closeById(String id) throws Exception;

    Integer  getNumberById(String id) throws Exception;

    boolean updateTZaiqingInfo(TZaiqingQueryParam tZaiqingQueryParam) throws Exception;

    List<TZaiqingTpQueryVo> getDisaster(String city, Integer id) throws Exception;

    //List<TZaiqingTpQueryVo> getbengchetujicha(String shiqu, Integer id, String cheleiing) throws Exception;

    List<String> getCityInfo() throws Exception;

    List<String> gerPumptrukType()throws Exception;


    List<PumptruckAllInfoVo> getPumptrukInfo(String city, String puckType, Integer type, Integer number, Integer zaiType, String sId)throws Exception;

    Boolean updateXian(TDispatch tDispatch) throws Exception;

    List<TZaiqingInfoQueryVoS> tDispatchInfo(String id) throws  Exception;


    List<TZaiqingInfoQueryVoS> getZaiInfo(String city, String danger, String startTime, String endTime, BigDecimal startLength, BigDecimal endLength,String id) throws Exception;

    List<VYjxxQueryVo> selectEarlyInfo() throws  Exception;

    boolean senyPaiDanByCar(TZaiqingsQueryParam tZaiqingsQueryParam) throws Exception;


    Map<String, Integer> getCarState( ) throws  Exception;




    Map<String, Integer> getCarStateInfoCity() throws  Exception;



    //泵车待派单
    Map<String, List<TZaiqingInfoQueryVoCdValue>> getCarRescue() throws  Exception;
    //泵车返回的任务执行还有已完成
    Map<String, List<TZaiqingInfoQueryVoCdValue>> getCarRescueTo();

    //市区待派单
    Map<String, List<TZaiqingInfoQueryVoCdValue>> getDispatch()  throws  Exception ;
    //市区返回的任务执行还有已完成
    Map<String, List<TZaiqingInfoQueryVoCdValue>> getDispatcTo();

    //区待派单
    Map<String,List<TZaiqingInfoQueryVoCdValue>> getDispatchByCity(String city) throws  Exception;
    //区返回的任务执行还有已完成
    Map<String, List<TZaiqingInfoQueryVoCdValue>> getDispatchByCityTo(String city);




    Map<String, List<TZaiqingInfoQueryVoCdValue>> totalDistricts();

    Map<String, List<TZaiqingInfoQueryVoCdValue>> totalDistrictsCity();

    Map<String, List<TZaiqingInfoQueryVoCdValue>> totalDistrictsWhole();

    List<TDispatchQueryVoCdValueSpz> getRenWuInfoById(String id) throws  Exception;

}

