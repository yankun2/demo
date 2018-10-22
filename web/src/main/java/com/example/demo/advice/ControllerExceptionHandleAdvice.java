package com.example.demo.advice;

import com.example.demo.bean.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * @Description: controller异常拦截
 * @Author: yankun
 * @Date: 2018-10-17 13:37
 */
@RestControllerAdvice
public class ControllerExceptionHandleAdvice {
    private final static Logger logger = LoggerFactory.getLogger(ControllerExceptionHandleAdvice.class);

    @ExceptionHandler
    public Result handler(HttpServletRequest req, HttpServletResponse res, Exception e) {
        if (res.getStatus() == HttpStatus.BAD_REQUEST.value()) {
            logger.info("修改返回状态值为200");
            res.setStatus(HttpStatus.OK.value());
        }
        if (e instanceof NullPointerException) {
            logger.error("SYS_0003：{}", e);
            return Result.error("SYS_0003");
        } else if (e instanceof IllegalArgumentException) {
            logger.error("SYS_0002：{}", e);
            return Result.error("SYS_0002");
        } else if (e instanceof SQLException) {
            logger.error("SQL_0001：{}", e);
            return Result.error("SQL_0001");
        } else {
            logger.error("SYS_0001：{}", e);
            return Result.error("SYS_0001");
        }
    }
}
