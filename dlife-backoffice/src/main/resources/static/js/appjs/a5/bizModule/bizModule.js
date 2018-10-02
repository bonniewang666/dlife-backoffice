var prefix = "/a5/bizModule"
$(function () {
    loadActivities();

    $("#companySelect").chosen().change(function () {
        var companyCode = $("#companySelect").val();
        loadModules(companyCode);
        reLoad();
    });


    $("#bizCategory").chosen({
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

            $('#bizCategory').on('change', function(e, params) {
                console.log(params.selected);
                var opt = {
                    query : {
                        company : $('#companySelect').val(),
                        bizCategory : params.selected
                    }
                }
                $('#exampleTable').bootstrapTable('refresh', opt);
            });


        }
    });
}

function load() {
    $('#exampleTable')
        .bootstrapTable(
            {
                method: 'get', // 服务器数据的请求方式 get or post
                url: prefix + "/list", // 服务器数据的加载地址
                //	showRefresh : true,
                //	showToggle : true,
                //	showColumns : true,
                iconSize: 'outline',
                toolbar: '#exampleToolbar',
                striped: true, // 设置为true会有隔行变色效果
                dataType: "json", // 服务器返回的数据类型
                pagination: true, // 设置为true会在底部显示分页条
                // queryParamsType : "limit",
                // //设置为limit则会发送符合RESTFull格式的参数
                singleSelect: false, // 设置为true将禁止多选
                // contentType : "application/x-www-form-urlencoded",
                // //发送到服务器的数据编码类型
                pageSize: 10, // 如果设置了分页，每页数据条数
                pageNumber: 1, // 如果设置了分布，首页页码
                //search : true, // 是否显示搜索框
                showColumns: false, // 是否显示内容下拉框（选择显示的列）
                sidePagination: "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
                queryParams: function (params) {
                    return {
                        //说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
                        limit: params.limit,
                        offset: params.offset,
                        bizCategory:$('#bizCategory').val(),
                        company:$('#companySelect').val()
                        // username:$('#searchName').val()
                    };
                },
                // //请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
                // queryParamsType = 'limit' ,返回参数必须包含
                // limit, offset, search, sort, order 否则, 需要包含:
                // pageSize, pageNumber, searchText, sortName,
                // sortOrder.
                // 返回false将会终止请求
                columns: [
                    {
                        checkbox: true
                    },
                    {
                        field: 'id',
                        title: '主键'
                    },
                    {
                        field: 'company',
                        title: '所属公司'
                    },
                    {
                        field: 'bizCategory',
                        title: '业务板块'
                    },
                    {
                        field: 'objectType',
                        title: '关联的业务对象类型'
                    },
                    {
                        field: 'objectId',
                        title: '关联的对象ID'
                    },
                    {
                        field: 'createUserId',
                        title: '创建人ID'
                    },
                    {
                        field: 'createDate',
                        title: '创建时间'
                    },
                    {
                        field: 'updateUserId',
                        title: '修改人ID'
                    },
                    {
                        field: 'updateDate',
                        title: '修改日期'
                    },
                    {
                        title: '操作',
                        field: 'id',
                        align: 'center',
                        formatter: function (value, row, index) {
                            var e = '<a class="btn btn-primary btn-sm ' + s_edit_h + '" href="#" mce_href="#" title="编辑" onclick="edit(\''
                                + row.id
                                + '\')"><i class="fa fa-edit"></i></a> ';
                            var d = '<a class="btn btn-warning btn-sm ' + s_remove_h + '" href="#" title="删除"  mce_href="#" onclick="remove(\''
                                + row.id
                                + '\')"><i class="fa fa-remove"></i></a> ';
                            var f = '<a class="btn btn-success btn-sm" href="#" title="备用"  mce_href="#" onclick="resetPwd(\''
                                + row.id
                                + '\')"><i class="fa fa-key"></i></a> ';
                            return e + d;
                        }
                    }]
            });

}

function reLoad() {
    // alert("hello");
    $('#exampleTable').bootstrapTable('refresh');
}

function add() {
    layer.open({
        type: 2,
        title: '增加',
        maxmin: true,
        shadeClose: false, // 点击遮罩关闭层
        area: ['800px', '520px'],
        content: prefix + '/add' // iframe的url
    });
}

function edit(id) {
    layer.open({
        type: 2,
        title: '编辑',
        maxmin: true,
        shadeClose: false, // 点击遮罩关闭层
        area: ['800px', '520px'],
        content: prefix + '/edit/' + id // iframe的url
    });
}

function remove(id) {
    layer.confirm('确定要删除选中的记录？', {
        btn: ['确定', '取消']
    }, function () {
        $.ajax({
            url: prefix + "/remove",
            type: "post",
            data: {
                'id': id
            },
            success: function (r) {
                if (r.code == 0) {
                    layer.msg(r.msg);
                    reLoad();
                } else {
                    layer.msg(r.msg);
                }
            }
        });
    })
}

function resetPwd(id) {
}

