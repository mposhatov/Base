window.onload = function () {
    getNewsListForAdmin();
    CKEDITOR.replace('form-full-news-content');
};

function addNews() {
    var params = $.extend({}, defaultAjaxParams);
    params.url = url.news;

    params.requestType = "POST";

    params.data = {
        name: $("#form-full-news-name").val(),
        publishAt: new Date($("#form-full-news-publishAt").val()).toDateString(),
        unpublishAt: new Date($("#form-full-news-unpublishAt").val()).toDateString(),
        content: CKEDITOR.instances['form-full-news-content'].getData()
    };

    params.successCallbackFunc = function (news) {
        $("#news-list").append(generateHtmlShortNewsForAdmin(news));
        $("#form-full-news").css('display', 'none');
    };

    doAjaxRequest(params);
}

function updateNews() {

}

function getNewsListForAdmin() {
    var params = $.extend({}, defaultAjaxParams);
    params.url = url.newsList;

    params.requestType = "GET";

    params.data = {
        page: 0,
        size: 10
    };

    params.successCallbackFunc = function (newsList) {
        var html = '';

        newsList.forEach(function (news) {
            html += generateHtmlShortNewsForAdmin(news);
        });

        $("#news-list").html(html);
    };

    doAjaxRequest(params);
}

function getFullNewsForAdmin(newsId) {
    var params = $.extend({}, defaultAjaxParams);
    params.url = url.news;

    params.requestType = "GET";

    params.data = {
        id: newsId
    };

    params.successCallbackFunc = function (news) {
        $("#full-news").css('display', 'block');
        $("#full-news").html(generateHtmlFullNewsForAdmin(news));
    };

    doAjaxRequest(params);
}

function getFullNewsForUpdate(newsId) {
    var params = $.extend({}, defaultAjaxParams);
    params.url = url.news;

    params.requestType = "GET";

    params.data = {
        id: newsId
    };

    params.successCallbackFunc = function (news) {
        showFormForUpdateNews(news);
    };

    doAjaxRequest(params);
}

function showFormForUpdateNews(news) {
    showFormFullNews();
    $("#button-update-news").css('display', 'block');
    $("#button-add-news").css('display', 'none');
    $("#form-full-news-name").val(news.name);
    $("#form-full-news-publishAt").val(moment(news.publishAt).format("YYYY-MM-DD"));
    $("#form-full-news-unpublishAt").val(moment(news.unpublishAt).format("YYYY-MM-DD"));
    CKEDITOR.instances['form-full-news-content'].setData(news.content);
}

function showFormForAddNews() {
    showFormFullNews();
    $("#button-add-news").css('display', 'block');
    $("#button-update-news").css('display', 'none');
}

function showFormFullNews() {
    $("#form-full-news-name").val(null);
    $("#form-full-news-publishAt").val(null);
    $("#form-full-news-unpublishAt").val(null);
    CKEDITOR.instances['form-full-news-content'].insertHtml(null);

    $("#form-full-news").css('display', 'block');
}

function closeFormFullNews() {
    $("#button-add-news").css('display', 'none');
    $("#button-update-news").css('display', 'none');
    $("#form-full-news").css('display', 'none');
}
function closeFullNews() {
    $("#full-news").css('display', 'none');
}

function generateHtmlShortNewsForAdmin(news) {
    var html = '';

    html += "<div id=news-" + news.id + " class=short-news>";
    html += "<div class=short-news-name>" + news.name + "</div>";
    html += "<div class=short-news-publish-at>" + moment(news.publishAt).format("DD.MM.YYYY") + "</div>";

    html += "<div class=button-show-news onclick=getFullNewsForAdmin(" + news.id + ")>Просмотреть новость</div>";

    html += "<div class=button-updated-news onclick=getFullNewsForUpdate(" + news.id + ")>Редактировать новость</div>";

    html += "</div>";

    return html;
}

function generateHtmlFullNewsForAdmin(news) {
    var html = '';

    html += "<div class=full-news-name>" + news.name + "</div>";
    html += "<div class=full-news-publish-at>" + moment(news.publishAt).format("DD.MM.YYYY") + "</div>";
    html += "<div class=full-news-unpublish-at>" + moment(news.unpublishAt).format("DD.MM.YYYY") + "</div>";
    html += "<div class=full-news-status>" + news.status + "</div>";
    html += "<div class=full-news-content>" + news.content + "</div>";

    html += "<button onclick=closeFullNews()>Закрыть новость</button>";

    return html;
}