/**
 * check is login
 * @return "NET_ERR" :network error
 *          "FALSE"  :no user in session
 *          OR session['userId']
 */
function checkIsLogin() {
    var result = "NET_ERR";
    // set ajax sync request
    $.ajaxSetup({
        async: false
    });
    $.get(
        "/getSession.do",
         function (data,status){
            if(data == "null"){
                result = "FALSE";
            }else{
                result = data;
            }
        }
    );
    // set ajax Async request
    $.ajaxSetup({
        async: true
    });
    return result;
}

/**
 * log out
 */
function logout(){
    // set ajax sync request
    $.ajaxSetup({
        async: false
    });
    var log = confirm("确认是否退出？");
    if(log == true){
        $.post(
            "/SignOut.do",
            function (status) {
                console.log(status);
                if(status == 200){
                    alert("已退出");
                    // redirect into index page
                }
                location.reload();
            }
        );
    }
    // set ajax Async request
    $.ajaxSetup({
        async: true
    });
}

function getAuthority(){
    var userId = checkIsLogin();
    var authority = null;
    if(userId != "FALSE") {
        $.ajaxSetup({
            async: false
        });
        $.post(
            "/Authority.do",
            function (data,status) {
                console.log(data);
                authority = data;
            }
        );
        // set ajax Async request
        $.ajaxSetup({
            async: true
        });
    }
    return authority;
}

/**
 * get message by from id
 */
function getMsgByFromId(fromId) {
    $.ajax({
        url: '/getMsg.do',
        data: {'fromId': fromId},
        dataType: 'json',
        success: function (data) {

        }
    })
}

/**
 * search for page to add active

$('.nav-tabs').find('a').each(function () {
    console.log(document.location.href);
    if (this.href == document.location.href || document.location.href.search(this.href) >= 0) {
        $(this).parent().addClass('active'); // this.className = 'active';
    }
});*/

/**
 *
 * @param url           :  request url
 * @param requestData   :  request data ( if request method is POST,it's needed )
 * @param async         :true or false, if value is true, request will be asynchronous.
 *                          default false
 * @param method        : "GET" "POST" and so on,default "GET"
 * @param func          : if async == true,this function will be executed,default null
 */
function loadXMLDoc(url, requestData, async, method, callback) {
    var xmlHttp = null;
    if(window.XMLHttpRequest){
        // For common browsers
        xmlHttp = new XMLHttpRequest();
    }else{
        // For IE 5/6
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    if(xmlHttp != null){
        if(async == true) {
            // async request,after success,it will execute callback function
            xmlHttp.setRequestHeader("Content-Type",
                "application/x-www-form-urlencoded;");
            xmlHttp.onreadystatechange = callback;
            xmlhttp.open(method, url, async);
            if(method == "POST") {
                xmlhttp.send(requestData);
            }else{
                xmlHttp.send();
            }
        }else{
            // sync request,
        }
    }
}
