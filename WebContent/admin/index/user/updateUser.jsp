<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
	<title>更新用户</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/admin/layui/css/layui.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/admin/css/admin.css"/>
</head>
<body>
	<div class="layui-tab page-content-wrap">
		<ul class="layui-tab-title">
			<li class="layui-this">修改资料</li>
			<!-- <li>修改密码</li> -->
		</ul>
		<div class="layui-tab-content">
		<div class="layui-tab-item layui-show">
			<form class="layui-form" action="${pageContext.request.contextPath }/adminUser_updateUser.action" style="width: 90%;padding-top: 20px;" method="post">
				
				<!-- 自定义未能修改的数据 -->
				<input type="hidden" name="uid" value="<s:property value="#session.userData.uid"/>"/>
				<input type="hidden" name="state" value="<s:property value="#session.userData.state"/>"/>
				<input type="hidden" name="code" value="<s:property value="#session.userData.code"/>"/>
				<input type="hidden" name="sex" value="<s:property value="#session.userData.sex"/>"/>
						
				<div class="layui-form-item">
					<label class="layui-form-label">用户uid：</label>
					<div class="layui-input-block">
						<input type="text" name="uid" disabled autocomplete="off" class="layui-input layui-disabled" value="<s:property value="#session.userData.uid"/>">
					</div>
				</div>

				<div class="layui-form-item">
					<label class="layui-form-label">用户昵称：</label>
					<div class="layui-input-block">
						<input type="text" name="username" required  lay-verify="required" placeholder="请输入用户昵称" autocomplete="off" class="layui-input" value="<s:property value="#session.userData.username"/>">
					</div>
				</div>

				<div class="layui-form-item">
					<label class="layui-form-label">用户名称：</label>
					<div class="layui-input-block">
						<input type="text" name="name" required  lay-verify="required" placeholder="请输入用户名称" autocomplete="off" class="layui-input" value="<s:property value="#session.userData.name"/>">
					</div>
				</div>

				<div class="layui-form-item">
					<label class="layui-form-label">用户密码：</label>
					<div class="layui-input-block">
						<input type="text" name="password" required  lay-verify="required" placeholder="请输入用户密码" autocomplete="off" class="layui-input" value="<s:property value="#session.userData.password"/>">
					</div>
				</div>

				<div class="layui-form-item">
					<label class="layui-form-label">用户邮箱：</label>
					<div class="layui-input-block">
						<input type="text" name="email" required  lay-verify="required" placeholder="请输入用户邮箱" autocomplete="off" class="layui-input" readonly="readonly" value="<s:property value="#session.userData.email"/>">
					</div>
				</div>

				<div class="layui-form-item">
					<label class="layui-form-label">用户电话：</label>
					<div class="layui-input-block">
						<input type="text" name="phone" required  lay-verify="required" placeholder="请输入用户电话" autocomplete="off" class="layui-input" value="<s:property value="#session.userData.phone"/>">
					</div>
				</div>

				<div class="layui-form-item">
					<label class="layui-form-label">用户地址：</label>
					<div class="layui-input-block">
						<input type="text" name="address" required  lay-verify="required" placeholder="请输入用户地址" autocomplete="off" class="layui-input" value="<s:property value="#session.userData.address"/>">
					</div>
				</div>
				
				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn layui-btn-normal" type="submit">立即提交</button>
					</div>
				</div>
			</form>
		</div>
		</div>
	</div>
<script src="${pageContext.request.contextPath }/static/admin/layui/layui.js" type="text/javascript" charset="utf-8"></script>
<%-- <script>
	//Demo
	layui.use(['form','element'], function(){
		var form = layui.form();
		var element = layui.element();
		form.render();
		
		//监听信息提交
		form.on('submit(adminInfo)', function(data){

			layer.msg(JSON.stringify(data.field));
			return false;
		});

		//监听密码提交
		form.on('submit(adminPassword)', function(data){

			layer.msg(JSON.stringify(data.field));
			return false;
		});
	});
</script> --%>
</body>
</html>