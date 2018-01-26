<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <title>Мир Квестов</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/news.css">
    <script>
        var contextUrl = "${pageContext.request.contextPath}";
    </script>
</head>

<body>

<div id="workspace" class="workspace">
</div>

<script defer type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script defer type="text/javascript" src="${pageContext.request.contextPath}/js/global.js"></script>
<script defer type="text/javascript" src="${pageContext.request.contextPath}/js/welcome.js"></script>
<script defer type="text/javascript" src="${pageContext.request.contextPath}/js/news.js"></script>
<script defer type="text/javascript" src="${pageContext.request.contextPath}/js/moment.js"></script>

</body>

</html>