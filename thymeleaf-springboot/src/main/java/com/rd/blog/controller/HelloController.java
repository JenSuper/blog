package com.rd.blog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * All rights Reserved, Designed By www.rongdasoft.com
 *
 * @version V1.0
 * @Title: HelloController
 * @Description:
 * @author:jichao
 * @date: 2018/3/8
 * @Copyright: 2018/3/8 www.rongdasoft.com
 * Inc. All rights reserved.
 */
@RestController
public class HelloController {

    @RequestMapping(value = "/hello")
    public String helloController(){
        return "helloword";
    }
}
