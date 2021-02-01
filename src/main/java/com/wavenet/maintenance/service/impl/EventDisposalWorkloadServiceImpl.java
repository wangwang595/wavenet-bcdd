package com.wavenet.maintenance.service.impl;

import com.wavenet.maintenance.dao.entity.EventDisposalWorkload;
import com.wavenet.maintenance.dao.mapper.EventDisposalWorkloadMapper;
import com.wavenet.maintenance.service.EventDisposalWorkloadService;
import com.wavenet.maintenance.web.query.EventDisposalWorkloadQueryParam;
import com.wavenet.maintenance.web.vo.EventDisposalWorkloadQueryVo;
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
 * @since 2020-03-30
 */
@Slf4j
@Service
public class EventDisposalWorkloadServiceImpl extends BaseServiceImpl<EventDisposalWorkloadMapper, EventDisposalWorkload> implements EventDisposalWorkloadService {

    @Autowired
    private EventDisposalWorkloadMapper eventDisposalWorkloadMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveEventDisposalWorkload(EventDisposalWorkload eventDisposalWorkload) throws Exception {
        return super.save(eventDisposalWorkload);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateEventDisposalWorkload(EventDisposalWorkload eventDisposalWorkload) throws Exception {
        return super.updateById(eventDisposalWorkload);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteEventDisposalWorkload(Long id) throws Exception {
        return super.removeById(id);
    }

    @Override
    public EventDisposalWorkloadQueryVo getEventDisposalWorkloadById(Serializable id) throws Exception {
        return eventDisposalWorkloadMapper.getEventDisposalWorkloadById(id);
    }

    @Override
    public Paging<EventDisposalWorkloadQueryVo> getEventDisposalWorkloadPageList(EventDisposalWorkloadQueryParam eventDisposalWorkloadQueryParam) throws Exception {
        Page page = setPageParam(eventDisposalWorkloadQueryParam);
        IPage<EventDisposalWorkloadQueryVo> iPage = eventDisposalWorkloadMapper.getEventDisposalWorkloadPageList(page, eventDisposalWorkloadQueryParam);
        return new Paging(iPage);
    }

    @Override
    public boolean saveWorkload(List<EventDisposalWorkload> eventDisposalWorkload) throws Exception {
        return super.saveBatch(eventDisposalWorkload);
    }

}
