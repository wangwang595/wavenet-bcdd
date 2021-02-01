/*
 * Copyright 2020 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.wavenet.maintenance.service.impl;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.wavenet.maintenance.dao.entity.TPumptruck;
import com.wavenet.maintenance.dao.mapper.TPumptruckControlMapper;
import com.wavenet.maintenance.service.PumpInfoService;
import com.wavenet.maintenance.web.query.ShiQuVoQueryParm;
import com.wavenet.maintenance.web.vo.DrainStationQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 48564
 * @date 2020/5/10 15:58
 */
@Service
public class PumpInfoServiceimpl implements PumpInfoService {

    @Autowired
    private TPumptruckControlMapper tPumptruckControlMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<Integer>  getTPumpInfo() throws Exception{
        Integer jijie = tPumptruckControlMapper.getTPumpInfo();
        Integer getkongxian = tPumptruckControlMapper.getkongxian();
        Integer getrenwujizhing = tPumptruckControlMapper.getrenwujizhing();
        Integer getzhudianbaozhang = tPumptruckControlMapper.getzhudianbaozhang();
        List<Integer> integers = new ArrayList<>();
        jijie =getkongxian+jijie;
        integers.add(jijie);
        integers.add(getrenwujizhing);
        integers.add(getzhudianbaozhang);

        return integers;
    }

    @Override
    public List<Integer> getshijishuliang(String city) throws Exception {

        Integer jijie = tPumptruckControlMapper.getshijidaiming(city);
        Integer getkongxian = tPumptruckControlMapper.getshijikongxian(city);
        Integer getrenwujizhing = tPumptruckControlMapper.getshijirenwujizhing(city);
        Integer getzhudianbaozhang = tPumptruckControlMapper.getshijizhudianbaozhang(city);
        jijie=getkongxian+jijie;
        List<Integer> integers = new ArrayList<>();
        integers.add(jijie);
        integers.add(getrenwujizhing);
        integers.add(getzhudianbaozhang);

        return integers;


    }


}