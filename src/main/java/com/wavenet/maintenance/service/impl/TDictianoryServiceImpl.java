package com.wavenet.maintenance.service.impl;

import com.wavenet.maintenance.dao.entity.TDictianory;
import com.wavenet.maintenance.dao.mapper.TDictianoryMapper;
import com.wavenet.maintenance.service.TDictianoryService;
import com.wavenet.maintenance.web.query.TDictianoryQueryParam;
import com.wavenet.maintenance.web.vo.TDictianoryQueryVo;
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
 * 字典表 服务实现类
 * </pre>
 *
 * @author zll
 * @since 2020-05-14
 */
@Slf4j
@Service
public class TDictianoryServiceImpl extends BaseServiceImpl<TDictianoryMapper, TDictianory> implements TDictianoryService {

    @Autowired
    private TDictianoryMapper tDictianoryMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveTDictianory(TDictianory tDictianory) throws Exception {
        return super.save(tDictianory);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateTDictianory(TDictianory tDictianory) throws Exception {
        return super.updateById(tDictianory);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteTDictianory(Long id) throws Exception {
        return super.removeById(id);
    }

    @Override
    public TDictianoryQueryVo getTDictianoryById(Serializable id) throws Exception {
        return tDictianoryMapper.getTDictianoryById(id);
    }

    @Override
    public Paging<TDictianoryQueryVo> getTDictianoryPageList(TDictianoryQueryParam tDictianoryQueryParam) throws Exception {
        Page page = setPageParam(tDictianoryQueryParam, OrderItem.desc("create_time"));
        IPage<TDictianoryQueryVo> iPage = tDictianoryMapper.getTDictianoryPageList(page, tDictianoryQueryParam);
        return new Paging(iPage);
    }

}
