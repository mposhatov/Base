var currentNewsId = null;

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

function getNews() {
    var params = $.extend({}, defaultAjaxParams);
    params.url = url.news;

    params.requestType = "GET";

    params.data = {
        id: currentNewsId
    };

    params.successCallbackFunc = function (news) {
        $("body").html(news.content);
    };

    doAjaxRequest(params);
}

function getNewsList() {
    var params = $.extend({}, defaultAjaxParams);
    params.url = url.news;

    params.requestType = "GET";

    params.data = {
        page: 0,
        size: 10
    };

    params.successCallbackFunc = function (newsList) {
    };

    doAjaxRequest(params);
}