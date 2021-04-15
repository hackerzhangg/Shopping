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
	<title>更新二级分类</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/admin/layui/css/layui.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/admin/css/admin.css" />
</head>
<body>
<div class="wrap-container">
	<form action="${pageContext.request.contextPath }/adminCategorySecond_csUpdate.action" method="post" class="layui-form" style="width: 90%;padding-top: 20px;">
		<input type="hidden" name="csid" value="<s:property value="model.csid"/>">
		<div class="layui-form-item">
			<label class="layui-form-label">上级：</label>
			<div class="layui-input-block">
			
				<select name="category.cid" lay-verify="required">
					<!-- 使用下拉列表显示所有一级分类  -->
					<s:iterator var="cList" value="categories">							
						<option value="<s:property value="#cList.cid"/>" <s:if test="#cList.cid==model.category.cid">selected</s:if>><s:property value="#cList.cname"/></option>
					</s:iterator>
				</select>					
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">名称：</label>
			<div class="layui-input-block">
			
				<input type="text" name="csname" value="<s:property value="model.csname"/>" required lay-verify="required" placeholder="请输入二级分类名称" autocomplete="off" class="layui-input">
			</div>
		</div>
			
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button type="submit" class="layui-btn layui-btn-normal" >立即更新</button>
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