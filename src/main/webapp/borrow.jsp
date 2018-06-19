<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta charset="UTF-8">
    <title>借书</title>
    <link rel="stylesheet" href="css/borrow.css"/>
    <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
</head>
<body>
<h1 class="title">借书管理</h1>
<div class="box">
    <form action="" id="form" method="post">
        <div class="box-th">
            <p>书本名字</p>
            <input type="text" name="bookName" placeholder="清输入书本名字"/>
        </div>
        <div class="box-th">
            <p>用户</p>
            <input type="text" name="userName" placeholder="请输入用户"/>
        </div>
        <div class="box-th">
            <p>借书日期</p>
            <input type="date" name="borrowDate"/>
        </div>
        <div class="box-th">
            <p>还书日期</p>
            <input type="date" name="returnDate"/>
        </div>
        <input type="submit" class="submit" value="提交订单"/>
    </form>
</div>
</body>
<script type="text/javascript">
    /*借书*/

</script>
</html>