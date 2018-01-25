<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/welcome.css">
    <title>Мир Квестов</title>
    <script>
        var contextUrl = "${pageContext.request.contextPath}";
    </script>
</head>

<body>

<input id="name" type="text" maxlength="200"/>

<textarea id="content" maxlength="32700"></textarea>

<input id="publishAt" type="date" name="calendar"/>

<input id="unpublishAt" type="date" name="calendar"/>

<button onclick="addNEws()">Добавить новость</button>

<script defer type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script defer type="text/javascript" src="${pageContext.request.contextPath}/js/handlebars.js"></script>
<script defer type="text/javascript" src="${pageContext.request.contextPath}/js/global.js"></script>
<script defer type="text/javascript" src="${pageContext.request.contextPath}/js/news.js"></script>
</body>

</html>