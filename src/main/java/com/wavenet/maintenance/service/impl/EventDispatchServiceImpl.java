package com.wavenet.maintenance.service.impl;

import com.wavenet.maintenance.dao.entity.EventDispatch;
import com.wavenet.maintenance.dao.entity.EventDisposalWorkload;
import com.wavenet.maintenance.dao.mapper.EventDispatchMapper;
import com.wavenet.maintenance.dao.mapper.EventInfoMapper;
import com.wavenet.maintenance.service.EventDispatchService;
import com.wavenet.maintenance.web.query.EventDispatchQueryParam;
import com.wavenet.maintenance.web.vo.EventDispatchQueryVo;
import com.wavenet.maintenance.web.vo.EventDispatchYhInfoVo;
import com.wavenet.maintenance.web.vo.EventDisposalWorkloadQueryVo;
import com.wavenet.maintenance.web.vo.EventInfoQueryVo;
import com.wavenetframework.boot.common.api.ApiResult;
import com.wavenetframework.boot.common.service.impl.BaseServiceImpl;
import com.wavenetframework.boot.common.vo.Paging;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.Code;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
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
public class EventDispatchServiceImpl extends BaseServiceImpl<EventDispatchMapper, EventDispatch> implements EventDispatchService {

    @Autowired
    private EventDispatchMapper eventDispatchMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveEventDispatch(EventDispatch eventDispatch) throws Exception {
        return super.save(eventDispatch);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateEventDispatch(EventDispatch eventDispatch) throws Exception {
        return super.updateById(eventDispatch);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteEventDispatch(Long id) throws Exception {
        return super.removeById(id);
    }

    @Override
    public EventDispatchQueryVo getEventDispatchById(Serializable id) throws Exception {
        return eventDispatchMapper.getEventDispatchById(id);
    }

    @Override
    public Paging<EventDispatchQueryVo> getEventDispatchPageList(EventDispatchQueryParam eventDispatchQueryParam) throws Exception {
        Page page = setPageParam(eventDispatchQueryParam, OrderItem.desc("dispatcher_date"));
        IPage<EventDispatchQueryVo> iPage = eventDispatchMapper.getEventDispatchPageList(page, eventDispatchQueryParam);
        return new Paging(iPage);
    }

    @Override
    public EventDispatchYhInfoVo getYhInfo(String dispatchCode,String disposalCode) {
        //查询主表
        EventDispatchYhInfoVo list = eventDispatchMapper.selectDispatchInfo(disposalCode);
        //病害信息
        List<EventInfoQueryVo> eventInfoQueryVos = eventDispatchMapper.selectInfoByCode(dispatchCode);
        //工作量查询
        List<EventDisposalWorkloadQueryVo> eventDisposalWorkloadQueryVos = eventDispatchMapper.selectWorkLoad(disposalCode);
        String solveStart = list.getSolveStart();
        String solveEnd = list.getSolveEnd();
        String start = solveStart.substring(0,solveStart.length()-8);
        String end = solveEnd.substring(0,solveEnd.length()-8);
        list.setSolveStart(start);
        list.setSolveEnd(end);
        //判断如果照片为空，就用图片代替
        if (list.getAttAfter()==null||list.getAttAfter()=="") {
            list.setAttAfter("5e8eb0e924a09d0c1fbacc20");
        }
        if (list.getAttOngoing()==null||list.getAttOngoing()=="") {
            list.setAttOngoing("5e8eb0e924a09d0c1fbacc20");
        }
        if (list.getAttBefore()==null||list.getAttBefore()=="") {
            list.setAttBefore("5e8eb0e924a09d0c1fbacc20");
        }
        list.setBhType(eventInfoQueryVos);
        list.setWorkLoad(eventDisposalWorkloadQueryVos);
        return list;
    }

}
