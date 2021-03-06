<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta charset="UTF-8">
    <title>借书</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/borrow.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
</head>
<body>
<h1 class="title">借书管理</h1>
<div class="box">
    <form action="" id="form" method="post">
        <div class="box-th">
            <p>书本名字</p>
            <input type="text" name="bookName" placeholder="请输入书本名字"/>
        </div>
        <div class="box-th">
            <p>用户</p>
            <input type="text" id="userName" name="userName" placeholder="请输入用户"/>
            <%--readonly="readonly"--%>
        </div>
        <div class="box-th">
            <p>借书日期</p>
            <input type="date" min="" id="borrowDate" name="borrowDate"/>
        </div>
        <div class="box-th">
            <p>还书日期</p>
            <input type="date" min="" id="returnDate" name="returnDate"/>
        </div>
        <input type="submit" class="submit" value="提交订单"/>
    </form>
</div>
</body>
<script type="text/javascript">

    $("#userName").val("${u.userName}");
    console.log(getDate(0));
    $("#borrowDate").val(getDate(0));
    $("#returnDate").val(getDate(7));
    $("#borrowDate").attr("min", getDate(0));
    $("#returnDate").attr("min", getDate(0));

    /*借书*/
    $(".submit").click(function (e) {
        e.preventDefault();
        $.ajax({
            type: "post",
            url: "${pageContext.request.contextPath}/borrows/borrow",
            data: $("#form").serialize(),
            async: false,
            success: function (data) {
                alert(data.msg);
                window.location.href = "${pageContext.request.contextPath}/returns/findAll";
            }
        });
    });

    function getDate(dayNum) {
        var date = new Date();
        date.setDate(date.getDate() + dayNum);
        var year = date.getFullYear();
        var month = date.getMonth() + 1;
        var day = date.getDate();
        if (month < 10) {
            month = '0' + month;
        }
        if (day < 10) {
            day = '0' + day;
        }
        return year + "-" + month + "-" + day;
    }
</script>
</html>