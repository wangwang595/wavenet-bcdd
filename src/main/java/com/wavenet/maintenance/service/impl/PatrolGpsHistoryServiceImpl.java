package com.wavenet.maintenance.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wavenet.maintenance.dao.entity.PatrolGpsHistory;
import com.wavenet.maintenance.dao.entity.PatrolGpsRealtime;
import com.wavenet.maintenance.dao.mapper.PatrolGpsHistoryMapper;
import com.wavenet.maintenance.service.PatrolGpsHistoryService;
import com.wavenet.maintenance.service.PatrolGpsRealtimeService;
import com.wavenet.maintenance.web.query.PatrolGpsHistoryQueryParam;
import com.wavenet.maintenance.web.vo.PatrolGpsHistoryQueryVo;
import com.wavenetframework.boot.common.service.impl.BaseServiceImpl;
import com.wavenetframework.boot.common.vo.Paging;
import com.wavenetframework.boot.util.BeanUtil;

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
public class PatrolGpsHistoryServiceImpl extends BaseServiceImpl<PatrolGpsHistoryMapper, PatrolGpsHistory> implements PatrolGpsHistoryService {

    @Autowired
    private PatrolGpsHistoryMapper patrolGpsHistoryMapper;
    @Autowired
    private PatrolGpsRealtimeService patrolGpsRealtimeService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean savePatrolGpsHistory(PatrolGpsHistory patrolGpsHistory) throws Exception {
        return super.save(patrolGpsHistory);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updatePatrolGpsHistory(PatrolGpsHistory patrolGpsHistory) throws Exception {
        return super.updateById(patrolGpsHistory);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deletePatrolGpsHistory(Long id) throws Exception {
        return super.removeById(id);
    }

    @Override
    public PatrolGpsHistoryQueryVo getPatrolGpsHistoryById(Serializable id) throws Exception {
        return patrolGpsHistoryMapper.getPatrolGpsHistoryById(id);
    }

    @Override
    public Paging<PatrolGpsHistoryQueryVo> getPatrolGpsHistoryPageList(PatrolGpsHistoryQueryParam patrolGpsHistoryQueryParam) throws Exception {
        Page page = setPageParam(patrolGpsHistoryQueryParam, OrderItem.desc("create_time"));
        IPage<PatrolGpsHistoryQueryVo> iPage = patrolGpsHistoryMapper.getPatrolGpsHistoryPageList(page, patrolGpsHistoryQueryParam);
        return new Paging(iPage);
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean savePatrolGpsHistoryAndUpdatePatrolRelam(PatrolGpsHistory patrolGpsHistory) throws Exception {
        savePatrolGpsHistory(patrolGpsHistory);
        PatrolGpsRealtime patrolGpsRealtime=new PatrolGpsRealtime();
        BeanUtil.copyProperties(patrolGpsRealtime,patrolGpsHistory);
        boolean flag=patrolGpsRealtimeService.saveOrUpdate(patrolGpsRealtime);
        return flag;
    }

}
