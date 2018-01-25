function addNEws() {
    var params = $.extend({}, defaultAjaxParams);
    params.url = url.news;

    params.requestType = "POST";

    params.data = {
        name: $("#name").val(),
        content: $("#content").val(),
        publishAt: new Date($("#publishAt").val()).toDateString(),
        unpublishAt: new Date($("#unpublishAt").val()).toDateString()
    };

    params.successCallbackFunc = function (news) {
    };

    doAjaxRequest(params);
}