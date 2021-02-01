package com.wavenet.maintenance.dao.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wavenet.maintenance.dao.entity.Syscommando;
import com.wavenet.maintenance.web.query.SyscommandoQueryParam;
import com.wavenet.maintenance.web.vo.SyscommandoQueryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <pre>
 *  Mapper 接口
 * </pre>
 *
 * @author zll
 * @since 2020-05-10
 */
@Repository
public interface SyscommandoMapper extends BaseMapper<Syscommando> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    SyscommandoQueryVo getSyscommandoById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param syscommandoQueryParam
     * @return
     */
    IPage<SyscommandoQueryVo> getSyscommandoPageList(@Param("page") Page page, @Param("param") SyscommandoQueryParam syscommandoQueryParam);


    Integer getrenwuzhixing();
    Integer getzhudianbaozhang();
    Integer getrenwuwancheng();
    Integer zongshu();
}
