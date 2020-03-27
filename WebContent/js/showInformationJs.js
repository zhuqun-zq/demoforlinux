/**
 * 
 */
function queryAll(){
	var page='/demoForLinux/hello';
	var data={"action":"queryAll"};
	$.ajax({
		type:"get",
		url:page,
		data:{"action":"value"},
		success:queryAllSuccess
	});
}
function queryAllSuccess(result){
	console.log(result);
	 var data=$.parseJSON(result);
	 console.log(data);
	 var html="";
	 for(var i=0;i<data.length;i++){
		 html+="<li>"+data[i].id+"  "+data[i].name+"</li>";
	 }
	 $("#showInformation").append(html);
}
function addOne(){
	$("#addOnePage").css('display','block'); 
}
function submitData(){
	var page='/demoForLinux/hello';
	var data={"action":"addOne","param":$("#submitValue").val()};
	console.log(data);
	$.ajax({
		type:"post",
		url:page,
		data:data,
		success:addOneSuccess()
	});
}
function addOneSuccess(){
	$("#addOnePage").css('display','none'); 
	$("#showInformation").html("<li>id name</li>");
	queryAll();
}
function deleteSome(){
	var page='http://localhost:8080/demoForLinux/html/showInformation.html';
	var data={"action":"deleteSome"};
	$.ajax({
		url:page,
		data:data,
		success:deleteSomeSuccess()
	});
}
function deleteSomeSuccess(){
	
}
function queryAllByMVC(){
	window.location.href="http://localhost:8080/demoForLinux/hello";
}

