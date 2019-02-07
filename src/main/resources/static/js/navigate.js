
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

/**
 * get blogs and append to html
 */
function blog(){
    $('#home-blog').addClass('active');
    $.ajax({
        url: "/getArticles.do",
        data:{
            'method': 'category',
            'category': '5'
        },
        async: false,
        type: "GET",
        success: function(data){
            var json = $.parseJSON(data);
            if(json.result==true) {
                var blogs = json.blogSets;
                for (var i in blogs) {
                    if(blogs[i].blogStatus == "审核通过"){
                        // TODO append html to main-contain
                        // TODO paging
                        $('#main-contain').append("<div><div class=\"b-list\"><p><h4><a href='/blog?blogId=" + blogs[i].blogId + "'>" + blogs[i].blogTitle + "</a></h4><div class='abstract-content'>" + blogs[i].blogAbstract + "</div>" +
                            "                   <div class='blog-info'><img src=''>" + "<span>" + blogs[i].author + "</span> <span>" + blogs[i].updateDate + "</span></div></p></div>" +
                            "            <HR style=\"FILTER: progid:DXImageTransform.Microsoft.Shadow(color:#987cb9,direction:145,strength:15)\" width=\"80%\" color=#987cb9 SIZE=1></div>")
                    }
                }
            }
        }
    })
}