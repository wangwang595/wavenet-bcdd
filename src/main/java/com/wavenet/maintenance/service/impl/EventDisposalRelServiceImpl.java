package com.wavenet.maintenance.service.impl;

import com.wavenet.maintenance.dao.entity.EventDisposalRel;
import com.wavenet.maintenance.dao.mapper.EventDisposalRelMapper;
import com.wavenet.maintenance.service.EventDisposalRelService;
import com.wavenet.maintenance.web.query.EventDisposalRelQueryParam;
import com.wavenet.maintenance.web.vo.EventDisposalRelQueryVo;
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
public class EventDisposalRelServiceImpl extends BaseServiceImpl<EventDisposalRelMapper, EventDisposalRel> implements EventDisposalRelService {

    @Autowired
    private EventDisposalRelMapper eventDisposalRelMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveEventDisposalRel(EventDisposalRel eventDisposalRel) throws Exception {
        return super.save(eventDisposalRel);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateEventDisposalRel(EventDisposalRel eventDisposalRel) throws Exception {
        return super.updateById(eventDisposalRel);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteEventDisposalRel(Long id) throws Exception {
        return super.removeById(id);
    }

    @Override
    public EventDisposalRelQueryVo getEventDisposalRelById(Serializable id) throws Exception {
        return eventDisposalRelMapper.getEventDisposalRelById(id);
    }

    @Override
    public Paging<EventDisposalRelQueryVo> getEventDisposalRelPageList(EventDisposalRelQueryParam eventDisposalRelQueryParam) throws Exception {
        Page page = setPageParam(eventDisposalRelQueryParam, OrderItem.desc("create_time"));
        IPage<EventDisposalRelQueryVo> iPage = eventDisposalRelMapper.getEventDisposalRelPageList(page, eventDisposalRelQueryParam);
        return new Paging(iPage);
    }

}
