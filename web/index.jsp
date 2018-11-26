<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!--
       这里不能使用url=/login，使用/login得到的请求url是localhost:8080/login;
       使用login，由于这个页面当前的服务端路径localhost:8080/icss，因此得到的请求url是localhost:8080/icss,
       也可以使用url=/icss/login，相对路径会从站点的根目录开始查找，得到的请求url也是localhost:8080/icss。
    -->
    <meta http-equiv="refresh" content="1;url=page/login">
    <title>SpringSecurity测试</title>
</head>
<body>
<h2>搭建SpringSecurity测试项目</h2>
</body>
</html>
