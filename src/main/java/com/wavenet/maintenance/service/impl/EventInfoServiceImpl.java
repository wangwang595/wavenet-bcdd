package com.wavenet.maintenance.service.impl;

import com.wavenet.maintenance.dao.entity.EventDisposalRel;
import com.wavenet.maintenance.dao.entity.EventInfo;
import com.wavenet.maintenance.dao.mapper.EventInfoMapper;
import com.wavenet.maintenance.service.EventInfoService;
import com.wavenet.maintenance.web.query.EventInfoQueryParam;
import com.wavenet.maintenance.web.vo.EventInfoQueryVo;
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
public class EventInfoServiceImpl extends BaseServiceImpl<EventInfoMapper, EventInfo> implements EventInfoService {

    @Autowired
    private EventInfoMapper eventInfoMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveEventInfo(EventInfo eventInfo) throws Exception {
        return super.save(eventInfo);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateEventInfo(EventInfo eventInfo) throws Exception {
        return super.updateById(eventInfo);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteEventInfo(Long id) throws Exception {
        return super.removeById(id);
    }

    @Override
    public EventInfoQueryVo getEventInfoById(Serializable id) throws Exception {
        return eventInfoMapper.getEventInfoById(id);
    }

    @Override
    public Paging<EventInfoQueryVo> getEventInfoPageList(EventInfoQueryParam eventInfoQueryParam) throws Exception {
        Page page = setPageParam(eventInfoQueryParam, OrderItem.desc("report_date"));
        IPage<EventInfoQueryVo> iPage = eventInfoMapper.getEventInfoPageList(page, eventInfoQueryParam);
        return new Paging(iPage);
    }

    /**
     * 根据路段编号查询
     * @param code
     * @return
     */
    @Override
    public List<EventInfoQueryVo> selectInfoByCode(String code) {
        List<EventInfoQueryVo> list = eventInfoMapper.selectInfoByCode(code);
        return list;
    }

    /**
     * 根据路段编号查询返回dispatch_code
     */
    @Override
    public List<EventDisposalRel> selectDispatchCode(String code) {
        List<EventDisposalRel> list = eventInfoMapper.selectDispatchCode(code);
        return list;
    }


}
