$(document).ready(function () {
    // menu click initialize
    //console.log('this is in ready function');
    $('#auditLink').click(auditInit());
    $('#postLink').click();
    $('#article-generality').click();
    //$.ajax({
    //    url: "/getArticles.do?method=status",
    //    type: 'get',
    //    dataType: 'json',
    //    success: function(data){
    //        console.log(data);
    //        //var parsedData = JSON.parse(data);
    //        $('#auditsTable').html(data);
    //    }
    //})
});

function auditInit() {
    console.log("this is in audit initialize function");
    var tableBody = $.ajax({
        url: '/audit',
        success: function (data) {
            //console.log(data);
            //console.log($(data).find('body'));
            if(data){
                //var html = $(data).find('body');
                console.log(true);
                $('#audits').html(data);
                $('#audits').css('display','block');
            }
        }
    });
    console.log(tableBody);
    //$('#auditContent').html(tableBody.responseText);
    auditListener();
}
function auditListener() {

    // first page
    if(currentPage == 1){
        //disabled firstPage
        $('.firstPage').attr('disabled','true');
    }else{
        $('.firstPage').removeAttr('disabled');
    }

    // last page
    if(currentPage == pageCount){
        //disabled lastPage
        $('.lastPage').attr('disabled','true');
    }else{
        $('.lastPage').removeAttr('disabled');
    }
    $('.firstPage').click(function () {
        var tableBody = $.ajax({url: '/audit'});
        $('#auditsContent').html(tableBody.responseText);
    });
    $('.lastPage').click(function(){
        var tableBody = $.ajax({
            url: '/audit?page=2',
            success: function (data) {
                if(data){
                    var html = $(data).find('body');
                    $('#auditContent').html(html);
                }
            }
        });
    });

}