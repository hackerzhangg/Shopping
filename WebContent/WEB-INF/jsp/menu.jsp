<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<div class="span10 last">
	<div class="topNav clearfix">
		<ul>
		   <s:if test="#session.existUser == null">
		   		<li id="headerLogin" class="headerLogin" style="display: list-item;">
					<a
					href="${ pageContext.request.contextPath }/admin_adminUserLoginPage.action">后台管理</a>|</li>
				<li id="headerLogin" class="headerLogin" style="display: list-item;">
					<a
					href="${ pageContext.request.contextPath }/user_loginPage.action">登录</a>|</li>
				<li id="headerRegister" class="headerRegister"
					style="display: list-item;"><a
					href="${ pageContext.request.contextPath }/user_registerPage.action">注册</a>|
				</li>
			</s:if>
			<s:else>
				<li id="headerLogin" class="headerLogin" style="display: list-item;">
					<s:property value="#session.existUser.name" /> |</li>
				<li id="headerLogin" class="headerLogin" style="display: list-item;">
					<a
					href="${ pageContext.request.contextPath }/order_findByUid.action?page=1">我的订单</a>
					|</li>
				<li id="headerRegister" class="headerRegister"
					style="display: list-item;"><a
					href="${ pageContext.request.contextPath }/user_updateUserInformationPage.action?uid=${existUser.uid }">用户信息</a>|
				</li>
				<li id="headerRegister" class="headerRegister"
					style="display: list-item;"><a
					href="${ pageContext.request.contextPath }/user_userQuit.action">退出</a>|
				</li>
			 </s:else>
			
			<!-- <li><a>会员中心</a> |</li> -->
			<li><a>购物指南</a> |</li>
			<li><a>关于我们</a></li>
		</ul>
	</div>
	<div class="cart">
		<a href="${pageContext.request.contextPath }/cart_MyCart.action" style="color: red;">购物车</a>
	</div>
	<div class="phone" style="background-color: darkseagreen;">
		客服热线: <strong>96008/53277764</strong>
	</div>
</div>
<div class="span24">
	<ul class="mainNav" style="background-color: slategray;">
		<li>
			<a href="${pageContext.request.contextPath }/index.action">首页</a> |
		</li>
		<!-- 显示一级分类名称 -->
		<s:iterator var="c" value="#session.cList">
			<li>
				<a href="${pageContext.request.contextPath }/product_findByCid.action?cid=<s:property value="#c.cid"/>&page=1"><s:property value="#c.cname" /></a> |
			</li>
		</s:iterator>
	</ul>
</div>