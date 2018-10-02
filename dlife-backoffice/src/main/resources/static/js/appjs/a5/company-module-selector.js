function loadModules(companyCode) {
    var html = "<option value=\"\">--选择业务板块--</option>";
    $.ajax({
        url : '/a5/bizModule/modules/' + companyCode,
        success : function(data) {
            //加载数据
            for (var i = 0; i < data.length; i++) {
                // alert(data[i].value);
                html += '<option value="' + data[i].value + '">' + data[i].name + '</option>'
            }

            $("#bizCategory").empty();
            /* 添加新select选项（省略） */
            $("#bizCategory").append(html);
            $("#bizCategory").trigger("chosen:updated");

            $("#bizCategory").chosen({
                maxHeight : 200
            });

            $("#bizCategory").chosen().change(function () {
                reLoad();
            });

            // $('#bizCategory').on('change', function(e, params) {
            //     console.log(params.selected);
            //     var opt = {
            //         query : {
            //             company : $('#companySelect').val(),
            //             bizCategory : params.selected
            //         }
            //     }
            //     $('#exampleTable').bootstrapTable('refresh', opt);
            // });


        }
    });
}


function loadBizCategory(){
    var html = "<option value=\"\">--选择业务板块--</option>";
    $.ajax({
        url : '/a5/bizModule/modules/' + $("#targetCompany").val(),
        success : function(data) {
            //加载数据
            for (var i = 0; i < data.length; i++) {
                // alert(data[i].value);
                html += '<option value="' + data[i].value + '">' + data[i].name + '</option>'
            }

            $("#targetBizCategory").empty();
            /* 添加新select选项（省略） */
            $("#targetBizCategory").append(html);
            $("#targetBizCategory").trigger("chosen:updated");

            $("#targetBizCategory").chosen({
                maxHeight : 200
            });
        }
    });
}