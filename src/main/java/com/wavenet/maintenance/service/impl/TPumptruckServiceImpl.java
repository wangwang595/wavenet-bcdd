package com.wavenet.maintenance.service.impl;

import com.wavenet.maintenance.dao.entity.TPumptruck;
import com.wavenet.maintenance.dao.mapper.TPumptruckMapper;
import com.wavenet.maintenance.service.TPumptruckService;
import com.wavenet.maintenance.web.query.ShiQuVoQueryParm;
import com.wavenet.maintenance.web.query.TPumptruckQueryParam;
import com.wavenet.maintenance.web.vo.PumptruckAllInfoVo;

import com.wavenet.maintenance.web.vo.TPumptruckControlQueryVo;
import com.wavenet.maintenance.web.vo.TPumptruckQueryVo;
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
 * @since 2020-05-10
 */
@Slf4j
@Service
public class TPumptruckServiceImpl extends BaseServiceImpl<TPumptruckMapper, TPumptruck> implements TPumptruckService {

    @Autowired
    private TPumptruckMapper tPumptruckMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveTPumptruck(TPumptruck tPumptruck) throws Exception {
        return super.save(tPumptruck);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateTPumptruck(TPumptruck tPumptruck) throws Exception {
        return super.updateById(tPumptruck);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteTPumptruck(Long id) throws Exception {
        return super.removeById(id);
    }

    @Override
    public TPumptruckQueryVo getTPumptruckById(Serializable id) throws Exception {
        return tPumptruckMapper.getTPumptruckById(id);
    }

    @Override
    public Paging<TPumptruckQueryVo> getTPumptruckPageList(TPumptruckQueryParam tPumptruckQueryParam) throws Exception {
        Page page = setPageParam(tPumptruckQueryParam, OrderItem.desc("create_time"));
        IPage<TPumptruckQueryVo> iPage = tPumptruckMapper.getTPumptruckPageList(page, tPumptruckQueryParam);
        return new Paging(iPage);
    }

    @Override
    public List<String> getshiqu( ) {


        return tPumptruckMapper.getshijikongxian();
    }

    @Override
    public List<PumptruckAllInfoVo> getPumptruckAllInfo(String sPtId) {

        List<PumptruckAllInfoVo> pumptruckAllInfoVos = tPumptruckMapper.getPumptruckAllInfo(sPtId);

        return pumptruckAllInfoVos;
    }

}
