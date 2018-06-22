<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>上传</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/userlist.css"/>
</head>

<body>
<div class="box-pwd">
    <form action="${pageContext.request.contextPath}/books/up" id="form" method="post" enctype="multipart/form-data">
        <div class="pwd"><h1>批量上传</h1></div>
        <%--<button type="button" class="" id="close"></button>--%>
        <div class="box-th">
            <p>选择文件</p>
            <input type="file" class="upInput" name="filedata" id="filedata" value="file"/>
        </div>

        <input type="button" class="submit" value="提交"/>
    </form>
</div>
<div class="box-shadow"></div>

</body>

<script>
    $(".submit").click(function () {
        var formData = new FormData(document.getElementById("form"));
        $.ajax({
            type: "post",
            url: "${pageContext.request.contextPath}/users/upUser",
            data: formData,
            //不处理请求头
            contentType: false,
            //不处理数据
            processData: false,
            async: false,
            encType: "multipart/form-data",
            success: function (data) {
                alert(data.msg);
                window.location.reload();
            }
        })
    });
</script>

</html>