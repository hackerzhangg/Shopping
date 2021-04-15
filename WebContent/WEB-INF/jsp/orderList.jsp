<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>订单列表</title>
<link href="${pageContext.request.contextPath }/css/common.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/css/cart.css"
	rel="stylesheet" type="text/css" />

<style type="text/css">
	.kw{
		width:180px;
		height:18px;
		padding:4px 7px;
		padding:6px 7px 2px\9;
		font:16px arial;
		background:url(http://www.baidu.com/img/i2.png) no-repeat;
		border:1px solid green;
		border-color:green;
		vertical-align:top
	}
	.btn{
		width:95px;
		height:28px;
		padding:0;
		padding-top:2px\9;
		border:0;
		background: url(http://www.baidu.com/img/i2.png) 0 -35px;
		cursor:pointer
	}
</style>
<script>
	//判断搜索框商品名称是否为空
	function checkPname(){
		
		var pname=document.getElementById("pname").value;		
		if(pname == null || pname == ''){
			
			alert("亲！ 请输入你想搜索的商品名称哦！");
			return false;
		}
	}
</script>
</head>
<body>

	<div class="container header">
		<div class="span5">
			<div class="logo">
				<a href="${pageContext.request.contextPath }/网上商城/index.htm"> <img
					src="${pageContext.request.contextPath }/image/logo3.png"
					alt="购物商城" style="width: 200px; height: 55px;" />
				</a>
			</div>
		</div>
		<div class="span9">
			<div class="headerAd">
				
				<form action="${pageContext.request.contextPath }/product_findConditionProduct.action" onsubmit="return checkPname();" method="post">
					<div style="position: relative;top: 20px;left: 50px;">
						<input name="pname" id="pname" class="kw" placeholder="请输入商品名称" type="text" maxLength="80" autocomplete="off"/>
						<input class="btn" type="submit" value="搜索" style="color: red;"/>
		             </div>
	             </form>
			</div>
		</div>
		<!-- 包含menu.jsp页面  -->
		<%@ include file="menu.jsp"%>
	</div>

	<div class="container cart">

		<div class="span24">

			<div class="step step1">
				<ul>
					<li class="current"></li>
					<li>订单列表</li>
				</ul>
			</div>
			<table>
				<tbody>
				<s:iterator var="order" value="pageBean.list">
					<tr>
						<th colspan="5">
							订单编号:<s:property value="#order.oid" />&nbsp;&nbsp;&nbsp;&nbsp;
							订单金额:<font color="red"><s:property value="#order.total"/></font>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<font color="red">
								<s:if test="#order.state == 1">
									<a href="${pageContext.request.contextPath }/order_findByOid.action?oid=<s:property value="#order.oid"/>">付款</a>
								</s:if>
								<s:if test="#order.state == 2">
									已付款
								</s:if>
								<s:if test="#order.state == 3">
									<a href="${pageContext.request.contextPath }/order_updateState.action?oid=<s:property value="#order.oid"/>">确认收货</a>
								</s:if>
								<s:if test="#order.state == 4">
									交易成功
								</s:if>
							</font>
						</th>
					</tr>
					<tr>
						<th>图片</th>
						<th>商品</th>
						<th>价格</th>
						<th>数量</th>
						<th>小计</th>
					</tr>
					<s:iterator var="orderItem" value="#order.orderItems">
						<tr>
							<td width="60"><img
								src="${pageContext.request.contextPath }/<s:property value="#orderItem.product.image" />" />
							</td>
							<td><a target="_blank"><s:property
										value="#orderItem.product.pname" /></a></td>
							<td><s:property value="#orderItem.product.shop_price" /></td>
							<td class="quantity" width="60"><s:property
									value="#orderItem.count" /></td>
							<td width="140"><span class="subtotal">￥<s:property
										value="#orderItem.subtotal" /></span></td>
						</tr>
					</s:iterator>
				</s:iterator>
					<tr>
						<th colspan="5">
							<div class="pagination">
								<span>第<s:property value="pageBean.page" />/<s:property
										value="pageBean.totalPage" />页
								</span>
								<!-- 判断当前是否为第一页  -->
								<s:if test="pageBean.page != 1">
									<a
										href="${ pageContext.request.contextPath }/order_findByUid.action?page=1"
										class="firstPage">&nbsp;</a>
									<a
										href="${ pageContext.request.contextPath }/order_findByUid.action?page=<s:property value="pageBean.page-1"/>"
										class="previousPage">&nbsp;</a>
								</s:if>
								<s:iterator var="i" begin="1" end="pageBean.totalPage">
									<s:if test="pageBean.page != #i">
										<a
											href="${ pageContext.request.contextPath }/order_findByUid.action?page=<s:property value="#i"/>"><s:property
												value="#i" /> </a>
									</s:if>
									<s:else>
										<span class="currentPage"><s:property value="#i" /> </span>
									</s:else>
								</s:iterator>
								<s:if test="pageBean.page != pageBean.totalPage">
									<a class="nextPage"
										href="${ pageContext.request.contextPath }/order_findByUid.action?page=<s:property value="pageBean.page+1"/>">&nbsp;</a>
									<a class="lastPage"
										href="${ pageContext.request.contextPath }/order_findByUid.action?page=<s:property value="pageBean.totalPage"/>">&nbsp;</a>
								</s:if>
							</div>
						</th>
					</tr>
				</tbody>
			</table>		
		</div>
	</div>
	<div class="container footer">

		<div class="span24">
			<div class="footerAd">
				<img src="${pageContext.request.contextPath }/image/button.png"
					width="950" height="48" alt="我们的优势" title="我们的优势">
			</div>
		</div>
		<div class="span24">
			<ul class="bottomNav">
				<li><a>关于我们</a> |</li>
				<li><a>联系我们</a> |</li>
				<li><a>联系客服</a> |</li>
				<li><a>合作招商</a> |</li>
				<li><a>商家帮助</a> |</li>
				<li><a target="_blank">营销中兴</a> |</li>
				<li><a target="_blank">手机商城</a> |</li>
				<li><a>友情链接</a> |</li>
				<li><a>销售联盟</a></li>
				<li><a>售后服务</a></li>
				<li><a>English Site</a></li>
				<li><a>隐私政策</a></li>
			</ul>
			<ul class="bottomNav">
				<li><a>互联网出版许可证编号新出网证（京）字150号</a> |</li>
				<li><a>大麦网</a> |</li>
				<li><a>京ICP证070359号</a> |</li>
				<li><a>支付宝</a> |</li>
				<li><a>网络文化经营许可证京网文[2014]2148-348号</a> |</li>
				<li><a target="_blank">营销中兴</a> |</li>
				<li><a target="_blank">手机商城</a> |</li>
				<li><a>开发平台</a> |</li>
				<li><a>（京）网械平台备字（2018）第00003号</a> |</li>
				<li><a>知识产权</a> |</li>
				<li><a>English Site</a> |</li>
				<li><a>消费者维权热线：4006067733</a> |</li>
			</ul>
		</div>
		<div class="span24">
			<div class="copyright">商城平台备字[2020]第00004号 网上商城 版权所有</div>
		</div>
	</div>
</body>
</html>