package com.nepous.provider.web;

import com.nepous.base.enums.ErrorCodeEnum;
import com.nepous.base.exception.BussinessException;
import com.nepous.provider.model.domain.GlobalExceptionLogDto;
import com.nepous.util.result.RestResult;
import com.nepous.util.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.task.TaskExecutor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.annotation.Resource;

/**
 * 全局的的异常拦截器
 *
 * @author paascloud.net @gmail.com
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @Resource
    private TaskExecutor taskExecutor;
    @Value("${spring.profiles.active}")
    String profile;
    @Value("${spring.application.name}")
    String applicationName;

    /**
     * 参数非法异常.
     *
     * @param e the e
     *
     * @return the wrapper
     */
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Result illegalArgumentException(IllegalArgumentException e) {
        log.error("参数非法异常={}", e.getMessage(), e);
        return RestResult.result(ErrorCodeEnum.GL99990100.code(), e.getMessage());
    }

    /**
     * 业务异常.
     *
     * @param e the e
     *
     * @return the wrapper
     */
    @ExceptionHandler(BussinessException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Result businessException(BussinessException e) {
        log.error("业务异常={}", e.getMessage(), e);
        return RestResult.result(e.getCode() == 0 ? Result.ERROR_CODE : e.getCode(), e.getMessage());
    }

    /**
     * 无权限访问.
     *
     * @param e the e
     *
     * @return the wrapper
     */
    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public Result unAuthorizedException(AccessDeniedException e) {
        log.error("业务异常={}", e.getMessage(), e);
        return RestResult.result(ErrorCodeEnum.GL99990401.code(), ErrorCodeEnum.GL99990401.msg());
    }


    /**
     * 全局异常.
     *
     * @param e the e
     *
     * @return the wrapper
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Result exception(Exception e) {
        log.info("保存全局异常信息 ex={}", e.getMessage(), e);
        taskExecutor.execute(() -> {
            GlobalExceptionLogDto globalExceptionLogDto = new GlobalExceptionLogDto().getGlobalExceptionLogDto(e, profile, applicationName);
           // mdcExceptionLogFeignApi.saveAndSendExceptionLog(globalExceptionLogDto);
        });
        return RestResult.error();
    }

}
