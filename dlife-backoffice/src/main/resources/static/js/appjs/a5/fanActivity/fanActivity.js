var prefix = "/a5/fanActivity"
$(function () {
    load();
});

function load() {
    $('#exampleTable')
        .bootstrapTable(
            {
                method: 'get', // 服务器数据的请求方式 get or post
                url: prefix + "/list", // 服务器数据的加载地址
                showRefresh: true,
                showToggle: true,
                showColumns: true,
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
                showColumns: true, // 是否显示内容下拉框（选择显示的列）
                sidePagination: "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
                queryParams: function (params) {
                    return {
                        //说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
                        limit: params.limit,
                        offset: params.offset,
                        activitiyTile: $('#searchTitle').val(),
                        wechatUserId: $('#searchAuthorId').val(),
                        id:$('#searchId').val()
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
                        title: 'ID'
                    },
                    {
                        field: 'activitiyTile',
                        title: '活动名称',
                        formatter: function (value, row, index) {
                            return '<a href="/a5/fanActivity/detail/' + row.id + '">' + value + '</a>';
                        }
                    },
                    {
                        field: 'wechatUserId',
                        title: '发布者id'
                    },
                    // {
                    //     field: 'avatar',
                    //     title: '头像',
                    //     formatter: function (value, row, index) {
                    //         return '<img src="' + value + '"/>';
                    //     }
                    // },
                    {
                        field: 'nickName',
                        title: '昵称',
                        formatter: function (value, row, index) {
                            return '<a href="/a5/wechatUser/detail/' + row.wechatUserId + '">' + value + '</a>';
                        }
                    },
                    {
                        field: 'activitiyType',
                        title: '活动类型'
                    },

                    {
                        field: 'budget',
                        title: '人均预算'
                    },
                    // {
                    //     field: 'activitiyAddre',
                    //     title: '活动地址'
                    // },
                    // {
                    //     field: 'descrption',
                    //     title: '活动描述'
                    // },
                    // 								{
                    // 	field : 'organizeUser',
                    // 	title : '组织者'
                    // },
                    // 								{
                    // 	field : 'coverPicture',
                    // 	title : '封面图'
                    // },
                    // 								{
                    // 	field : 'appointDatetime',
                    // 	title : '约定时间'
                    // },
                    // 								{
                    // 	field : 'appointEndDatetime',
                    // 	title : '约定结束时间'
                    // },
                    // 								{
                    // 	field : 'salerUrl',
                    // 	title : '商家URL'
                    // },
                    // 								{
                    // 	field : 'lowerLimit',
                    // 	title : '最少参与者'
                    // },
                    // 								{
                    // 	field : 'upperLimit',
                    // 	title : '最多参与者'
                    // },
                    // 								{
                    // 	field : 'payType',
                    // 	title : '支付类型'
                    // },
                    // 								{
                    // 	field : 'deadline',
                    // 	title : '截至日期'
                    // },
                    // {
                    //     field: 'jhiComment',
                    //     title: '备注'
                    // },
                    {
                        field: 'status',
                        // title: '活动状态<br>0-新建 <br>1-完成 <br>2-取消'
                        title: '活动状态'
                    },
                    {
                        field: 'commentCount',
                        title: '评论数量'
                    },
                    {
                        field: 'readingCount',
                        title: '浏览次数'
                    },
                    // 								{
                    // 	field : 'modifyTime',
                    // 	title : ''
                    // },
                    // 								{
                    // 	field : 'joinStatus',
                    // 	title : ''
                    // },
                    // 								{
                    // 	field : 'official',
                    // 	title : ''
                    // },
                    // 								{
                    // 	field : 'stick',
                    // 	title : ''
                    // },
                    // 								{
                    // 	field : 'stickOrder',
                    // 	title : ''
                    // },
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


function loadAttendee() {
    var prefix = "/a5/attendee";
    $('#attendeeTable').bootstrapTable('refresh');
    $('#attendeeTable')
        .bootstrapTable(
            {
                method : 'get', // 服务器数据的请求方式 get or post
                url : prefix + "/list", // 服务器数据的加载地址
                //	showRefresh : true,
                //	showToggle : true,
                //	showColumns : true,
                iconSize : 'outline',
                toolbar : '#exampleToolbar',
                striped : true, // 设置为true会有隔行变色效果
                dataType : "json", // 服务器返回的数据类型
                pagination : true, // 设置为true会在底部显示分页条
                // queryParamsType : "limit",
                // //设置为limit则会发送符合RESTFull格式的参数
                singleSelect : false, // 设置为true将禁止多选
                // contentType : "application/x-www-form-urlencoded",
                // //发送到服务器的数据编码类型
                pageSize : 10, // 如果设置了分页，每页数据条数
                pageNumber : 1, // 如果设置了分布，首页页码
                //search : true, // 是否显示搜索框
                showColumns : false, // 是否显示内容下拉框（选择显示的列）
                sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
                queryParams : function(params) {
                    return {
                        //说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
                        limit: params.limit,
                        offset:params.offset,
                        pinFanActivityId: $('#id').val()
                    };
                },
                // //请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
                // queryParamsType = 'limit' ,返回参数必须包含
                // limit, offset, search, sort, order 否则, 需要包含:
                // pageSize, pageNumber, searchText, sortName,
                // sortOrder.
                // 返回false将会终止请求
                columns : [
                    {
                        checkbox : true
                    },
                    {
                        field : 'id',
                        title : '编号'
                    },
                    {
                        field : 'wechatUserId',
                        title : '微信编号'
                    },
                    {
                        field: 'avatar',
                        title: '头像',
                        formatter: function (value, row, index) {
                            return '<a href="/a5/wechatUser/detail/' + row.wechatUserId + '">' + '<img src="' + value + '" /></a>';
                        }
                    },
                    {
                        field: 'nickName',
                        title: '昵称',
                        formatter: function (value, row, index) {
                            return '<a href="/a5/wechatUser/detail/' + row.wechatUserId + '">' + value + '</a>';
                        }
                    },
                    {
                        field : 'participationTime',
                        title : '加入时间'
                    },
                    {
                        field : 'activitiyTile',
                        title : '活动类型'
                    },
                    // {
                    //     field : 'pinFanActivityId',
                    //     title : '活动编号'
                    // },
                    {
                        title : '操作',
                        field : 'id',
                        align : 'center',
                        formatter : function(value, row, index) {
                            var e = '';
                            var d = '<a class="btn btn-warning btn-sm '+s_remove_h+'" href="#" title="删除"  mce_href="#" onclick="remove(\''
                                + row.id
                                + '\')"><i class="fa fa-remove"></i></a> ';
                            var f = '<a class="btn btn-success btn-sm" href="#" title="备用"  mce_href="#" onclick="resetPwd(\''
                                + row.id
                                + '\')"><i class="fa fa-key"></i></a> ';
                            return e + d ;
                        }
                    } ]
            });
}