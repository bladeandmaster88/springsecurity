
function layerAutoCloseMsg(msg, type, timeout) {
	layui.use('layer', function() {
		var layer = layui.layer;
		layer.msg(msg, {
			icon : type, // 1：对钩，2：叉叉，3：问号，4：锁符号，5：哭脸，6：笑脸
			time : timeout,
			shade : [ 0.3, '#000' ],
			offset : '70px'
		}, function() {
		});
	});
}


function layerMsg(text,timeout){
    layui.use('layer', function(){
		var layer = layui.layer;
        layer.open(
            {
//            	type: 1, 
                title:"提示", content:text, skin:"", area:'360px', closeBtn:1,
                time:timeout,
                btn:["确定"], icon:7, yes: function(index){layer.close(index);},
		        success:function(index,layero){
		        	$(".layui-layer-setwin .layui-layer-close").attr("href","###"); 
		        	//解决ie下，提示框被视频窗口ocx遮盖
					$(".layui-layer-dialog").append(
				            '<iframe src="about:blank" frameborder="0" marginheight="0" marginwidth="0" style="position:absolute;visibility:inherit;top:0;left:0;height:100%;width:100%;z-index:-1"></iframe>');	        	
		        }
            }
        );
    });
}

//弹出确认消息
function layerConfirmMsg(text,yesFunc,cancelFunc,param){
	 layui.use('layer', function(){
			var layer = layui.layer;
	        layer.open(
	            {
//	            	type: 1, 
	                title:"提示", 
	                content:text, 
	                skin:"", 
	                area:'360px',
	                closeBtn:1,
	              /*  time:timeout,*/
	                btn:["确定","取消"],
	                icon:7, 
	                yes: function(index){
	                	if(yesFunc){
	                		window[yesFunc](param);
	                	}
	                	layer.close(index);
	                },
	                btn2 : function(index) { // 第二个按钮
	                	if(cancelFunc){
	                		window[cancelFunc](param);
	                	}
	    				layer.close(index);
	    			},
	    			cancel:function(index){
	    				if(cancelFunc){
	                		window[cancelFunc](param);
	                	}
	    			},
			        success:function(index,layero){
			        	$(".layui-layer-setwin .layui-layer-close").attr("href","###"); 
			        	//解决ie下，提示框被视频窗口ocx遮盖
						$(".layui-layer-dialog").append(
					            '<iframe src="about:blank" frameborder="0" marginheight="0" marginwidth="0" \
								style="position:absolute;visibility:inherit;top:0;left:0;height:100%;width:100%;z-index:-1"></iframe>');	        	
			        }
	            }
	        );
	    });
}