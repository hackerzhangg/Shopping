<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<title>商品详情</title>
<link href="${pageContext.request.contextPath}/css/common.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/product.css"
	rel="stylesheet" type="text/css" />

<style>
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
	//提交购物车
	function saveCart() {
		document.getElementById("cartForm").submit();
	}
</script>
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
				<a> <img
					src="${pageContext.request.contextPath}/image/logo3.png" alt="购物商城"
					style="width: 200px; height: 55px;" />
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
	<div class="container productContent">
		<div class="span6">
			<div class="hotProductCategory">
				<!-- 循环一级分类 -->
				<s:iterator var="c" value="#session.cList">
					<dl>
						<dt>
							<a
								href="${pageContext.request.contextPath}/product_findByCid.action?cid=<s:property value="#c.cid"/>&page=1"><s:property
									value="#c.cname" /></a>
						</dt>
						<!-- 循环一级分类对应的二级分类 -->
						<s:iterator var="cs" value="#c.categorySeconds">
							<dd>
								<a
									href="${pageContext.request.contextPath }/product_findByCsid.action?csid=<s:property value="#cs.csid"/>&page=1"><s:property
										value="#cs.csname" /></a>
							</dd>
						</s:iterator>
					</dl>
				</s:iterator>
			</div>
		</div>
		<div class="span18 last">
			<div class="productImage">
				<a title="" style="outline-style: none; text-decoration: none;"
					id="zoom"
					href="http://image/r___________renleipic_01/bigPic1ea8f1c9-8b8e-4262-8ca9-690912434692.jpg"
					rel="gallery">
					<div class="zoomPad">
						<img style="opacity: 1;" title="" class="medium"
							src="${pageContext.request.contextPath }/<s:property value="model.image" />" />
						<div
							style="display: block; top: 0px; left: 162px; width: 0px; height: 0px; position: absolute; border-width: 1px;"
							class="zoomPup"></div>
						<div
							style="position: absolute; z-index: 5001; left: 312px; top: 0px; display: block;"
							class="zoomWindow">
							<div style="width: 368px;" class="zoomWrapper">
								<div style="width: 100%; position: absolute; display: none;"
									class="zoomWrapperTitle"></div>
								<div style="width: 0%; height: 0px;" class="zoomWrapperImage">
									<img src=""
										style="position: absolute; border: 0px none; display: block; left: -432px; top: 0px;" />
								</div>
							</div>
						</div>
						<div
							style="visibility: hidden; top: 129.5px; left: 106px; position: absolute;"
							class="zoomPreload">Loading zoom</div>
					</div>
				</a>
			</div>
			<div class="name">
				<s:property value="model.pname" />
			</div>
			<div class="sn">
				<div>
					商品编号：
					<s:property value="model.pid" />
				</div>
			</div>
			<div class="info">
				<dl>
					<dt>商城价:</dt>
					<dd>
						<strong>￥：<s:property value="model.shop_price" />元/份
						</strong> 参 考 价：
						<del>
							￥
							<s:property value="model.market_price" />
							元/份
						</del>
					</dd>
				</dl>
				<dl>
					<dt>市场促销:</dt>
					<dd>
						<a target="_blank" title="限时抢购 (2014-07-30 ~ 2015-01-01)">限时抢购</a>
					</dd>
				</dl>
				<dl>
					<dt></dt>
					<dd>
						<span> </span>
					</dd>
				</dl>
			</div>
			<form id="cartForm"
				action="${pageContext.request.contextPath }/cart_addCart.action"
				method="post">
				<input type="hidden" name="pid"
					value="<s:property value="model.pid"/>" />
				<div class="action" style="background-color: #00FFFF;">
					<dl class="quantity">
						<dt>购买数量:</dt>
						<dd>
							<input id="count" name="count" value="1" maxlength="4"
								onpaste="return false;" type="text" />
							<div>
								<span id="increase" class="increase">&nbsp;</span> <span
									id="decrease" class="decrease">&nbsp;</span>
							</div>
						</dd>
						<dd>件</dd>
					</dl>
					<div class="buy">
						<input id="addCart" class="addCart" value="加入购物车" type="button"
							onclick="saveCart();" />

					</div>
				</div>
			</form>
			<div id="bar" class="bar">
				<ul>
					<li id="introductionTab"><a href="#introduction">商品介绍</a></li>
				</ul>
			</div>
			<div id="introduction" name="introduction" class="introduction">
				<div class="title">
					<strong><s:property value="model.pdesc" /></strong>
				</div>
				<div>
					<img
						src="${pageContext.request.contextPath }/<s:property value="model.image" />" />
				</div>
			</div>
		</div>
	</div>
	<div class="container footer">

		<div class="span24">
			<div class="footerAd">
				<img src="${pageContext.request.contextPath}/image/button.png"
					width="950" height="48" alt="我们的优势" title="我们的优势" />
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