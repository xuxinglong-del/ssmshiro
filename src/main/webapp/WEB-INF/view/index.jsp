<%--
  Created by IntelliJ IDEA.
  User: XXL
  Date: 2020/4/21
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--引入shiro--%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
    <title>系统首页</title>
</head>
<body>
系统首页
<hr>
    <shiro:hasPermission name="user:query">
        <a href="${ctx }/user/query.action">查询用户</a>
        <br>
    </shiro:hasPermission>

    <shiro:hasPermission name="user:add">
        <a href="${ctx }/user/add.action">添加用户</a>
        <br>
    </shiro:hasPermission>

    <shiro:hasPermission name="user:update">
        <a href="${ctx }/user/update.action">修改用户</a>
        <br>
    </shiro:hasPermission>

    <shiro:hasPermission name="user:delete">
        <a href="${ctx }/user/delete.action">删除用户</a>
        <br>
    </shiro:hasPermission>

    <shiro:hasPermission name="user:export">
        <a href="${ctx }/user/export.action">导出用户</a>
        <br>
    </shiro:hasPermission>
</body>
</html>
