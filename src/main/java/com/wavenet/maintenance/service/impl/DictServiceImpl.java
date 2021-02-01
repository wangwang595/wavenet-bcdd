package com.wavenet.maintenance.service.impl;

import com.wavenet.maintenance.dao.entity.Dict;
import com.wavenet.maintenance.dao.mapper.DictMapper;
import com.wavenet.maintenance.service.DictService;
import com.wavenet.maintenance.web.query.DictQueryParam;
import com.wavenet.maintenance.web.vo.DictQueryVo;
import com.wavenet.maintenance.web.vo.EventTypeQueryVo;
import com.wavenetframework.boot.common.service.impl.BaseServiceImpl;
import com.wavenetframework.boot.common.vo.Paging;
import com.wavenetframework.boot.util.UUIDUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;


/**
 * <pre>
 *  服务实现类
 * </pre>
 *
 * @author zll
 * @since 2020-03-28
 */
@Slf4j
@Service
public class DictServiceImpl extends BaseServiceImpl<DictMapper, Dict> implements DictService {

    @Autowired
    private DictMapper dictMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveDict(Dict dict) throws Exception {

        return super.save(dict);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateDict(Dict dict) throws Exception {
        return super.updateById(dict);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteDict(Long id) throws Exception {
        return super.removeById(id);
    }

    @Override
    public DictQueryVo getDictById(Serializable id) throws Exception {
        return dictMapper.getDictById(id);
    }

    @Override
    public Paging<DictQueryVo> getDictPageList(DictQueryParam dictQueryParam) throws Exception {
        Page page = setPageParam(dictQueryParam, OrderItem.desc("create_time"));
        IPage<DictQueryVo> iPage = dictMapper.getDictPageList(page, dictQueryParam);
        return new Paging(iPage);
    }

    @Override
    public List<DictQueryVo> getDictTypeByParentCode(String id) throws Exception {
        DictQueryVo eventTypeQueryVo=new DictQueryVo();
        eventTypeQueryVo.setTypeCode(id);
        List<DictQueryVo> list = dictMapper.selectListByParentCode(id);
        return list;
    }
}
