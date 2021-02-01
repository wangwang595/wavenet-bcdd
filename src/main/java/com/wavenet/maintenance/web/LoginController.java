/*
 * Copyright 2019-2029 geekidea(https://github.com/geekidea)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.wavenet.maintenance.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.wavenet.maintenance.service.LoginService;
import com.wavenetframework.boot.common.api.ApiResult;
import com.wavenetframework.boot.shiro.param.LoginParam;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * 登陆控制器
 *
 * @author geekidea
 * @date 2019-09-28
 * @since 1.3.0.RELEASE
 **/
@Api("登陆控制器")
@Slf4j
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;
    @Autowired
    private RestTemplate restTemplate;
    @PostMapping("/login")
    @ApiOperation(value = "登陆", notes = "系统用户登陆")
    public JSONObject login(@Valid @RequestBody LoginParam loginParam, HttpServletResponse response) throws Exception {

        JSONObject json = restTemplate.postForEntity("http://172.18.1.221:9011/login", loginParam, JSONObject.class).getBody();
        return json;
    }

    @PostMapping("/logout")
    public ApiResult logout(HttpServletRequest request) throws Exception {
        loginService.logout(request);
        return ApiResult.ok("退出成功");
    }


    @PostMapping("/getData")
    @ApiOperation(value = "获取分区", notes = "获取用户片区")
    public JSONObject getData(HttpServletRequest request) throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.add("token",request.getHeader("token"));
        HttpEntity<String> requestEntity = new HttpEntity<String>(null, headers);
        ResponseEntity<JSONObject> response = restTemplate.exchange("http://localhost:9011/orgData/getList", HttpMethod.GET, requestEntity, JSONObject.class);
        JSONObject json = response.getBody();
        return json;
    }

    @PostMapping("/getUserByDataCode/{dataCode}")
    @ApiOperation(value = "根据分区获取用户", notes = "根据片区id获取用户")
    public JSONObject  getByDataCode(@NotBlank(message = "片区id不能为空") @PathVariable("dataCode") String dataCode, HttpServletRequest request)throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.add("token",request.getHeader("token"));
        HttpEntity<String> requestEntity = new HttpEntity<String>(null, headers);
        ResponseEntity<JSONObject> response = restTemplate.exchange("http://localhost:9011/orgUser/getByDataCode/"+dataCode, HttpMethod.GET, requestEntity, JSONObject.class);
        JSONObject json = response.getBody();
        return json;
    }
}
