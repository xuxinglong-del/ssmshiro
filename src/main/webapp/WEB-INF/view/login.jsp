<%--
  Created by IntelliJ IDEA.
  User: XXL
  Date: 2020/4/21
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>用户登录</title>
</head>
<body>
    <h1 align="center">用户登陆</h1>
    <h6 style="color: red;">${error}</h6>
    <form action="${ctx}/login/login.action" method="post">
        <table align="center" width="50%"  border="1" cellpadding="5" cellspacing="5">
            <tr>
                <td align="right">用户名:</td>
                <td>
                    <input type="text" name="username">
                </td>
            </tr>
            <tr>
                <td align="right">用户名:</td>
                <td>
                    <input type="password" name="userpwd">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="checkbox" name="rememberMe" value="1" > 记住我
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="提交">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
