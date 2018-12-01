<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/1
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>用户列表</title>
</head>
<body>
<c:forEach items="${allUser}" var="user" varStatus="vs">
    <tr>

        <td>
            <s:property value="#vs.index+1"/>
        </td>
        <td align = "center">${user.id}</td>
        <td align = "center">${user.username}</td>
        <td align = "center">${user.password}</td>
        <td align = "center">${user.state}</td>
    </tr>
</c:forEach>
</body>
</html>
