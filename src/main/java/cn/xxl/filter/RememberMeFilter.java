package cn.xxl.filter;

import cn.xxl.domain.ActiveUser;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author xuxinglong
 * @date 2020/4/22 10:04
 * @Description 解决session无法获取的问题
 */
public class RememberMeFilter extends FormAuthenticationFilter {

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {

        Subject subject = getSubject(request, response);
        Session session = subject.getSession();
        //主体没有认证，勾选记住我，从session中获取用户为空
        if (!subject.isAuthenticated() && subject.isRemembered() && session.getAttribute("user") == null) {
            //说明是记住我的功能
            ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
            if (null != activeUser) {
                session.setAttribute("user", activeUser.getUser());
            }
        }
        System.out.println("================");
        return true;
    }
}
