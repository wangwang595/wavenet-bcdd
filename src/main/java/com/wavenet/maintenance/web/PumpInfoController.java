package com.wavenet.maintenance.web;

import com.wavenet.maintenance.dao.entity.Syscommando;
import com.wavenet.maintenance.service.PumpInfoService;
import com.wavenet.maintenance.service.SyscommandoService;
import com.wavenet.maintenance.web.query.ShiQuVoQueryParm;
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
@RequestMapping("/PumpInfo")
@Api(" API")
public class PumpInfoController extends BaseController {

    @Autowired
    private PumpInfoService pumpInfoService;

    @PostMapping("/shuliang")
    @ApiOperation(value = "获取PumpInfo")
    public ApiResult<List<Integer>> getshuliang() throws  Exception{
        List<Integer> info = pumpInfoService.getTPumpInfo();
        return ApiResult.ok(info);

    }

    @GetMapping("/shijishuliang")
    @ApiOperation(value = "获取市级的数量")
    public ApiResult<List<Integer>> getshijishuliang(String city) throws  Exception{
        List<Integer> info = pumpInfoService.getshijishuliang(city);
        return ApiResult.ok(info);

    }


}

