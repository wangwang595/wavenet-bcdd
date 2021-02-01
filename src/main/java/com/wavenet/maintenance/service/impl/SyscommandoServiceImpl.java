package com.wavenet.maintenance.service.impl;

import com.wavenet.maintenance.dao.entity.Syscommando;
import com.wavenet.maintenance.dao.mapper.SyscommandoMapper;
import com.wavenet.maintenance.service.SyscommandoService;
import com.wavenet.maintenance.web.query.SyscommandoQueryParam;
import com.wavenet.maintenance.web.vo.SyscommandoQueryVo;
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
import java.util.ArrayList;
import java.util.List;


/**
 * <pre>
 *  服务实现类
 * </pre>
 *
 * @author zll
 * @since 2020-05-10
 */
@Slf4j
@Service
public class SyscommandoServiceImpl extends BaseServiceImpl<SyscommandoMapper, Syscommando> implements SyscommandoService {

    @Autowired
    private SyscommandoMapper syscommandoMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveSyscommando(Syscommando syscommando) throws Exception {
        return super.save(syscommando);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateSyscommando(Syscommando syscommando) throws Exception {
        return super.updateById(syscommando);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteSyscommando(Long id) throws Exception {
        return super.removeById(id);
    }

    @Override
    public SyscommandoQueryVo getSyscommandoById(Serializable id) throws Exception {
        return syscommandoMapper.getSyscommandoById(id);
    }

    @Override
    public Paging<SyscommandoQueryVo> getSyscommandoPageList(SyscommandoQueryParam syscommandoQueryParam) throws Exception {
        Page page = setPageParam(syscommandoQueryParam, OrderItem.desc("create_time"));
        IPage<SyscommandoQueryVo> iPage = syscommandoMapper.getSyscommandoPageList(page, syscommandoQueryParam);
        return new Paging(iPage);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<Integer> syscommInfo() throws Exception{
        Integer zongshu = syscommandoMapper.zongshu();
        Integer getzhudianbaozhang = syscommandoMapper.getzhudianbaozhang();
        Integer getrenwuwancheng = syscommandoMapper.getrenwuwancheng();
        Integer getrenwuzhixing = syscommandoMapper.getrenwuzhixing();
        Integer jijiedai=zongshu-getzhudianbaozhang-getrenwuwancheng-getrenwuzhixing;
        List<Integer> integers = new ArrayList<>();
        integers.add(getzhudianbaozhang);
        integers.add(getrenwuwancheng);
        integers.add(getrenwuzhixing);
        integers.add(jijiedai);
        return integers;
    }



}
