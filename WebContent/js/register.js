// 校验两次密码是否一致
//form.verify({
//    confirmPass:function(value){
//        if($('input[name=password]').val() !== value)
//            return '两次密码输入不一致！';
//    }
//});
var result="";
function passIsValid(){
	var pass=$('input[name=password]').val();
	if(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[^]{8,16}$/.test(pass)){
		$("#isvalid").html("<i class=\"layui-icon layui-icon-ok-circle layui-bg-green\"></i>");
	}else{
		$("#isvalid").html("<i class=\"layui-icon layui-icon-close layui-bg-red\"></i>")
	}
	
}
function confirmPass(){
	var value= $('input[name=secondPassword]').val();
	if($('input[name=password]').val() !== value){
		result="两次密码不一致";
		$("#confirmPass").html("<i class=\"layui-icon layui-icon-close layui-bg-red\"></i>");
	}else{
		result="两次密码一致";
		$("#confirmPass").html("<i class=\"layui-icon layui-icon-ok-circle layui-bg-green\"></i>");
	}
    //console.log(result);    
}