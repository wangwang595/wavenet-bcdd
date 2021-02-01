/**
 * All rights Reserved, Designed By www.wavenet.com.cn
 *
 * @Title: UserServiceImpl.java
 * @Package com.wavenet.biz.biz1.service.impl
 * @Description: (用一句话描述该文件做什么)
 * @author: hp
 * @date: 2019/10/21 10:43
 * @version V1.0
 * @Copyright: 2019 www.wavenet.com.cn. All rights reserved.
 * 注意：本内容仅限于上海网波软件股份有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
package com.wavenet.maintenance.service.impl;


import java.util.List;

import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.wavenet.maintenance.manager.common.MongoDbFile;
import com.wavenet.maintenance.service.FileService;

import lombok.Data;

/**
 * @ClassName: UserServiceImpl
 * @Description: (这里用一句话描述这个类的作用)
 * @author: hp
 * @date: 2019/10/21 10:43
 * @Copyright: 2019 www.wavenet.com.cn. All rights reserved.
 */
@Service
@Data
public class FileServiceImpl implements FileService {

    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public String addImg(List<MultipartFile> files) {
        String imgIds="";
        try{
            if(files!=null){
                for(MultipartFile m:files){
                    MongoDbFile mongoDbFile=new MongoDbFile();
                    mongoDbFile.setContent(new Binary(m.getBytes()));
                    MongoDbFile mongoDbFile1=mongoTemplate.save(mongoDbFile,"sjsb");
                    imgIds=imgIds+mongoDbFile1.getsId().trim()+",";
                }
            }
            String subs = imgIds.substring(0, imgIds.length() - 1);
            return subs;
        }catch (Exception e){
            return imgIds;
        }
    }




}
