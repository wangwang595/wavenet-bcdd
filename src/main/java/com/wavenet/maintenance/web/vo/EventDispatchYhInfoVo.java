/**
 * All rights Reserved, Designed By www.wavenet.com.cn
 *
 * @Title: EventDispatchYhInfoVo.java
 * @Package com.wavenet.maintenance.web.vo
 * @Description: (用一句话描述该文件做什么)
 * @author: admin
 * @date: 2020-04-08 10:31
 * @version V1.0
 * @Copyright: 2020 www.wavenet.com.cn. All rights reserved.
 * 注意：本内容仅限于上海网波软件股份有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
package com.wavenet.maintenance.web.vo;

import lombok.Data;

import java.beans.Transient;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: EventDispatchYhInfoVo
 * @Description: (这里用一句话描述这个类的作用)
 * @author: admin
 * @date: 2020-04-08 10:31     
 * @Copyright: 2020 www.wavenet.com.cn. All rights reserved.
 */
@Data
public class EventDispatchYhInfoVo {
    private String dispatchCode;

    private String dispatcherCode;

    private String dispatcherName;

    private Date dispatcherDate;

    private String dispatcherDesc;

    private String recipientCode;

    private String recipientName;

    private String town;

    private String company;

    private String type;

    private String roadCode;

    private String roadName;

    private String roadSectionCode;

    private String roadSectionStart;

    private String roadSectionEnd;

    private String dispatchState;

    private String attBefore;

    private String attOngoing;

    private String attAfter;

    private String solveStart;

    private String solveEnd;

    private List<EventInfoQueryVo> bhType;

    private List<EventDisposalWorkloadQueryVo> workLoad;
}
