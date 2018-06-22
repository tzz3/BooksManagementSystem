<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>上传</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
</head>

<body>
<form action="${pageContext.request.contextPath}/books/up" id="form" method="post" enctype="multipart/form-data">
    <input type="file" name="filedata" id="filedata" value="file"/>
    <input type="button" class="submit" value="上传"/>
</form>
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