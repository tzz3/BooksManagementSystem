<%@ page import="org.apache.shiro.crypto.hash.Md5Hash" %>
<%@ page import="com.zt.book.pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: tzz
  Date: 2018/6/22
  Time: 0:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>修改密码</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/userlist.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
</head>
<body>
<div class="box-pwd">
    <form action="" id="form" method="post">
        <div class="pwd">修改密码</div>
        <%--<button type="button" class="" id="close"></button>--%>

        <div class="box-th">
            <p>用户</p>
            <input type="text" name="userName" id="userName" class="userName" readonly="readonly"/>
        </div>

        <div class="box-th">
            <p>原密码</p>
            <input type="password" name="userPassword" id="userPassword" class="passWord" onblur="checkPwd()"/>
        </div>

        <div class="box-th">
            <p>新密码</p>
            <input type="password" name="npwd" id="npwd" class="phone"/>
        </div>
        <div class="box-th">
            <p>确认密码</p>
            <input type="password" name="rnpwd" id="rnpwd" class="phone" onkeyup="check()"/>
        </div>
        <div class="info-pwd" id="info-pwd">
        </div>
        <input type="submit" class="submit update_submit" value="提交"/>
    </form>
</div>
<div class="box-shadow"></div>
</body>

<script>
    $(".submit").attr("disabled", true);

    $(".box-shadow").css({
        "display": "block"
    });

    $("#userName").val("${u.userName}");
    var id = "${u.id}";


    $(".submit").click(function (e) {
        e.preventDefault();
        var newpwd = $("#npwd").val();
        console.log(newpwd);
        $.ajax({
            url: "${pageContext.request.contextPath}/users/updatePassword",
            type: "post",
            data: {"id": id, "newpwd": newpwd},
            async: false,
            success: function (data) {
                alert(data.msg);
                if (data.msg == "密码修改成功,请重新登录") {
                    window.top.location = "${pageContext.request.contextPath}/login.jsp";
                }
            }
        })
    });

    var password = "${u.userPassword}";

    function checkPwd() {
        var pwd = $("#userPassword").val();
        if (pwd == "") {
            $("#info-pwd").text("原密码不可为空");
            $("#npwd").attr("disabled", true);
            $("#rnpwd").attr("disabled", true);
            $(".submit").attr("disabled", true);
        } else {
            console.log("password:", password);
            var pwd1;
            $.ajax({
                url: "${pageContext.request.contextPath}/users/getMd5",
                type: "post",
                data: {"pwd": pwd},
                async: false,
                success: function (data) {
                    pwd1 = data;
                }
            });
            console.log("pwd:", pwd1);

            if (pwd1 != password) {
                $("#info-pwd").text("原密码错误");
                $("#npwd").attr("disabled", true);
                $("#rnpwd").attr("disabled", true);
                $(".submit").attr("disabled", true);
            } else {
                $("#info-pwd").text("");
                $("#npwd").attr("disabled", false);
                $("#rnpwd").attr("disabled", false);
            }
        }

    }


    function check() {
        var npwd = $("#npwd").val();
        var rnpwd = $("#rnpwd").val();
        if (npwd == "") {
            $("#info-pwd").text("输入密码不可为空");
            $(".submit").attr("disabled", true);
        }
        else {
            if (npwd != rnpwd) {
                $("#info-pwd").text("输入密码不相同");
                $(".submit").attr("disabled", true);
            } else {
                $("#info-pwd").text("");
                $(".submit").attr("disabled", false);
            }
        }
    }
</script>
</html>
