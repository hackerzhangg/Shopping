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
	<title>用户列表</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/admin/layui/css/layui.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/admin/css/admin.css" />
</head>
<body>
	<div class="page-content-wrap">
		<div class="layui-form-item">											
			<button class="layui-btn layui-btn-normal" disabled="disabled">用户列表</button>
		</div>
		<div class="layui-form" id="table-list">
			<table class="layui-table" lay-skin="line">													
				<tr>
					<td>uid</td>
					<td>昵称</td>
					<td>名称</td>
					<td>密码</td>
					<td>性别</td>
					<td>邮箱</td>
					<td>号码</td>
					<td>地址</td>
					<td>操作</td>									
				</tr>
				
				<!-- 使用迭代循环值栈中的数据 -->
				<s:iterator var="uList" value="pageBean.list">			
				<tr>
					<td><s:property value="#uList.uid"/></td>
					<td><s:property value="#uList.username"/></td>
					<td><s:property value="#uList.name"/></td>
					<td><s:property value="#uList.password"/></td>
					<td><s:property value="#uList.sex"/></td>
					<td><s:property value="#uList.email"/></td>
					<td><s:property value="#uList.phone"/></td>
					<td><s:property value="#uList.address"/></td>
					<td>
						<div class="layui-inline">
							<button class="layui-btn layui-btn-mini layui-btn-normal  edit-btn" data-id="1" onclick="javascript:window.location.href='${pageContext.request.contextPath}/adminUser_updateUserPage.action?uid=<s:property value="#uList.uid" />'"><i class="layui-icon">&#xe642;</i></button>
							<button class="layui-btn layui-btn-mini layui-btn-danger del-btn" data-id="1" onclick="javascript:window.location.href='${pageContext.request.contextPath}/adminUser_deleteUser.action?uid=<s:property value="#uList.uid" />'"><i class="layui-icon">&#xe640;</i></button>
						</div>
					</td>
				</tr>
				</s:iterator>
			</table>
			<!-- 用户列表分页模块 -->
			<div class="page-wrap">
				<ul class="pagination">
					<li>
						<span>第<s:property value="pageBean.page"/></span>
					</li>
					<li>
						<span><s:property value="pageBean.totalPage"/>页</span>
					</li>
					<!-- 判断当前是否为不等于第一页 则可以点击上一页和首页 -->
					<s:if test="pageBean.page != 1">
						<li>
							<span><a href="${pageContext.request.contextPath }/adminUser_userListPage.action?page=1">««</a></span>
						</li>
						<li>
							<span><a href="${pageContext.request.contextPath }/adminUser_userListPage.action?page=<s:property value="pageBean.page-1"/>">«</a></span>
						</li>
					</s:if>					
					
					<!-- 判断当前是否为不等于最后一页 则可以点击下一页和尾页 -->
					<s:if test="pageBean.page !=pageBean.totalPage">
						<li>
							<a href="${pageContext.request.contextPath }/adminUser_userListPage.action?page=<s:property value="pageBean.page+1" />">»</a>
						</li>
						<li>
							<span><a href="${pageContext.request.contextPath }/adminUser_userListPage.action?page=<s:property value="pageBean.totalPage" />">»»</a></span>
						</li>
					</s:if>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>