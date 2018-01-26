<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <title>Мир Квестов</title>
    <script>
        var contextUrl = "${pageContext.request.contextPath}";
    </script>
</head>

<body>

<input id="name" type="text" maxlength="200"/>

<input id="publishAt" type="date" name="calendar"/>

<input id="unpublishAt" type="date" name="calendar"/>

<div id="content">
</div>

<button onclick="addNEws()">Добавить новость</button>

<button onclick="getNews()">Просмотреть новость</button>

<script defer type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script defer type="text/javascript" src="${pageContext.request.contextPath}/js/handlebars.js"></script>
<script defer type="text/javascript" src="${pageContext.request.contextPath}/js/global.js"></script>
<script defer type="text/javascript" src="${pageContext.request.contextPath}/js/news.js"></script>
<script defer type="text/javascript" src="${pageContext.request.contextPath}/ckeditor/ckeditor.js"></script>

<script>
    window.onload = function() {
        CKEDITOR.replace('content');
    };
</script>

</body>

</html>