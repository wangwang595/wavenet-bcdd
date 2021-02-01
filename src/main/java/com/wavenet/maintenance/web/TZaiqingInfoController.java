package com.wavenet.maintenance.web;

import cn.hutool.core.exceptions.ValidateException;
import com.wavenet.maintenance.dao.entity.EventDispatch;
import com.wavenet.maintenance.dao.entity.TDispatch;
import com.wavenet.maintenance.dao.entity.TZaiqingInfo;
import com.wavenet.maintenance.dao.mapper.TDispatchMapper;
import com.wavenet.maintenance.dao.mapper.TZaiqingInfoMapper;
import com.wavenet.maintenance.service.TDispatchService;
import com.wavenet.maintenance.service.TZaiqingInfoService;


import com.wavenet.maintenance.web.query.TZaiqingInfoQueryParam;
import com.wavenet.maintenance.web.query.TZaiqingQueryParam;

import com.wavenet.maintenance.web.query.TZaiqingsQueryParam;
import com.wavenet.maintenance.web.vo.*;
import com.wavenetframework.boot.common.api.ApiResult;

import com.wavenetframework.boot.common.controller.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.PaddingScheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

import com.wavenetframework.boot.common.vo.Paging;
import com.wavenetframework.boot.common.param.IdParam;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 * 险情信息表 前端控制器
 * </pre>
 *
 * @author zll
 * @since 2020-05-11
 */
@Slf4j
@RestController
@RequestMapping("/tZaiqingInfo")
@Api(tags = "灾难详情表的信息 ")
public class TZaiqingInfoController extends BaseController {

    @Autowired
    private TZaiqingInfoService tZaiqingInfoService;
    @Autowired
    private TZaiqingInfoMapper tZaiqingInfoMapper;
    @Autowired
    private TDispatchService tdspatchService;
    /**
     * 添加险情信息表
     */
    @PostMapping("/add")
    @RequiresPermissions("t:zaiqing:info:add")
    @ApiOperation(value = "添加TZaiqingInfo对象", notes = "添加险情信息表", response = ApiResult.class)
    public ApiResult<Boolean> addTZaiqingInfo(@Valid @RequestBody TZaiqingInfo tZaiqingInfo) throws Exception {
        boolean flag = tZaiqingInfoService.saveTZaiqingInfo(tZaiqingInfo);
        return ApiResult.result(flag);
    }

    /**
     * 修改险情信息表
     */
    @PostMapping("/update")
    @RequiresPermissions("t:zaiqing:info:update")
    @ApiOperation(value = "修改TZaiqingInfo对象", notes = "修改险情信息表", response = ApiResult.class)
    public ApiResult<Boolean> updateTZaiqingInfo(@Valid @RequestBody TZaiqingInfo tZaiqingInfo) throws Exception {
        boolean flag = tZaiqingInfoService.updateTZaiqingInfo(tZaiqingInfo);
        return ApiResult.result(flag);
    }

    /**
     * 删除险情信息表
     */
    @PostMapping("/delete/{id}")
    @RequiresPermissions("t:zaiqing:info:delete")
    @ApiOperation(value = "删除TZaiqingInfo对象", notes = "删除险情信息表", response = ApiResult.class)
    public ApiResult<Boolean> deleteTZaiqingInfo(@PathVariable("id") Long id) throws Exception {
        boolean flag = tZaiqingInfoService.deleteTZaiqingInfo(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取险情信息表
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("t:zaiqing:info:info")
    @ApiOperation(value = "获取TZaiqingInfo对象详情", notes = "查看险情信息表", response = TZaiqingInfoQueryVo.class)
    public ApiResult<TZaiqingInfoQueryVo> getTZaiqingInfo(@PathVariable("id") Long id) throws Exception {
        TZaiqingInfoQueryVo tZaiqingInfoQueryVo = tZaiqingInfoService.getTZaiqingInfoById(id);
        return ApiResult.ok(tZaiqingInfoQueryVo);
    }

    /**
     * 险情信息表分页列表
     */
    @PostMapping("/getPageList")
    @RequiresPermissions("t:zaiqing:info:page")
    @ApiOperation(value = "获取TZaiqingInfo分页列表", notes = "险情信息表分页列表", response = TZaiqingInfoQueryVo.class)
    public ApiResult<Paging<TZaiqingInfoQueryVo>> getTZaiqingInfoPageList(@Valid @RequestBody TZaiqingInfoQueryParam tZaiqingInfoQueryParam) throws Exception {
        Paging<TZaiqingInfoQueryVo> paging = tZaiqingInfoService.getTZaiqingInfoPageList(tZaiqingInfoQueryParam);
        return ApiResult.ok(paging);
    }



                                        //派单接口

    /**
     * 关闭派单的操作
     */
    @PostMapping ("/closeById")
    //@RequiresPermissions("t:zaiqing:info:update")
    @ApiOperation(value = "关闭险情", notes = "关闭险情", response = ApiResult.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "灾难id",dataType="String")

    })
    public ApiResult<Boolean> closeById( String id) throws Exception {
        boolean b = tZaiqingInfoService.closeById(id);

        return ApiResult.result(b);

    }
    //选择小车进行派单


