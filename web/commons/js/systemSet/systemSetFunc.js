//初始加载用户和角色信息
$(function(){
	initLoadUserInfo();
	initLoadRoleInfo();	
});

//初始加载用户信息
function initLoadUserInfo(){
	$(".user-table tbody").html("");
	var url="/icss/systemSet/getAllUser";
	var forward=dataChangeByAjax(null,url);
	if(forward.success){
		var userList=forward.list;
		if(userList!=null&&userList.length>0){
			for(var i=0;i<userList.length;i++){
				var option=getAllRoleOption(userList[i].roleName);
				var tr='<tr style="display: table-row;" userId='+userList[i].guid+'>'
					    +'<td title='+userList[i].name+'>'+userList[i].name+'</td>'
					    +'<td title='+userList[i].userCode+'>'+userList[i].userCode+'</td>'
					    +'<td title='+userList[i].createUser+'>'+userList[i].createUser+'</td>'
					    +'<td title='+new Date(userList[i].createTime).format("yyyy-MM-dd hh:mm:ss")+'>'+new Date(userList[i].createTime).format("yyyy-MM-dd hh:mm:ss")+'</td>'
					    +'<td title='+userList[i].updateUser+'>'+userList[i].updateUser+'</td>'
					    +'<td title='+new Date(userList[i].updateTime).format("yyyy-MM-dd hh:mm:ss")+'>'+new Date(userList[i].updateTime).format("yyyy-MM-dd hh:mm:ss")+'</td>'
					    +'<td>'+showStatus(userList[i].status)+'</td>'
					    +'<td><input type="button" class="editbtn" onclick="editUser(this)" value="编辑"> <input type="button" class="delbtn" onclick="delUser(this)" value="账号状态"></td>'
					    +'<td><div class="userRoleSelect"><select>'+option+'</select>'
					    +'<div class="select-cover"><div class="select-value" roleId='+userList[i].roleId+' title='+userList[i].roleName+'>'+userList[i].roleName+'</div><div class="selectButton"></div></div></div></td>'
					    +'</tr>';
				$(".user-table tbody").append(tr);
			}
			bindChangeRoleEvent();
		}	
	}
}

//初始加载角色信息
function initLoadRoleInfo(){
	$(".role-table tbody").html("");
	var url="/icss/systemSet/getAllRole";
	var forward=dataChangeByAjax(null,url);
	if(forward.success){
		var roleList=forward.list;
		if(roleList!=null&&roleList.length>0){
			for(var i=0;i<roleList.length;i++){
				var data={
					roleName:roleList[i].name
				}
				var menuForward=dataChangeByAjax(data,"/icss/systemSet/getMenuByRole");
				var menuStr="";
				if(menuForward.success){
					var menuList=menuForward.list;
					if(menuList!=null&&menuList.length>0){
						menuStr=appendMenuStr(menuList,'name');
					}
				}
				var tr='<tr style="display: table-row;" roleId='+roleList[i].id+'>'
					  +'<td title='+roleList[i].name+'>'+roleList[i].name+'</td>'
					  +'<td title='+menuStr+' menuList='+appendMenuList(menuList)+'>'+menuStr+'</td>'
					  +'<td><input type="button" class="editbtn" onclick="editRole(this)" value="编辑"> <input type="button" class="delbtn" onclick="delRole(this)" value="删除"></td>'
				      +'</tr>';
				$(".role-table tbody").append(tr);
			}
		}
	
	}
}

//新增用户或角色
function add(){
	var option;
	var funcArray=new Array(2);
	var conten;	
	if($(".menu li.current").html()=="角色管理"){//新增角色
		clearAddRoleInfo();
		bindAddRoleEvent();
		option={
			width:"350px",
			title:"新增角色"
		}
		content="addRoleInfo";
		funcArray[1]="saveRoleData";
	}else{//新增用户
		clearAddUserInfo();
		option={
			width:"350px",
			title:"新增用户"
		}
		content="addUser";
		funcArray[1]="saveAddUserData";
	}
	popLayer(option,content,funcArray);
}


//保存新增用户信息
function saveAddUserData(index){
	var data= {
			"username" : $("#username").val().trim(),
			"userCode" : $("#usercode").val().trim(),
			"password" : $("#password").val().trim(),
			"roleId":$("#user-role .select-cover .select-value").attr("roleId")
		};
	var url="/icss/systemSet/addUser";
	var forward=dataChangeByAjax(data,url);
	if (forward.success) {
		layer.close(index);
		layerAutoCloseMsg("新增用户成功",1,1000);
		initLoadUserInfo();
	} else {
		layerAutoCloseMsg("新增用户失败",2,1000);
	}
}


