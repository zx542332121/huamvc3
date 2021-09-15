<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2021/9/14
  Time: 9:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>新增</title>
</head>
<body>
<div>
    <form action="<c:url value="/goods/doAdd"/>" method="post">
        <table>
            <tr>
                <td>编号</td><td><input type="text" name="id"></td>
            </tr>
            <tr>
                <td>名称</td><td><input type="text" name="g_name" ></td>
            </tr>
            <tr>
                <td>价格</td><td><input type="text" name="g_price"></td>
            </tr>
            <tr>
                <td>日期</td><td><input type="date" name="g_date"></td>
            </tr>
            <tr>
                <td><input type="submit" value="保存"><input type="button" onclick="history.go(-1)" value="取消"></td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>
