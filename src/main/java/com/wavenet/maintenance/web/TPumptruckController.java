package com.wavenet.maintenance.web;

import com.wavenet.maintenance.dao.entity.TPumptruck;
import com.wavenet.maintenance.dao.entity.TZaiqingInfo;
import com.wavenet.maintenance.dao.mapper.TPumptruckMapper;
import com.wavenet.maintenance.service.TPumptruckService;
import com.wavenet.maintenance.web.query.ShiQuVoQueryParm;
import com.wavenet.maintenance.web.query.TPumptruckQueryParam;
import com.wavenet.maintenance.web.vo.*;

import com.wavenetframework.boot.common.api.ApiResult;

import com.wavenetframework.boot.common.controller.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

import com.wavenetframework.boot.common.vo.Paging;
import com.wavenetframework.boot.common.param.IdParam;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *  前端控制器
 * </pre>
 *
 * @author zll
 * @since 2020-05-10
 */
@Slf4j
@RestController
@RequestMapping("/tPumptruck")
@Api(tags = "泵车的详情")
public class TPumptruckController extends BaseController {

    @Autowired
    private TPumptruckService tPumptruckService;

    @Autowired
    private  TPumptruckMapper tPumptruckMapper;

    /**
     * 添加
     */
    @PostMapping("/add")
    @RequiresPermissions("t:pumptruck:add")
    @ApiOperation(value = "添加TPumptruck对象", notes = "添加", response = ApiResult.class)
    public ApiResult<Boolean> addTPumptruck(@Valid @RequestBody TPumptruck tPumptruck) throws Exception {
        boolean flag = tPumptruckService.saveTPumptruck(tPumptruck);
        return ApiResult.result(flag);
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @RequiresPermissions("t:pumptruck:update")
    @ApiOperation(value = "修改TPumptruck对象", notes = "修改", response = ApiResult.class)
    public ApiResult<Boolean> updateTPumptruck(@Valid @RequestBody TPumptruck tPumptruck) throws Exception {
        boolean flag = tPumptruckService.updateTPumptruck(tPumptruck);
        return ApiResult.result(flag);
    }

    /**
     * 删除
     */
    @PostMapping("/delete/{id}")
    @RequiresPermissions("t:pumptruck:delete")
    @ApiOperation(value = "删除TPumptruck对象", notes = "删除", response = ApiResult.class)
    public ApiResult<Boolean> deleteTPumptruck(@PathVariable("id") Long id) throws Exception {
        boolean flag = tPumptruckService.deleteTPumptruck(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("t:pumptruck:info")
    @ApiOperation(value = "获取TPumptruck对象详情", notes = "查看", response = TPumptruckQueryVo.class)
    public ApiResult<TPumptruckQueryVo> getTPumptruck(@PathVariable("id") Long id) throws Exception {
        TPumptruckQueryVo tPumptruckQueryVo = tPumptruckService.getTPumptruckById(id);
        return ApiResult.ok(tPumptruckQueryVo);
    }

    /**
     * 分页列表
     */
    @PostMapping("/getPageList")
    @RequiresPermissions("t:pumptruck:page")
    @ApiOperation(value = "获取TPumptruck分页列表", notes = "分页列表", response = TPumptruckQueryVo.class)
    public ApiResult<Paging<TPumptruckQueryVo>> getTPumptruckPageList(@Valid @RequestBody TPumptruckQueryParam tPumptruckQueryParam) throws Exception {
        Paging<TPumptruckQueryVo> paging = tPumptruckService.getTPumptruckPageList(tPumptruckQueryParam);
        return ApiResult.ok(paging);
    }

    /**
     * 分页列表
     */
    @PostMapping("/getshiqu")
    @ApiOperation(value = "获取市区")
    public ApiResult<List<String>> getTPumptruckPageList() throws Exception {
        List<String> getshiqu = tPumptruckService.getshiqu();
        return ApiResult.ok(getshiqu);
    }
    /**
     * 获取泵车全部信息
     */
    @GetMapping("/pumpTruck")
    @ApiOperation(value = "获取泵车全部信息", notes = "获取泵车的所有信息")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "sPtId" ,value = "泵车id" , dataType = "String")
    )
    public ApiResult<List<PumptruckAllInfoVo>> getTPumptruck(String sPtId) throws Exception {

        List<PumptruckAllInfoVo> pumptruckAllInfoVos = tPumptruckService.getPumptruckAllInfo(sPtId);

        return ApiResult.ok(pumptruckAllInfoVos);
    }

    /**
     * 历史轨迹
     */
    @GetMapping("/historicalTrack")
    @ApiOperation(value = "历史轨迹", notes = "历史轨迹")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sPtId" ,value = "泵车id" , dataType = "String"),
            @ApiImplicitParam(name = "startTime" ,value = "开始时间" , dataType = "String"),
            @ApiImplicitParam(name = "endTime" ,value = "结束时间" , dataType = "String"),
            @ApiImplicitParam(name = "name" ,value = "险情名称" , dataType = "String")

    } )
    public ApiResult<List<TPumptruckControlhisQueryVos>> historicalTrack(String sPtId, String startTime, String endTime, String name) throws Exception {

        List<TPumptruckControlhisQueryVos> historicalTrack = tPumptruckMapper.historicalTrack(sPtId,startTime,endTime,name);
       List<TPumptruckControlhisQueryVoArr> tPumptruckControlhisQueryVoArrs = new ArrayList<>();

       //返回的结果要求坐标要求是一个对象里面 从string 转换对象positionVo
        for (int i = 0; i < historicalTrack.size(); i++) {
            TPumptruckControlhisQueryVos tPumptruckControlhisQueryVos = historicalTrack.get(i);
            String npy = tPumptruckControlhisQueryVos.getNPY();
            String npx = tPumptruckControlhisQueryVos.getNPX();
            String[] ny = npy.split(",");
            String[] nx = npx.split(",");
            TPumptruckControlhisQueryVoArr tPumptruckControlhisQueryVoArr = new TPumptruckControlhisQueryVoArr();
            tPumptruckControlhisQueryVoArr.setSTastId(tPumptruckControlhisQueryVos.getSTastId());
            tPumptruckControlhisQueryVoArr.setEndtime(tPumptruckControlhisQueryVos.getEndtime());
            tPumptruckControlhisQueryVoArr.setStarttime(tPumptruckControlhisQueryVos.getStarttime());
            tPumptruckControlhisQueryVoArr.setSName(tPumptruckControlhisQueryVos.getSName());
            PositionVo[] positionVo1 = new PositionVo[ny.length];
            for (int i1 = 0; i1 < ny.length; i1++) {
                PositionVo positionVo = new PositionVo();
                String nx1 = nx[i1];
                String ny1 = ny[i1];
                positionVo.setNPX(nx1);
                positionVo.setNPY(ny1);
                positionVo1[i1]=positionVo;

            }
            tPumptruckControlhisQueryVoArr.setData(positionVo1);
            tPumptruckControlhisQueryVoArrs.add(tPumptruckControlhisQueryVoArr);
        }

        return ApiResult.ok(tPumptruckControlhisQueryVoArrs);
    }

    /**
     * 实时轨迹
     */
    @GetMapping("/nowlTrack")
    @ApiOperation(value = "实时轨迹", notes = "实时轨迹")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sPtId" ,value = "泵车id" , dataType = "String"),
            @ApiImplicitParam(name = "startTime" ,value = "开始时间" , dataType = "String"),
            @ApiImplicitParam(name = "endTime" ,value = "结束时间" , dataType = "String"),
            @ApiImplicitParam(name = "sId" ,value = "险情sId" , dataType = "String")

    } )
    public ApiResult<List<TPumptruckControlhisQueryVos>> nowlTrack(String sPtId, String startTime, String endTime, String sId) throws Exception {

        List<TPumptruckControlhisQueryVos> historicalTrack = tPumptruckMapper.nowlTrack(sPtId,startTime,endTime,sId);
        List<TPumptruckControlhisQueryVoArr> tPumptruckControlhisQueryVoArrs = new ArrayList<>();

        //返回的结果要求坐标要求是一个对象里面 从string 转换对象positionVo
        for (int i = 0; i < historicalTrack.size(); i++) {
            TPumptruckControlhisQueryVos tPumptruckControlhisQueryVos = historicalTrack.get(i);
            String npy = tPumptruckControlhisQueryVos.getNPY();
            String npx = tPumptruckControlhisQueryVos.getNPX();
            String[] ny = npy.split(",");
            String[] nx = npx.split(",");
            TPumptruckControlhisQueryVoArr tPumptruckControlhisQueryVoArr = new TPumptruckControlhisQueryVoArr();
            tPumptruckControlhisQueryVoArr.setSTastId(tPumptruckControlhisQueryVos.getSTastId());
            tPumptruckControlhisQueryVoArr.setEndtime(tPumptruckControlhisQueryVos.getEndtime());
            tPumptruckControlhisQueryVoArr.setStarttime(tPumptruckControlhisQueryVos.getStarttime());
            tPumptruckControlhisQueryVoArr.setSName(tPumptruckControlhisQueryVos.getSName());
            PositionVo[] positionVo1 = new PositionVo[ny.length];
            for (int i1 = 0; i1 < ny.length; i1++) {
                PositionVo positionVo = new PositionVo();
                String nx1 = nx[i1];
                String ny1 = ny[i1];
                positionVo.setNPX(nx1);
                positionVo.setNPY(ny1);
                positionVo1[i1]=positionVo;

            }
            tPumptruckControlhisQueryVoArr.setData(positionVo1);
            tPumptruckControlhisQueryVoArrs.add(tPumptruckControlhisQueryVoArr);
        }

        return ApiResult.ok(tPumptruckControlhisQueryVoArrs);
    }









}

