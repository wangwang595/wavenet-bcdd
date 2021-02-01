package com.wavenet.maintenance.service.impl;


import com.wavenet.maintenance.dao.entity.TDispatch;
import com.wavenet.maintenance.dao.entity.TZaiqingInfo;
import com.wavenet.maintenance.dao.mapper.TDictianoryMapper;
import com.wavenet.maintenance.dao.mapper.TDispatchMapper;
import com.wavenet.maintenance.dao.mapper.TPumptruckControlMapper;
import com.wavenet.maintenance.dao.mapper.TZaiqingInfoMapper;
import com.wavenet.maintenance.service.PumpInfoService;
import com.wavenet.maintenance.service.TZaiqingInfoService;
import com.wavenet.maintenance.web.query.TZaiqingInfoQueryParam;
import com.wavenet.maintenance.web.query.TZaiqingQueryParam;

import com.wavenet.maintenance.web.query.TZaiqingsQueryParam;
import com.wavenet.maintenance.web.vo.*;
import com.wavenetframework.boot.common.service.impl.BaseServiceImpl;
import com.wavenetframework.boot.common.vo.Paging;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;


/**
 * <pre>
 * 险情信息表 服务实现类
 * </pre>
 *
 * @author zll
 * @since 2020-05-11
 */
@Slf4j
@Service
public class TZaiqingInfoServiceImpl extends BaseServiceImpl<TZaiqingInfoMapper, TZaiqingInfo> implements TZaiqingInfoService {

