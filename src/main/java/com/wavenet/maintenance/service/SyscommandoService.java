package com.wavenet.maintenance.service;

import com.wavenet.maintenance.dao.entity.Syscommando;
import com.wavenetframework.boot.common.service.BaseService;
import com.wavenet.maintenance.web.query.SyscommandoQueryParam;
import com.wavenet.maintenance.web.vo.SyscommandoQueryVo;
import com.wavenetframework.boot.common.vo.Paging;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 *  服务类
 * </pre>
 *
 * @author zll
 * @since 2020-05-10
 */
public interface SyscommandoService extends BaseService<Syscommando> {

    /**
     * 保存
     *
     * @param syscommando
     * @return
     * @throws Exception
     */
    boolean saveSyscommando(Syscommando syscommando) throws Exception;

    /**
     * 修改
     *
     * @param syscommando
     * @return
     * @throws Exception
     */
    boolean updateSyscommando(Syscommando syscommando) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteSyscommando(Long id) throws Exception;

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    SyscommandoQueryVo getSyscommandoById(Serializable id) throws Exception;

    //突击队信息
    List<Integer> syscommInfo() throws Exception;

    /**
     * 获取分页对象
     *
     * @param syscommandoQueryParam
     * @return
     * @throws Exception
     */
    Paging<SyscommandoQueryVo> getSyscommandoPageList(SyscommandoQueryParam syscommandoQueryParam) throws Exception;

}
