/**
 * 重写了时间格式化，对时间进行通用化格式化。
 * 调用方法 new Date().format('yyyy-MM-dd hh:mm:ss')
 * 注意事项：要在调用函数之前加载此方法
 * @param format
 * @returns
 * author：y26467
 */
Date.prototype.format = function(format) {
    var date = this
    var fmt = {
        yyyy: date.getFullYear(),
        MM: pad(date.getMonth() + 1),
        dd: pad(date.getDate()),
        hh: pad(date.getHours()),
        mm: pad(date.getMinutes()),
        ss: pad(date.getSeconds()),
        yy: date.getFullYear().toString().substr(2),
        M: (date.getMonth() + 1).toString(),
        d: date.getDate().toString(),
        h: date.getHours().toString(),
        m: date.getMinutes().toString(),
        s: date.getSeconds().toString()
    }
    
    function pad(num) {
        num = num.toString();
        return num.length === 1?'0' + num:num;
    }
    
    return format.replace(/(y+|M+|d+|h+|m+|s+)/g,function(match) {
        return fmt[match]||''
    })
} 
