package com.wavenet.maintenance.web;

import javax.validation.Valid;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wavenet.maintenance.dao.entity.MaintenanceDetail;
import com.wavenet.maintenance.service.MaintenanceDetailService;
import com.wavenet.maintenance.web.query.MaintenanceDetailQueryParam;
import com.wavenet.maintenance.web.vo.MaintenanceDetailQueryVo;
import com.wavenetframework.boot.common.api.ApiResult;
import com.wavenetframework.boot.common.controller.BaseController;
import com.wavenetframework.boot.common.vo.Paging;
import com.wavenetframework.boot.util.UUIDUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * <pre>
 *  前端控制器
 * </pre>
 *
 * @author zll
 * @since 2020-03-13
 */
@Slf4j
@RestController
@RequestMapping("/maintenanceDetail")
@Api(" API")
public class MaintenanceDetailController extends BaseController {

    @Autowired
    private MaintenanceDetailService maintenanceDetailService;

    /**
     * 添加
     */
    @PostMapping("/add")
    @RequiresPermissions("maintenance:maintenanceDetail:add")
    @ApiOperation(value = "添加MaintenanceDetail对象", notes = "添加", response = ApiResult.class)
    public ApiResult<Boolean> addMaintenanceDetail(@Valid @RequestBody MaintenanceDetail maintenanceDetail) throws Exception {
        maintenanceDetail.setDetailCode(UUIDUtil.getUUID());
        boolean flag = maintenanceDetailService.saveMaintenanceDetail(maintenanceDetail);
        return ApiResult.result(flag);
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @RequiresPermissions("maintenance:maintenanceDetail:update")
    @ApiOperation(value = "修改MaintenanceDetail对象", notes = "修改", response = ApiResult.class)
    public ApiResult<Boolean> updateMaintenanceDetail(@Valid @RequestBody MaintenanceDetail maintenanceDetail) throws Exception {
        boolean flag = maintenanceDetailService.updateMaintenanceDetail(maintenanceDetail);
        return ApiResult.result(flag);
    }

    /**
     * 删除
     */
    @PostMapping("/delete/{id}")
    @RequiresPermissions("maintenance:maintenanceDetail:delete")
    @ApiOperation(value = "删除MaintenanceDetail对象", notes = "删除", response = ApiResult.class)
    public ApiResult<Boolean> deleteMaintenanceDetail(@PathVariable("id") String id) throws Exception {
        boolean flag = maintenanceDetailService.deleteMaintenanceDetail(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("maintenance:maintenanceDetail:info")
    @ApiOperation(value = "获取MaintenanceDetail对象详情", notes = "查看", response = MaintenanceDetailQueryVo.class)
    public ApiResult<MaintenanceDetailQueryVo> getMaintenanceDetailById(@PathVariable("id") String id) throws Exception {
        MaintenanceDetailQueryVo maintenanceDetailQueryVo = maintenanceDetailService.getMaintenanceDetailById(id);
        return ApiResult.ok(maintenanceDetailQueryVo);
    }

    /**
     * 分页列表
     */
    @PostMapping("/getPageList")
    @ApiOperation(value = "获取MaintenanceDetail分页列表", notes = "分页列表", response = MaintenanceDetailQueryVo.class)
    public ApiResult<Paging<MaintenanceDetailQueryVo>> getMaintenanceDetailPageList(@Valid @RequestBody MaintenanceDetailQueryParam maintenanceDetailQueryParam) throws Exception {
        Paging<MaintenanceDetailQueryVo> paging = maintenanceDetailService.getMaintenanceDetailPageList(maintenanceDetailQueryParam);
        return ApiResult.ok(paging);
    }


    /**
     * 获取
     */
    @PostMapping("/info")
    @RequiresPermissions("maintenance:maintenanceDetail:info")
    @ApiOperation(value = "获取MaintenanceDetail对象详情", notes = "查看", response = MaintenanceDetailQueryVo.class)
    public ApiResult<MaintenanceDetailQueryVo> getMaintenanceDetail(@Valid @RequestBody MaintenanceDetailQueryParam maintenanceDetailQueryParam) throws Exception {
        MaintenanceDetailQueryVo maintenanceDetailQueryVo = maintenanceDetailService.getMaintenanceDetail(maintenanceDetailQueryParam);
        return ApiResult.ok(maintenanceDetailQueryVo);
    }

}

