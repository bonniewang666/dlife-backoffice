$().ready(function() {
    $("#targetCompany").chosen({
        maxHeight : 200
    });
    $("#targetBizCategory").chosen({
        maxHeight : 200
    });
});

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


function batchMove(prefix){
    var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
    if (rows.length == 0) {
        layer.msg("请选择要修改的数据");
        return;
    }
    layer.confirm("确认要修改选中的'" + rows.length + "'条数据吗?", {
        btn: ['确定', '取消']
        // 按钮
    }, function () {
        var ids = new Array();
        // 遍历所有选择的行数据，取每条数据对应的ID
        $.each(rows, function (i, row) {
            ids[i] = row['id'];
        });
        $.ajax({
            type: 'POST',
            data: {
                "targetCompany": $("#targetCompany").val(),
                "targetBizCategory": $("#targetBizCategory").val(),
                "ids": ids
            },
            url: prefix + '/batchMove',
            success: function (r) {
                if (r.code == 0) {
                    layer.msg(r.msg);
                    reLoad();
                } else {
                    layer.msg(r.msg);
                }
            }
        });
    }, function () {

    });
}