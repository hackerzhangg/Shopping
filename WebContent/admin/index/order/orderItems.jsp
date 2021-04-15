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
	<title>用户订单项列表</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/admin/layui/css/layui.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/admin/css/admin.css" />
</head>
<body>
	<div class="page-content-wrap">
		
		<div class="layui-form" id="table-list">
			<table class="layui-table" lay-skin="line">													
				<tr>
					<td>itemid</td>
					<td>商品图片</td>					
					<td>订单项数量</td>
					<td>订单项小计</td>													
				</tr>
				
				<!-- 循环显示用户订单的订单项  -->
				<s:iterator var="orderItem" value="orderItems">				
				<tr>
					<td><s:property value="#orderItem.itemid"/></td>
					<td><img src="<s:property value="#orderItem.product.image"/>" style="width: 60px;height: 40px;"></td>
					<td><s:property value="#orderItem.count"/></td>
					<td><s:property value="#orderItem.subtotal"/></td>					
				</tr>
				</s:iterator>	
			</table>
		</div>
	</div>
</body>
</html>