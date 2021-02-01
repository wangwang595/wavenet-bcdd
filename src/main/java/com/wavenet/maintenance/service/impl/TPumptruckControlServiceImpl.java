package com.wavenet.maintenance.service.impl;

import com.wavenet.maintenance.dao.entity.TPumptruckControl;
import com.wavenet.maintenance.dao.mapper.TPumptruckControlMapper;
import com.wavenet.maintenance.service.TPumptruckControlService;
import com.wavenet.maintenance.web.query.TPumptruckControlQueryParam;
import com.wavenet.maintenance.web.vo.TPumptruckControlQueryVo;
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
 * 泵车状态表 服务实现类
 * </pre>
 *
 * @author zll
 * @since 2020-05-10
 */
@Slf4j
@Service
public class TPumptruckControlServiceImpl extends BaseServiceImpl<TPumptruckControlMapper, TPumptruckControl> implements TPumptruckControlService {

    @Autowired
    private TPumptruckControlMapper tPumptruckControlMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveTPumptruckControl(TPumptruckControl tPumptruckControl) throws Exception {
        return super.save(tPumptruckControl);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateTPumptruckControl(TPumptruckControl tPumptruckControl) throws Exception {
        return super.updateById(tPumptruckControl);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteTPumptruckControl(Long id) throws Exception {
        return super.removeById(id);
    }

    @Override
    public TPumptruckControlQueryVo getTPumptruckControlById(Serializable id) throws Exception {
        return tPumptruckControlMapper.getTPumptruckControlById(id);
    }

    @Override
    public Paging<TPumptruckControlQueryVo> getTPumptruckControlPageList(TPumptruckControlQueryParam tPumptruckControlQueryParam) throws Exception {
        Page page = setPageParam(tPumptruckControlQueryParam, OrderItem.desc("create_time"));
        IPage<TPumptruckControlQueryVo> iPage = tPumptruckControlMapper.getTPumptruckControlPageList(page, tPumptruckControlQueryParam);
        return new Paging(iPage);
    }

}
