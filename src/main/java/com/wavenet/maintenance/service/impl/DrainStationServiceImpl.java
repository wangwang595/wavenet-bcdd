package com.wavenet.maintenance.service.impl;

import com.wavenet.maintenance.dao.entity.DrainStation;
import com.wavenet.maintenance.dao.entity.MaintenanceDetail;
import com.wavenet.maintenance.dao.mapper.DrainStationMapper;
import com.wavenet.maintenance.service.DrainStationService;
import com.wavenet.maintenance.web.query.DrainStationQueryParam;
import com.wavenet.maintenance.web.vo.DrainStationQueryVo;
import com.wavenetframework.boot.common.service.impl.BaseServiceImpl;
import com.wavenetframework.boot.common.vo.Paging;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.io.Serializable;
import java.util.List;


/**
 * <pre>
 *  服务实现类
 * </pre>
 *
 * @author zll
 * @since 2020-05-06
 */
@Slf4j
@Service
public class DrainStationServiceImpl extends BaseServiceImpl<DrainStationMapper, DrainStation> implements DrainStationService {

    @Autowired
    private DrainStationMapper drainStationMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveDrainStation(DrainStation drainStation) throws Exception {
        return super.save(drainStation);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateDrainStation(DrainStation drainStation) throws Exception {
        return super.updateById(drainStation);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteDrainStation(Long id) throws Exception {
        return super.removeById(id);
    }

    @Override
    public DrainStationQueryVo getDrainStationById(Serializable id) throws Exception {
        return drainStationMapper.getDrainStationById(id);
    }

    @Override
    public Paging<DrainStationQueryVo> getDrainStationPageList(DrainStationQueryParam drainStationQueryParam) throws Exception {
        Page page = setPageParam(drainStationQueryParam, OrderItem.desc("create_time"));
        IPage<DrainStationQueryVo> iPage = drainStationMapper.getDrainStationPageList(page, drainStationQueryParam);
        return new Paging(iPage);
    }
    @Override
    public List<DrainStationQueryVo>  selectDrainById(String stStationid) throws Exception{
        List<DrainStationQueryVo> list = drainStationMapper.selectDrainById(stStationid);
        return list;
    }

}
