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
                        console.log("is login");
                    }
                }
            }
        )
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
            $.post(
                "/SignUp.do",
                {"userName":name,"userPassword":pass,"userEmail":email},
                function (data) {
                    $("#email_msg").css("display","none");
                    console.log(data);
                    if(data == "SUCCESS"){
                        alert("注册成功！");
                    }
                    $('#name_msg').css("display","block");
                    $("#login_form").removeClass('shake_effect');
                    setTimeout(function () {
                        $("#login_form").addClass('shake_effect')
                    }, 1);
                }
            );
        }else{
            $("#checkpassword_msg").css("display","block");
        }
    }else{
        $("#email_msg").css("display","block");
    }
    $("#login_form").removeClass('shake_effect');
    setTimeout(function () {
        $("#login_form").addClass('shake_effect')
    }, 1);
}