    @PostMapping("/senyPaiDanByCar")
    // @RequiresPermissions("t:zaiqing:info:update")
    @ApiOperation(value = "选择小车进行派单", notes = "选择小车进行派单操作", response = ApiResult.class)
    public ApiResult<Boolean> senyPaiDanByCar(@RequestBody TZaiqingsQueryParam tZaiqingsQueryParam) throws Exception {

        boolean flag = tZaiqingInfoService.senyPaiDanByCar(tZaiqingsQueryParam);
        return ApiResult.result(flag);
    }
    /**
     * 派单
     */
    @PostMapping("/senyPaiDan")
    // @RequiresPermissions("t:zaiqing:info:update")
    @ApiOperation(value = "进行派单", notes = "进行派单操作", response = ApiResult.class)
    public ApiResult<Boolean> updateTZaiqingInfo(@RequestBody TZaiqingQueryParam tZaiqingQueryParam) throws Exception {

        boolean flag = tZaiqingInfoService.updateTZaiqingInfo(tZaiqingQueryParam);
        return ApiResult.result(flag);
    }
    /**
     * 根据前端的条件进行查询查询前端需要的数据下拉列表联动
     */
    @GetMapping("/getTziInFo")
    //  @RequiresPermissions("t:zaiqing:info:info")
    @ApiOperation(value = "根据前端的条件进行查询下拉列表联动", notes = "根据前端条件进行查询下拉列表联动")
     @ApiImplicitParams({
             @ApiImplicitParam(name = "city",value = "市区",dataType="String"),
             @ApiImplicitParam(name = "id",value = "灾情id",dataType="Integer")
                     })
    public ApiResult<List<TZaiqingTpQueryVo>> getDisaster(String city, Integer id) throws Exception {
        List<TZaiqingTpQueryVo> lists = tZaiqingInfoService.getDisaster(city, id);

        return ApiResult.ok(lists);
    }
    /**
     * 智能调度 进行查询 区 状态   车的类型 这个查询之后还要进行一个筛选
     *
     */
    @GetMapping("/PumptrukInfo")
    //  @RequiresPermissions("t:zaiqing:info:info")
    @ApiOperation(value = "下拉列表进行展示", notes = "根据前端条件进行查询下拉列表进行展示")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "city",value = "市区",dataType="String"),
            @ApiImplicitParam(name = "puckType",value = "泵车来源",dataType="String"),
            @ApiImplicitParam(name = "type",value = "泵车类型",dataType="Integer"),
            @ApiImplicitParam(name = "number",value = "最适合最近距离",dataType="Integer"),
            @ApiImplicitParam(name = "zaiType",value = "灾难类型",dataType="Integer"),
            @ApiImplicitParam(name = "sId",value = "灾难id",dataType="String")
    })       // TZaiqingTpQueryVoS
    public ApiResult<List<PumptruckAllInfoVo>> PumptrukInfo(String city, String puckType, Integer type, Integer number, Integer zaiType, String sId) throws Exception {
        List<PumptruckAllInfoVo> lists = tZaiqingInfoService.getPumptrukInfo(city, puckType, type, number, zaiType, sId);

        return ApiResult.ok(lists);

    }
    /**
     * 派单数量的（灾情表的主键 跟任务表的S_ZAIQING_ID 关联查询数量）
     */
    @GetMapping("/number/{id}")
    //  @RequiresPermissions("t:zaiqing:info:info")
    @ApiOperation(value = "获取派单数量", notes = "获取派单数量")
    @ApiImplicitParam(name = "id",value = "灾情id",dataType="String")
    public ApiResult<Integer> getNumberById(@PathVariable("id") String id) throws Exception {
        Integer shuliang = tZaiqingInfoService.getNumberById(id);
        return ApiResult.ok(shuliang);
    }


                                    //险情的接口

    //关键字搜索险情信息
    @GetMapping("/selectBySearch")
    //  @RequiresPermissions("t:zaiqing:info:info")
    @ApiOperation(value = "关键字搜索险情信息 ", notes = "关键字搜索险情信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "crux",value = "关键字",dataType="String"),

    })
    public ApiResult<List<TZaiqingInfoQueryVoCon>> selectBySearch(String crux) throws Exception {

        List<TZaiqingInfoQueryVoCon> disasterCome = tZaiqingInfoMapper.selectBySearch(crux);
        return ApiResult.ok(disasterCome);
    }

    //灾难位置险情信息

    @GetMapping("/tDispatchInfo")
    //  @RequiresPermissions("t:zaiqing:info:info")
    @ApiOperation(value = "灾难位置险情信息 ", notes = "灾难位置险情信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "灾难id",dataType="String"),

    })
    public ApiResult<List<TZaiqingInfoQueryVoS>> tDispatchInfo(String id) throws Exception {
        List<TZaiqingInfoQueryVoS> DispatchInfo = tZaiqingInfoService.tDispatchInfo(id);

        return ApiResult.ok(DispatchInfo);
    }

    //编辑详情信息
    @PostMapping("/updateXian")
    @ApiOperation(value = "编辑险情信息", notes = "编辑险情信息")
    public ApiResult<Boolean> updateXian(@RequestBody TDispatch tDispatch) throws Exception {
        Boolean flae = tZaiqingInfoService.updateXian(tDispatch);
        return ApiResult.result(flae);
    }


    //下拉框根据条件筛选灾情信息
    @GetMapping("/getZaiInfo")
    @ApiOperation(value = "下拉框根据条件筛选灾情信息", notes = "下拉框根据条件筛选灾情信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "city",value = "市区",dataType="String"),
            @ApiImplicitParam(name = "Danger",value = "灾情来源",dataType="String"),
            @ApiImplicitParam(name = "StartTime",value = "开始时间",dataType="Integer"),
            @ApiImplicitParam(name = "endTime",value = "结束时间",dataType="Integer"),
            @ApiImplicitParam(name = "startLength",value = "开始积水深度",dataType="Integer"),
            @ApiImplicitParam(name = "endLength",value = "结束积水深度",dataType="String"),
            @ApiImplicitParam(name = "id",value = "小车id",dataType="String")
    })
    public ApiResult<List<TZaiqingInfoQueryVoS>> selectEarlyInfo(String city, String Danger, String StartTime, String endTime
            , BigDecimal startLength, BigDecimal endLength,String id) throws Exception {
        // List<TDispatchQueryVo> DispatchInfo=tZaiqingInfoService.tDispatchInfo(id);
        // List<> tZaiqingInfoService.selectEarlyInfo();
        // return ApiResult.ok(DispatchInfo);
        List<TZaiqingInfoQueryVoS> DispatchInfo = tZaiqingInfoService.getZaiInfo(city, Danger, StartTime, endTime, startLength, endLength,id);
        return ApiResult.ok(DispatchInfo);

    }
    //增加险情信息
    @PostMapping("/IncreaseXian")
    @ApiOperation(value = "增加险情信息", notes = "增加险情信息")
    public ApiResult<Boolean> IncreaseXian(@RequestBody TZaiqingInfo tZaiqingInfo) throws Exception {
        Boolean flae = tZaiqingInfoService.save(tZaiqingInfo);
        return ApiResult.result(flae);
    }

    //根据险情id得到小车的位置
    @GetMapping("/Carposition")
    //  @RequiresPermissions("t:zaiqing:info:info")
    @ApiOperation(value = "根据险情id得到小车的位置 ", notes = "根据险情id得到小车的位置")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id" ,value = "险情id",dataType = "String")
    })
    public ApiResult<List<TPumptruckControlQueryVo>> Carposition(String id) throws Exception {

        List<TPumptruckControlQueryVo> carposition = tZaiqingInfoMapper.Carposition(id);
        return ApiResult.ok(carposition);
    }




                                    //第一栏的接口
    //车的状态对应的数量市级
    @GetMapping("/getCarStateInfoCity")
    //  @RequiresPermissions("t:zaiqing:info:info")
    @ApiOperation(value = "市级车的状态对应的数量", notes = "市级车的状态对应的数量")
    public ApiResult<Map<String, Integer>> getCarStateInfoCity() throws Exception {
        Map<String, Integer> carState = tZaiqingInfoService.getCarStateInfoCity();
        return ApiResult.ok(carState);
    }

    //车的状态对应的数量
    @GetMapping("/getCarState")
    //  @RequiresPermissions("t:zaiqing:info:info")
    @ApiOperation(value = "车的状态对应的数量", notes = "车的状态对应的数量")
    public ApiResult<Map<String, Integer>> getCarState() throws Exception {
        Map<String, Integer> carState = tZaiqingInfoService.getCarState();
        return ApiResult.ok(carState);
    }

    //第一栏的接口
    //各区泵车状态
    @GetMapping("/getCountByCar")
    @ApiOperation(value = "各区泵车状态", notes = "各区泵车状态")
    public ApiResult<List<CountByCarVo>> getCountByCar() throws Exception {

        List<CountByCarVo> countByCarVos = tZaiqingInfoMapper.getCountByCar();

        return ApiResult.ok(countByCarVos);
    }


                                //第二栏的接口
    // 各区调度情待派单
    @GetMapping("/getDispatchByCity")
    @ApiOperation(value = "各区调度情况", notes = "各区调度情况")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "city",value = "市区",dataType="String")

    })
    public ApiResult<Map<String, List<TZaiqingInfoQueryVoCdValue>>> getDispatchByCity(String city) throws Exception {

        Map<String, List<TZaiqingInfoQueryVoCdValue>> carState = tZaiqingInfoService.getDispatchByCity(city);
        return ApiResult.ok(carState);
    }

    //各区调度情况完成还有执行
    @GetMapping("/getDispatchByCityTo")
    @ApiOperation(value = "各区调度情况完成还有执行", notes = "各区调度情况")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "city",value = "市区",dataType="String")

    })
    public ApiResult<Map<String, List<TZaiqingInfoQueryVoCdValue>>> getDispatchByCityTo(String city) throws Exception {

        Map<String, List<TZaiqingInfoQueryVoCdValue>> carState = tZaiqingInfoService.getDispatchByCityTo(city);
        return ApiResult.ok(carState);
    }
    //各区调度总数
    @GetMapping("/totalDistricts")
    @ApiOperation(value = "各区调度总数", notes = "各区调度总数")
    public ApiResult<Map<String, List<TZaiqingInfoQueryVoCdValue>>> totalDistricts( ) throws Exception {

        Map<String, List<TZaiqingInfoQueryVoCdValue>> totalDistricts = tZaiqingInfoService.totalDistricts();

        return ApiResult.ok(totalDistricts);
    }

    //第二栏的接口
    //市区调度情况待派单
    @GetMapping("/getDispatch")
    @ApiOperation(value = "市区调度情况", notes = "市区调度情况")
    public ApiResult<Map<String, List<TZaiqingInfoQueryVoCdValue>>> getDispatch() throws Exception {

        Map<String, List<TZaiqingInfoQueryVoCdValue>> carState = tZaiqingInfoService.getDispatch();
        return ApiResult.ok(carState);
    }

    //第二栏的接口
    //市区调度情况完成还有执行 市区调度情况完成还有执行 getDispatcTo
    @GetMapping("/getDispatcTo")
    @ApiOperation(value = "市区调度情况完成还有执行", notes = "市区调度情况")
    public ApiResult<Map<String, List<TZaiqingInfoQueryVoCdValue>>> getDispatcTo() throws Exception {
        Map<String, List<TZaiqingInfoQueryVoCdValue>> carState = tZaiqingInfoService.getDispatcTo();
        return ApiResult.ok(carState);
    }

    //市区调度总数
    @GetMapping("/totalDistrictsCity")
    @ApiOperation(value = "市区调度总数", notes = "市区调度总数")
    public ApiResult<Map<String, List<TZaiqingInfoQueryVoCdValue>>> totalDistrictsCity( ) throws Exception {

        Map<String, List<TZaiqingInfoQueryVoCdValue>> totalDistricts = tZaiqingInfoService.totalDistrictsCity();
        return ApiResult.ok(totalDistricts);
    }

    //第二栏的接口
    //泵车抢险待派单

    @GetMapping("/getCarRescue")
    @ApiOperation(value = "泵车抢险", notes = "泵车抢险")
    public ApiResult<Map<String, List<TZaiqingInfoQueryVoCdValue>>> getCarRescue() throws Exception {

        Map<String, List<TZaiqingInfoQueryVoCdValue>> carState = tZaiqingInfoService.getCarRescue();
        return ApiResult.ok(carState);
    }
    //泵车抢险完成还有执行
    @GetMapping("/getCarRescueTo")
    @ApiOperation(value = "泵车抢险完成还有执行", notes = "泵车抢险")
    public ApiResult<Map<String, List<TZaiqingInfoQueryVoCdValue>>> getCarRescueTo() throws Exception {

        Map<String, List<TZaiqingInfoQueryVoCdValue>> carState = tZaiqingInfoService.getCarRescueTo();
        return ApiResult.ok(carState);
    }

    //全部调度总数
    @GetMapping("/totalDistrictsWhole")
    @ApiOperation(value = "全部调度总数", notes = "全部调度总数")
    public ApiResult<Map<String, List<TZaiqingInfoQueryVoCdValue>>> totalDistrictsWhole( ) throws Exception {

        Map<String, List<TZaiqingInfoQueryVoCdValue>> totalDistricts = tZaiqingInfoService.totalDistrictsWhole();
        return ApiResult.ok(totalDistricts);
    }


                                 //用來獲取數據的
    //灾情来源
    @GetMapping("/disasterCome")
    //  @RequiresPermissions("t:zaiqing:info:info")
    @ApiOperation(value = "灾情来源 ", notes = "灾情来源")
    public ApiResult<List<String>> disasterCome() throws Exception {
        //List<String> disasterCome=tZaiqingInfoService.disasterCome();


        List<String> disasterCome = tZaiqingInfoMapper.disasterCome();
        return ApiResult.ok(disasterCome);
    }
    //灾情类别
    @GetMapping("/disasterCategory")
    //  @RequiresPermissions("t:zaiqing:info:info")
    @ApiOperation(value = "灾情类别 ", notes = "灾情类别")
    public ApiResult<List<String>> disasterCategory() throws Exception {

        List<String> disasterCome = tZaiqingInfoMapper.disasterCategory();

        return ApiResult.ok(disasterCome);
    }


    //用來獲取數據的
    //获取泵车列表
    @GetMapping("/tPumptrukType")
    //  @RequiresPermissions("t:zaiqing:info:info")
    @ApiOperation(value = "获取泵车列表 ", notes = "获取泵车列表")
    public ApiResult<List<String>> gerPumptrukType() throws Exception {

        List<String> PumptrukTypeList = tZaiqingInfoService.gerPumptrukType();

        return ApiResult.ok(PumptrukTypeList);

    }

    //用來獲取數據的
    //获取市区列表
    @GetMapping("/cityInfo")
    //  @RequiresPermissions("t:zaiqing:info:info")
    @ApiOperation(value = "市区进行查询 ", notes = "市区进行查询")
    public ApiResult<List<String>> getCityInfo() throws Exception {
        List<String> cityList = tZaiqingInfoService.getCityInfo();

        return ApiResult.ok(cityList);
    }


    //单表进行查询所需要的信息
    //预警信息
    @GetMapping("/selectEarlyInfo")
    @ApiOperation(value = "查询预警信息", notes = "查询预警信息")
    public ApiResult<List<VYjxxQueryVo>> selectEarlyInfo() throws Exception {
        List<VYjxxQueryVo> DispatchInfo = tZaiqingInfoService.selectEarlyInfo();
        // List<> tZaiqingInfoService.selectEarlyInfo();
        return ApiResult.ok(DispatchInfo);

    }


    //获取视频
    @GetMapping("/getVideoById")
    @ApiOperation(value = "获取视频", notes = "获取视频")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "小车id",dataType="String")
    })
    public ApiResult<List<String>> getVideoById( String id) throws Exception {
        List<String> videoList = tZaiqingInfoMapper.getVideoById(id);

        return ApiResult.ok(videoList);

    }


    //获取任务信息
    @GetMapping("/getRenWuInfoById")
    @ApiOperation(value = "获取任务信息", notes = "获取任务信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "险情id",dataType="String")
    })
    public ApiResult<List<TDispatchQueryVoCdValueSpz>> getRenWuInfoById( String id) throws Exception {

        List<TDispatchQueryVoCdValueSpz> List =tZaiqingInfoService.getRenWuInfoById(id);

        //计算任务执行时常
        for (int i = 0; i < List.size(); i++) {
            TDispatchQueryVoCdValueSpz tDispatchQueryVoCdValueSpz = List.get(i);

           Date tEndTime = tDispatchQueryVoCdValueSpz.getTEndTime();

            Date tStartTime = tDispatchQueryVoCdValueSpz.getTStartTime();

            float diff=  tEndTime.getTime()-tStartTime.getTime();
            float hour = diff/60/1000/60;
            tDispatchQueryVoCdValueSpz.setHour(hour);

        }


        return ApiResult.ok(List);

    }


}

