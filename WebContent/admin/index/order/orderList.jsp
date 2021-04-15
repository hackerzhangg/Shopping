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
	<title>用户订单列表</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/admin/layui/css/layui.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/admin/css/admin.css" />
</head>
<body>
	<div class="page-content-wrap">
		
		<div class="layui-form-item">											
			<button class="layui-btn layui-btn-normal" disabled="disabled">订单列表</button>
		</div>		
		<div class="layui-form" id="table-list">
			<table class="layui-table" lay-skin="line">													
				<tr>
					<td>oid</td>
					<td>订单金额</td>
					<td>订单时间</td>
					<td>收货人</td>					
					<td>订单状态</td>
					
					<td>订单地址</td>					
					<td>订单电话</td>
					<td>所属用户</td>
					<td>操作</td>									
				</tr>
				
				<!-- 循环显示所有订单  -->
				<s:iterator var="orders" value="pageBean.list">				
				<tr>
					<td><s:property value="#orders.oid"/></td>
					<td><s:property value="#orders.total"/></td>
					<td><s:property value="#orders.ordertime"/></td>
					<td><s:property value="#orders.name"/></td>
					<!-- 判断订单的状态  -->
					<td>
						<s:if test="#orders.state==1">
							未付款
						</s:if>
						<s:if test="#orders.state==2">
							<a href="${ pageContext.request.contextPath }/adminOrder_updateOrderState.action?oid=<s:property value="#orders.oid"/>"><font color="blue">发货</font></a>
						</s:if>
						<s:if test="#orders.state==3">
							等待确认收货
						</s:if>
						<s:if test="#orders.state==4">
							订单完成
						</s:if>
					</td>
					
					<td><s:property value="#orders.address"/></td>
					<td><s:property value="#orders.phone"/></td>
					<td><s:property value="#orders.user.name"/></td>
					<td>
						<div class="layui-inline">							
							<button style="background-color: #008000" class="layui-btn layui-btn-mini layui-btn-danger del-btn" data-id="1" onclick="javascript:window.location.href='${pageContext.request.contextPath }/adminOrder_findByOrderItem.action?oid=<s:property value="#orders.oid"/>'"><i class="layui-icon">订单详情</i></button>
							<button class="layui-btn layui-btn-mini layui-btn-danger del-btn" data-id="1" onclick="javascript:window.location.href='${pageContext.request.contextPath }/adminOrder_deleteUserOrder.action?oid=<s:property value="#orders.oid"/>'"><i class="layui-icon">删除订单</i></button>
						</div>
					</td>
				</tr>
				</s:iterator>	
			</table>
			<!-- 用户订单列表分页模块 -->
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
							<span><a href="${pageContext.request.contextPath }/adminOrder_orderListPage.action?page=1">««</a></span>
						</li>
						<li>
							<span><a href="${pageContext.request.contextPath }/adminOrder_orderListPage.action?page=<s:property value="pageBean.page-1"/>">«</a></span>
						</li>
					</s:if>					
					
					<!-- 判断当前是否为不等于最后一页 则可以点击下一页和尾页 -->
					<s:if test="pageBean.page !=pageBean.totalPage">
						<li>
							<a href="${pageContext.request.contextPath }/adminOrder_orderListPage.action?page=<s:property value="pageBean.page+1" />">»</a>
						</li>
						<li>
							<span><a href="${pageContext.request.contextPath }/adminOrder_orderListPage.action?page=<s:property value="pageBean.totalPage" />">»»</a></span>
						</li>
					</s:if>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>