//编辑用户
function editUser(obj) {
	$("#editusername").val($(obj).parent().parent().find("td").eq(0).html());
	$("#editusercode").val($(obj).parent().parent().find("td").eq(1).html());
	$("#editpassword").val("");
	var option={
			width:"350px",
			title:"编辑用户"
	}
	var funcArray=new Array(2);
	var content="editInfo";
	funcArray[1]='saveEditUserData';
	popLayer(option,content,funcArray);
}


//保存编辑用户信息
function saveEditUserData(index){
	var data={
			"username" : $("#editusername").val().trim(),
			"password" : $("#editpassword").val().trim(),
			"usercode" : $("#editusercode").val().trim()
	};
	var url="/icss/systemSet/editUser";
	var forward=dataChangeByAjax(data,url);
	if (forward.success) {
		layer.close(index);
		layerAutoCloseMsg("编辑用户成功",1,1000);
		initLoadUserInfo();
	} else {
		layerAutoCloseMsg("编辑用户失败",2,1000);
	}
}


//更改用户账号状态
function delUser(obj) {
	layui.use('layer', function() {
		var layer = layui.layer;
		var username=$(obj).parent().parent().find("td").eq(0).html();
		var usercode=$(obj).parent().parent().find("td").eq(1).html();
		layer.msg('', {
			time : 20000,
			shade : 0.7,
			btn:['激活','停用','删除','取消'],
			btn1:function(index){
				var data= {
							"userCode" : usercode,
							"status" : "1"
						};
				var url="/icss/systemSet/delUser";
				var forward=dataChangeByAjax(data,url);
				if (forward.success) {
					layer.close(index);
					layerAutoCloseMsg("更新账号状态成功",1,1000);
					initLoadUserInfo();
				} else {
					layerAutoCloseMsg("更新账号状态失败",2,1000);
				}
			},
			btn2:function(index){
				var data= {
						"usercode" : usercode,
						"status" : "2"
					};
				var url="/icss/systemSet/delUser";
				var forward=dataChangeByAjax(data,url);
				if (forward.success) {
					layer.close(index);
					layerAutoCloseMsg("更新账号状态成功",1,1000);
					initLoadUserInfo();
				} else {
					layerAutoCloseMsg("更新账号状态失败",2,1000);
				}
			},
			btn3:function(index){
				var data= {
						"userCode" : usercode,
						"status" : "0"
					};
				var url="/icss/systemSet/delUser";
				var forward=dataChangeByAjax(data,url);
				if (forward.success) {
					layer.close(index);
					layerAutoCloseMsg("更新账号状态成功",1,1000);
					initLoadUserInfo();
				} else {
					layerAutoCloseMsg("更新账号状态失败!",2,1000);
				}
			},
			btn4:function(index){
				layer.close(index);
			}
		})
	});
}


//保存新增角色信息
function saveRoleData(index){
	var checkedMenu=[];
	$("#addRoleInfo .authorityList .check-box.checked").each(
			function(){
				checkedMenu.push($(this).attr("menuNo"));
			}
	);
	var menuNoStr=appendMenuStr(checkedMenu);
	var data={
		roleName:$("#addRoleInfo #addRoleAccount").val(),
		menuNoStr:menuNoStr
	}
	var forward=dataChangeByAjax(data,"/icss/systemSet/addRole");
	if (forward.success) {
		layer.close(index);
		layerAutoCloseMsg("新增角色成功",1,1000);
		initLoadRoleInfo();
	} else {
		layerAutoCloseMsg("新增用户失败",2,1000);
	}
}

//编辑角色
function editRole(obj){
	var option={
			width:"350px",
			title:"编辑角色"
	}
	bindEditRoleEvent(obj);
	var funcArray=new Array(2);
	content="editRoleInfo";
	funcArray[0]="";
	funcArray[1]="saveEditRoleData";
	popLayer(option,content,funcArray,obj);	
}


