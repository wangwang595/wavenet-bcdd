package com.wavenet.maintenance.web;

import com.wavenet.maintenance.dao.entity.Syscommando;
import com.wavenet.maintenance.service.SyscommandoService;
import com.wavenet.maintenance.web.query.SyscommandoQueryParam;
import com.wavenet.maintenance.web.vo.SyscommandoQueryVo;
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
 * @since 2020-05-10
 */
@Slf4j
@RestController
@RequestMapping("/syscommando")
@Api(" API")
public class SyscommandoController extends BaseController {

    @Autowired
    private SyscommandoService syscommandoService;

    /**
     * 添加
     */
    @PostMapping("/add")
    @RequiresPermissions("syscommando:add")
    @ApiOperation(value = "添加Syscommando对象", notes = "添加", response = ApiResult.class)
    public ApiResult<Boolean> addSyscommando(@Valid @RequestBody Syscommando syscommando) throws Exception {
        boolean flag = syscommandoService.saveSyscommando(syscommando);
        return ApiResult.result(flag);
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @RequiresPermissions("syscommando:update")
    @ApiOperation(value = "修改Syscommando对象", notes = "修改", response = ApiResult.class)
    public ApiResult<Boolean> updateSyscommando(@Valid @RequestBody Syscommando syscommando) throws Exception {
        boolean flag = syscommandoService.updateSyscommando(syscommando);
        return ApiResult.result(flag);
    }

    /**
     * 删除
     */
    @PostMapping("/delete/{id}")
    @RequiresPermissions("syscommando:delete")
    @ApiOperation(value = "删除Syscommando对象", notes = "删除", response = ApiResult.class)
    public ApiResult<Boolean> deleteSyscommando(@PathVariable("id") Long id) throws Exception {
        boolean flag = syscommandoService.deleteSyscommando(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("syscommando:info")
    @ApiOperation(value = "获取Syscommando对象详情", notes = "查看", response = SyscommandoQueryVo.class)
    public ApiResult<SyscommandoQueryVo> getSyscommando(@PathVariable("id") Long id) throws Exception {
        SyscommandoQueryVo syscommandoQueryVo = syscommandoService.getSyscommandoById(id);
        return ApiResult.ok(syscommandoQueryVo);
    }

    /**
     * 分页列表
     */
    @PostMapping("/getPageList")
    @RequiresPermissions("syscommando:page")
    @ApiOperation(value = "获取Syscommando分页列表", notes = "分页列表", response = SyscommandoQueryVo.class)
    public ApiResult<Paging<SyscommandoQueryVo>> getSyscommandoPageList(@Valid @RequestBody SyscommandoQueryParam syscommandoQueryParam) throws Exception {
        Paging<SyscommandoQueryVo> paging = syscommandoService.getSyscommandoPageList(syscommandoQueryParam);
        return ApiResult.ok(paging);
    }

    /**
     * 突击队信息
     */
    @PostMapping("/getsysinfo")
    @ApiOperation(value = "获取突击队信息")
    public ApiResult<List<Integer>> gettujidui() throws Exception {
        List<Integer> integers = syscommandoService.syscommInfo();
        return ApiResult.ok(integers);
    }

}

