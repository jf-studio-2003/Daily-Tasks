// JavaScript Document

// 获取元素ID
  function xs(b) {
      return document.getElementById(b);
    };
	
	
	
	//  返回某ID的值  格式  idv("1"); 

function idv(a) {
	return document.getElementById(a).value;
}

	
	
// 替换掉 -  
	
	function ti_huan(b) {
      return b.replace(/a/g, "");
    };
	
	
	
// 创建音效对象 可以直接链接音频文件
//var audio = new Audio('./yin_xiao.wav');

// 也可以单独设置音效路径
//audio.src = './yin_xiao_2.wav';

// 播放音频
//audio.play();

	
	



 // 刷新网页 location.reload()
 




// 获取URL值 
function getQueryVariable(variable)
{
       var query = window.location.search.substring(1);
       var vars = query.split("&");
       for (var i=0;i<vars.length;i++) {
               var pair = vars[i].split("=");
               if(pair[0] == variable){return pair[1];}
       }
       return(false);
}



// 获取本地存储的KEY	 
function lsk(b) {	 
	return localStorage.key(b);
	 
	  };
	  
 // 获取本地存储的value	
function lsv(b) {
	return localStorage.getItem(localStorage.key(b));
	
	 };
	 
	 
// 转换成数值类型
function sz(b) {
return Number(b);
 };
 
 // 根据索引获取数值类型的本地存储值
 function c(a) {

return sz(ti_huan(lsv(a)));
  };
  
   // 根据索引获取数值类型的本地存储值
 function lsv_sz(a) {

return sz(ti_huan(lsv(a)));
  };

 // 获取本地存储的value	换行
function lsv_br(a,b) {
  a =a+ localStorage.getItem(localStorage.key(b))+"<br>";
	return a;
	 };
 
 
 // 根据条件语句
 function tj(a) {
var cvd="";
 if ( a>1,a < 3)
{cvd = "xiao";}
else if  ( a > 5,a<10)
{cvd = "zhong";}

else if  ( a > 10,a<20)
{cvd = "da";}
return cvd
  };
  
  
 function jy() { 
return  s.getItem(s.key(i-1))
 };
 
 
  function jon(a) { 
return   JSON.parse(a);
  };
  
  
  //跳转到首页函数开始
function home_html(){
//跳转到首页
window.location.href='index.html'

};
//跳转到首页函数结束

//跳转到添加函数开始
function add_html(){
//跳转到添加
window.location.href='add.html'

};
//跳转到添加函数结束

//跳转到删除函数开始
function del_html(){
//跳转到删除
window.location.href='del.html'

};
//跳转到删除函数结束

//跳转到历史记录函数开始
function history_html(){
//跳转到历史记录
window.location.href='history.html'

};
//跳转到历史记录函数结束

//跳转到我的函数开始
function about_html(){
//跳转到我的
window.location.href='about.html'

};
//跳转到我的函数结束


//禁止选择,也就是无法复制
document.onselectstart=new Function("event.returnValue=false;");  