//绑定编辑角色事件
function bindEditRoleEvent(obj){
	$("#editRole").val($(obj).parent().parent().find("td").eq(0).html());
	$("#editRoleInfo .authorityList").html("");
	var forward=dataChangeByAjax(null,"/icss/systemSet/getAllMenu");
	if($(obj).parent().parent().find("td").eq(1).attr("menuList")){		
		var checkedMenu=$(obj).parent().parent().find("td").eq(1).attr("menuList").split(",");
	}
	if(forward.success){
		var menuList=forward.list;
		if(menuList!=null&&menuList.length>0){
			for(var i=0;i<menuList.length;i++){
				var menu;
				if($.inArray(menuList[i].menuNo,checkedMenu)!=-1){					
					menu='<div class="choice"><div class="check-box fl checked" menuNo='+menuList[i].menuNo+'></div>'
					+'<span>'+menuList[i].name+'</span>'
					+'</div>';
				}else{
					menu='<div class="choice"><div class="check-box fl" menuNo='+menuList[i].menuNo+'></div>'
					+'<span>'+menuList[i].name+'</span>'
					+'</div>';
				}
				$("#editRoleInfo .authorityList").append(menu);
			}
		}
	}
	$("#editRoleInfo .authorityList .choice").off("click").on("click",function(){
		$(this).children(".check-box").toggleClass("checked");		
	});
}


//保存编辑角色信息
function saveEditRoleData(obj,index){
	var checkedMenu=[];
	$("#editRoleInfo .authorityList .check-box.checked").each(
			function(){
				checkedMenu.push($(this).attr("menuNo"));
			}
	);
	var menuNoStr=appendMenuStr(checkedMenu);
	var data={
		roleId:$(obj).parent().parent().attr("roleId"),
		menuNoStr:menuNoStr
	}
	var forward=dataChangeByAjax(data,"/icss/systemSet/editRole");
	if (forward.success) {
		layer.close(index);
		layerAutoCloseMsg("编辑角色成功",1,1000);
		initLoadRoleInfo();
	} else {
		layerAutoCloseMsg("编辑角色失败",2,1000);		
	}
}


//更改角色状态
function delRole(obj) {
	var roleName=$(obj).parent().parent().find("td").eq(0).html();
	var roleId=$(obj).parent().parent().attr("roleId");
	layerConfirmMsg("确认删除角色"+roleName+"吗","delRoleData",null,roleId);
}


//删除角色
function delRoleData(obj){
	var data= {
			"roleId" : obj,
		};
	var url="/icss/systemSet/delRole";
	var forward=dataChangeByAjax(data,url);
	if (forward.success) {
		layerAutoCloseMsg("删除角色成功",1,1000);
		initLoadRoleInfo();
	} else {
		layerAutoCloseMsg("删除角色失败",2,1000);
	}
}


//角色菜单名称
function appendMenuStr(menuList,attr){
	var index=0;
	var menuStr="";
	for(var j=0;j<menuList.length;j++){ 
		var menu;
		if(attr){
			menu=menuList[j][attr];
		}else{
			menu=menuList[j];
		}
		if(index==0){
			menuStr+=menu;
			index++;
		}else{
			menuStr+=','+menu;
		}
	}
	return menuStr;
}


//角色菜单ID
function appendMenuList(menuList){
	var list=[];
	if(menuList!=null&&menuList.length>0){
		for(var i=0;i<menuList.length;i++){
			list.push(menuList[i].menuNo);
		}		
	}
	return list;
}


//状态显示
function showStatus(status){
	var status=parseInt(status);
	switch(status){
		case 0:{
			return '<font color="red">已删除</font>';
			break;
		}
		case 1:{
			return '<font color="green">正常</font>';
			break;
		}
		case 2:{
			return '<font color="#FFA443">已停用</font>';
			break;
		}
	}
	
}


//弹出Layer
function popLayer(option,content,funcName,obj){
	var width=option.width;
	var height=option.height;
	var title=option.title;
	layui.use('layer', function() {
		var layer = layui.layer;
		layer.open({
			id:'systemLayer',
			type : 1,
			title : title,
			area : [width], // 宽 高
			maxmin : false,
			anim : 5,
			resize:false,
			offset:'',
			content : $('#'+content),
			btn : [ '确认', '取消' ],
			btnAlign : 'c',
			closeBtn : 1,
			moveType : 1,
			shade:0.7,
			yes : function(index) { // 第一个按钮
				if(obj){				
					window[funcName[1]](obj,index);
				}else{					
					window[funcName[1]](index);
				}
			},
			btn2 : function(index) { // 第二个按钮
				layer.close(index);
			},
			cancel : function(index) { // 右上角关闭按钮
				layer.close(index);
			},
			success : function(layerobj, index) {
				$(".layui-layer-setwin .layui-layer-close").attr("href","###");
				if(window[funcName[0]]){
					window[funcName[0]]();
				}
			}
		});
	});
}


