/*
 * Copyright 2020 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.wavenet.maintenance.service;

import com.wavenet.maintenance.web.query.ShiQuVoQueryParm;

import java.util.List;

/**
 * @author 48564
 * @date 2020/5/10 15:58
 */
public interface PumpInfoService {
    List<Integer> getTPumpInfo() throws  Exception;

    List<Integer> getshijishuliang(String city) throws  Exception;
}