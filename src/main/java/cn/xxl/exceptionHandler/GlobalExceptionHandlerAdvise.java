package cn.xxl.exceptionHandler;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xuxinglong
 * @date 2020/4/22 10:31
 * @Description 全局的异常处理器
 *  @RestControllerAdvice :这个注解是监控controller里面是否有发生异常，如果有发生就跳转页面
 */
@RestControllerAdvice
public class GlobalExceptionHandlerAdvise {

    /**
     * 未授权
     * @return
     */
    @ExceptionHandler(value = {UnauthorizedException.class})
    public Object unauthorized(){
        Map<String,Object> map = new HashMap<>();
        map.put("code", -1);
        map.put("msg", "未授权，请联系管理员");
        return map;
    }
}
