package com.wavenet.maintenance.web;

import com.wavenet.maintenance.dao.entity.DrainStation;
import com.wavenet.maintenance.service.DrainStationService;
import com.wavenet.maintenance.web.query.DrainStationQueryParam;
import com.wavenet.maintenance.web.vo.DrainStationQueryVo;
import com.wavenetframework.boot.common.api.ApiResult;

import com.wavenetframework.boot.common.controller.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

import com.wavenetframework.boot.common.vo.Paging;
import com.wavenetframework.boot.common.param.IdParam;

import java.util.List;

/**
 * <pre>
 *  前端控制器
 * </pre>
 *
 * @author zll
 * @since 2020-05-06
 */
@Slf4j
@RestController
@RequestMapping("/drainStation")
@Api(" API")
public class DrainStationController extends BaseController {

    @Autowired
    private DrainStationService drainStationService;

    /**
     * 添加
     */
    @PostMapping("/add")
    @RequiresPermissions("drain:station:add")
    @ApiOperation(value = "添加DrainStation对象", notes = "添加", response = ApiResult.class)
    public ApiResult<Boolean> addDrainStation(@Valid @RequestBody DrainStation drainStation) throws Exception {
        boolean flag = drainStationService.saveDrainStation(drainStation);
        return ApiResult.result(flag);
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @RequiresPermissions("drain:station:update")
    @ApiOperation(value = "修改DrainStation对象", notes = "修改", response = ApiResult.class)
    public ApiResult<Boolean> updateDrainStation(@Valid @RequestBody DrainStation drainStation) throws Exception {
        boolean flag = drainStationService.updateDrainStation(drainStation);
        return ApiResult.result(flag);
    }

    /**
     * 删除
     */
    @PostMapping("/delete/{id}")
    @RequiresPermissions("drain:station:delete")
    @ApiOperation(value = "删除DrainStation对象", notes = "删除", response = ApiResult.class)
    public ApiResult<Boolean> deleteDrainStation(@PathVariable("id") Long id) throws Exception {
        boolean flag = drainStationService.deleteDrainStation(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取
     */
    @ApiOperation(value = "雨量站测试")
    @GetMapping(value = "/stStationid")
    public ApiResult<DrainStationQueryVo> getDrainStation(String stStationid) throws Exception {
        List<DrainStationQueryVo>  list =  drainStationService.selectDrainById(stStationid);
//        DrainStationQueryVo drainStationQueryVo = drainStationService.getDrainStationById(stStationid);
        return ApiResult.ok(list);
    }

    /**
     * 分页列表
     */
    @PostMapping("/getPageList")
    @RequiresPermissions("drain:station:page")
    @ApiOperation(value = "获取DrainStation分页列表", notes = "分页列表", response = DrainStationQueryVo.class)
    public ApiResult<Paging<DrainStationQueryVo>> getDrainStationPageList(@Valid @RequestBody DrainStationQueryParam drainStationQueryParam) throws Exception {
        Paging<DrainStationQueryVo> paging = drainStationService.getDrainStationPageList(drainStationQueryParam);
        return ApiResult.ok(paging);
    }

}

