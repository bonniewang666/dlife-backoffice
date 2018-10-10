$().ready(function() {
    $('.summernote').summernote({
        height : '220px',
        lang : 'zh-CN',
        callbacks: {
            onImageUpload: function(files, editor, $editable) {
                console.log("onImageUpload");
                sendFile(files);
            }
        }
    });
    var descrption = $("#descrption").val();
    $('#descrption_sn').summernote('code', descrption);
    validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
function save() {
    var descrption_sn = $("#descrption_sn").summernote('code');
    $("#descrption").val(descrption_sn);

	$.ajax({
		cache : true,
		type : "POST",
		url : "/a5/fitnessActivity/save",
		data : $('#signupForm').serialize(),// 你的formid
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg("操作成功");
				parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);

			} else {
				parent.layer.alert(data.msg)
			}

		}
	});

}
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
			name : {
				required : true
			}
		},
		messages : {
			name : {
				required : icon + "请输入姓名"
			}
		}
	})
}