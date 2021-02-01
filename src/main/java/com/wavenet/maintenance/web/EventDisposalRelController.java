package com.wavenet.maintenance.web;

import com.wavenet.maintenance.dao.entity.EventDisposalRel;
import com.wavenet.maintenance.service.EventDisposalRelService;
import com.wavenet.maintenance.web.query.EventDisposalRelQueryParam;
import com.wavenet.maintenance.web.vo.EventDisposalRelQueryVo;
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
@RequestMapping("/eventDisposalRel")
@Api(" API")
public class EventDisposalRelController extends BaseController {

    @Autowired
    private EventDisposalRelService eventDisposalRelService;

    /**
     * 添加
     */
    @PostMapping("/add")
    @RequiresPermissions("event:disposal:rel:add")
    @ApiOperation(value = "添加EventDisposalRel对象", notes = "添加", response = ApiResult.class)
    public ApiResult<Boolean> addEventDisposalRel(@Valid @RequestBody EventDisposalRel eventDisposalRel) throws Exception {
        boolean flag = eventDisposalRelService.saveEventDisposalRel(eventDisposalRel);
        return ApiResult.result(flag);
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @RequiresPermissions("event:disposal:rel:update")
    @ApiOperation(value = "修改EventDisposalRel对象", notes = "修改", response = ApiResult.class)
    public ApiResult<Boolean> updateEventDisposalRel(@Valid @RequestBody EventDisposalRel eventDisposalRel) throws Exception {
        boolean flag = eventDisposalRelService.updateEventDisposalRel(eventDisposalRel);
        return ApiResult.result(flag);
    }

    /**
     * 删除
     */
    @PostMapping("/delete/{id}")
    @RequiresPermissions("event:disposal:rel:delete")
    @ApiOperation(value = "删除EventDisposalRel对象", notes = "删除", response = ApiResult.class)
    public ApiResult<Boolean> deleteEventDisposalRel(@PathVariable("id") Long id) throws Exception {
        boolean flag = eventDisposalRelService.deleteEventDisposalRel(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("event:disposal:rel:info")
    @ApiOperation(value = "获取EventDisposalRel对象详情", notes = "查看", response = EventDisposalRelQueryVo.class)
    public ApiResult<EventDisposalRelQueryVo> getEventDisposalRel(@PathVariable("id") Long id) throws Exception {
        EventDisposalRelQueryVo eventDisposalRelQueryVo = eventDisposalRelService.getEventDisposalRelById(id);
        return ApiResult.ok(eventDisposalRelQueryVo);
    }

    /**
     * 分页列表
     */
    @PostMapping("/getPageList")
    @RequiresPermissions("event:disposal:rel:page")
    @ApiOperation(value = "获取EventDisposalRel分页列表", notes = "分页列表", response = EventDisposalRelQueryVo.class)
    public ApiResult<Paging<EventDisposalRelQueryVo>> getEventDisposalRelPageList(@Valid @RequestBody EventDisposalRelQueryParam eventDisposalRelQueryParam) throws Exception {
        Paging<EventDisposalRelQueryVo> paging = eventDisposalRelService.getEventDisposalRelPageList(eventDisposalRelQueryParam);
        return ApiResult.ok(paging);
    }

}

