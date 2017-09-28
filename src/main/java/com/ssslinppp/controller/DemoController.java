package com.ssslinppp.controller;

import com.ssslinppp.model.ResultEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description：<br/>
 * User: liulin <br/>
 * Date: 2017/9/27 <br/>
 * Time: 19:25 <br/>
 * Email: liulin@cmss.chinamobile.com <br/>
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("/exceptionhandle")
public class DemoController {
    @GetMapping(value = "/null")
    public ResultEntity throwNullException() {
        throw new NullPointerException("发生了 NullPointerException 异常");
    }

    @GetMapping(value = "/errorargs")
    public ResultEntity throwIllegalArgumentException() {
        throw new IllegalArgumentException("发生了 IllegalArgumentException 异常");
    }

    @GetMapping(value = "/runtime")
    public ResultEntity throwRuntimeException() {
        throw new RuntimeException("发生了 RuntimeException 异常");
    }
}
