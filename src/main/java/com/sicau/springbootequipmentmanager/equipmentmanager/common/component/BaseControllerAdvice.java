package com.sicau.springbootequipmentmanager.equipmentmanager.common.component;


import com.sicau.springbootequipmentmanager.equipmentmanager.common.result.Result;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BaseControllerAdvice {
    @ExceptionHandler(value = RuntimeException.class)
    public Result<?> runtimeExceptionResponse(Exception e){
        return new Result<>().error(400, e.getMessage());
    }

    @ExceptionHandler(value = UnauthorizedException.class)
    public Result<?> unAuthorize(UnauthorizedException e){
        return new Result<>().error(401,"没有操作权限");
    }

    @ExceptionHandler(value = Exception.class)
    public Result<?> exceptionResponse(Exception e){
        return new Result<>().error(500,"服务器内部错误");
    }
}
