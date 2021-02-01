package com.wavenet.maintenance.web;

import com.wavenet.maintenance.dao.entity.EventDispatchRel;
import com.wavenet.maintenance.service.EventDispatchRelService;
import com.wavenet.maintenance.web.query.EventDispatchRelQueryParam;
import com.wavenet.maintenance.web.vo.EventDispatchRelQueryVo;
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
 *  前端控制器
 * </pre>
 *
 * @author zll
 * @since 2020-03-30
 */
@Slf4j
@RestController
@RequestMapping("/eventDispatchRel")
@Api(" API")
public class EventDispatchRelController extends BaseController {

    @Autowired
    private EventDispatchRelService eventDispatchRelService;

    /**
     * 添加
     */
    @PostMapping("/add")
    @RequiresPermissions("event:dispatch:rel:add")
    @ApiOperation(value = "添加EventDispatchRel对象", notes = "添加", response = ApiResult.class)
    public ApiResult<Boolean> addEventDispatchRel(@Valid @RequestBody EventDispatchRel eventDispatchRel) throws Exception {
        boolean flag = eventDispatchRelService.saveEventDispatchRel(eventDispatchRel);
        return ApiResult.result(flag);
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @RequiresPermissions("event:dispatch:rel:update")
    @ApiOperation(value = "修改EventDispatchRel对象", notes = "修改", response = ApiResult.class)
    public ApiResult<Boolean> updateEventDispatchRel(@Valid @RequestBody EventDispatchRel eventDispatchRel) throws Exception {
        boolean flag = eventDispatchRelService.updateEventDispatchRel(eventDispatchRel);
        return ApiResult.result(flag);
    }

    /**
     * 删除
     */
    @PostMapping("/delete/{id}")
    @RequiresPermissions("event:dispatch:rel:delete")
    @ApiOperation(value = "删除EventDispatchRel对象", notes = "删除", response = ApiResult.class)
    public ApiResult<Boolean> deleteEventDispatchRel(@PathVariable("id") Long id) throws Exception {
        boolean flag = eventDispatchRelService.deleteEventDispatchRel(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("event:dispatch:rel:info")
    @ApiOperation(value = "获取EventDispatchRel对象详情", notes = "查看", response = EventDispatchRelQueryVo.class)
    public ApiResult<EventDispatchRelQueryVo> getEventDispatchRel(@PathVariable("id") Long id) throws Exception {
        EventDispatchRelQueryVo eventDispatchRelQueryVo = eventDispatchRelService.getEventDispatchRelById(id);
        return ApiResult.ok(eventDispatchRelQueryVo);
    }

    /**
     * 分页列表
     */
    @PostMapping("/getPageList")
    @RequiresPermissions("event:dispatch:rel:page")
    @ApiOperation(value = "获取EventDispatchRel分页列表", notes = "分页列表", response = EventDispatchRelQueryVo.class)
    public ApiResult<Paging<EventDispatchRelQueryVo>> getEventDispatchRelPageList(@Valid @RequestBody EventDispatchRelQueryParam eventDispatchRelQueryParam) throws Exception {
        Paging<EventDispatchRelQueryVo> paging = eventDispatchRelService.getEventDispatchRelPageList(eventDispatchRelQueryParam);
        return ApiResult.ok(paging);
    }

}

