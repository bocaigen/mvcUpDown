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
    <title>用户注册</title>
  </head>
  <body>

      <h2>用户注册</h2>
      <form action="${pageContext.request.contextPath }/register" enctype="multipart/form-data" method="post">
        <table>
          <tr>
            <td>用户名:</td>
            <td><input type="text" name="username"></td>
          </tr>
          <tr>
            <td>请上传头像:</td>
            <td><input type="file" name="image"></td>
          </tr>
          <tr>
            <td><input type="submit" value="注册"></td>
          </tr>
        </table>
      </form>
  </body>
</html>
