package com.wavenet.maintenance.web;

import com.wavenet.maintenance.dao.entity.TPumptruckControl;
import com.wavenet.maintenance.service.TPumptruckControlService;
import com.wavenet.maintenance.web.query.TPumptruckControlQueryParam;
import com.wavenet.maintenance.web.vo.TPumptruckControlQueryVo;
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
 * 泵车状态表 前端控制器
 * </pre>
 *
 * @author zll
 * @since 2020-05-10
 */
@Slf4j
@RestController
@RequestMapping("/tPumptruckControl")
@Api("泵车状态表 API")
public class TPumptruckControlController extends BaseController {

    @Autowired
    private TPumptruckControlService tPumptruckControlService;

    /**
     * 添加泵车状态表
     */
    @PostMapping("/add")
    @RequiresPermissions("t:pumptruck:control:add")
    @ApiOperation(value = "添加TPumptruckControl对象", notes = "添加泵车状态表", response = ApiResult.class)
    public ApiResult<Boolean> addTPumptruckControl(@Valid @RequestBody TPumptruckControl tPumptruckControl) throws Exception {
        boolean flag = tPumptruckControlService.saveTPumptruckControl(tPumptruckControl);
        return ApiResult.result(flag);
    }

    /**
     * 修改泵车状态表
     */
    @PostMapping("/update")
    @RequiresPermissions("t:pumptruck:control:update")
    @ApiOperation(value = "修改TPumptruckControl对象", notes = "修改泵车状态表", response = ApiResult.class)
    public ApiResult<Boolean> updateTPumptruckControl(@Valid @RequestBody TPumptruckControl tPumptruckControl) throws Exception {
        boolean flag = tPumptruckControlService.updateTPumptruckControl(tPumptruckControl);
        return ApiResult.result(flag);
    }

    /**
     * 删除泵车状态表
     */
    @PostMapping("/delete/{id}")
    @RequiresPermissions("t:pumptruck:control:delete")
    @ApiOperation(value = "删除TPumptruckControl对象", notes = "删除泵车状态表", response = ApiResult.class)
    public ApiResult<Boolean> deleteTPumptruckControl(@PathVariable("id") Long id) throws Exception {
        boolean flag = tPumptruckControlService.deleteTPumptruckControl(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取泵车状态表
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("t:pumptruck:control:info")
    @ApiOperation(value = "获取TPumptruckControl对象详情", notes = "查看泵车状态表", response = TPumptruckControlQueryVo.class)
    public ApiResult<TPumptruckControlQueryVo> getTPumptruckControl(@PathVariable("id") Long id) throws Exception {
        TPumptruckControlQueryVo tPumptruckControlQueryVo = tPumptruckControlService.getTPumptruckControlById(id);
        return ApiResult.ok(tPumptruckControlQueryVo);
    }

    /**
     * 泵车状态表分页列表
     */
    @PostMapping("/getPageList")
    @RequiresPermissions("t:pumptruck:control:page")
    @ApiOperation(value = "获取TPumptruckControl分页列表", notes = "泵车状态表分页列表", response = TPumptruckControlQueryVo.class)
    public ApiResult<Paging<TPumptruckControlQueryVo>> getTPumptruckControlPageList(@Valid @RequestBody TPumptruckControlQueryParam tPumptruckControlQueryParam) throws Exception {
        Paging<TPumptruckControlQueryVo> paging = tPumptruckControlService.getTPumptruckControlPageList(tPumptruckControlQueryParam);
        return ApiResult.ok(paging);
    }

}

