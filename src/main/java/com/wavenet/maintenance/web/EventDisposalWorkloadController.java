package com.wavenet.maintenance.web;

import com.wavenet.maintenance.dao.entity.EventDisposalWorkload;
import com.wavenet.maintenance.service.EventDisposalWorkloadService;
import com.wavenet.maintenance.web.query.EventDisposalWorkloadQueryParam;
import com.wavenet.maintenance.web.vo.EventDisposalWorkloadQueryVo;
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
@RequestMapping("/eventDisposalWorkload")
@Api(" API")
public class EventDisposalWorkloadController extends BaseController {

    @Autowired
    private EventDisposalWorkloadService eventDisposalWorkloadService;

    /**
     * 添加
     */
    @PostMapping("/add")
    @RequiresPermissions("event:disposal:workload:add")
    @ApiOperation(value = "添加EventDisposalWorkload对象", notes = "添加", response = ApiResult.class)
    public ApiResult<Boolean> addEventDisposalWorkload(@Valid @RequestBody EventDisposalWorkload eventDisposalWorkload) throws Exception {
        boolean flag = eventDisposalWorkloadService.saveEventDisposalWorkload(eventDisposalWorkload);
        return ApiResult.result(flag);
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @RequiresPermissions("event:disposal:workload:update")
    @ApiOperation(value = "修改EventDisposalWorkload对象", notes = "修改", response = ApiResult.class)
    public ApiResult<Boolean> updateEventDisposalWorkload(@Valid @RequestBody EventDisposalWorkload eventDisposalWorkload) throws Exception {
        boolean flag = eventDisposalWorkloadService.updateEventDisposalWorkload(eventDisposalWorkload);
        return ApiResult.result(flag);
    }

    /**
     * 删除
     */
    @PostMapping("/delete/{id}")
    @RequiresPermissions("event:disposal:workload:delete")
    @ApiOperation(value = "删除EventDisposalWorkload对象", notes = "删除", response = ApiResult.class)
    public ApiResult<Boolean> deleteEventDisposalWorkload(@PathVariable("id") Long id) throws Exception {
        boolean flag = eventDisposalWorkloadService.deleteEventDisposalWorkload(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("event:disposal:workload:info")
    @ApiOperation(value = "获取EventDisposalWorkload对象详情", notes = "查看", response = EventDisposalWorkloadQueryVo.class)
    public ApiResult<EventDisposalWorkloadQueryVo> getEventDisposalWorkload(@PathVariable("id") Long id) throws Exception {
        EventDisposalWorkloadQueryVo eventDisposalWorkloadQueryVo = eventDisposalWorkloadService.getEventDisposalWorkloadById(id);
        return ApiResult.ok(eventDisposalWorkloadQueryVo);
    }

    /**
     * 分页列表
     */
    @PostMapping("/getPageList")
    @RequiresPermissions("event:disposal:workload:page")
    @ApiOperation(value = "获取EventDisposalWorkload分页列表", notes = "分页列表", response = EventDisposalWorkloadQueryVo.class)
    public ApiResult<Paging<EventDisposalWorkloadQueryVo>> getEventDisposalWorkloadPageList(@Valid @RequestBody EventDisposalWorkloadQueryParam eventDisposalWorkloadQueryParam) throws Exception {
        Paging<EventDisposalWorkloadQueryVo> paging = eventDisposalWorkloadService.getEventDisposalWorkloadPageList(eventDisposalWorkloadQueryParam);
        return ApiResult.ok(paging);
    }

    /**
     * 批量新增
     */
    @ApiOperation(value = "批量新增")
    @PostMapping("/adds")
    public ApiResult<Boolean> addsWorkload(@Valid @RequestBody List<EventDisposalWorkload> eventDisposalWorkload) throws Exception {
        boolean flag = eventDisposalWorkloadService.saveWorkload(eventDisposalWorkload);
        return ApiResult.result(flag);
    }
}

