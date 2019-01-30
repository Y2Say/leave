var SnippetLogin = function() {
    var e = $("#m_login"),
        t = function() {
            e.removeClass("m-login--forget-password"),
                e.removeClass("m-login--signup"),
                e.addClass("m-login--signin"),
                e.find(".m-login__signin").animateClass("flipInX animated")
        },
        r = function() {
            e.removeClass("m-login--signin"),
                e.removeClass("m-login--signup"),
                e.addClass("m-login--forget-password"),
                e.find(".m-login__forget-password").animateClass("flipInX animated")
        },
        n = function() {
            $("#m_login_forget_password").click(function(e) {
                e.preventDefault(),
                    r()
            }),
                $("#m_login_forget_password_cancel").click(function(e) {
                    e.preventDefault(),
                        t()
                }),
                $("#m_login_signup_cancel").click(function(e) {
                    e.preventDefault(),
                        t()
                })
        }
    return {
        init: function() {
            n()
        }
    }
} ();
jQuery(document).ready(function() {
    SnippetLogin.init()
});
/*接口路径*/
var host = window.location.host;
var contextPath = 'http://' + host;

/*扩展方法*/
var tools = {};
tools["_isMobile"] = function(value){
    var length = value.length;

    //中国移动
    var cm = /(^1(3[4-9]|4[7]|5[0-27-9]|7[8]|8[2-478])\d{8}$)|(^1705\d{7}$)/;

    //中国联通
    var cu = /(^1(3[0-2]|4[5]|5[56]|7[6]|8[56])\d{8}$)|(^1709\d{7}$)/;

    //中国电信
    var ct = /(^1(33|53|77|8[019])\d{8}$)|(^1700\d{7}$)/;
    return (length == 11 && (cm.test(value) || cu.test(value) || ct.test(value)))
}
$.validator.addMethod("isMobile", function(value, element) {
    return (this.optional(element) || tools._isMobile(value));
});

