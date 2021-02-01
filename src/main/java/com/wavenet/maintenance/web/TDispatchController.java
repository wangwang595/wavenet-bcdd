package com.wavenet.maintenance.web;

import com.wavenet.maintenance.dao.entity.TDispatch;
import com.wavenet.maintenance.service.TDispatchService;
import com.wavenet.maintenance.web.query.TDispatchQueryParam;
import com.wavenet.maintenance.web.vo.TDispatchQueryVo;
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

/**
 * <pre>
 * 任务信息表 前端控制器
 * </pre>
 *
 * @author zll
 * @since 2020-05-11
 */
@Slf4j
@RestController
@RequestMapping("/tDispatch")
@Api("任务信息表 API")
public class TDispatchController extends BaseController {

    @Autowired
    private TDispatchService tDispatchService;

    /**
     * 添加任务信息表
     */
    @PostMapping("/add")
    @RequiresPermissions("t:dispatch:add")
    @ApiOperation(value = "添加TDispatch对象", notes = "添加任务信息表", response = ApiResult.class)
    public ApiResult<Boolean> addTDispatch(@Valid @RequestBody TDispatch tDispatch) throws Exception {
        boolean flag = tDispatchService.saveTDispatch(tDispatch);
        return ApiResult.result(flag);
    }

    /**
     * 修改任务信息表
     */
    @PostMapping("/update")
    @RequiresPermissions("t:dispatch:update")
    @ApiOperation(value = "修改TDispatch对象", notes = "修改任务信息表", response = ApiResult.class)
    public ApiResult<Boolean> updateTDispatch(@Valid @RequestBody TDispatch tDispatch) throws Exception {
        boolean flag = tDispatchService.updateTDispatch(tDispatch);
        return ApiResult.result(flag);
    }

    /**
     * 删除任务信息表
     */
    @PostMapping("/delete/{id}")
    @RequiresPermissions("t:dispatch:delete")
    @ApiOperation(value = "删除TDispatch对象", notes = "删除任务信息表", response = ApiResult.class)
    public ApiResult<Boolean> deleteTDispatch(@PathVariable("id") Long id) throws Exception {
        boolean flag = tDispatchService.deleteTDispatch(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取任务信息表
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("t:dispatch:info")
    @ApiOperation(value = "获取TDispatch对象详情", notes = "查看任务信息表", response = TDispatchQueryVo.class)
    public ApiResult<TDispatchQueryVo> getTDispatch(@PathVariable("id") Long id) throws Exception {
        TDispatchQueryVo tDispatchQueryVo = tDispatchService.getTDispatchById(id);
        return ApiResult.ok(tDispatchQueryVo);
    }

    /**
     * 任务信息表分页列表
     */
    @PostMapping("/getPageList")
    @RequiresPermissions("t:dispatch:page")
    @ApiOperation(value = "获取TDispatch分页列表", notes = "任务信息表分页列表", response = TDispatchQueryVo.class)
    public ApiResult<Paging<TDispatchQueryVo>> getTDispatchPageList(@Valid @RequestBody TDispatchQueryParam tDispatchQueryParam) throws Exception {
        Paging<TDispatchQueryVo> paging = tDispatchService.getTDispatchPageList(tDispatchQueryParam);
        return ApiResult.ok(paging);
    }

}

