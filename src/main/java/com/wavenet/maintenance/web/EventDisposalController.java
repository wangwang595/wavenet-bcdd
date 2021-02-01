package com.wavenet.maintenance.web;

import com.wavenet.maintenance.dao.entity.EventDisposal;
import com.wavenet.maintenance.service.EventDisposalService;
import com.wavenet.maintenance.web.query.EventDisposalQueryParam;
import com.wavenet.maintenance.web.vo.EventDisposalQueryVo;
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
@RequestMapping("/eventDisposal")
@Api(" API")
public class EventDisposalController extends BaseController {

    @Autowired
    private EventDisposalService eventDisposalService;

    /**
     * 添加
     */
    @PostMapping("/add")
    @RequiresPermissions("event:disposal:add")
    @ApiOperation(value = "添加EventDisposal对象", notes = "添加", response = ApiResult.class)
    public ApiResult<String> addEventDisposal(@Valid @RequestBody EventDisposal eventDisposal) throws Exception {
        String s = eventDisposalService.saveEventDisposal(eventDisposal);
        return ApiResult.ok(s);
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @RequiresPermissions("event:disposal:update")
    @ApiOperation(value = "修改EventDisposal对象", notes = "修改", response = ApiResult.class)
    public ApiResult<Boolean> updateEventDisposal(@Valid @RequestBody EventDisposal eventDisposal) throws Exception {
        boolean flag = eventDisposalService.updateEventDisposal(eventDisposal);
        return ApiResult.result(flag);
    }

    /**
     * 删除
     */
    @PostMapping("/delete/{id}")
    @RequiresPermissions("event:disposal:delete")
    @ApiOperation(value = "删除EventDisposal对象", notes = "删除", response = ApiResult.class)
    public ApiResult<Boolean> deleteEventDisposal(@PathVariable("id") Long id) throws Exception {
        boolean flag = eventDisposalService.deleteEventDisposal(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("event:disposal:info")
    @ApiOperation(value = "获取EventDisposal对象详情", notes = "查看", response = EventDisposalQueryVo.class)
    public ApiResult<EventDisposalQueryVo> getEventDisposal(@PathVariable("id") String id) throws Exception {
        EventDisposalQueryVo eventDisposalQueryVo = eventDisposalService.getEventDisposalById(id);
        return ApiResult.ok(eventDisposalQueryVo);
    }

    /**
     * 分页列表
     */
    @PostMapping("/getPageList")
    @RequiresPermissions("event:disposal:page")
    @ApiOperation(value = "获取EventDisposal分页列表", notes = "分页列表", response = EventDisposalQueryVo.class)
    public ApiResult<Paging<EventDisposalQueryVo>> getEventDisposalPageList(@Valid @RequestBody EventDisposalQueryParam eventDisposalQueryParam) throws Exception {
        Paging<EventDisposalQueryVo> paging = eventDisposalService.getEventDisposalPageList(eventDisposalQueryParam);
        return ApiResult.ok(paging);
    }

}

