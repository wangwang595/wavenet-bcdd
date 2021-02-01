package com.wavenet.maintenance.web;

import com.wavenet.maintenance.dao.entity.EventDispatch;
import com.wavenet.maintenance.dao.entity.EventDisposalWorkload;
import com.wavenet.maintenance.service.EventDispatchService;
import com.wavenet.maintenance.web.query.EventDispatchQueryParam;
import com.wavenet.maintenance.web.vo.EventDispatchQueryVo;
import com.wavenet.maintenance.web.vo.EventDispatchYhInfoVo;
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
 * @since 2020-03-30
 */
@Slf4j
@RestController
@RequestMapping("/eventDispatch")
@Api(" API")
public class EventDispatchController extends BaseController {

    @Autowired
    private EventDispatchService eventDispatchService;

    /**
     * 添加
     */
    @PostMapping("/add")
    @RequiresPermissions("event:dispatch:add")
    @ApiOperation(value = "添加EventDispatch对象", notes = "添加", response = ApiResult.class)
    public ApiResult<Boolean> addEventDispatch(@Valid @RequestBody EventDispatch eventDispatch) throws Exception {
        boolean flag = eventDispatchService.saveEventDispatch(eventDispatch);
        return ApiResult.result(flag);
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @RequiresPermissions("event:dispatch:update")
    @ApiOperation(value = "修改EventDispatch对象", notes = "修改", response = ApiResult.class)
    public ApiResult<Boolean> updateEventDispatch(@Valid @RequestBody EventDispatch eventDispatch) throws Exception {
        boolean flag = eventDispatchService.updateEventDispatch(eventDispatch);
        return ApiResult.result(flag);
    }

    /**
     * 删除
     */
    @PostMapping("/delete/{id}")
    @RequiresPermissions("event:dispatch:delete")
    @ApiOperation(value = "删除EventDispatch对象", notes = "删除", response = ApiResult.class)
    public ApiResult<Boolean> deleteEventDispatch(@PathVariable("id") Long id) throws Exception {
        boolean flag = eventDispatchService.deleteEventDispatch(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("event:dispatch:info")
    @ApiOperation(value = "获取EventDispatch对象详情", notes = "查看", response = EventDispatchQueryVo.class)
    public ApiResult<EventDispatchQueryVo> getEventDispatch(@PathVariable("id") Long id) throws Exception {
        EventDispatchQueryVo eventDispatchQueryVo = eventDispatchService.getEventDispatchById(id);
        return ApiResult.ok(eventDispatchQueryVo);
    }

    /**
     * 分页列表
     */
    @PostMapping("/getPageList")
    @RequiresPermissions("event:dispatch:page")
    @ApiOperation(value = "获取EventDispatch分页列表", notes = "分页列表", response = EventDispatchQueryVo.class)
    public ApiResult<Paging<EventDispatchQueryVo>> getEventDispatchPageList(@Valid @RequestBody EventDispatchQueryParam eventDispatchQueryParam) throws Exception {
        Paging<EventDispatchQueryVo> paging = eventDispatchService.getEventDispatchPageList(eventDispatchQueryParam);
        return ApiResult.ok(paging);
    }

    /**
     * 养护详情页面
     */
    @ApiOperation(value = "养护详情")
    @PostMapping("/yhInfo")
    public EventDispatchYhInfoVo getYhInfo(String dispatchCode, String disposalCode ) throws Exception {
        EventDispatchYhInfoVo list = eventDispatchService.getYhInfo(dispatchCode, disposalCode);
        return list;
    }

}

