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
	<title>添加商品</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/admin/layui/css/layui.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/admin/css/admin.css" />
</head>
<body>
	<div class="wrap-container">
		<form action="${pageContext.request.contextPath }/adminProduct_saveProduct.action" method="post" enctype="multipart/form-data" class="layui-form" style="width: 90%;padding-top: 20px;">
				
			<div class="layui-form-item">
				<label class="layui-form-label">二级分类：</label>
				<div class="layui-input-block">
					<select name="categorySecond.csid" lay-verify="required">
					
					<!-- 使用下拉列表显示所有二级分类  -->
					<s:iterator var="csList" value="categorySeconds">							
						<option value="<s:property value="#csList.csid"/>"><s:property value="#csList.csname"/></option>
					</s:iterator>
				</select>	
				</div>
			</div>
				
			<div class="layui-form-item">
				<label class="layui-form-label">商品名称：</label>
				<div class="layui-input-block">
					<input type="text" name="pname" required lay-verify="required" placeholder="请输入名称" autocomplete="off" class="layui-input">
				</div>
			</div>

			<div class="layui-form-item">
				<label class="layui-form-label">市场价格：</label>
				<div class="layui-input-block">
					<input type="text" name="market_price" required lay-verify="required" placeholder="请输入市场价格" autocomplete="off" class="layui-input">
				</div>
			</div>

			<div class="layui-form-item">
				<label class="layui-form-label">售卖价格：</label>
				<div class="layui-input-block">
					<input type="text" name="shop_price" required lay-verify="required" placeholder="请输入售卖价格" autocomplete="off" class="layui-input">
				</div>
			</div>

			<div class="layui-form-item">
				<label class="layui-form-label">是否热门：</label>
				<div class="layui-input-block">
					
					<!-- 显示商品是否热门  -->
					<select name="is_hot" lay-verify="required">
						<option value="1">是</option>
						<option value="0">否</option>						
					</select>
				</div>
			</div>

			<div class="layui-form-item">
				<label class="layui-form-label">商品图片：</label>
				<div class="layui-input-block">
					<input type="file" name="upload">
				</div>
			</div>
			
			<div class="layui-form-item layui-form-text">
				<label class="layui-form-label">商品描述：</label>
				<div class="layui-input-block">
					<textarea name="pdesc" placeholder="请输入商品描述" class="layui-textarea"></textarea>
				</div>
			</div>

			<div class="layui-form-item">
				<div class="layui-input-block">
					<button type="submit" class="layui-btn layui-btn-normal">立即添加</button>
					<button type="reset" class="layui-btn layui-btn-primary">重置</button>
				</div>
			</div>
		</form>
	</div>

<script src="${pageContext.request.contextPath }/static/admin/layui/layui.js" type="text/javascript" charset="utf-8"></script>
<script>
	//Demo
	layui.use(['form'], function() {
		var form = layui.form();
		form.render();

		//监听提交
		form.on('submit(formDemo)', function(data) {

			layer.msg(JSON.stringify(data.field));
			return false;
		});
	});
</script>
</body>
</html>