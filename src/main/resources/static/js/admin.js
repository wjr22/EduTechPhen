$(document).ready(function () {
    var url = GetUrlRelativePath();
    switch (url) {
        case "/admin/audit":
            $('#_blog').addClass('active');
            $('#_blog').addClass('active');
        break;
        case "/admin/allArticle":
            $('#_blog').addClass('active');
            $('#_blog').addClass('active');
            break;
        case "/admin/userControl":
            $('#_blog').addClass('active');
            $('#_blog').addClass('active');
            break;
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