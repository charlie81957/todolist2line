$(document).on("click", "#btnSearch", function(){
    $.ajax({
        url: "/test/search",
        type: "post",
        data: $("#searchForm").serialize()
    }).done(function(data){
        $("tbody").empty();
        if(data == ""){
            $("#msg").html("入力されたユーザは存在しません");
            $("#msg").show();
            return false;
        }else{
            $("#msg").hide();
            $.each(data, function(index, value){
                $('tbody').append('<tr><td>' + value.userId + '</td><td>' + value.password + '</td></tr>');
            })
        }
    });
});