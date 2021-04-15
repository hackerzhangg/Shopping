<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>商城后台登录</title>
  <meta name="description" content="particles.js is a lightweight JavaScript library for creating particles.">
  <meta name="author" content="Vincent Garreau" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
  <link rel="stylesheet" media="screen" href="${pageContext.request.contextPath}/css/style.css">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css"/>
  
  <!-- 前台的管理员登录校验  -->
  <script type="text/javascript">
 
  	function checkUser(){ 		
  		//获取用户名称
  		var username=document.getElementById("username").value;
  		//判断用户名是否为空
  		if(username == null || username == ''){
  			
  			alert("亲，用户名不能为空！");
  			return false;
  		}
  		
  		//获取用户密码
  		var password=document.getElementById("password").value;
  		//判断用户密码是否为空
  		if(password == null || password == ''){
  			
  			alert("亲，密码不能为空");
  			return false;
  		}		
  	}  
  </script>
  
</head>
<body>

<div id="particles-js">
		<div class="login">
			<div class="login-top">
				商城后台登录
			</div>
			<div>
				<!-- 显示用户登录失败的信息 -->
				<%-- <s:actionerror/> --%>
			</div>
			<form id="adminUser" action="${pageContext.request.contextPath }/admin_adminLogin.action" onsubmit="return checkUser();" method="post">
			<div class="login-center clearfix">
				<div class="login-center-img"><img src="${pageContext.request.contextPath}/images/name.png"/></div>
				<div class="login-center-input">
					<input type="text" name="username" id="username" value="" placeholder="请输入您的用户名" onfocus="this.placeholder=''" onblur="this.placeholder='请输入您的用户名'"/>
					<div class="login-center-input-text">用户名</div>
				</div>
			</div>
			<div class="login-center clearfix">
				<div class="login-center-img"><img src="${pageContext.request.contextPath}/images/password.png"/></div>
				<div class="login-center-input">
					<input type="password" name="password" id="password" value="" placeholder="请输入您的密码" onfocus="this.placeholder=''" onblur="this.placeholder='请输入您的密码'"/>
					<div class="login-center-input-text">密码</div>
				</div>
			</div>
			<div class="login-button">
				
				<!-- <a href="javascript:document.getElementById('adminUser').submit();">登录</a> -->
				<button type="submit">登录</button>
			</div>
			</form>
		</div>
		<div class="sk-rotating-plane"></div>
</div>

<!-- scripts -->
<script src="${pageContext.request.contextPath}/js/particles.min.js"></script>
<script src="${pageContext.request.contextPath}/js/app.js"></script>
<script type="text/javascript">
	/* function hasClass(elem, cls) {
	  cls = cls || '';
	  if (cls.replace(/\s/g, '').length == 0) return false; //当cls没有参数时，返回false
	  return new RegExp(' ' + cls + ' ').test(' ' + elem.className + ' ');
	}
	 
	function addClass(ele, cls) {
	  if (!hasClass(ele, cls)) {
	    ele.className = ele.className == '' ? cls : ele.className + ' ' + cls;
	  }
	}
	 
	function removeClass(ele, cls) {
	  if (hasClass(ele, cls)) {
	    var newClass = ' ' + ele.className.replace(/[\t\r\n]/g, '') + ' ';
	    while (newClass.indexOf(' ' + cls + ' ') >= 0) {
	      newClass = newClass.replace(' ' + cls + ' ', ' ');
	    }
	    ele.className = newClass.replace(/^\s+|\s+$/g, '');
	  }
	}
		document.querySelector(".login-button").onclick = function(){
				addClass(document.querySelector(".login"), "active")
				setTimeout(function(){
					addClass(document.querySelector(".sk-rotating-plane"), "active")
					document.querySelector(".login").style.display = "none"
				},800)
				setTimeout(function(){
					removeClass(document.querySelector(".login"), "active")
					removeClass(document.querySelector(".sk-rotating-plane"), "active")
					document.querySelector(".login").style.display = "block"
					alert("登录成功")
					
				},5000)
		} */
</script>
</body>
</html>