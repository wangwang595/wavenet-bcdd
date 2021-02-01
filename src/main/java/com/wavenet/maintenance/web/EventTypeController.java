package com.wavenet.maintenance.web;

import java.util.List;

import javax.validation.Valid;

import com.wavenet.maintenance.dao.entity.EventTreeVo;
import com.wavenet.maintenance.web.vo.EventInfoQueryVo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wavenet.maintenance.dao.entity.EventType;
import com.wavenet.maintenance.service.EventTypeService;
import com.wavenet.maintenance.web.query.EventTypeQueryParam;
import com.wavenet.maintenance.web.vo.EventTypeQueryVo;
import com.wavenetframework.boot.common.api.ApiResult;
import com.wavenetframework.boot.common.controller.BaseController;
import com.wavenetframework.boot.common.vo.Paging;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * <pre>
 *  前端控制器
 * </pre>
 *
 * @author zll
 * @since 2020-03-24
 */
@Slf4j
@RestController
@RequestMapping("/eventTypeDo")
@Api(" API")
public class EventTypeController extends BaseController {

    @Autowired
    private EventTypeService eventTypeService;

    /**
     * 添加
     */
    @PostMapping("/add")
    @RequiresPermissions("event:type:add")
    @ApiOperation(value = "添加EventType对象", notes = "添加", response = ApiResult.class)
    public ApiResult<Boolean> addEventType(@Valid @RequestBody EventType eventTypeDo) throws Exception {
        boolean flag = eventTypeService.saveEventType(eventTypeDo);
        return ApiResult.result(flag);
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @RequiresPermissions("event:type:update")
    @ApiOperation(value = "修改EventType对象", notes = "修改", response = ApiResult.class)
    public ApiResult<Boolean> updateEventType(@Valid @RequestBody EventType eventTypeDo) throws Exception {
        boolean flag = eventTypeService.updateEventType(eventTypeDo);
        return ApiResult.result(flag);
    }

    /**
     * 删除
     */
    @PostMapping("/delete/{id}")
    @RequiresPermissions("event:type:delete")
    @ApiOperation(value = "删除EventType对象", notes = "删除", response = ApiResult.class)
    public ApiResult<Boolean> deleteEventType(@PathVariable("id") String id) throws Exception {
        boolean flag = eventTypeService.deleteEventType(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("event:type:info")
    @ApiOperation(value = "获取EventType对象详情", notes = "查看", response = EventTypeQueryVo.class)
    public ApiResult<EventTypeQueryVo> getEventType(@PathVariable("id") String id) throws Exception {
        EventTypeQueryVo eventTypeDoQueryVo = eventTypeService.getEventTypeById(id);
        return ApiResult.ok(eventTypeDoQueryVo);
    }

    /**
     * 分页列表
     */
    @PostMapping("/getPageList")
    @RequiresPermissions("event:type:page")
    @ApiOperation(value = "获取EventType分页列表", notes = "分页列表", response = EventTypeQueryVo.class)
    public ApiResult<Paging<EventTypeQueryVo>> getEventTypePageList(@Valid @RequestBody EventTypeQueryParam eventTypeDoQueryParam) throws Exception {
        Paging<EventTypeQueryVo> paging = eventTypeService.getEventTypePageList(eventTypeDoQueryParam);
        return ApiResult.ok(paging);
    }


    /**
     * 根据parentId获取子对象
     */
    @GetMapping("/infoByParentCode/{parentCode}")
    @RequiresPermissions("event:type:info")
    @ApiOperation(value = "获取EventType对象详情", notes = "查看", response = EventTypeQueryVo.class)
    public ApiResult<EventTypeQueryVo> getEventTypeByParentCode(@PathVariable("parentCode") String id) throws Exception {
        List<EventTypeQueryVo> eventTypeQueryVoList = eventTypeService.getEventTypeByParentCode(id);
        return ApiResult.ok(eventTypeQueryVoList);
    }

    @ApiOperation(value = "根据名称查询")
    @GetMapping("/byName")
    public  ApiResult<EventTypeQueryVo> selectByName(String name) throws Exception {
        List<EventTypeQueryVo> list = eventTypeService.selectByName(name);
        return ApiResult.ok(list);

    }

    @ApiOperation(value = "树形数据")
    @PostMapping ("/tree")
    public ApiResult<Paging<EventTreeVo>> getAllEventTree() throws Exception {
        List<EventTreeVo> treeVos = eventTypeService.selectByTree();
        return ApiResult.ok(treeVos);
    }

    @ApiOperation(value = "根据编码值查询eventInfo表")
    @GetMapping  ("/byCode")
    public ApiResult<EventInfoQueryVo> selectByCode(String code) throws Exception {
        List<EventInfoQueryVo> list = eventTypeService.selectByCode(code);
        return ApiResult.ok(list);
    }
}

