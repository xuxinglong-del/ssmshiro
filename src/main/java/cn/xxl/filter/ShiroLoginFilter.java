package cn.xxl.filter;

import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xuxinglong
 * @date 2020/4/22 10:45
 * @Description 解决未登陆不使用重定向使用JSON的问题
 */
public class ShiroLoginFilter extends FormAuthenticationFilter {

    /**
     * 在访问controller前判断是否登录，返回json,不进行重定向
     *
     * @param request
     * @param response
     * @return true-继续往下执行，false-该filter过滤器已经处理，不继续执行其他过滤器
     * @throws Exception onAccessDenied:拒绝访问
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {

        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        //如果是ajax请求
        if (isAjax(request)) {
            httpServletResponse.setCharacterEncoding("UTF-8");
            //设置内容类型为json
            httpServletResponse.setContentType("application/json");
            Map<String, Object> resultData = new HashMap<>();
            resultData.put("code", -1);
            resultData.put("msg", "登录认证失败，请重新登录");
            //以json字符串响应给客户端
            httpServletResponse.getWriter().write(JSONObject.toJSON(resultData).toString());


        } else {
            //非ajax重定向到登录页面
            httpServletResponse.sendRedirect("/login");
        }
        return false;
    }

    private boolean isAjax(ServletRequest request) {
        String header = ((HttpServletRequest) request).getHeader("X-Requested-With");
        if ("XMLHttpRequest".equalsIgnoreCase(header)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

}
