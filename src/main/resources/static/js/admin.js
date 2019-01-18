$(document).ready(function () {
    var url = GetUrlRelativePath();
    switch (url) {
        case "/admin/audit":
            $('#_blog').addClass('active');
            $('auditLink').addClass('active');
            appendTablePath();
        break;
        case "/admin/allArticle":
            $('#_blog').addClass('active');
            $('#allArticleLink').addClass('active');
            break;
        case "/admin/userControl":
            $('#_user').addClass('active');
            $('#groupLink').addClass('active');
            break;
        case "/admin":
            $('_admin').addClass('active');
    }
});
function GetUrlRelativePath() {
    var url = document.location.toString();
    var arrUrl = url.split("//");
    var start = arrUrl[1].indexOf("/");
    var relUrl = arrUrl[1].substring(start);//stop省略，截取从start开始到结尾的所有字符

    if(relUrl.indexOf("?") != -1){
        relUrl = relUrl.split("?")[0];
    }
    return relUrl;
}
function appendTablePath(input){

}
/*
function audit(blogId, method){
    alert('method is '+method);
}*/
function audit(blogId, method, reason, table) {
    $.ajax({
        url: "/doAudit.do",
        data: {
            'blogId':blogId,
            'target':method,
            'reason':reason
        },
        dataType: "json",
        success: function (data) {
        }
    });
    return true;
}

function getDataFromStatus(param) {
    var res = [];
    $.ajax({
        url: '/getArticles.do',
        type: 'get',
        data: {'method': 'status','status': param},
        async: false,
        success: function (result) {
            res = $.parseJSON(result);
            //console.log(res);
            //console.log(res.data[7]);
        }
    });
    return res;
}