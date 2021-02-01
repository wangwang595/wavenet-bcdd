package com.wavenet.maintenance.web;

import com.wavenet.maintenance.dao.entity.TDictianory;
import com.wavenet.maintenance.service.TDictianoryService;
import com.wavenet.maintenance.web.query.TDictianoryQueryParam;
import com.wavenet.maintenance.web.vo.TDictianoryQueryVo;
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
 * 字典表 前端控制器
 * </pre>
 *
 * @author zll
 * @since 2020-05-14
 */
@Slf4j
@RestController
@RequestMapping("/tDictianory")
@Api("字典表 API")
public class TDictianoryController extends BaseController {

    @Autowired
    private TDictianoryService tDictianoryService;

    /**
     * 添加字典表
     */
    @PostMapping("/add")
    @RequiresPermissions("t:dictianory:add")
    @ApiOperation(value = "添加TDictianory对象", notes = "添加字典表", response = ApiResult.class)
    public ApiResult<Boolean> addTDictianory(@Valid @RequestBody TDictianory tDictianory) throws Exception {
        boolean flag = tDictianoryService.saveTDictianory(tDictianory);
        return ApiResult.result(flag);
    }

    /**
     * 修改字典表
     */
    @PostMapping("/update")
    @RequiresPermissions("t:dictianory:update")
    @ApiOperation(value = "修改TDictianory对象", notes = "修改字典表", response = ApiResult.class)
    public ApiResult<Boolean> updateTDictianory(@Valid @RequestBody TDictianory tDictianory) throws Exception {
        boolean flag = tDictianoryService.updateTDictianory(tDictianory);
        return ApiResult.result(flag);
    }

    /**
     * 删除字典表
     */
    @PostMapping("/delete/{id}")
    @RequiresPermissions("t:dictianory:delete")
    @ApiOperation(value = "删除TDictianory对象", notes = "删除字典表", response = ApiResult.class)
    public ApiResult<Boolean> deleteTDictianory(@PathVariable("id") Long id) throws Exception {
        boolean flag = tDictianoryService.deleteTDictianory(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取字典表
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("t:dictianory:info")
    @ApiOperation(value = "获取TDictianory对象详情", notes = "查看字典表", response = TDictianoryQueryVo.class)
    public ApiResult<TDictianoryQueryVo> getTDictianory(@PathVariable("id") Long id) throws Exception {
        TDictianoryQueryVo tDictianoryQueryVo = tDictianoryService.getTDictianoryById(id);
        return ApiResult.ok(tDictianoryQueryVo);
    }

    /**
     * 字典表分页列表
     */
    @PostMapping("/getPageList")
    @RequiresPermissions("t:dictianory:page")
    @ApiOperation(value = "获取TDictianory分页列表", notes = "字典表分页列表", response = TDictianoryQueryVo.class)
    public ApiResult<Paging<TDictianoryQueryVo>> getTDictianoryPageList(@Valid @RequestBody TDictianoryQueryParam tDictianoryQueryParam) throws Exception {
        Paging<TDictianoryQueryVo> paging = tDictianoryService.getTDictianoryPageList(tDictianoryQueryParam);
        return ApiResult.ok(paging);
    }

}

