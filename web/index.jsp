<%--
  Created by IntelliJ IDEA.
  User: zhangxibo
  Date: 2018/1/11
  Time: 9:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>文件上传</title>
  </head>
  <body>

      <h2>文件上传</h2>
      <form action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data" method="post">
        <table>
          <tr>
            <td>文件描述:</td>
            <td><input type="text" name="description"></td>
          </tr>
          <tr>
            <td>请选择文件:</td>
            <td><input type="file" name="file"></td>
          </tr>
          <tr>
            <td><input type="submit" value="上传"></td>
          </tr>
        </table>
      </form>
      <a href="${pageContext.request.contextPath}/toRegisterForm">跳转注册表单</a>
      <a href="${pageContext.request.contextPath}/excel/excel.do">跳转Excel导入</a>
      <a href="http://172.19.36.222:8081/fly-portal-4/uuac/login.do">飞翔登录</a>
  </body>
</html>
