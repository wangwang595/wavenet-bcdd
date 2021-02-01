package com.wavenet.maintenance.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wavenet.maintenance.dao.entity.MaintenanceDisposal;
import com.wavenet.maintenance.service.MaintenanceDetailService;
import com.wavenet.maintenance.service.MaintenanceDisposalService;
import com.wavenet.maintenance.web.query.MaintenanceDisposalQueryParam;
import com.wavenet.maintenance.web.vo.MaintenanceDisposalQueryVo;
import com.wavenetframework.boot.common.api.ApiResult;
import com.wavenetframework.boot.common.controller.BaseController;
import com.wavenetframework.boot.common.vo.Paging;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

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
@RequestMapping("/maintenanceDisposal")
@Api(" API")
public class MaintenanceDisposalController extends BaseController {

    @Autowired
    private MaintenanceDisposalService maintenanceDisposalService;

    @Autowired
    private  MaintenanceDetailService maintenanceDetailService;
    /**
     * 添加
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加MaintenanceDisposal对象", notes = "添加", response = ApiResult.class)
    public ApiResult<String> addMaintenanceDisposal(@Valid @RequestBody MaintenanceDisposal maintenanceDisposal) throws Exception {
        String flag = maintenanceDisposalService.saveMaintenanceDisposal(maintenanceDisposal);
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
    @ApiOperation(value = "修改MaintenanceDisposal对象", notes = "修改", response = ApiResult.class)
    public ApiResult<Boolean> updateMaintenanceDisposal(@Valid @RequestBody MaintenanceDisposal maintenanceDisposal) throws Exception {
        boolean flag = maintenanceDisposalService.updateMaintenanceDisposal(maintenanceDisposal);
        return ApiResult.result(flag);
    }

    /**
     * 删除
     */
    @PostMapping("/delete/{id}")
    @ApiOperation(value = "删除MaintenanceDisposal对象", notes = "删除", response = ApiResult.class)
    public ApiResult<Boolean> deleteMaintenanceDisposal(@PathVariable("id") String id) throws Exception {
        boolean flag = maintenanceDisposalService.deleteMaintenanceDisposal(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取MaintenanceDisposal对象详情", notes = "查看", response = MaintenanceDisposalQueryVo.class)
    public ApiResult<MaintenanceDisposalQueryVo> getMaintenanceDisposal(@PathVariable("id") String id) throws Exception {
        MaintenanceDisposalQueryVo maintenanceDisposalQueryVo = maintenanceDisposalService.getMaintenanceDisposalById(id);
        return ApiResult.ok(maintenanceDisposalQueryVo);
    }

    /**
     * 分页列表
     */
    @PostMapping ("/getPageList")
    @ApiOperation(value = "获取MaintenanceDisposal分页列表", notes = "分页列表", response = MaintenanceDisposalQueryVo.class)
    public ApiResult<Paging<MaintenanceDisposalQueryVo>> getMaintenanceDisposalPageList(@Valid @RequestBody MaintenanceDisposalQueryParam maintenanceDisposalQueryParam) throws Exception {
        Paging<MaintenanceDisposalQueryVo> paging = maintenanceDisposalService.getMaintenanceDisposalPageList(maintenanceDisposalQueryParam);
        return ApiResult.ok(paging);
    }

    /**
     * 查询长度总和
     */
    @PostMapping ("/getLength")
    @ApiOperation(value = "获取长度总和", notes = "分页列表", response = MaintenanceDisposalQueryVo.class)
    public ApiResult<Long> getLengthCount(@Valid @RequestBody MaintenanceDisposalQueryParam maintenanceDisposalQueryParam) throws Exception {
        Long count = maintenanceDisposalService.getLengthCount(maintenanceDisposalQueryParam);
        return ApiResult.ok(count);
    }

}

