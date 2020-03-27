/**
 * 
 */
function login(){
	var page='/demoForLinux/login';
	var data={"action":"login","userName":$("#userName").val(),"password":$("#password").val()};
	$.ajax({
		type:"post",
		url:page,
		data:data,
		success:loginSuccess
	});
}
function loginSuccess(result){
	console.log(result);
	window.location="/"
//	var data=$.parseJSON(result);
//	console.log(data.returnValue)
//	if(data.returnValue==1){
//		alert('正确');	
//	}
//	if(data.returnValue==2){
//		alert('没有用户名');
//	}
//	if(data.returnValue==3){
//		alert('有用户名，但密码错误');
//	}
}
function jumpToRegister(){
	window.location="/demoForLinux/html/register.html"
}