    @Autowired
    private TZaiqingInfoMapper tZaiqingInfoMapper;
    @Autowired
    private TDispatchMapper tDispatchMapper;
    @Autowired
    private TDictianoryMapper tDictianoryMapper;
    @Autowired
    private TDispatchServiceImpl tDispatchService;
    @Autowired
    private PumpInfoService pumpInfoService;


    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveTZaiqingInfo(TZaiqingInfo tZaiqingInfo) throws Exception {
        return super.save(tZaiqingInfo);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateTZaiqingInfo(TZaiqingInfo tZaiqingInfo) throws Exception {
        return super.updateById(tZaiqingInfo);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteTZaiqingInfo(Long id) throws Exception {
        return super.removeById(id);
    }

    @Override
    public TZaiqingInfoQueryVo getTZaiqingInfoById(Serializable id) throws Exception {
        return tZaiqingInfoMapper.getTZaiqingInfoById(id);
    }

    @Override
    public Paging<TZaiqingInfoQueryVo> getTZaiqingInfoPageList(TZaiqingInfoQueryParam tZaiqingInfoQueryParam) throws Exception {
        Page page = setPageParam(tZaiqingInfoQueryParam, OrderItem.desc("create_time"));
        IPage<TZaiqingInfoQueryVo> iPage = tZaiqingInfoMapper.getTZaiqingInfoPageList(page, tZaiqingInfoQueryParam);
        return new Paging(iPage);
    }

    //关闭单子
    @Override
    public boolean closeById(String id) throws Exception {
        Integer integer = tZaiqingInfoMapper.closeById(id);
        System.out.println(integer);

        if (integer==null){
            return false ;
        }else if (integer==0){
            return  false;
        }else {
            return  true;
        }


    }

    //获得派车的数量
    @Override
    public Integer getNumberById(String id) throws Exception {
        return tZaiqingInfoMapper.getNumberById(id);
    }


    //任务详情表进行信息插入
    @Override
    public boolean updateTZaiqingInfo(TZaiqingQueryParam tZaiqingQueryParam) throws Exception {
        String sId = tZaiqingQueryParam.getSId();
        //灾情表的所有信息
        TZaiqingInfoQueryVo  tZaiqingInfoQueryVo=tZaiqingInfoMapper.selectyId(sId);
        //修改派单状态
        tZaiqingInfoMapper.updataBysId(sId);
        //获取灾情表里的信息
        String sName = tZaiqingInfoQueryVo.getSName();//灾情名称
        String sDeptid = tZaiqingInfoQueryVo.getSDeptid();//所属区
        String sAdd = tZaiqingInfoQueryVo.getSAdd();//地址
        BigDecimal nValue = tZaiqingInfoQueryVo.getNValue();//积水深度
        Date tPublishTime = tZaiqingInfoQueryVo.getTPublishTime();//发布时间
        String sPublisher = tZaiqingInfoQueryVo.getSPublisher();//发布人
        BigDecimal nSource = tZaiqingInfoQueryVo.getNSource();//灾情来源
        String sType = tZaiqingInfoQueryVo.getSType();//灾情类别
        BigDecimal nsx = tZaiqingInfoQueryVo.getNSX();//灾情位置X
        BigDecimal nsy = tZaiqingInfoQueryVo.getNSY();//灾情位置Y
        BigDecimal nIsclose = tZaiqingInfoQueryVo.getNIsclose();//是否封交
        BigDecimal nCancel = tZaiqingInfoQueryVo.getNCancel();//是否关闭
        BigDecimal nPaidan = tZaiqingInfoQueryVo.getNPaidan();//是否派单
        BigDecimal nZhiyuan = tZaiqingInfoQueryVo.getNZhiyuan();//是否支援
        String sBz = tZaiqingInfoQueryVo.getSBz();//备注
        BigDecimal nPbX = tZaiqingInfoQueryVo.getNPbX();//灾情百度位置X
        BigDecimal nPbY = tZaiqingInfoQueryVo.getNPbY();//
        String sCancelper = tZaiqingInfoQueryVo.getSCancelper();//关闭人
        Date tCanceltime = tZaiqingInfoQueryVo.getTCanceltime();//关闭时间
        String sLxr = tZaiqingInfoQueryVo.getSLxr();//现场联系人
        String sLxdh = tZaiqingInfoQueryVo.getSLxdh();//现场联系人电话
        BigDecimal nComplete = tZaiqingInfoQueryVo.getNComplete();//是否处置完成0--未完成；1--已完成
        //根据sid进行查询 结果tZaiqingInfoQueryVo放入底下的结果集
        List<String> sPzList = tZaiqingQueryParam.getSPz();
        Boolean save = new Boolean(false);
        for (int i = 0; i <sPzList.size() ; i++) {
            String spz = sPzList.get(i);//根据车牌号进行查询数据放到任务表里面
            TzaiInfoVo tzaiInfoVo=tZaiqingInfoMapper.getTzziInfo(spz);
            String sPtId = tzaiInfoVo.getSPtId();
            Integer integer=tZaiqingInfoMapper.getTuJiSum(sPtId);
            //在信息表里面进行存储
            TDispatch tDispatch = new TDispatch();
           // String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            tDispatch.setSZaiqingId(sId);
            tDispatch.setSName(sName);
            tDispatch.setSDescribe(sName+"积水"+nValue+"深度");
            tDispatch.setSCity("上海市");
            tDispatch.setSAddress(sAdd);
            tDispatch.setSArea(sDeptid);
            tDispatch.setNX(nsx);
            tDispatch.setNY(nsy);
            Date date = new Date();
            tDispatch.setTStime(date);
            tDispatch.setSPername(sPublisher);
            tDispatch.setSContacts(sLxr);
            tDispatch.setSContactphone(sLxdh);
            BigDecimal bigDecimal1 = new BigDecimal(1);
            tDispatch.setNEmergent(bigDecimal1);
            BigDecimal bigDecimal2 = new BigDecimal(2);
            tDispatch.setNResult(bigDecimal2);
            tDispatch.setNState(bigDecimal2);
            tDispatch.setSType(sType);
            tDispatch.setTUpdatetime(date);
            tDispatch.setNPbX(nPbX);
            tDispatch.setNPbY(nPbY);
            tDispatch.setSBz(sBz);
            //tDispatch.setSSource("swj");
            tDispatch.setSCharge(tzaiInfoVo.getSPtContacts());//负责人
            tDispatch.setSChargephone(tzaiInfoVo.getSPtContactphone()); //负责电话
            tDispatch.setSPtId(tzaiInfoVo.getSPtId());//车id
            BigDecimal bigDecimal4 = new BigDecimal(integer);
            tDispatch.setNRenshu(bigDecimal4); //人数
            tDispatch.setNPsl(tzaiInfoVo.getSPtFlow()); //排水量
            save = tDispatchService.save(tDispatch);
        }
          return save;


      }


      //获得下拉联动列表的信息
    @Override
    public List<TZaiqingTpQueryVo> getDisaster(String city, Integer id) throws Exception {

        //当车的状态没有进行选择的时候
        if (id == null) {  //全部
            List<TZaiqingTpQueryVo> lists = tZaiqingInfoMapper.getAllInfo(city, id);
            return lists;
        } else if (id == 1) { //集结
            List<TZaiqingTpQueryVo> lists = tZaiqingInfoMapper.getAggregation(city, id);
            id=4;
            List<TZaiqingTpQueryVo> lists1 = tZaiqingInfoMapper.getFree(city, id);
            lists.addAll(lists1);
            return lists;
        } else if (id == 2) { //保障
            List<TZaiqingTpQueryVo> lists = tZaiqingInfoMapper.getGuarantee(city, id);
            //还要进行一个筛选
            return lists;
        } else if (id == 3) {  //执行
            List<TZaiqingTpQueryVo> lists = tZaiqingInfoMapper.getImplement(city, id);
            return lists;
        }else{
            return null;

        }
    }

    //市区列表
    @Override
    public List<String> getCityInfo() throws Exception {

        String stype="泵车区县";
        List<String> cityList=tDictianoryMapper.getCityInfo(stype);


        return cityList;
    }
    //泵车区县 泵车分类s
    //泵车类型
    @Override
    public List<String> gerPumptrukType() throws Exception {
        String stype="泵车分类";
        List<String> strings = tDictianoryMapper.gerPumptrukType(stype);
        return  strings;

    }


    //条件判断进行查询
    @Override
    public List<PumptruckAllInfoVo> getPumptrukInfo(String city, String puckType, Integer type, Integer number, Integer zaiType, String sId) throws Exception {
        String sType= "";

        //number为最合适字段 当为0的时候为最近距离返回全部的数据
        if(number==0) {
            sType = "";
            //当不为空的时候根据灾难类型来判断sType 为什么
        }else if (zaiType==1){
            sType = "N_XLj";
        }else if(zaiType==2){
            //道路
            sType = "N_DL";

        }else if(zaiType==3){
            //小区
            sType = "N_XQ";

        }else if(zaiType==4){
            //底下车库
            sType = "N_DXCK";

        }else if(zaiType==5){
            //地铁车站
            sType = "N_DTCZ";

        }else if(zaiType==6){
            //6 地道隧道N_DDSD
            sType = "N_DDSD";

        }else if (zaiType==7){
            //7 排水系统缺失N_PSXTQS
            sType = "N_PSXTQS";
        }else if (zaiType==8){
            //8 泵用排水能力不足  N_BZPSDLBZ
            sType = "N_BZPSDLBZ";
        }else {
            return  null;
        }

        //根据车的状态进行判断
        if(type==null){  //全部
           List<PumptruckAllInfoVo> lists =tZaiqingInfoMapper.getAllInfoS(city, puckType,sType,sId);
            return lists;

        }else if (type==1){ //集结 空闲
            List<PumptruckAllInfoVo> lists =tZaiqingInfoMapper.getAggregationS(city, puckType,sType,sId);
             type=4;
            List<PumptruckAllInfoVo> lists1 =tZaiqingInfoMapper.getFreeS(city, puckType,sType,sId);
            lists.addAll(lists1);
            return lists;

        }else if (type==2){ //保障
            List<PumptruckAllInfoVo> lists =tZaiqingInfoMapper.getGuaranteeS(city, puckType,sType,sId);
            //还要进行一个筛选
            return lists;

        }else if (type==3){  //执行
            List<PumptruckAllInfoVo> lists =tZaiqingInfoMapper.getImplementS(city, puckType,sType,sId);
            return lists;

        } else{

            return null;
        }



    }

    //修海险情信息
    @Override
    public Boolean updateXian(TDispatch tDispatch) throws  Exception{
        Boolean b = tDispatchService.updateTDispatch(tDispatch);

        return b;
    }

    //险情信息
    @Override
    public List<TZaiqingInfoQueryVoS> tDispatchInfo(String id) throws Exception {

        List<TZaiqingInfoQueryVoS>  DispatchInfo= tDispatchMapper.tDispatchInfo(id);

        return DispatchInfo;
    }

    //多条件进行查询灾情信息
    @Override
    public List<TZaiqingInfoQueryVoS> getZaiInfo(String city, String danger, String startTime, String endTime, BigDecimal startLength, BigDecimal endLength,String id) throws Exception {

        List<TZaiqingInfoQueryVoS> tDispatchQueryVos=tZaiqingInfoMapper.getZaiInfo(city,danger,startTime,endTime,startLength,endLength,id);

        return tDispatchQueryVos;
    }

    //预警信息
    @Override
    public List<VYjxxQueryVo> selectEarlyInfo() throws Exception {
        List<VYjxxQueryVo>  vYjxxQueryVos= tZaiqingInfoMapper.selectEarlyInfo();

        return vYjxxQueryVos;
    }

    //进行派单
    @Override
    public boolean senyPaiDanByCar(TZaiqingsQueryParam tZaiqingsQueryParam) throws Exception {
        String sId = tZaiqingsQueryParam.getSId();
        //灾情表的所有信息
        TZaiqingInfoQueryVo  tZaiqingInfoQueryVo=tZaiqingInfoMapper.selectyId(sId);
        tZaiqingInfoMapper.updataBysId(sId);
        String sName = tZaiqingInfoQueryVo.getSName();//灾情名称
        String sDeptid = tZaiqingInfoQueryVo.getSDeptid();//所属区
        String sAdd = tZaiqingInfoQueryVo.getSAdd();//地址
        BigDecimal nValue = tZaiqingInfoQueryVo.getNValue();//积水深度
        Date tPublishTime = tZaiqingInfoQueryVo.getTPublishTime();//发布时间
        String sPublisher = tZaiqingInfoQueryVo.getSPublisher();//发布人
        BigDecimal nSource = tZaiqingInfoQueryVo.getNSource();//灾情来源
        String sType = tZaiqingInfoQueryVo.getSType();//灾情类别
        BigDecimal nsx = tZaiqingInfoQueryVo.getNSX();//灾情位置X
        BigDecimal nsy = tZaiqingInfoQueryVo.getNSY();//灾情位置Y
        BigDecimal nIsclose = tZaiqingInfoQueryVo.getNIsclose();//是否封交
        BigDecimal nCancel = tZaiqingInfoQueryVo.getNCancel();//是否关闭
        BigDecimal nPaidan = tZaiqingInfoQueryVo.getNPaidan();//是否派单
        BigDecimal nZhiyuan = tZaiqingInfoQueryVo.getNZhiyuan();//是否支援
        String sBz = tZaiqingInfoQueryVo.getSBz();//备注
        BigDecimal nPbX = tZaiqingInfoQueryVo.getNPbX();//灾情百度位置X
        BigDecimal nPbY = tZaiqingInfoQueryVo.getNPbY();//
        String sCancelper = tZaiqingInfoQueryVo.getSCancelper();//关闭人
        Date tCanceltime = tZaiqingInfoQueryVo.getTCanceltime();//关闭时间
        String sLxr = tZaiqingInfoQueryVo.getSLxr();//现场联系人
        String sLxdh = tZaiqingInfoQueryVo.getSLxdh();//现场联系人电话
        BigDecimal nComplete = tZaiqingInfoQueryVo.getNComplete();//是否处置完成0--未完成；1--已完成
        //根据sid进行查询 结果tZaiqingInfoQueryVo放入底下的结果集
        String sPz = tZaiqingsQueryParam.getSPz();
        Boolean save = new Boolean(false);

            TzaiInfoVo tzaiInfoVo=tZaiqingInfoMapper.getTzziInfo(sPz);
            String sPtId = tzaiInfoVo.getSPtId();
            Integer integer=tZaiqingInfoMapper.getTuJiSum(sPtId);
            //在信息表里面进行存储

            TDispatch tDispatch = new TDispatch();
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            // tDispatch.setSId(uuid);
            tDispatch.setSZaiqingId(sId);
            tDispatch.setSName(sName);
            tDispatch.setSDescribe(sName+"积水"+nValue+"深度");
            tDispatch.setSCity("上海市");
            tDispatch.setSAddress(sAdd);
            tDispatch.setSArea(sDeptid);
            tDispatch.setNX(nsx);
            tDispatch.setNY(nsy);
            Date date = new Date();
            tDispatch.setTStime(date);
            tDispatch.setSPername(sPublisher);
            tDispatch.setSContacts(sLxr);
            tDispatch.setSContactphone(sLxdh);
            BigDecimal bigDecimal1 = new BigDecimal(1);
            tDispatch.setNEmergent(bigDecimal1);
            BigDecimal bigDecimal2 = new BigDecimal(2);
            tDispatch.setNResult(bigDecimal2);
            tDispatch.setNState(bigDecimal2);
            tDispatch.setSType(sType);
            tDispatch.setTUpdatetime(date);
            tDispatch.setNPbX(nPbX);
            tDispatch.setNPbY(nPbY);
            tDispatch.setSBz(sBz);

            tDispatch.setSCharge(tzaiInfoVo.getSPtContacts());//负责人
            tDispatch.setSChargephone(tzaiInfoVo.getSPtContactphone()); //负责电话
            tDispatch.setSPtId(tzaiInfoVo.getSPtId());//车id
            BigDecimal bigDecimal4 = new BigDecimal(integer);
            tDispatch.setNRenshu(bigDecimal4); //人数
            tDispatch.setNPsl(tzaiInfoVo.getSPtFlow()); //排水量
            save = tDispatchService.save(tDispatch);

        return save;

    }


    @Override
    public Map<String, Integer>getCarState( ) throws Exception {
        String city="";
        List<Integer> lists = pumpInfoService.getshijishuliang(city);

        Map<String, Integer> stringIntegerHashMap = new HashMap<>();
        //集结 任务执行 驻点保障
        stringIntegerHashMap.put("jjdm",lists.get(0));
        stringIntegerHashMap.put("rwzx",lists.get(1));
        stringIntegerHashMap.put("zdbz",lists.get(2));
        return stringIntegerHashMap;
    }



    @Override
    public Map<String, Integer> getCarStateInfoCity() throws Exception {
        CountByCarVoS countByCarVoS=tZaiqingInfoMapper.getCarStateInfoCity();
        Integer jjdm = countByCarVoS.getJjdm();
        Integer rwzx = countByCarVoS.getRwzx();
        Integer zdbz = countByCarVoS.getZdbz();
        Map<String, Integer> stringIntegerHashMap = new HashMap<>();
        stringIntegerHashMap.put("jjdm",jjdm);
        stringIntegerHashMap.put("rwzx",rwzx);
        stringIntegerHashMap.put("zdbz",zdbz);


        return stringIntegerHashMap;
    }

    //各区调度情况
    @Override
    public Map<String ,List<TZaiqingInfoQueryVoCdValue>> getDispatchByCity(String city) throws Exception {


        List<TZaiqingInfoQueryVoCdValue>  integer=tZaiqingInfoMapper.getDispatcByCity(city);
        // 调度情况  待派单  处理中 已完成

        Map<String, List<TZaiqingInfoQueryVoCdValue>> stringIntegerHashMap = new HashMap<>();
        stringIntegerHashMap.put("integer",integer);

        return stringIntegerHashMap;
    }


    @Override
    public Map<String, List<TZaiqingInfoQueryVoCdValue>> getDispatchByCityTo(String city) {
        List<TZaiqingInfoQueryVoCdValue>  rwzx= tZaiqingInfoMapper.getDispatchDoByCity(city);
        List<TZaiqingInfoQueryVoCdValue>  rwwc=tZaiqingInfoMapper.getDispatchCloseByCity(city);
        Map<String, List<TZaiqingInfoQueryVoCdValue>> stringIntegerHashMap = new HashMap<>();
        // 调度情况    处理中 已完成
        stringIntegerHashMap.put("rwzx",rwzx);
        stringIntegerHashMap.put("rwwc",rwwc);
        return stringIntegerHashMap;
    }

    //所有的信息
    @Override
    public Map<String, List<TZaiqingInfoQueryVoCdValue>> totalDistricts() {

        Map<String, List<TZaiqingInfoQueryVoCdValue>> stringIntegerHashMap = new HashMap<>();
       List<TZaiqingInfoQueryVoCdValue> lists = new ArrayList<TZaiqingInfoQueryVoCdValue>();
        String city="";
        List<TZaiqingInfoQueryVoCdValue>  integer=tZaiqingInfoMapper.getDispatcByCity(city);
        List<TZaiqingInfoQueryVoCdValue>  rwzx= tZaiqingInfoMapper.getDispatchDoByCity(city);
        List<TZaiqingInfoQueryVoCdValue>  rwwc=tZaiqingInfoMapper.getDispatchCloseByCity(city);
        lists.addAll(integer);
        lists.addAll(rwwc);
        lists.addAll(rwzx);
        stringIntegerHashMap.put("integer",lists);
//        stringIntegerHashMap.put("integer",rwzx);
//        stringIntegerHashMap.put("integer",rwwc);

        return stringIntegerHashMap;
    }





    @Override
    public Map<String, List<TZaiqingInfoQueryVoCdValue>> getDispatch() throws Exception {
        //市级调度情况 待派单
        List<TZaiqingInfoQueryVoCdValue>  integer=tZaiqingInfoMapper.getDispatch();

        Map<String, List<TZaiqingInfoQueryVoCdValue>> stringIntegerHashMap = new HashMap<>();
        stringIntegerHashMap.put("integer",integer);

        return stringIntegerHashMap;
    }
    @Override
    public Map<String, List<TZaiqingInfoQueryVoCdValue>> getDispatcTo() {
        // 调度情况  处理中 已完成
        List<TZaiqingInfoQueryVoCdValue>  rwzx= tZaiqingInfoMapper.getDispatchDo();
        List<TZaiqingInfoQueryVoCdValue>  rwwc=tZaiqingInfoMapper.getDispatchClose();

        Map<String, List<TZaiqingInfoQueryVoCdValue>> stringIntegerHashMap = new HashMap<>();

        stringIntegerHashMap.put("rwzx",rwzx);
        stringIntegerHashMap.put("rwwc",rwwc);
        return stringIntegerHashMap;
    }

    @Override
    public Map<String, List<TZaiqingInfoQueryVoCdValue>> totalDistrictsCity() {

        List<TZaiqingInfoQueryVoCdValue>  integer=tZaiqingInfoMapper.getDispatch();
        List<TZaiqingInfoQueryVoCdValue>  rwzx= tZaiqingInfoMapper.getDispatchDo();
        List<TZaiqingInfoQueryVoCdValue>  rwwc=tZaiqingInfoMapper.getDispatchClose();
        List<TZaiqingInfoQueryVoCdValue> lists = new ArrayList<TZaiqingInfoQueryVoCdValue>();
        Map<String, List<TZaiqingInfoQueryVoCdValue>> stringIntegerHashMap = new HashMap<>();
        lists.addAll(integer);
        lists.addAll(rwzx);
        lists.addAll(rwwc);
        stringIntegerHashMap.put("integer",lists);
//        stringIntegerHashMap.put("integer",rwzx);
//        stringIntegerHashMap.put("integer",rwwc);

        return stringIntegerHashMap;

    }




    //全部的调度情况以派单
    @Override
    public Map<String, List<TZaiqingInfoQueryVoCdValue>> getCarRescue() throws Exception {
        List<TZaiqingInfoQueryVoCdValue>  integer=tZaiqingInfoMapper.getCarRescue();


        Map<String, List<TZaiqingInfoQueryVoCdValue>> stringIntegerHashMap = new HashMap<>();
        stringIntegerHashMap.put("integer",integer);

        return stringIntegerHashMap;

    }
    @Override
    public Map<String, List<TZaiqingInfoQueryVoCdValue>> getCarRescueTo() {
        // 调度情况  处理中 已完成
        List<TZaiqingInfoQueryVoCdValue>  rwzx= tZaiqingInfoMapper.getCarRescueDo();
        List<TZaiqingInfoQueryVoCdValue>  rwwc=tZaiqingInfoMapper.getDispatchcomplete();
        Map<String,  List<TZaiqingInfoQueryVoCdValue>> stringIntegerHashMap = new HashMap<>();
        stringIntegerHashMap.put("rwzx",rwzx);
         stringIntegerHashMap.put("rwwc",rwwc);

        return stringIntegerHashMap;
    }
    @Override
    public Map<String, List<TZaiqingInfoQueryVoCdValue>> totalDistrictsWhole() {

        List<TZaiqingInfoQueryVoCdValue>  integer=tZaiqingInfoMapper.getCarRescue();
        List<TZaiqingInfoQueryVoCdValue>  rwzx= tZaiqingInfoMapper.getCarRescueDo();
        List<TZaiqingInfoQueryVoCdValue>  rwwc=tZaiqingInfoMapper.getDispatchcomplete();
        List<TZaiqingInfoQueryVoCdValue> lists = new ArrayList<TZaiqingInfoQueryVoCdValue>();
        Map<String, List<TZaiqingInfoQueryVoCdValue>> stringIntegerHashMap = new HashMap<>();
        lists.addAll(integer);
        lists.addAll(rwzx);
        lists.addAll(rwwc);
        stringIntegerHashMap.put("integer",lists);
        return stringIntegerHashMap;
    }
       //获取任务信息
    public List<TDispatchQueryVoCdValueSpz> getRenWuInfoById(String id) throws Exception {
        List<TDispatchQueryVoCdValueSpz> cityList=tDispatchMapper.getRenWuInfoById(id);
        return cityList;
    }


}
