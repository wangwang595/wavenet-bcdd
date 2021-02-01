package com.wavenet.maintenance.service.impl;

import com.wavenet.maintenance.dao.entity.PatrolInfo;
import com.wavenet.maintenance.dao.mapper.PatrolInfoMapper;
import com.wavenet.maintenance.service.PatrolInfoService;
import com.wavenet.maintenance.web.query.PatrolInfoQueryParam;
import com.wavenet.maintenance.web.vo.PatrolInfoQueryVo;
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
public class PatrolInfoServiceImpl extends BaseServiceImpl<PatrolInfoMapper, PatrolInfo> implements PatrolInfoService {

    @Autowired
    private PatrolInfoMapper patrolInfoMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public String savePatrolInfo(PatrolInfo patrolInfo) throws Exception {
        if(super.save(patrolInfo)) {
            return patrolInfo.getPatrolCode();
        }else {
            return null;
        }

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updatePatrolInfo(PatrolInfo patrolInfo) throws Exception {
        return super.updateById(patrolInfo);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deletePatrolInfo(Long id) throws Exception {
        return super.removeById(id);
    }

    @Override
    public PatrolInfoQueryVo getPatrolInfoById(Serializable id) throws Exception {
        return patrolInfoMapper.getPatrolInfoById(id);
    }

    @Override
    public Paging<PatrolInfoQueryVo> getPatrolInfoPageList(PatrolInfoQueryParam patrolInfoQueryParam) throws Exception {
        Page page = setPageParam(patrolInfoQueryParam, OrderItem.desc("create_time"));
        IPage<PatrolInfoQueryVo> iPage = patrolInfoMapper.getPatrolInfoPageList(page, patrolInfoQueryParam);
        return new Paging(iPage);
    }

}
