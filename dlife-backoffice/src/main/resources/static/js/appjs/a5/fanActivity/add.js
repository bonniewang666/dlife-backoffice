$().ready(function() {
    validateRule4FanActivity();
});

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});




$("#submitBtn").click(function () {
    if($("#fanActivityForm").valid()){
        $.ajax({
            cache : true,
            type : "POST",
            url :"/a5/fanActivity/save",
            data : $('#fanActivityForm').serialize(),
            async : false,
            error : function(request) {
                laryer.alert("Connection error");
            },
            success : function(data) {
                if (data.code == 0) {
                    parent.layer.msg("更新成功");
                    parent.reLoad();
                    var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
                    parent.layer.close(index);
                } else {
                    parent.layer.alert(data.msg)
                }
            }
        });
    }
});

function validateRule4FanActivity() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#fanActivityForm").validate({
		rules : {
            wechatUserId : {
				required : true
			},
            activitiyTile : {
                required : true
            },
            activitiyAddre:{
                required : true
            },
            descrption:{
                required : true
            },
            deadline:{
                required : true
            },
            salerUrl:{
                url : true
            }
        },
		messages : {
            wechatUserId : {
				required : icon + "请输入创建的微信ID"
			},
            activitiyAddre : {
                required : icon + "请输入活动地址"
            }
		}
	})
}