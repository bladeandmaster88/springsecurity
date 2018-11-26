function initial() {
    $("#moudle").attr("src", "index");
    iframeOnLoad();
    $(".navlist>li").hide();
    //$(".navlist>li>a").removeClass("current");
    menuContro();
}

//根据权限,控制菜单显示
function menuContro() {
    var url = "/icss/main/getMenu";
    var json = {};
    var obj = dataChangeByAjax(json, url).list;
    for (var i = 0; i < obj.length; i++) {
        switch (obj[i].name) {
            case "首页":
                $(".communicate-dispatch").show();
                break;
            case "地图应用":
                $(".resource-map").show();
                break;
            case "系统设置":
                $(".systemSet").show();
                break;
        }
    }
}

//obj目标li对象，str目标url
function changeTap(obj, str) {
    iframeOnLoad();
    $("#moudle").attr("param", str);
    $(".navlist>li>a").removeClass("current");
    $(obj).addClass("current");
    switch (str) {
        case "dispatch": {
            $("#moudle").attr("src", "");
            break;
        }
        case "resourceMap": {
            $("#moudle").attr("src", str);
            break;
        }
        case "systemSet": {
            $("#moudle").attr("src", str);
            break;
        }
    }

}

function iframeOnLoad() {
    $('#moudle').css('visibility', 'hidden');
    $('#moudle')[0].onload = function () {
        $('#moudle').css('visibility', 'visible');
    }
}



