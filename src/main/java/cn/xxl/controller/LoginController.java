package cn.xxl.controller;

import cn.xxl.domain.ActiveUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * 登录
 */
@Controller
@RequestMapping("login")
public class LoginController {

    @RequestMapping("/toLogin")
    public ModelAndView toLogin() {
        return new ModelAndView("login");
    }

    /**
     * 完成登录的方法
     * @param username
     * @param userpwd
     * @param rememberMe
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("/login")
    public ModelAndView login(String username, String userpwd, Integer rememberMe, HttpSession session, Model model) {
        //封装token
        UsernamePasswordToken token = new UsernamePasswordToken(username, userpwd);
        //得到主体
        Subject subject = SecurityUtils.getSubject();
        try {
            if (rememberMe != null && rememberMe == 1){
                token.setRememberMe(true);
            }
            //调用主体登录的方法
            subject.login(token);
            System.out.println("登录成功");
            ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
            session.setAttribute("user", activeUser.getUser());
            return new ModelAndView("redirect:/user/loadAllUser.action");
        } catch (IncorrectCredentialsException e) {
            System.err.println("密码不正确");
            model.addAttribute("error", "密码不正确");
        } catch (UnknownAccountException e) {
            System.err.println("用户名不存在");
            model.addAttribute("error", "用户名不存在");
        }
        //重定向到
        return new ModelAndView("redirect:/login.jsp");
    }
}
