package com.wavenet.maintenance.service.impl;

import java.io.Serializable;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wavenetframework.boot.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wavenet.maintenance.dao.entity.MaintenanceDetail;
import com.wavenet.maintenance.dao.mapper.MaintenanceDetailMapper;
import com.wavenet.maintenance.service.MaintenanceDetailService;
import com.wavenet.maintenance.web.query.MaintenanceDetailQueryParam;
import com.wavenet.maintenance.web.vo.MaintenanceDetailQueryVo;
import com.wavenetframework.boot.common.service.impl.BaseServiceImpl;
import com.wavenetframework.boot.common.vo.Paging;

import lombok.extern.slf4j.Slf4j;


/**
 * <pre>
 *  服务实现类
 * </pre>
 *
 * @author zll
 * @since 2020-03-13
 */
@Slf4j
@Service
@DS("application")
public class MaintenanceDetailServiceImpl extends BaseServiceImpl<MaintenanceDetailMapper, MaintenanceDetail> implements MaintenanceDetailService {

    @Autowired
    private MaintenanceDetailMapper maintenanceDetailMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveMaintenanceDetail(MaintenanceDetail maintenanceDetail) throws Exception {
        return super.save(maintenanceDetail);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateMaintenanceDetail(MaintenanceDetail maintenanceDetail) throws Exception {
        return super.updateById(maintenanceDetail);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteMaintenanceDetail(String id) throws Exception {
        return super.removeById(id);
    }

    @Override
    public MaintenanceDetailQueryVo getMaintenanceDetailById(Serializable id) throws Exception {
        return maintenanceDetailMapper.getMaintenanceDetailById(id);
    }

    @Override
    public Paging<MaintenanceDetailQueryVo> getMaintenanceDetailPageList(MaintenanceDetailQueryParam maintenanceDetailQueryParam) throws Exception {
        Page page = setPageParam(maintenanceDetailQueryParam);
        IPage<MaintenanceDetailQueryVo> iPage = maintenanceDetailMapper.getMaintenanceDetailPageList(page, maintenanceDetailQueryParam);
        return new Paging(iPage);
    }

    @Override
    public MaintenanceDetailQueryVo getMaintenanceDetail(MaintenanceDetailQueryParam maintenanceDetailQueryParam) throws Exception {

        MaintenanceDetailQueryVo vo=maintenanceDetailMapper.getMaintenanceDetail(maintenanceDetailQueryParam);

        return vo;
    }

}
