/**
 * document load
 */
$(document).ready(function () {

});

/**
 * 登录检测
 */
function login() {
    var name = $("#user_name").val();
    var pass = $("#password").val();
    if (name != "" || pass !="") {
        $.ajaxSetup({
           async: false
        });
        $.post(
            "/SignIn.do",
            {"userName":name,"userPassword":pass},
            function(data){
                if(data == "SUCCESS"){
                    alert("登录成功！");
                    $("#user_name").val("");
                    $("#password").val("");
                    // skip into home page
                    window.location.href="/home";
                }else{
                    $("#login_form").removeClass('shake_effect');
                    setTimeout(function () {
                        $("#login_form").addClass('shake_effect')
                    }, 1);
                    if(data == 'ISLOGIN'){
                        //$('#reason').html("<b>该用户已登录</b>");
                        $('#msg').html("<b>该用户已登录</b>");
                        console.log("is login");
                    }else if(data == 'USER_NOT_FOUND'){
                        $('#msg').html("<b>未找到该用户</b>");
                        //$('#modal-warning').modal();
                        console.log('user not found');
                    }else if(data == 'PASSWORD_ERR'){
                        $('#msg').html("<b>密码错误</b>");
                        //$('#modal-warning').modal();
                        console.log('password error')
                    }
                }
            }
        )
        $.ajaxSetup({
            async: true
        });
    }
    else {
        $("#login_form").removeClass('shake_effect');
        setTimeout(function () {
            $("#login_form").addClass('shake_effect')
        }, 1);
    }
}

/**
 * 注册检查
 */
function register() {
    var name = $("#r_user_name").val();
    var pass = $("#r_password").val();
    var email = $("#r_email").val();
    var passCheck = $("#r_password_check").val();
    var pattern = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
    if(pattern.test(email)) {
        if(pass == passCheck) {
            $.ajaxSetup({
                async: false
            });
            $.post(
                "/SignUp.do",
                {"userName":name,"userPassword":pass,"userEmail":email},
                function (data) {
                    console.log(data);
                    if(data == "SUCCESS"){
                        alert("注册成功！");
                    }else if(data == 'EMAIL_UNIQUE'){
                        $('#msg').html("<b>Email已被注册</b>");
                        //$('#modal-warning').modal();
                        console.log('email exists');
                    }else if(data == 'NAME_UNIQUE'){
                        $('#msg').html("<b>用户名已被注册</b>");
                        //$('#modal-warning').modal();
                        console.log('name exists');
                    }
                    $("#login_form").removeClass('shake_effect');
                    setTimeout(function () {
                        $("#login_form").addClass('shake_effect')
                    }, 1);
                }
            );
            $.ajaxSetup({
                async: true
            });
        }else{
            $('#msg').html("<b>请再次输入相同的密码</b>");
            //$('#modal-warning').modal();
            console.log("check password error");
        }
    }else{
        $('#msg').html("<b>Email格式错误 （eg. example@gmail.com）</b>");
        //$('#modal-warning').modal();
        console.log("email format error");
    }
    $("#login_form").removeClass('shake_effect');
    setTimeout(function () {
        $("#login_form").addClass('shake_effect')
    }, 1);
}
