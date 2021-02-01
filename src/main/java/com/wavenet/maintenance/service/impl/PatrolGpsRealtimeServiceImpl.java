package com.wavenet.maintenance.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wavenet.maintenance.dao.entity.PatrolGpsRealtime;
import com.wavenet.maintenance.dao.mapper.PatrolGpsRealtimeMapper;
import com.wavenet.maintenance.service.PatrolGpsRealtimeService;
import com.wavenet.maintenance.web.query.PatrolGpsRealtimeQueryParam;
import com.wavenet.maintenance.web.vo.PatrolGpsRealtimeQueryVo;
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
public class PatrolGpsRealtimeServiceImpl extends BaseServiceImpl<PatrolGpsRealtimeMapper, PatrolGpsRealtime> implements PatrolGpsRealtimeService {

    @Autowired
    private PatrolGpsRealtimeMapper patrolGpsRealtimeMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean savePatrolGpsRealtime(PatrolGpsRealtime patrolGpsRealtime) throws Exception {
        return super.save(patrolGpsRealtime);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updatePatrolGpsRealtime(PatrolGpsRealtime patrolGpsRealtime) throws Exception {
        return super.updateById(patrolGpsRealtime);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deletePatrolGpsRealtime(Long id) throws Exception {
        return super.removeById(id);
    }

    @Override
    public PatrolGpsRealtimeQueryVo getPatrolGpsRealtimeById(Serializable id) throws Exception {
        return patrolGpsRealtimeMapper.getPatrolGpsRealtimeById(id);
    }

    @Override
    public Paging<PatrolGpsRealtimeQueryVo> getPatrolGpsRealtimePageList(PatrolGpsRealtimeQueryParam patrolGpsRealtimeQueryParam) throws Exception {
        Page page = setPageParam(patrolGpsRealtimeQueryParam, OrderItem.desc("create_time"));
        IPage<PatrolGpsRealtimeQueryVo> iPage = patrolGpsRealtimeMapper.getPatrolGpsRealtimePageList(page, patrolGpsRealtimeQueryParam);
        return new Paging(iPage);
    }

}
