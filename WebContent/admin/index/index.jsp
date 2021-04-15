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
	<title>商城后台管理系统</title>
	<link rel="stylesheet" type="text/css" href="../../static/admin/layui/css/layui.css"/>
	<link rel="stylesheet" type="text/css" href="../../static/admin/css/admin.css"/>
</head>
<body>
	<div class="main-layout" id='main-layout'>
		<!--侧边栏-->
		<div class="main-layout-side">
			<div class="m-logo"></div>
			<ul class="layui-nav layui-nav-tree" lay-filter="leftNav">
				<li class="layui-nav-item layui-nav-itemed">
					<a href="javascript:;"><i class="iconfont">&#xe607;</i>用户管理</a>
					<dl class="layui-nav-child">
						<dd><a href="javascript:;" data-url="${pageContext.request.contextPath }/adminUser_userListPage.action?page=1" data-id='1' data-text="用户列表"><span class="l-line"></span>用户列表</a></dd>						
					</dl>
				</li>

				<li class="layui-nav-item">
					<a href="javascript:;"><i class="iconfont">&#xe608;</i>一级分类</a>
					<dl class="layui-nav-child">
						<dd><a href="javascript:;" data-url="${pageContext.request.contextPath }/adminCategory_categoryListPage.action" data-id='2' data-text="一级分类列表"><span class="l-line"></span>一级分类列表</a></dd>
						<dd><a href="javascript:;" data-url="${pageContext.request.contextPath }/adminCategory_addCategoryPage.action" data-id='3' data-text="添加一级分类"><span class="l-line"></span>添加一级分类</a></dd>
					</dl>
				</li>

				<li class="layui-nav-item">
					<a href="javascript:;"><i class="iconfont">&#xe608;</i>二级分类</a>
					<dl class="layui-nav-child">
						<dd><a href="javascript:;" data-url="${pageContext.request.contextPath }/adminCategorySecond_csListPage.action?page=1" data-id='4' data-text="二级分类列表"><span class="l-line"></span>二级分类列表</a></dd>
						<dd><a href="javascript:;" data-url="${pageContext.request.contextPath }/adminCategorySecond_addCsPage.action" data-id='5' data-text="添加二级分类"><span class="l-line"></span>添加二级分类</a></dd>
					</dl>
				</li>

				<li class="layui-nav-item">
					<a href="javascript:;"><i class="iconfont">&#xe608;</i>购物商品</a>
					<dl class="layui-nav-child">
						<dd><a href="javascript:;" data-url="${pageContext.request.contextPath }/adminProduct_productListPage.action?page=1" data-id='6' data-text="商品列表"><span class="l-line"></span>商品列表</a></dd>
						<dd><a href="javascript:;" data-url="${pageContext.request.contextPath }/adminProduct_addProductPage.action" data-id='7' data-text="添加商品"><span class="l-line"></span>添加商品</a></dd>
					</dl>
				</li>

				<li class="layui-nav-item">
					<a href="javascript:;"><i class="iconfont">&#xe608;</i>用户订单</a>
					<dl class="layui-nav-child">
						<dd><a href="javascript:;" data-url="${pageContext.request.contextPath }/adminOrder_orderListPage.action?page=1" data-id='8' data-text="订单列表"><span class="l-line"></span>订单列表</a></dd>
					</dl>
				</li>

				<li class="layui-nav-item">
					<a href="javascript:;" data-url="${pageContext.request.contextPath }/admin_adminInfoPage.action?uid=<s:property value="#session.admin.uid"/>" data-id='9' data-text="个人信息"><i class="iconfont">&#xe606;</i>个人信息</a>
				</li>

				<li class="layui-nav-item">
					<a href="${pageContext.request.contextPath }/admin_adminQuitLogin.action" data-id='10' data-text="退出登录"><i class="iconfont">&#xe606;</i>退出登录</a>
				</li>				
			</ul>
		</div>
		<!--右侧内容-->
		<div class="main-layout-container">
			<!--头部-->
			<div class="main-layout-header">
				<div class="menu-btn" id="hideBtn">
					<a href="javascript:;">
						<span class="iconfont">&#xe60e;</span>
					</a>
				</div>
				<ul class="layui-nav" lay-filter="rightNav">
					<li class="layui-nav-item">
						<a href="javascript:;" data-url="email.html" data-id='4' data-text="邮件系统">
							<i class="iconfont">&#xe603;</i>
						</a>
					</li>

					<li class="layui-nav-item">
						<!-- 管理员名称 -->
						<a href="javascript:;" data-url="#" data-id='5' data-text="管理员"><s:property value="#session.admin.username"/></a>
					</li>

					<li class="layui-nav-item">
						<a href="${pageContext.request.contextPath }/admin_adminQuitLogin.action">退出</a>
					</li>
				</ul>
			</div>
			<!--主体内容-->
			<div class="main-layout-body">
				<!--tab 切换-->
				<div class="layui-tab layui-tab-brief main-layout-tab" lay-filter="tab" lay-allowClose="true">
					<ul class="layui-tab-title">
						<li class="layui-this welcome">后台主页</li>
					</ul>
					<div class="layui-tab-content">
						<div class="layui-tab-item layui-show" style="background: #f5f5f5;">
							<!--1-->
							<iframe src="welcome.jsp" width="100%" height="100%" name="iframe" scrolling="auto" class="iframe" framborder="0"></iframe>
							<!--1end-->
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--遮罩-->
		<div class="main-mask"></div>
	</div>
	<script type="text/javascript">
		var scope={
			link:'./welcome.html'
		}
	</script>
	<script src="../../static/admin/layui/layui.js" type="text/javascript" charset="utf-8"></script>
	<script src="../../static/admin/js/common.js" type="text/javascript" charset="utf-8"></script>
	<script src="../../static/admin/js/main.js" type="text/javascript" charset="utf-8"></script>	
</body>
</html>
    