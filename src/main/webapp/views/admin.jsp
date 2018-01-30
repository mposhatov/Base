<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <title>Региональное инвестиционное агентство «ГомельИнвест» - Региональное инвестиционное агентство «ГомельИнвест»</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css">
    <script>
        var contextUrl = "${pageContext.request.contextPath}";
    </script>
</head>

<body>

<div id="news-list" class="news-list">
</div>

<div id="full-news" class="full-news">
</div>

<button onclick="showFormForAddNews()">Добавить новость</button>

<div id="form-full-news" class="form-full-news">
    <input id="form-full-news-name" type="text" maxlength="200"/>

    <input id="form-full-news-publishAt" type="date" name="calendar"/>

    <input id="form-full-news-unpublishAt" type="date" name="calendar"/>

    <div id="form-full-news-content">
    </div>

    <button id="button-add-news" onclick="addNews()">Добавить новость</button>
    <button id="button-update-news" onclick="updateNews()">Изменить новость</button>

    <button onclick="closeFormFullNews()">Закрыть</button>
</div>

<script defer type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script defer type="text/javascript" src="${pageContext.request.contextPath}/js/handlebars.js"></script>
<script defer type="text/javascript" src="${pageContext.request.contextPath}/js/moment.js"></script>
<script defer type="text/javascript" src="${pageContext.request.contextPath}/js/global.js"></script>
<script defer type="text/javascript" src="${pageContext.request.contextPath}/js/news.js"></script>
<script defer type="text/javascript" src="${pageContext.request.contextPath}/js/admin.js"></script>
<script defer type="text/javascript" src="${pageContext.request.contextPath}/ckeditor/ckeditor.js"></script>

</body>

</html>