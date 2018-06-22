<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page import="com.zt.book.pojo.Book" %>

<!DOCTYPE html>
<html lang="zh-cn">
<%
    List<Book> books = (List<Book>) request.getAttribute("books");
%>
<head>
    <title>主页</title>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Slicebox - 3D Image Slider with Fallback"/>
    <meta name="keywords"
          content="jquery, css3, 3d, webkit, fallback, slider, css3, 3d transforms, slices, rotate, box, automatic"
    />
    <meta name="author" content="Pedro Botelho for Codrops"/>
    <link rel="shortcut icon" href="../favicon.ico">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/demo.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/slicebox.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/custom.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/init.css">
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.3.1.min.js"></script>
    <style>
        .top-banner {
            background-color: rgba(255, 255, 255, 0.55);
        }

        .top-banner a {
            color: #019135;
        }

        h1 {
            margin-top: 100px;
            font-family: 'Microsoft Yahei';
            font-size: 36px;
            color: #019157;
        }
    </style>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/modernizr.custom.46884.js"></script>
</head>

<body>
<div class="container">

    <div class="more">
        <ul id="sb-examples">
        </ul>
    </div>

    <div class="wrapper">

        <ul id="sb-slider" class="sb-slider">
            <%
                for (Book book :
                        books) {
            %>
            <li>
                <a href="" target="_blank">
                    <img src="${pageContext.request.contextPath}/<%=book.getAddress()%>" height="396px" width="740px"
                         alt="<%=book.getBookName()%>>"/>
                </a>
                <div class="sb-description">
                    <h3><%=book.getBookName()%>
                    </h3>
                </div>
            </li>
            <%
                }
            %>
        </ul>

        <div id="shadow" class="shadow"></div>

        <div id="nav-arrows" class="nav-arrows">
            <a href="#">Next</a>
            <a href="#">Previous</a>
        </div>

    </div>
    <!-- /wrapper -->
    <div class="footer-banner" style="width:728px; margin:30px auto"></div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.slicebox.js"></script>
<script type="text/javascript">

    $(function () {
        var Page = (function () {
            var $navArrows = $('#nav-arrows').hide(),
                $shadow = $('#shadow').hide(),
                slicebox = $('#sb-slider').slicebox({
                    onReady: function () {
                        $navArrows.show();
                        $shadow.show();
                    },
                    orientation: 'r',
                    cuboidsRandom: true,
                    disperseFactor: 30
                }),
                init = function () {
                    initEvents();
                },
                initEvents = function () {
                    // add navigation events
                    $navArrows.children(':first').on('click', function () {
                        slicebox.next();
                        return false;
                    });
                    $navArrows.children(':last').on('click', function () {
                        slicebox.previous();
                        return false;
                    });
                };
            return {init: init};
        })();
        Page.init();
    });
</script>
</body>

</html>