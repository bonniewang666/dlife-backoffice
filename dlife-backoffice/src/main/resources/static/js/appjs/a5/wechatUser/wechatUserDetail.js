// var prefix = "/sys/user"
$(function () {
    // laydate({
    //     elem : '#birth'
    // });
});
/**
 * 基本信息提交
 */
$("#base_save").click(function () {
    var hobbyStr = getHobbyStr();
    $("#hobby").val(hobbyStr);
    if ($("#basicInfoForm").valid()) {
        $.ajax({
            cache: true,
            type: "POST",
            url: "/sys/user/updatePeronal",
            data: $('#basicInfoForm').serialize(),
            async: false,
            error: function (request) {
                laryer.alert("Connection error");
            },
            success: function (data) {
                if (data.code == 0) {
                    parent.layer.msg("更新成功");
                } else {
                    parent.layer.alert(data.msg)
                }
            }
        });
    }

});
$("#pwd_save").click(function () {
    if ($("#modifyPwd").valid()) {
        $.ajax({
            cache: true,
            type: "POST",
            url: "/sys/user/resetPwd",
            data: $('#modifyPwd').serialize(),
            async: false,
            error: function (request) {
                parent.laryer.alert("Connection error");
            },
            success: function (data) {
                if (data.code == 0) {
                    parent.layer.alert("更新密码成功");
                    $("#photo_info").click();
                } else {
                    parent.layer.alert(data.msg)
                }
            }
        });
    }
});

function getHobbyStr() {
    var hobbyStr = "";
    $(".hobby").each(function () {
        if ($(this).is(":checked")) {
            hobbyStr += $(this).val() + ";";
        }
    });
    return hobbyStr;
}


function loadQuestions() {
    var prefix = "/a5/question"
    $('#questionsTable').bootstrapTable('refresh');
    $('#questionsTable')
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
                        wechatUserId: $('#id').val()
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
                        title: '问题编号',
                        formatter: function (value, row, index) {
                            return '<a href="' + prefix + '/detail/' + row.id + '">' + value + '</a>';
                        }
                    },
                    {
                        field: 'title',
                        title: '问题标题',
                        formatter: function (value, row, index) {
                            return '<a href="' + prefix + '/detail/' + row.id + '">' + value + '</a>';
                        }
                    },
                    // {
                    //     field: 'wechatUserId',
                    //     title: '微信用户ID'
                    // },
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
                        field: 'createTime',
                        title: '创建时间'
                    },
                    // {
                    //     field: 'description',
                    //     title: '详细描述'
                    // },
                    {
                        field: 'answerCount',
                        title: '回复数'
                    },
                    {
                        field: 'readingCount',
                        title: '浏览次数'
                    },


                    // {
                    //     field: 'replyCount',
                    //     title: '回复次数'
                    // },
                    {
                        field: 'thumbsupCount',
                        title: '获赞数'
                    },
                    {
                        field: 'modifyTime',
                        title: '修改时间'
                    }]
            });
}

function loadFanActivity() {
    var prefix = "/a5/fanActivity";
    $('#xiaoyaoyueTable').bootstrapTable('refresh');
    $('#xiaoyaoyueTable')
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
                        wechatUserId: $('#id').val()
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
                    // {
                    //     field: 'wechatUserId',
                    //     title: '发布者id'
                    // },
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
                    								{
                    	field : 'modifyTime',
                    	title : '最后修改时间'
                    }]
            });
}


function loadFitnessActivity() {
    var prefix = "/a5/fitnessActivity";
    $('#xiaomubiaoTable').bootstrapTable('refresh');
    $('#xiaomubiaoTable')
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
                        wechatUserId: $('#id').val()
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
                    // {
                    //     field: 'wechatUserId',
                    //     title: '用户id 创建人'
                    // },
                    // {
                    //     field: 'avatar',
                    //     title: '头像',
                    //     formatter:function (value,row,index) {
                    //         return '<img src="'+value+'"/>';
                    //     }
                    // },

                    {
                        field: 'nickName',
                        title: '昵称',
                        formatter: function (value, row, index) {
                            return '<a href="/a5/wechatUser/detail/' + row.wechatUserId + '">' + value + '</a>';
                        }
                    },

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
                        field: 'modifyTime',
                        title: '修改时间'
                    },
                    {
                        field: 'readingCount',
                        title: '浏览次数'
                    }]
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
                        wechatUserId: $('#id').val()
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
                                return '<a href="/a5/comment/detail/' + row.id + '">' + value + '</a>';
                            else
                                return value;
                        }
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
                        field: 'objectId',
                        title: '关联对象编号',
                        formatter: function (value, row, index) {
                            if( value != '' && value != null ) {
                                if(row.channel == 'FIT')
                                // 小目标
                                    return '<a href="/a5/fitnessActivity/detail/' + row.objectId + '">' + value + '</a>';
                                else if(row.channel == 'POINT_PRODUCT')
                                // 积分商城
                                    return '<a href="/a5/fitnessActivity/detail/' + row.objectId + '">' + value + '</a>';
                                else if(row.channel == 'FAQS')
                                // 小问答
                                    return '<a href="/a5/question/detail/' + row.objectId + '">' + value + '</a>';
                                else if(row.channel == 'PIN')
                                // 小邀约
                                    return '<a href="/a5/fanActivity/detail/' + row.objectId + '">' + value + '</a>';
                            } else
                                return value;
                        }
                    },
                    {
                        field: 'channel',
                        title: '类型'
                    },
                    {
                        field: 'content',
                        title: '内容'
                    },
                    {
                        field: 'wechatUserId',
                        title: '微信用户编号'
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