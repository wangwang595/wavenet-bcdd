package com.wavenet.maintenance.web;

import com.wavenet.maintenance.dao.entity.Dict;
import com.wavenet.maintenance.service.DictService;
import com.wavenet.maintenance.web.query.DictQueryParam;
import com.wavenet.maintenance.web.vo.DictQueryVo;
import com.wavenet.maintenance.web.vo.EventTypeQueryVo;
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
 * @since 2020-03-28
 */
@Slf4j
@RestController
@RequestMapping("/dict")
@Api(" API")
public class DictController extends BaseController {

    @Autowired
    private DictService dictService;

    /**
     * 添加
     */
    @PostMapping("/add")
    @RequiresPermissions("dict:add")
    @ApiOperation(value = "添加Dict对象", notes = "添加", response = ApiResult.class)
    public ApiResult<Boolean> addDict(@Valid @RequestBody Dict dict) throws Exception {
        boolean flag = dictService.saveDict(dict);
        return ApiResult.result(flag);
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @RequiresPermissions("dict:update")
    @ApiOperation(value = "修改Dict对象", notes = "修改", response = ApiResult.class)
    public ApiResult<Boolean> updateDict(@Valid @RequestBody Dict dict) throws Exception {
        boolean flag = dictService.updateDict(dict);
        return ApiResult.result(flag);
    }

    /**
     * 删除
     */
    @PostMapping("/delete/{id}")
    @RequiresPermissions("dict:delete")
    @ApiOperation(value = "删除Dict对象", notes = "删除", response = ApiResult.class)
    public ApiResult<Boolean> deleteDict(@PathVariable("id") Long id) throws Exception {
        boolean flag = dictService.deleteDict(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("dict:info")
    @ApiOperation(value = "获取Dict对象详情", notes = "查看", response = DictQueryVo.class)
    public ApiResult<DictQueryVo> getDict(@PathVariable("id") Long id) throws Exception {
        DictQueryVo dictQueryVo = dictService.getDictById(id);
        return ApiResult.ok(dictQueryVo);
    }

    /**
     * 分页列表
     */
    @PostMapping("/getPageList")
    @RequiresPermissions("dict:page")
    @ApiOperation(value = "获取Dict分页列表", notes = "分页列表", response = DictQueryVo.class)
    public ApiResult<Paging<DictQueryVo>> getDictPageList(@Valid @RequestBody DictQueryParam dictQueryParam) throws Exception {
        Paging<DictQueryVo> paging = dictService.getDictPageList(dictQueryParam);
        return ApiResult.ok(paging);
    }

    /**
     * 根据parentId获取子对象
     */
    @GetMapping("/infoByParentCode/{parentCode}")
    @RequiresPermissions("event:type:info")
    @ApiOperation(value = "获取EventType对象详情", notes = "查看", response = EventTypeQueryVo.class)
    public ApiResult<DictQueryVo> getEventTypeByParentCode(@PathVariable("parentCode") String id) throws Exception {
        List<DictQueryVo> dictQueryVoList = dictService.getDictTypeByParentCode(id);
        return ApiResult.ok(dictQueryVoList);
    }

}

