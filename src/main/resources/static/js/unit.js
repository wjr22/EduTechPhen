function checkIsLogin() {
    $.get(
        "/getSession.do",
        function (data,status){
            if(data == null){
                alert("还没有登录");
                window.location.href="/signin"
            }
        }
    )
}

