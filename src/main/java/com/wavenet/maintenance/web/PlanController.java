/**
 * All rights Reserved, Designed By www.wavenet.com.cn
 *
 * @Title: PlanController.java
 * @Package com.wavenet.maintenance.web.vo
 * @Description: (用一句话描述该文件做什么)
 * @author: admin
 * @date: 2020-04-17 9:58
 * @version V1.0
 * @Copyright: 2020 www.wavenet.com.cn. All rights reserved.
 * 注意：本内容仅限于上海网波软件股份有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
package com.wavenet.maintenance.web;

import com.wavenet.maintenance.dao.entity.MaintenanceDetail;
import com.wavenet.maintenance.service.PlanService;
import com.wavenet.maintenance.web.vo.PlanTableVo;
import com.wavenetframework.boot.common.api.ApiResult;
import com.wavenetframework.boot.common.controller.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: PlanController
 * @Description: (这里用一句话描述这个类的作用)
 * @author: admin
 * @date: 2020-04-17 9:58     
 * @Copyright: 2020 www.wavenet.com.cn. All rights reserved.
 */
@RestController
@RequestMapping(value = "/plan")
@Api(tags = {"计划疏通列表"})
public class PlanController extends BaseController {
    @Resource
    private PlanService service;

    /**
     * 查询计划疏通
     */
    @ApiOperation(value = "查询疏通计划")
    @GetMapping(value = "/plans")
    public ApiResult<PlanTableVo> selectPlan(String year,String month,String team ) throws Exception {
        List<PlanTableVo> list = service.selectPlan(year, month,team);
        return ApiResult.ok(list);
    }

    /**
     * 查询路段名称
     */
    @ApiOperation(value = "查询路段名称")
    @GetMapping(value = "/roadName")
    public ApiResult<MaintenanceDetail> selectRoadName(String year, String month, String team ) throws Exception {
        List<MaintenanceDetail> list = service.selectRoadName(year, month,team);
        return ApiResult.ok(list);
    }
}
