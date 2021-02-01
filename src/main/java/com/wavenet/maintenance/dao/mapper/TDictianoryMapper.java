package com.wavenet.maintenance.dao.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.wavenet.maintenance.dao.entity.TDictianory;

import com.wavenet.maintenance.web.query.TDictianoryQueryParam;
import com.wavenet.maintenance.web.vo.TDictianoryQueryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 * 字典表 Mapper 接口
 * </pre>
 *
 * @author zll
 * @since 2020-05-14
 */
@Repository
public interface TDictianoryMapper extends BaseMapper<TDictianory> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    TDictianoryQueryVo getTDictianoryById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param tDictianoryQueryParam
     * @return
     */
    IPage<TDictianoryQueryVo> getTDictianoryPageList(@Param("page") Page page, @Param("param") TDictianoryQueryParam tDictianoryQueryParam);


    List<String> getCityInfo( @Param("stype") String stype);

    List<String> gerPumptrukType(@Param("stype")String stype);
}
