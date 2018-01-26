function addNEws() {
    var params = $.extend({}, defaultAjaxParams);
    params.url = url.news;

    params.requestType = "POST";

    params.data = {
        name: $("#name").val(),
        content: CKEDITOR.instances['content'].getData(),
        publishAt: new Date($("#publishAt").val()).toDateString(),
        unpublishAt: new Date($("#unpublishAt").val()).toDateString()
    };

    params.successCallbackFunc = function (news) {
    };

    doAjaxRequest(params);
}

//CKEDITOR.instances['content'].insertHtml('<p>This is a new paragraph.</p>');

function getNews(newsId) {
    var params = $.extend({}, defaultAjaxParams);
    params.url = url.news;

    params.requestType = "GET";

    params.data = {
        id: newsId
    };

    params.successCallbackFunc = function (news) {
        $("body").html(generateHtmlNews(news, false));
    };

    doAjaxRequest(params);
}

function getNewsList() {
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
            html += generateHtmlNews(news, true);
        });

        $("#workspace").html(html);
    };

    doAjaxRequest(params);
}

function generateHtmlNews(news, isClickable) {
    var html = '';

    if(isClickable) {
        html += "<div id = news-" + news.id + " class=news onclick='getNews(" + news.id + ")'>";
        html += "<div class=news-name>" + news.name + "</div>";
        html += "<div class=news-publish-at>" + moment(news.publishAt).format("DD.MM.YYYY") + "</div>";
    } else {
        html += "<div id = news-" + news.id + " class=news>";
        html += "<div class=news-name>" + news.name + "</div>";
        html += "<div class=news-publish-at>" + moment(news.publishAt).format("DD.MM.YYYY") + "</div>";
        html += "<div class=news-unpublish-at>" + moment(news.unpublishAt).format("DD.MM.YYYY") + "</div>";
        html += "<div class=content>" + news.content + "</div>";
    }

    html += "</div>";

    return html;
}
