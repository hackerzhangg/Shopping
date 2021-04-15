<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0080)http://localhost:8080/mango/login.jhtml?redirectUrl=%2Fmango%2Fcart%2Flist.jhtml -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>会员登录</title>

<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet" type="text/css" />

<style>
	.kw{
		width:180px;
		height:18px;
		padding:4px 7px;
		padding:6px 7px 2px\9;
		font:16px arial;
		background:url(http://www.baidu.com/img/i2.png) no-repeat;
		border:1px solid green;
		border-color:green;
		vertical-align:top
	}
	.btn{
		width:95px;
		height:28px;
		padding:0;
		padding-top:2px\9;
		border:0;
		background: url(http://www.baidu.com/img/i2.png) 0 -35px;
		cursor:pointer
	}
</style>

<script>
	//判断搜索框商品名称是否为空
	function checkPname(){
		
		var pname=document.getElementById("pname").value;		
		if(pname == null || pname == ''){
			
			alert("亲！ 请输入你想搜索的商品名称哦！");
			return false;
		}
	}
</script>

<script>
	
	//校验用户登录数据
	function checkForm(){
		
		//获取登录表单用户名
		var username=document.getElementById("username").value;
		if(username == null || username==''){
			
			alert("用户名不能为空!");
			return false;
		}
		
		//获取登录表单密码
		var password=document.getElementById("password").value;
		if(password == null || password==''){
			
			alert("用户密码不能为空!");
			return false;
		}
	}

	//点击图片切换验证码
	function change(){
		var img = document.getElementById("checkImg");
		img.src="${pageContext.request.contextPath}/checkImg.action?"+new Date().getTime();
	}
</script>
</head>
<body>

	<div class="container header">
		<div class="span5">
			<div class="logo">
				<a href="http://localhost:8080/mango/">
					<img src="${pageContext.request.contextPath}/image/logo3.png" alt="购物商城"
					style="width: 200px; height: 55px;" />
				</a>
			</div>
		</div>
		<div class="span9">
			<div class="headerAd">
									
				<form action="${pageContext.request.contextPath }/product_findConditionProduct.action" onsubmit="return checkPname();" method="post">
					<div style="position: relative;top: 20px;left: 50px;">
						<input id="pname" name="pname" class="kw" placeholder="请输入商品名称" type="text" maxLength="80" autocomplete="off"/>
						<input class="btn" type="submit" value="搜索" style="color: red;"/>
		             </div>
	             </form>
			</div>
		</div>

		<!-- 包含menu.jsp页面 -->
		<%@ include file="menu.jsp"%>

	</div>
	<div class="container login">
		<div class="span12">
			&nbsp;
			&nbsp;
			<div class="ad">									
				<img src="${pageContext.request.contextPath}/image/19114344.png" width="400" height="270"/>
			</div>
		</div>
		<div class="span12 last">
			&nbsp;&nbsp;
			<div class="wrap">
				<div class="main">
					<div class="title">
						<strong>用户登录</strong>USER LOGIN
					</div>
					<div>
						<s:actionerror />
					</div>
					<form id="loginForm" action="${pageContext.request.contextPath }/user_login.action" method="post" onsubmit="return checkForm();" novalidate="novalidate">
						<table>
							<tbody>
								<tr>
									<th>用户名/E-mail:</th>
									<td><input type="text" id="username" name="username"
										class="text" maxlength="20"/></td>
								</tr>
								<tr>
									<th>密&nbsp;&nbsp;码:</th>
									<td><input type="password" id="password" name="password"
										class="text" maxlength="20" autocomplete="off"/></td>
								</tr>
								<tr>
									<th>验证码:</th>
									<td><span class="fieldSet"> <input type="text"
											id="checkcode" name="checkcode" class="text captcha"
											maxlength="4" autocomplete="off"/><img
												id="checkImg" class="captchaImage"
												src="${pageContext.request.contextPath}/checkImg.action" onclick="change()" title="点击更换验证码"/></span></td>
								</tr>
								<!-- <tr>
									<th>&nbsp;</th>
									<td><label> <input type="checkbox"
											id="isRememberUsername" name="isRememberUsername"
											value="true"/>记住用户名 </label> <label> &nbsp;&nbsp;<a>找回密码</a>
									</label></td>
								</tr> -->
								<tr>
									<th>&nbsp;</th>
									<td><input type="submit" class="submit" value="登 录"/></td>
								</tr>
								<tr class="register">
									<th>&nbsp;</th>
									<td>
										<dl>
											<dt style="color: orange;">还没有注册账号？</dt>
											<dd>
												立即注册即可体验在线购物！ <a style="color: #FF6347;" href="${pageContext.request.contextPath}/user_registerPage.action">立即注册</a>
											</dd>
										</dl>
									</td>
								</tr>
							</tbody>
						</table>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div class="container footer">

		<div class="span24">
			<div class="footerAd">				
				<img src="${pageContext.request.contextPath}/image/button.png" width="950" height="48" alt="我们的优势"
					title="我们的优势"/>
			</div>
		</div>
		<div class="span24">
			<ul class="bottomNav">
				<li><a>关于我们</a> |</li>
				<li><a>联系我们</a> |</li>
				<li><a>联系客服</a> |</li>
				<li><a>合作招商</a> |</li>
				<li><a>商家帮助</a> |</li>
				<li><a target="_blank">营销中兴</a> |</li>
				<li><a target="_blank">手机商城</a> |</li>
				<li><a>友情链接</a> |</li>
				<li><a>销售联盟</a></li>
				<li><a>售后服务</a></li>
				<li><a>English Site</a></li>
				<li><a>隐私政策</a></li>
			</ul>
			<ul class="bottomNav">
				<li><a>互联网出版许可证编号新出网证（京）字150号</a> |</li>
				<li><a>大麦网</a> |</li>
				<li><a>京ICP证070359号</a> |</li>
				<li><a>支付宝</a> |</li>
				<li><a>网络文化经营许可证京网文[2014]2148-348号</a> |</li>
				<li><a target="_blank">营销中兴</a> |</li>
				<li><a target="_blank">手机商城</a> |</li>
				<li><a>开发平台</a> |</li>
				<li><a>（京）网械平台备字（2018）第00003号</a> |</li>
				<li><a>知识产权</a> |</li>
				<li><a>English Site</a> |</li>
				<li><a>消费者维权热线：4006067733</a> |</li>
			</ul>
		</div>
		<div class="span24">
			<div class="copyright">商城平台备字[2020]第00004号 网上商城 版权所有</div>
		</div>
	</div>
</body>
</html>