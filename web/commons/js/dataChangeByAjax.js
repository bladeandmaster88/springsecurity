//ajax数据交换的方法
function dataChangeByAjax(data,url){
	var forword;
	$.ajax({
		async : false,
		cache : false,
		type : 'POST',
		dataType : "json",
        traditional:true,		
		data :data,
		url : url, // 请求的action路径
		error : function(e) {// 请求失败处理函数
			alert("请求服务器失败",e);
		},
		success : function(forward) { // 请求成功后处理函数。
			forword=forward;
		}
	});
	return forword;
}
//contentType:"application/json;charset=utf-8",