package com.wavenet.maintenance.service.impl;

import com.wavenet.maintenance.dao.entity.TDispatch;
import com.wavenet.maintenance.dao.mapper.TDispatchMapper;
import com.wavenet.maintenance.service.TDispatchService;
import com.wavenet.maintenance.web.query.TDispatchQueryParam;
import com.wavenet.maintenance.web.vo.TDispatchQueryVo;
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
 * 任务信息表 服务实现类
 * </pre>
 *
 * @author zll
 * @since 2020-05-11
 */
@Slf4j
@Service
public class TDispatchServiceImpl extends BaseServiceImpl<TDispatchMapper, TDispatch> implements TDispatchService {

    @Autowired
    private TDispatchMapper tDispatchMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveTDispatch(TDispatch tDispatch) throws Exception {
        return super.save(tDispatch);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateTDispatch(TDispatch tDispatch) throws Exception {
        return super.updateById(tDispatch);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteTDispatch(Long id) throws Exception {
        return super.removeById(id);
    }

    @Override
    public TDispatchQueryVo getTDispatchById(Serializable id) throws Exception {
        return tDispatchMapper.getTDispatchById(id);
    }

    @Override
    public Paging<TDispatchQueryVo> getTDispatchPageList(TDispatchQueryParam tDispatchQueryParam) throws Exception {
        Page page = setPageParam(tDispatchQueryParam, OrderItem.desc("create_time"));
        IPage<TDispatchQueryVo> iPage = tDispatchMapper.getTDispatchPageList(page, tDispatchQueryParam);
        return new Paging(iPage);
    }

}
