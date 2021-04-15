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
	<title>二级分类列表</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/admin/layui/css/layui.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/admin/css/admin.css" />
</head>
<body>
	<div class="page-content-wrap">
			<div class="layui-form-item">
				<div class="layui-inline tool-btn">
					<button class="layui-btn layui-btn-small layui-btn-normal addBtn hidden-xs" onclick="javascript:window.location.href='${pageContext.request.contextPath }/adminCategorySecond_addCsPage.action'" ><i class="layui-icon">&#xe654;</i></button>								
				</div>
											
				<button class="layui-btn layui-btn-normal" disabled="disabled">二级分类列表</button>
			</div>
		<div class="layui-form" id="table-list">
			<table class="layui-table" lay-skin="line">													
				<tr>
					<td>csid</td>
					<td>名称</td>
					<td>所属一级分类</td>
					<td>操作</td>									
				</tr>
				
				<!-- 循环二级分类数据  -->
				<s:iterator var="list" value="pageBean.list">			
				<tr>
					<td><s:property value="#list.csid"/></td>
					<td><s:property value="#list.csname"/></td>
					<td><s:property value="#list.category.cname"/></td>
					<td>
						<div class="layui-inline">
							<button class="layui-btn layui-btn-mini layui-btn-normal  edit-btn" data-id="1" onclick="javascript:window.location.href='${pageContext.request.contextPath }/adminCategorySecond_csUpdatePage.action?csid=<s:property value="#list.csid"/>'"><i class="layui-icon">&#xe642;</i></button>
							<button class="layui-btn layui-btn-mini layui-btn-danger del-btn" data-id="1" onclick="javascript:window.location.href='${pageContext.request.contextPath }/adminCategorySecond_deleteCategorySecond.action?csid=<s:property value="#list.csid"/>'"><i class="layui-icon">&#xe640;</i></button>
						</div>
					</td>
				</tr>
				</s:iterator>	
			</table>
			<!-- 二级分类列表分页模块 -->
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
							<span><a href="${pageContext.request.contextPath }/adminCategorySecond_csListPage.action?page=1">««</a></span>
						</li>
						<li>
							<span><a href="${pageContext.request.contextPath }/adminCategorySecond_csListPage.action?page=<s:property value="pageBean.page-1"/>">«</a></span>
						</li>
					</s:if>					
					
					<!-- 判断当前是否为不等于最后一页 则可以点击下一页和尾页 -->
					<s:if test="pageBean.page !=pageBean.totalPage">
						<li>
							<a href="${pageContext.request.contextPath }/adminCategorySecond_csListPage.action?page=<s:property value="pageBean.page+1" />">»</a>
						</li>
						<li>
							<span><a href="${pageContext.request.contextPath }/adminCategorySecond_csListPage.action?page=<s:property value="pageBean.totalPage" />">»»</a></span>
						</li>
					</s:if>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>