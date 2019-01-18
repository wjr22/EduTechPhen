
function addActive() {
    $(".nav-tabs").find("li").each(function () {
        var a = $(this).find("a:first")[0];
        if ($(a).attr("href") === location.pathname) {
            $(this).addClass("active");
        } else {
            $(this).removeClass("active");
        }
    });
}
function blog(){
    $('#home-blog').addClass('active');
    $.ajax({
        url: "/getArticles.do",
        data:{
            'method': 'category',
            'category': '5'
        },
        type: "GET",
        success: function(data){
            var json = $.parseJSON(data);
            if(json.result==true) {
                var blogs = json.blogSets;
                console.log(blogs);
                for (var i in blogs) {
                    if(blogs[i].blogStatus == "审核通过"){
                        //alert(blogs[i].blogId);
                        // TODO append html to main-contain
                        $('#main-contain').html("<div>\n" +
                            "            <div class=\"b-list\">\n" +
                            "                <p>\n" +
                            "<h3><a href='/blog?blogId=" + blogs[i].blogId + "'>" + blogs[i].blogTitle +"</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                            "<small>" + blogs[i].author + "</small></h3>" +
                            "<small>" + blogs[i].blogAbstract + "</small>" +
                            "                </p>\n" +
                            "            </div>\n" +
                            "            <HR style=\"FILTER: progid:DXImageTransform.Microsoft.Shadow(color:#987cb9,direction:145,strength:15)\" width=\"80%\" color=#987cb9 SIZE=1>\n" +
                            "        </div>")
                    }
                }
            }
        }
    })
}