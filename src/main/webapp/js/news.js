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
            html += generateHtmlShortNews(news);
        });

        $("#news-list").html(html);
    };

    doAjaxRequest(params);
}