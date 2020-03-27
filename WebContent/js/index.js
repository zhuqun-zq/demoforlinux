/**
 * 
 */
$(document).ready(function() {
	layui.use('element', function() {
		var element = layui.element;

	});
	var data={"action":"init"};
	$.ajax({
		type:"get",
		data:data,
		url:'/demoForLinux/html/index',
		success:initSuccess
	});
});

function initSuccess(result){
	console.log(result);
	var html="";
	for(var key in result){
		html += "<h1 id=\'"+key+"\'><a onclick=\'queryArticleById(this)\'>"+result[key]+"</a></h1>";
	}
	$(".layui-body div").append(html);
}
function queryArticleById(param){
	var id = $(param).parent().attr("id");
	console.log(id);
	var data={"id":id,"action":"queryArticleById"};
	$.ajax({
		type:"get",
		url:'/demoForLinux/html/index',
		data:data,
		success:queryArticleByIdSuccess
	});
}
function queryArticleByIdSuccess(result){
	console.log(result);
	$(".layui-body div").html("");
	$(".layui-body div").append("<h1>"+result.articleTitle+"</h1>");
	$(".layui-body div").append("<p>"+result.articleContent+"</p>");
}
function quickSql(){
	$(".layui-body div").html("");
	var html="<span>域名:</span><input id=\'dominName\' type=\'text\' />";
	html += "<span>退供单:</span><input id=\'order\' type=\'text\' />";
	html +="<input id=\'order\' type=\'button\' value='\生成'\ onclick='\generateSql()'\/>";
	html +="<br><span>sql语句:</span><input id=\'order\' type=\'textarea\' />";
	$(".layui-body div").append(html);
}
function generateSql(){
	
}