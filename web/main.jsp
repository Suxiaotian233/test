<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>主页</title>
    <link rel="stylesheet" href="css/mian.css">
</head>
<body>
    <a href="/index" class="top_btn">刷新</a>
    <a href="/select" class="select_btn">查询</a>
    <input type="text" name="select" class="select_input">

    <table class="content">
        <c:forEach items="${words}" var="w">
        <tr class="nav">
            <td>${w.id}</td>
            <td>${w.word}</td>
            <td>${w.translate}</td>
            <td></td>
        </tr>
        </c:forEach>

    </table>

    <a href="/insert" class="insert">添加词条</a>


</body>
</html>
