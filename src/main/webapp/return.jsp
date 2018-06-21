<%@page import="com.zt.book.pojo.Record" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    List<Record> records = (List<Record>) request.getAttribute("records");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta charset="UTF-8">
    <title>归还</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/userlist.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
</head>

<body>
<h1 class="title">还书管理</h1>
<table class="list">
    <th colspan="6">
        <form action="${pageContext.request.contextPath}/returns/findByLike" method="post">
            <input type="text" placeholder="按用户名搜索" name="userName" id="search-input" class="search-input"/>
            <input type="submit" id="search-button" value="搜索"/>
        </form>
    </th>
    <tr class="title-tr">
        <td>Id</td>
        <td>图书书名</td>
        <td>借书用户</td>
        <td>借书时间</td>
        <td>还书时间</td>
        <td>还书操作</td>
    </tr>

    <%
        for (Record record : records) {
    %>
    <tr class="value-tr">
        <td class="value-td"><%=record.getId()%>
        </td>
        <td class="value-td"><%=record.getBookName()%>
        </td>
        <td class="value-td"><%=record.getUserName()%>
        </td>
        <td class="value-td"><%=record.getBorrowDate()%>
        </td>
        <td class="value-td"><%=record.getReturnDate()%>
        </td>
        <td class="value-botton">
            <button type="button" class="delete">归还</button>
        </td>
    <tr>
            <%
				}
			%>

</table>

<script type="text/javascript">

    /*删除按钮*/
    $(".delete").click(function () {
        var rid = $(this).parents("tr").find("td").eq(0).html().replace(/^\s+|\s+$/g, "");
       $.ajax({
           url:"${pageContext.request.contextPath}/returns/returnBook",
           data:"id="+rid,
           type:"post",
           async:false,
           success:function (data) {
               alert(data.msg);
               location.reload();
           }
       });
    });


</script>
</body>
</html>