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
	<title>商品列表</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/admin/layui/css/layui.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/admin/css/admin.css" />
</head>
<body>
	<div class="page-content-wrap">		
			<div class="layui-form-item">
				<div class="layui-inline tool-btn">
					<button class="layui-btn layui-btn-small layui-btn-normal addBtn hidden-xs" onclick="javascript:window.location.href='${pageContext.request.contextPath }/adminProduct_addProductPage.action'"><i class="layui-icon">&#xe654;</i></button>								
				</div>
										
				<button class="layui-btn layui-btn-normal" disabled="disabled">商品列表</button>
			</div>
		<div class="layui-form" id="table-list">
			<table class="layui-table" lay-skin="line">													
				<tr>
					<td>pid</td>
					<td>名称</td>
					<td>图片</td>
					<td>售卖价格</td>
					<td>市场价格</td>
					<td>所属二级分类</td>
					<td>操作</td>									
				</tr>
				
				<!-- 循环显示商品信息  -->
				<s:iterator var="products" value="pageBean.list">			
				<tr>
					<td><s:property value="#products.pid"/></td>
					<td><s:property value="#products.pname"/></td>
					<td><img src="<s:property value="#products.image"/>" style="width: 60px;height: 40px;"></td>
					<td><s:property value="#products.shop_price"/></td>
					<td><s:property value="#products.market_price"/></td>
					<td><s:property value="#products.categorySecond.csname"/></td>					
					<td>
						<div class="layui-inline">
							<button class="layui-btn layui-btn-mini layui-btn-normal  edit-btn" data-id="1" onclick="javascript:window.location.href='${pageContext.request.contextPath}/adminProduct_updateProductPage.action?pid=<s:property value="#products.pid"/>'"><i class="layui-icon">&#xe642;</i></button>
							<button class="layui-btn layui-btn-mini layui-btn-danger del-btn" data-id="1" onclick="javascript:window.location.href='${pageContext.request.contextPath}/adminProduct_deleteProduct.action?pid=<s:property value="#products.pid"/>'"><i class="layui-icon">&#xe640;</i></button>
						</div>
					</td>
				</tr>
				</s:iterator>				
			</table>
			<!-- 商品列表分页模块 -->
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
							<span><a href="${pageContext.request.contextPath }/adminProduct_productListPage.action?page=1">««</a></span>
						</li>
						<li>
							<span><a href="${pageContext.request.contextPath }/adminProduct_productListPage.action?page=<s:property value="pageBean.page-1"/>">«</a></span>
						</li>
					</s:if>					
					
					<!-- 判断当前是否为不等于最后一页 则可以点击下一页和尾页 -->
					<s:if test="pageBean.page !=pageBean.totalPage">
						<li>
							<a href="${pageContext.request.contextPath }/adminProduct_productListPage.action?page=<s:property value="pageBean.page+1" />">»</a>
						</li>
						<li>
							<span><a href="${pageContext.request.contextPath }/adminProduct_productListPage.action?page=<s:property value="pageBean.totalPage" />">»»</a></span>
						</li>
					</s:if>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>