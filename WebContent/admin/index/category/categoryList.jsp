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
	<title>一级分类列表</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/admin/layui/css/layui.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/admin/css/admin.css" />
</head>
<body>
	<div class="page-content-wrap">
		<form class="layui-form" action="${pageContext.request.contextPath }/adminCategory_findCondition.action" method="post">
			<div class="layui-form-item">
				
				<!-- 到添加一级分类页面 -->
				<div class="layui-inline tool-btn">
					<button class="layui-btn layui-btn-small layui-btn-normal addBtn hidden-xs" onclick="javascript:window.location.href='admin/index/category/addCategory.jsp'"><i class="layui-icon">&#xe654;</i></button>								
				</div>
								
				<div class="layui-inline">
					<input type="text" name="cname" required lay-verify="required" placeholder="请输入一级分类" autocomplete="off" class="layui-input">
				</div>							
				<button type="submit" class="layui-btn layui-btn-normal">搜索</button>
			</div>
		</form>
		<div class="layui-form" id="table-list">
			<table class="layui-table" lay-skin="line">													
				<tr>
					<td>cid</td>
					<td>名称</td>
					<td>操作</td>									
				</tr>
				
				<!-- 循环显示一级分类  -->	
				<s:iterator var="categorie" value="categories">		
				<tr>
					<td><s:property value="#categorie.cid"/></td>
					<td><s:property value="#categorie.cname"/></td>
					<td>
						<!-- 修改和删除一级分类  -->
						<div class="layui-inline">
							<button class="layui-btn layui-btn-mini layui-btn-normal  edit-btn" data-id="1" onclick="javascript:window.location.href='${pageContext.request.contextPath}/adminCategory_updateCategoryPage.action?cid=<s:property value="#categorie.cid" />'"><i class="layui-icon">&#xe642;</i></button>
							<button class="layui-btn layui-btn-mini layui-btn-danger del-btn" data-id="1" onclick="javascript:window.location.href='${pageContext.request.contextPath}/adminCategory_deleteCategory.action?cid=<s:property value="#categorie.cid" />'"><i class="layui-icon">&#xe640;</i></button>
						</div>
					</td>
				</tr>
				</s:iterator>
				
			</table>
		</div>
	</div>
</body>
</html>