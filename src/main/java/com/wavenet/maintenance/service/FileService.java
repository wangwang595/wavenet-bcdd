/**
 * All rights Reserved, Designed By www.wavenet.com.cn
 *
 * @Title: UserService.java
 * @Package com.wavenet.biz.biz1.service
 * @Description: (用一句话描述该文件做什么)
 * @author: hp
 * @date: 2019/10/21 10:40
 * @version V1.0
 * @Copyright: 2019 www.wavenet.com.cn. All rights reserved.
 * 注意：本内容仅限于上海网波软件股份有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
package com.wavenet.maintenance.service;


import java.util.List;

import org.springframework.web.multipart.MultipartFile;


/**
 * @ClassName: UserService
 * @Description: (这里用一句话描述这个类的作用)
 * @author: hp
 * @date: 2019/10/21 10:40
 * @Copyright: 2019 www.wavenet.com.cn. All rights reserved.
 */
public interface FileService {
    String addImg(List<MultipartFile> files);


}
