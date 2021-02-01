package com.wavenet.maintenance.service.impl;

import com.wavenet.maintenance.dao.entity.EventDisposal;
import com.wavenet.maintenance.dao.mapper.EventDisposalMapper;
import com.wavenet.maintenance.service.EventDisposalService;
import com.wavenet.maintenance.web.query.EventDisposalQueryParam;
import com.wavenet.maintenance.web.vo.EventDisposalQueryVo;
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
public class EventDisposalServiceImpl extends BaseServiceImpl<EventDisposalMapper, EventDisposal> implements EventDisposalService {

    @Autowired
    private EventDisposalMapper eventDisposalMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public String saveEventDisposal(EventDisposal eventDisposal) throws Exception {
        super.save(eventDisposal);
        return eventDisposal.getDisposalCode();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateEventDisposal(EventDisposal eventDisposal) throws Exception {
        return super.updateById(eventDisposal);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteEventDisposal(Long id) throws Exception {
        return super.removeById(id);
    }

    @Override
    public EventDisposalQueryVo getEventDisposalById(Serializable id) throws Exception {
        return eventDisposalMapper.getEventDisposalById(id);
    }

    @Override
    public Paging<EventDisposalQueryVo> getEventDisposalPageList(EventDisposalQueryParam eventDisposalQueryParam) throws Exception {
        Page page = setPageParam(eventDisposalQueryParam);
        IPage<EventDisposalQueryVo> iPage = eventDisposalMapper.getEventDisposalPageList(page, eventDisposalQueryParam);
        return new Paging(iPage);
    }

}
