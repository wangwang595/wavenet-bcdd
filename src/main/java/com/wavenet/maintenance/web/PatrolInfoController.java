package com.wavenet.maintenance.web;

import com.wavenet.maintenance.dao.entity.PatrolInfo;
import com.wavenet.maintenance.service.PatrolInfoService;
import com.wavenet.maintenance.web.query.PatrolInfoQueryParam;
import com.wavenet.maintenance.web.vo.PatrolInfoQueryVo;
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
@RequestMapping("/patrolInfo")
@Api(" API")
public class PatrolInfoController extends BaseController {

    @Autowired
    private PatrolInfoService patrolInfoService;

    /**
     * 添加
     */
    @PostMapping("/add")
    @RequiresPermissions("patrol:info:add")
    @ApiOperation(value = "添加PatrolInfo对象", notes = "添加", response = ApiResult.class)
    public ApiResult<Boolean> addPatrolInfo(@Valid @RequestBody PatrolInfo patrolInfo) throws Exception {
        String flag = patrolInfoService.savePatrolInfo(patrolInfo);
        if (flag.isEmpty()) {
            return ApiResult.fail();
        }else {
            return ApiResult.ok(flag);
        }

    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @RequiresPermissions("patrol:info:update")
    @ApiOperation(value = "修改PatrolInfo对象", notes = "修改", response = ApiResult.class)
    public ApiResult<Boolean> updatePatrolInfo(@Valid @RequestBody PatrolInfo patrolInfo) throws Exception {
        boolean flag = patrolInfoService.updatePatrolInfo(patrolInfo);
        return ApiResult.result(flag);
    }

    /**
     * 删除
     */
    @PostMapping("/delete/{id}")
    @RequiresPermissions("patrol:info:delete")
    @ApiOperation(value = "删除PatrolInfo对象", notes = "删除", response = ApiResult.class)
    public ApiResult<Boolean> deletePatrolInfo(@PathVariable("id") Long id) throws Exception {
        boolean flag = patrolInfoService.deletePatrolInfo(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("patrol:info:info")
    @ApiOperation(value = "获取PatrolInfo对象详情", notes = "查看", response = PatrolInfoQueryVo.class)
    public ApiResult<PatrolInfoQueryVo> getPatrolInfo(@PathVariable("id") Long id) throws Exception {
        PatrolInfoQueryVo patrolInfoQueryVo = patrolInfoService.getPatrolInfoById(id);
        return ApiResult.ok(patrolInfoQueryVo);
    }

    /**
     * 分页列表
     */
    @PostMapping("/getPageList")
    @RequiresPermissions("patrol:info:page")
    @ApiOperation(value = "获取PatrolInfo分页列表", notes = "分页列表", response = PatrolInfoQueryVo.class)
    public ApiResult<Paging<PatrolInfoQueryVo>> getPatrolInfoPageList(@Valid @RequestBody PatrolInfoQueryParam patrolInfoQueryParam) throws Exception {
        Paging<PatrolInfoQueryVo> paging = patrolInfoService.getPatrolInfoPageList(patrolInfoQueryParam);
        return ApiResult.ok(paging);
    }

}