//绑定添加角色事件
function bindAddRoleEvent(){
	$("#addRoleInfo .authorityList").html("");
	var forward=dataChangeByAjax(null,"/icss/systemSet/getAllMenu");
	if(forward.success){
		var menuList=forward.list;
		if(menuList!=null&&menuList.length>0){
			for(var i=0;i<menuList.length;i++){
				var menu='<div class="choice"><div class="check-box fl checked" menuNo='+menuList[i].menuNo+'></div>'
			             +'<span>'+menuList[i].name+'</span>'
				         +'</div>';
				$("#addRoleInfo .authorityList").append(menu);
			}
		}
	}
	$("#addRoleInfo .authorityList .choice").off("click").on("click",function(){
		$(this).children(".check-box").toggleClass("checked");		
	});
}


//获取所有角色
function getAllRoleOption(roleName){
	var roles=dataChangeByAjax(null,"/icss/systemSet/getAllRole").list;
	var option="";
	for(var j=0;roles && j<roles.length;j++){
		if(roles[j].name==roleName){
			option+='<option value='+roles[j].id+' selected="selected">'+roles[j].name+'</option>';
		}else{		
			option+='<option value='+roles[j].id+'>'+roles[j].name+'</option>';
		}
	}
	return option;
}


//用户绑定角色事件
function bindChangeRoleEvent(){
	$(".userRoleSelect select").off("change").on("change",function(){
		var username=$(this).parents("tr").find("td").eq(0).html();
		var value=$(this).children("option:selected").html();
		var msg="确定更改用户"+username+"的角色为"+value+"吗";
		layerConfirmMsg(msg,"changeUserRole",'cancelChangeUserRole',$(this));		
	});
}


//用户更改角色
function changeUserRole(obj){
	var userId=$(obj).parents("tr").attr("userid");
	var roleId=$(obj).children("option:selected").attr("value");
	var value=$(obj).children("option:selected").html();
	$(obj).siblings(".select-cover").children(".select-value").html(value);
	$(obj).siblings(".select-cover").children(".select-value").attr("title",value);
	$(obj).siblings(".select-cover").children(".select-value").attr("roleId",roleId);
	var data={
		userId:userId,
		roleId:roleId
	};
	var forward=dataChangeByAjax(data,"/icss/systemSet/addRoleForUser");
	if (forward.success) {	
		layerAutoCloseMsg("更改角色成功",1,1000);
	} else {
		layerAutoCloseMsg("更改角色失败",2,1000);
	}
}

//用户取消更改角色
function cancelChangeUserRole(obj){
	var roleId=$(obj).siblings(".select-cover").children(".select-value").attr("roleId");
	$(obj).children("option").removeAttr("selected");
	$(obj).children("option").each(function(){
		if($(this).attr("value")==roleId){
			$(this).attr("selected","selected");
		}
	});	
}

//绑定tab操作
$(".menu li").click(function(){
    $(".menu li").removeClass("current");
    $(this).addClass("current");
    $(".rollcall-table").removeClass("current");
    if($(this).html()=="用户管理"){
    	$(".rollcall-table.user-table").addClass("current");   
    }else{
    	$(".rollcall-table.role-table").addClass("current");    	
    }
});


//清除新增用户信息
function clearAddUserInfo(){
	$("#username").val("");
	$("#usercode").val("");
	$("#password").val("");
	var roles=dataChangeByAjax(null,"/icss/systemSet/getAllRole").list;
	var option="";
	for(var j=0;j<roles.length;j++){
		option+='<option value='+roles[j].id+'>'+roles[j].name+'</option>';
	}
	$("#addUser .roleSelect select").html(option);
	$("#user-role .select-cover .select-value").html(roles[0].name);
	$("#user-role .select-cover .select-value").attr("roleId",roles[0].id);
	$("#addUser .roleSelect select").off("change").on("change",function(){
		$("#user-role .select-cover .select-value").html($(this).children("option:selected").html());
		$("#user-role .select-cover .select-value").attr("roleId",$(this).children("option:selected").attr("value"));
	});
}


//清除新增角色信息
function clearAddRoleInfo(){
	$("#addRoleAccount").val("");
	$(".authorityList .check-box").each(function(){
		$(this).addClass("checked");
	});
}