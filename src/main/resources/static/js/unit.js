/**
 * Create by wjr
 * in 9/16/2018
 * wangjiaruo22@hotmail.com
 * description :
 *  this page is used to save PUBLIC javascript function.
 *  
 */

/**
 * test
 */
function test() {
    alert("test");
}

/**
 * load editor
 * require textarea id = editor
 */
function loadEditor(){
    CKEDITOR.replace( 'editor',
        {
            toolbar :
                [
                    //加粗     斜体，     下划线      穿过线      下标字        上标字
                    ['Bold','Italic','Underline','Strike','Subscript','Superscript'],
                    // 数字列表          实体列表            减小缩进    增大缩进
                    ['NumberedList','BulletedList','-','Outdent','Indent'],
                    //左对 齐             居中对齐          右对齐          两端对齐
                    ['JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock'],
                    //超链接  取消超链接 锚点
                    ['Link','Unlink','Anchor'],
                    //图片    flash    表格       水平线            表情       特殊字符        分页符
                    ['Image','Flash','Table','HorizontalRule','Smiley','SpecialChar','PageBreak'],
                    '/',
                    // 样式       格式      字体    字体大小
                    ['Styles','Format','Font','FontSize'],
                    //文本颜色     背景颜色
                    ['TextColor','BGColor'],
                    //全屏           显示区块
                    ['Maximize', 'ShowBlocks','-']
                ]

        }
    );
}

/*
    
    forbidden goback 

    $(document).ready(function (e) {
        var counter = 0;
        if (window.history && window.history.pushState) {
            $(window).on('popstate', function () {
                window.history.pushState('forward', null, '#');
                window.history.forward(1);
                // alert("不可回退");  //如果需在弹框就有它
                self.location="orderinfo.html"; //如查需要跳转页面就用它
            });
        }
 
        window.history.pushState('forward', null, '#'); //在IE中必须得有这两行
        window.history.forward(1);
    });
*/