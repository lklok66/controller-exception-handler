package com.ssslinppp.aop;

import com.ssslinppp.model.ResultEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * Description：用于处理 {@code  @Controller} 中所有{@code @RequestMapping}方法的异常处理<br/>
 * User: liulin <br/>
 * Date: 2017/9/28 <br/>
 * Time: 11:04 <br/>
 * Email: liulin@cmss.chinamobile.com <br/>
 * To change this template use File | Settings | File Templates.
 */
@RestControllerAdvice
public class ControllerExceptionHandleAdvice {
    private final static Logger logger = LoggerFactory.getLogger(ControllerExceptionHandleAdvice.class);

    @ExceptionHandler
    public ResultEntity handler(HttpServletRequest req, HttpServletResponse res, Exception e) {
        logger.info("Restful Http请求发生异常...");

        if (res.getStatus() == HttpStatus.BAD_REQUEST.value()) {
            logger.info("修改返回状态值为200");
            res.setStatus(HttpStatus.OK.value());
        }

        if (e instanceof NullPointerException) {
            logger.error("代码00：" + e.getMessage(), e);
            return ResultEntity.fail("发生空指针异常");
        } else if (e instanceof IllegalArgumentException) {
            logger.error("代码01：" + e.getMessage(), e);
            return ResultEntity.fail("请求参数类型不匹配");
        } else if (e instanceof SQLException) {
            logger.error("代码02：" + e.getMessage(), e);
            return ResultEntity.fail("数据库访问异常");
        } else {
            logger.error("代码99：" + e.getMessage(), e);
            return ResultEntity.fail("服务器代码发生异常,请联系管理员");
        }
    }
}
