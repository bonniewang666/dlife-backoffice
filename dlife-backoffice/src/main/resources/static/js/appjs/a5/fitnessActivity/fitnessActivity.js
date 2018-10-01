var prefix = "/a5/fitnessActivity"
$(function () {
    load();
});

function load() {
    $('#exampleTable')
        .bootstrapTable(
            {
                method: 'get', // 服务器数据的请求方式 get or post
                url: prefix + "/list", // 服务器数据的加载地址
                showRefresh : true,
                showToggle : true,
                showColumns : true,
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
                        title: $('#searchTitle').val(),
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
                        title: ''
                    },
                    {
                        field: 'title',
                        title: '活动标题',
                        formatter: function (value, row, index) {
                            return '<a href="/a5/fitnessActivity/detail/' + row.id + '">' + value + '</a>';
                        }
                    },
                    // {
                    //     field: 'descrption',
                    //     title: '活动描述'
                    // },


                    // 								{
                    // 	field : 'project',
                    // 	title : '项目名称'
                    // },
                    // 								{
                    // 	field : 'companyRole',
                    // 	title : '角色'
                    // },
                    // 								{
                    // 	field : 'signStartTime',
                    // 	title : '报名开始时间'
                    // },
                    // 								{
                    // 	field : 'signEndTime',
                    // 	title : '报名截至时间'
                    // },
                    {
                        field: 'activityStartTime',
                        title: '开始时间'
                    },
                    {
                        field: 'activityEndTime',
                        title: '结束时间'
                    },
                    {
                        field: 'commentCount',
                        title: '评论数量'
                    },
                    {
                        field: 'wechatUserId',
                        title: '微信编号'
                    },

                    {
                        field: 'nickName',
                        title: '昵称',
                        formatter: function (value, row, index) {
                            return '<a href="/a5/wechatUser/detail/' + row.wechatUserId + '">' + value + '</a>';
                        }
                    },
                    {
                        field: 'modifyTime',
                        title: '修改时间'
                    },
                    {
                        field: 'readingCount',
                        title: '浏览次数'
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


function loadParticipant() {
    var prefix = "/a5/activityParticipation";
    $('#participantTable').bootstrapTable('refresh');
    $('#participantTable')
        .bootstrapTable(
            {
                method : 'get', // 服务器数据的请求方式 get or post
                url : prefix + "/list", // 服务器数据的加载地址
                // showRefresh : true,
                // showToggle : true,
                // showColumns : true,
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
                        fitnessActivityId: $('#id').val()
                        // name:$('#searchName').val(),
                        // username:$('#searchName').val()
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
                        title : '参加人微信编号'
                    },
                    // {
                    //     field : 'nickName',
                    //     title : '参加人昵称'
                    // },
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
                    // {
                    //     field : 'project',
                    //     title : '所在'
                    // },
                    {
                        field : 'participationTime',
                        title : '参加时间'
                    },
                    {
                        field : 'currentContinueDays',
                        title : '持续时间'
                    },
                    // {
                    //     field : 'fitnessActivityId',
                    //     title : '小目标编号'
                    // },
                    {
                        field : 'latestClockinTime',
                        title : '最后打卡时间'
                    },
                    {
                        field : 'longestContinueDays',
                        title : '最长持续时间'
                    },
                    {
                        field : 'totalClockinDays',
                        title : '总打卡天数'
                    },
                    {
                        field : 'totalParticipateDays',
                        title : '总参与时间'
                    },
                    {
                        title : '操作',
                        field : 'id',
                        align : 'center',
                        formatter : function(value, row, index) {
                            var e = '';
                            var d = '<a class="btn btn-warning btn-sm '+s_remove_h+'" href="#" title="删除"  mce_href="#" onclick="removeParticipant(\''
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


function loadComment() {
    var prefix = "/a5/comment";
    $('#commentTable').bootstrapTable('refresh');
    $('#commentTable')
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
                        channel:'FIT',
                        objectId: $('#id').val()
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
                        title: '回复编号',
                        formatter: function (value, row, index) {
                            if (value != '' && value != null)
                                return '<a href="/a5/comment/parent/' + row.id + '">' + value + '</a>';
                            else
                                return value;
                        }
                    },
                    {
                        field: 'avatar',
                        title: '头像',
                        formatter: function (value, row, index) {
                            return '<img src="' + value + '"/>';
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
                        field: 'content',
                        title: '内容'
                    },

                    {
                        field: 'parentId',
                        title: '父编号',
                        formatter: function (value, row, index) {
                            if (value != '' && value != null)
                                return '<a href="/a5/comment/parent/' +value+ '">' + value + '</a>';
                            else
                                return value;
                        }
                    },

                    {
                        field: 'wechatUserId',
                        title: '微信用户编号'
                    },


                    // {
                    //     field: 'rating1',
                    //     title: ''
                    // },
                    // {
                    //     field: 'rating2',
                    //     title: ''
                    // },
                    // {
                    //     field: 'rating3',
                    //     title: ''
                    // },
                    {
                        field: 'createTime',
                        title: '创建时间'
                    },
                    // {
                    //     field: 'modifyTime',
                    //     title: ''
                    // },
                    {
                        field: 'replyCount',
                        title: '回复数'
                    },
                    // {
                    //     field: 'rpAvatar',
                    //     title: ''
                    // },
                    // {
                    //     field: 'rpNickName',
                    //     title: ''
                    // },
                    // {
                    //     field: 'rpWechatUserId',
                    //     title: ''
                    // },
                    {
                        field: 'module',
                        title: ''
                    }]
            });
}


/**
 * Loading 打卡信息for particular 小目标
 * */
function loadClockIn(){
    var prefix = "/a5/clockIn";
    $('#clockinTable').bootstrapTable('refresh');

    $('#clockinTable')
        .bootstrapTable(
            {
                method : 'get', // 服务器数据的请求方式 get or post
                url : prefix + "/list", // 服务器数据的加载地址
                showRefresh: true,
                showToggle: true,
                showColumns: true,
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
                showColumns : true, // 是否显示内容下拉框（选择显示的列）
                sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
                queryParams : function(params) {
                    return {
                        //说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
                        limit: params.limit,
                        offset:params.offset,
                        activityId: $('#id').val()
                        // name:$('#searchName').val(),
                        // username:$('#searchName').val()
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
                        title : '编号',
                        formatter: function (value, row, index) {
                            if (value != '' && value != null)
                                return '<a href="/a5/comment/parent/' + row.id + '">' + value + '</a>';
                            else
                                return value;
                        }
                    },
                    {
                        field: 'wechatUserDO.avatar',
                        title: '头像',
                        formatter: function (value, row, index) {
                            return '<img src="' + value + '"/>';
                        }
                    },
                    {
                        field: 'wechatUserDO.nickName',
                        title: '昵称',
                        formatter: function (value, row, index) {
                            return '<a href="/a5/wechatUser/detail/' + row.wechatUserDO.id + '">' + value + '</a>';
                        }
                    },
                    {
                        field : 'signNote',
                        title : '签到日记'
                    },
                    {
                        field : 'punchDateTime',
                        title : '打卡时间'
                    },
                    {
                        field : 'activityId',
                        title : '活动编号'
                    },

                    {
                        field : 'replyCount',
                        title : '回复数'
                    },
                    {
                        field : 'thumbsUpCount',
                        title : '点赞数'
                    },
                    {
                        title : '操作',
                        field : 'id',
                        align : 'center',
                        formatter : function(value, row, index) {
                            var e = '<a class="btn btn-primary btn-sm '+s_edit_h+'" href="#" mce_href="#" title="编辑" onclick="edit(\''
                                + row.id
                                + '\')"><i class="fa fa-edit"></i></a> ';
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