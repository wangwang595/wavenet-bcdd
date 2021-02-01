package com.wavenet.maintenance.service;

import com.wavenet.maintenance.dao.entity.EventDisposalRel;
import com.wavenet.maintenance.dao.entity.EventInfo;
import com.wavenetframework.boot.common.service.BaseService;
import com.wavenet.maintenance.web.query.EventInfoQueryParam;
import com.wavenet.maintenance.web.vo.EventInfoQueryVo;
import com.wavenetframework.boot.common.vo.Paging;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 *  服务类
 * </pre>
 *
 * @author zll
 * @since 2020-03-30
 */
public interface EventInfoService extends BaseService<EventInfo> {

    /**
     * 保存
     *
     * @param eventInfo
     * @return
     * @throws Exception
     */
    boolean saveEventInfo(EventInfo eventInfo) throws Exception;

    /**
     * 修改
     *
     * @param eventInfo
     * @return
     * @throws Exception
     */
    boolean updateEventInfo(EventInfo eventInfo) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteEventInfo(Long id) throws Exception;

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    EventInfoQueryVo getEventInfoById(Serializable id) throws Exception;

    /**
     * 获取分页对象
     *
     * @param eventInfoQueryParam
     * @return
     * @throws Exception
     */
    Paging<EventInfoQueryVo> getEventInfoPageList(EventInfoQueryParam eventInfoQueryParam) throws Exception;

    /**
     * 根据code进行关联查询
     */
    List<EventInfoQueryVo> selectInfoByCode(String code);

    /**
     * 根据路段编号查询返回dispatch_code
     */
    List<EventDisposalRel> selectDispatchCode(String code);
}
