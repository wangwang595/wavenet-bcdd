package com.wavenet.maintenance.web;

import com.wavenet.maintenance.dao.entity.EventDisposalRel;
import com.wavenet.maintenance.dao.entity.EventInfo;
import com.wavenet.maintenance.service.EventInfoService;
import com.wavenet.maintenance.web.query.EventInfoQueryParam;
import com.wavenet.maintenance.web.vo.EventInfoQueryVo;
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
@RequestMapping("/eventInfo")
@Api(" API")
public class EventInfoController extends BaseController {

    @Autowired
    private EventInfoService eventInfoService;

    /**
     * 添加
     */
    @PostMapping("/add")
    @RequiresPermissions("event:info:add")
    @ApiOperation(value = "添加EventInfo对象", notes = "添加", response = ApiResult.class)
    public ApiResult<Boolean> addEventInfo(@Valid @RequestBody EventInfo eventInfo) throws Exception {
        boolean flag = eventInfoService.saveEventInfo(eventInfo);
        return ApiResult.result(flag);
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @RequiresPermissions("event:info:update")
    @ApiOperation(value = "修改EventInfo对象", notes = "修改", response = ApiResult.class)
    public ApiResult<Boolean> updateEventInfo(@Valid @RequestBody EventInfo eventInfo) throws Exception {
        boolean flag = eventInfoService.updateEventInfo(eventInfo);
        return ApiResult.result(flag);
    }

    /**
     * 删除
     */
    @PostMapping("/delete/{id}")
    @RequiresPermissions("event:info:delete")
    @ApiOperation(value = "删除EventInfo对象", notes = "删除", response = ApiResult.class)
    public ApiResult<Boolean> deleteEventInfo(@PathVariable("id") Long id) throws Exception {
        boolean flag = eventInfoService.deleteEventInfo(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("event:info:info")
    @ApiOperation(value = "获取EventInfo对象详情", notes = "查看", response = EventInfoQueryVo.class)
    public ApiResult<EventInfoQueryVo> getEventInfo(@PathVariable("id") Long id) throws Exception {
        EventInfoQueryVo eventInfoQueryVo = eventInfoService.getEventInfoById(id);
        return ApiResult.ok(eventInfoQueryVo);
    }

    /**
     * 分页列表
     */
    @PostMapping("/getPageList")
    @RequiresPermissions("event:info:page")
    @ApiOperation(value = "获取EventInfo分页列表", notes = "分页列表", response = EventInfoQueryVo.class)
    public ApiResult<Paging<EventInfoQueryVo>> getEventInfoPageList(@Valid @RequestBody EventInfoQueryParam eventInfoQueryParam) throws Exception {
        Paging<EventInfoQueryVo> paging = eventInfoService.getEventInfoPageList(eventInfoQueryParam);
        return ApiResult.ok(paging);
    }

    @ApiOperation(value = "根据code关联查询")
    @GetMapping("/byCode")
    public ApiResult<EventInfoQueryVo> selectInfoByCode(String code) throws Exception {
        List<EventInfoQueryVo> list = eventInfoService.selectInfoByCode(code);
        return ApiResult.ok(list);
    }

    @ApiOperation(value = "根据路段编号查询返回dispatch_code")
    @GetMapping("/dispatch")
    public ApiResult<EventDisposalRel> selectDispatchCode(String code) throws Exception {
        List<EventDisposalRel> list = eventInfoService.selectDispatchCode(code);
        return ApiResult.ok(list);
    }
}

