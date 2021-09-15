<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2021/9/13
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="hwadee" uri="http://hwadee.cn/common/" %>

<html>
<head>
    <title>商品管理</title>
</head>
<body>
<div>
    <table class="table">
    <tr>
        <th>#</th>
        <th>商品名</th>
        <th>价格</th>
        <th>日期</th>
    </tr>
    <c:forEach items="${list}" var="model">
        <tr>
            <td><c:out value="${model.id}"/></td>
            <td><c:out value="${model.g_name}"/></td>
            <td><c:out value="${model.g_price}"/></td>
            <td><c:out value="${model.g_date}"/></td>
            <td>
                <a href="<c:url value="/goods/update/${model.id}"/>">修改</a>
                <a href="<c:url value="/goods/del/${model.id}"/>">删除</a>
                <a href="<c:url value="/add.jsp"/>">新增</a>
            </td>
        </tr>
    </c:forEach>
        <div>
            <hwadee:page url="${pageContext.request.contextPath}/goods/list"></hwadee:page>
        </div>
</table>
</div>
</body>
</html>
