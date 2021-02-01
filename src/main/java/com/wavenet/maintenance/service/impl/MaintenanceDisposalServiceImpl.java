package com.wavenet.maintenance.service.impl;

import java.io.Serializable;
import java.util.List;


import com.wavenet.maintenance.dao.entity.MaintenanceDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wavenet.maintenance.dao.entity.MaintenanceDisposal;
import com.wavenet.maintenance.dao.mapper.MaintenanceDetailMapper;
import com.wavenet.maintenance.dao.mapper.MaintenanceDisposalMapper;
import com.wavenet.maintenance.service.MaintenanceDisposalService;
import com.wavenet.maintenance.web.query.MaintenanceDisposalQueryParam;
import com.wavenet.maintenance.web.vo.MaintenanceDisposalQueryVo;
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
public class MaintenanceDisposalServiceImpl extends BaseServiceImpl<MaintenanceDisposalMapper, MaintenanceDisposal> implements MaintenanceDisposalService {

    @Autowired
    private MaintenanceDisposalMapper maintenanceDisposalMapper;
    @Autowired
    private MaintenanceDetailMapper maintenanceDetailMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public String saveMaintenanceDisposal(MaintenanceDisposal maintenanceDisposal ) throws Exception {
        if (super.save(maintenanceDisposal)) {
            return maintenanceDisposal.getDisposalCode();
        }else {
            return null;
        }

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateMaintenanceDisposal(MaintenanceDisposal maintenanceDisposal) throws Exception {
        MaintenanceDetail maintenanceDetail=new MaintenanceDetail();
        maintenanceDetail.setDetailCode(maintenanceDisposal.getDetailCode());
        maintenanceDetail.setCuringState(maintenanceDetail.getCuringState());
        //maintenanceDetailMapper.updateById(maintenanceDetail);
        return super.updateById(maintenanceDisposal);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteMaintenanceDisposal(String id) throws Exception {
        return super.removeById(id);
    }

    @Override
    public MaintenanceDisposalQueryVo getMaintenanceDisposalById(Serializable id) throws Exception {
        return maintenanceDisposalMapper.getMaintenanceDisposalById(id);
    }

    @Override
    public Paging<MaintenanceDisposalQueryVo> getMaintenanceDisposalPageList(MaintenanceDisposalQueryParam maintenanceDisposalQueryParam) throws Exception {
        Page page = setPageParam(maintenanceDisposalQueryParam);
        IPage<MaintenanceDisposalQueryVo> iPage = maintenanceDisposalMapper.getMaintenanceDisposalPageList(page, maintenanceDisposalQueryParam);
        return  new Paging(iPage);
    }

    @Override
    public Long getLengthCount(MaintenanceDisposalQueryParam maintenanceDisposalQueryParam) throws Exception {
        Long count = maintenanceDisposalMapper.getLengthCount(maintenanceDisposalQueryParam);
        return count;
    }

}
