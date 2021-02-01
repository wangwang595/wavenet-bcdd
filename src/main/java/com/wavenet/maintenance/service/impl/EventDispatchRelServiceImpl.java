package com.wavenet.maintenance.service.impl;

import com.wavenet.maintenance.dao.entity.EventDispatchRel;
import com.wavenet.maintenance.dao.mapper.EventDispatchRelMapper;
import com.wavenet.maintenance.service.EventDispatchRelService;
import com.wavenet.maintenance.web.query.EventDispatchRelQueryParam;
import com.wavenet.maintenance.web.vo.EventDispatchRelQueryVo;
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
public class EventDispatchRelServiceImpl extends BaseServiceImpl<EventDispatchRelMapper, EventDispatchRel> implements EventDispatchRelService {

    @Autowired
    private EventDispatchRelMapper eventDispatchRelMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveEventDispatchRel(EventDispatchRel eventDispatchRel) throws Exception {
        return super.save(eventDispatchRel);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateEventDispatchRel(EventDispatchRel eventDispatchRel) throws Exception {
        return super.updateById(eventDispatchRel);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteEventDispatchRel(Long id) throws Exception {
        return super.removeById(id);
    }

    @Override
    public EventDispatchRelQueryVo getEventDispatchRelById(Serializable id) throws Exception {
        return eventDispatchRelMapper.getEventDispatchRelById(id);
    }

    @Override
    public Paging<EventDispatchRelQueryVo> getEventDispatchRelPageList(EventDispatchRelQueryParam eventDispatchRelQueryParam) throws Exception {
        Page page = setPageParam(eventDispatchRelQueryParam, OrderItem.desc("create_time"));
        IPage<EventDispatchRelQueryVo> iPage = eventDispatchRelMapper.getEventDispatchRelPageList(page, eventDispatchRelQueryParam);
        return new Paging(iPage);
    }

}