function batchRemove() {
    var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
    if (rows.length == 0) {
        layer.msg("请选择要删除的数据");
        return;
    }
    layer.confirm("确认要删除选中的'" + rows.length + "'条数据吗?", {
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
                "ids": ids
            },
            url: prefix + '/batchRemove',
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


function loadActivities() {
    $('#exampleTable')
        .bootstrapTable(
            {
                method: 'get', // 服务器数据的请求方式 get or post
                url: prefix + "/listActivities", // 服务器数据的加载地址
                //	showRefresh : true,
                //	showToggle : true,
                //	showColumns : true,
                iconSize: 'outline',
                toolbar: '#exampleToolbar',
                striped: true, // 设置为true会有隔行变色效果
                dataType: "json", // 服务器返回的数据类型
                pagination: true, // 设置为true会在底部显示分页条
                // queryParamsType : "limit",
                // //设置为limit则会发送符合RESTFull格式的参数
                singleSelect: false, // 设置为true将禁止多选
                // contentType : "application/x-www-form-urlencoded",
                // //发送到服务器的数据编码类型
                pageSize: 10, // 如果设置了分页，每页数据条数
                pageNumber: 1, // 如果设置了分布，首页页码
                //search : true, // 是否显示搜索框
                showColumns: false, // 是否显示内容下拉框（选择显示的列）
                sidePagination: "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
                queryParams: function (params) {
                    return {
                        //说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
                        limit: params.limit,
                        offset: params.offset,
                        bizCategory:$('#bizCategory').val(),
                        company:$('#companySelect').val()
                        // username:$('#searchName').val()
                    };
                },
                onLoadSuccess: function(data){
                    $('.J_menuItem').on('click', menuItem);
                },
                // //请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
                // queryParamsType = 'limit' ,返回参数必须包含
                // limit, offset, search, sort, order 否则, 需要包含:
                // pageSize, pageNumber, searchText, sortName,
                // sortOrder.
                // 返回false将会终止请求
                columns: [
                    {
                        checkbox: true
                    },
                    {
                        field: 'id',
                        title: '主键'
                    },
                    {
                        field: 'company',
                        title: '所属公司'
                    },
                    {
                        field: 'bizCategory',
                        title: '业务板块'
                    },
                    {
                        field: 'objectTitle',
                        title: '标题',
                        formatter: function (value, row, index) {
                            if (value != '' && value != null) {
                                if (row.objectType == 'FIT')
                                // 小目标
                                    return '<a class="J_menuItem" data-index="'+row.objectId+'" href="/a5/fitnessActivity/detail/' + row.objectId + '">' + value + '</a>';
                                else if (row.objectType == 'POINT_PRODUCT')
                                // 积分商城
                                    return '<a class="J_menuItem" data-index="'+row.objectId+'" href="/a5/fitnessActivity/detail/' + row.objectId + '">' + value + '</a>';
                                else if (row.objectType == 'FAQS')
                                // 小问答
                                    return '<a class="J_menuItem" data-index="'+row.objectId+'" href="/a5/question/detail/' + row.objectId + '">' + value + '</a>';
                                else if (row.objectType == 'PIN')
                                // 小邀约
                                    return '<a class="J_menuItem" data-index="'+row.objectId+'" href="/a5/fanActivity/detail/' + row.objectId + '">' + value + '</a>';
                            } else
                                return value;

                        }
                    },
                    // {
                    //     field: 'avatar',
                    //     title: '头像',
                    //     formatter: function (value, row, index) {
                    //         return '<img src="' + value + '"/>';
                    //     }
                    // },

                    {
                        field: 'objectType',
                        title: '关联的业务对象类型'
                    },
                    // {
                    //     field: 'objectId',
                    //     title: '关联的对象ID',
                    //     formatter: function (value, row, index) {
                    //         if (value != '' && value != null) {
                    //             if (row.objectType == 'FIT')
                    //             // 小目标
                    //                 return '<a href="/a5/fitnessActivity/detail/' + row.objectId + '">' + value + '</a>';
                    //             else if (row.objectType == 'POINT_PRODUCT')
                    //             // 积分商城
                    //                 return '<a href="/a5/fitnessActivity/detail/' + row.objectId + '">' + value + '</a>';
                    //             else if (row.objectType == 'FAQS')
                    //             // 小问答
                    //                 return '<a href="/a5/question/detail/' + row.objectId + '">' + value + '</a>';
                    //             else if (row.objectType == 'PIN')
                    //             // 小邀约
                    //                 return '<a href="/a5/fanActivity/detail/' + row.objectId + '">' + value + '</a>';
                    //         } else
                    //             return value;
                    //
                    //
                    //     }
                    // },
                    {
                        field: 'nickName',
                        title: '昵称',
                        formatter: function (value, row, index) {
                            return '<a class="J_menuItem" data-index="'+row.createUserId+'" href="/a5/wechatUser/detail/' + row.createUserId + '">' + value + '</a>';
                        }
                    },
                    // {
                    //     field: 'createUserId',
                    //     title: '创建人ID'
                    // },
                    {
                        field: 'createDate',
                        title: '创建时间'
                    },

                    // {
                    //     field: 'updateUserId',
                    //     title: '修改人ID'
                    // },
                    {
                        field: 'updateDate',
                        title: '最后修改日期'
                    },
                    {
                        title: '操作',
                        field: 'id',
                        align: 'center',
                        formatter: function (value, row, index) {
                            var e = '<a class="btn btn-primary btn-sm ' + s_edit_h + '" href="#" mce_href="#" title="编辑" onclick="edit(\''
                                + row.id
                                + '\')"><i class="fa fa-edit"></i></a> ';
                            var d = '<a class="btn btn-warning btn-sm ' + s_remove_h + '" href="#" title="删除"  mce_href="#" onclick="remove(\''
                                + row.id
                                + '\')"><i class="fa fa-remove"></i></a> ';
                            var f = '<a class="btn btn-success btn-sm" href="#" title="备用"  mce_href="#" onclick="resetPwd(\''
                                + row.id
                                + '\')"><i class="fa fa-key"></i></a> ';
                            return e + d;
                        }
                    }]
            });



}
