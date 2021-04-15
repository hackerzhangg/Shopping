<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>购物商城首页</title>
<link href="${pageContext.request.contextPath}/css/slider.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/common.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/index.css"
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
				<a href="${pageContext.request.contextPath}/网上商城/index.htm">
					<img src="${pageContext.request.contextPath}/image/logo3.png"
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

	<div class="container index">
		<div class="span24">
			<div id="hotProduct" class="hotProduct clearfix">
				<div class="title" style="background-color:#90EE90;">
					<strong>热门商品</strong>					
				</div>
				<ul class="tab" style="background-color:#90EE90;">					
				</ul>
				<ul class="tabContent" style="display: block;">
					<!-- 显示热门商品 -->
					<s:iterator var="hot" value="hotList">
						<li>
							<a target="_blank" href="${ pageContext.request.contextPath }/product_findByPid.action?pid=<s:property value="#hot.pid"/>">
								<img src="${pageContext.request.contextPath}/<s:property value="#hot.image"/>" style="display: block;"/>
								<span style='color:green'>
										<s:property value="#hot.pname"/>
								 </span>
								 <br/>
								 <span class="price" style='color:red'>
									 商城价： ￥<s:property value="#hot.shop_price"/>/份
								 </span>
								 <br/>
								 <span class="price" style='color:rosybrown'>
									 市场价： ￥<del><s:property value="#hot.market_price"/></del>/份
								 </span>
							</a>
						</li>
					</s:iterator>
				</ul>
			</div>
		</div>
		<div class="span24">
			<div id="newProduct" class="newProduct clearfix">
				<div class="title" style="background-color:#87CEEB;">
					<strong>最新商品</strong> <a target="_blank"></a>
				</div>
				<ul class="tab" style="background-color:#87CEEB;">					
				</ul>	
				<ul class="tabContent" style="display: block;">
					<!-- 显示最新商品 -->
					<s:iterator var="news" value="newList">
						<li>
							<a target="_blank" href="${ pageContext.request.contextPath }/product_findByPid.action?pid=<s:property value="#news.pid"/>">
								<img src="${pageContext.request.contextPath}/<s:property value="#news.image"/>" style="display: block;"/>
								<span style='color:green'>
									<s:property value="#news.pname"/>
								</span>
								 <br/>
								<span class="price" style='color:red'>
									 商城价： ￥<s:property value="#news.shop_price"/>/份
								</span>
								 <br/>
								<span class="price" style='color:rosybrown'>
									 市场价： ￥<del><s:property value="#news.market_price"/></del>/份
								</span>
							</a>
						</li>
					</s:iterator>
				</ul>
			</div>
		</div>
		<div class="span24">
			<div class="friendLink" style="background-color: #40E0D0;">
				<dl>
					<dt style="background-color: #9ACD32;">新手指南</dt>
					<dd>
						<a target="_blank">购物流程</a> |
					</dd>
					<dd>
						<a target="_blank">会员介绍</a> |
					</dd>
					<dd>
						<a target="_blank">生活旅行</a> |
					</dd>
					<dd>
						<a target="_blank">常见问题</a> |
					</dd>
					<dd>
						<a target="_blank">大家电</a> |
					</dd>
					<dd>
						<a target="_blank">联系客服</a> |
					</dd>
					<dd>
						<a target="_blank">价格保护</a> |
					</dd>
					<dd>
						<a target="_blank">退款说明</a> |
					</dd>
					<dd>
						<a target="_blank">延保服务</a> |
					</dd>
					<dd>
						<a target="_blank">京东通信</a> |
					</dd>

					<dd class="more" style="background-color: #9ACD32;">
						<a>更多</a>
					</dd>
				</dl>
			</div>
		</div>
	</div>
	<div class="container footer">
		<div class="span24">
			<div class="footerAd">
				<!-- <img src="${pageContext.request.contextPath}/image/footer.jpg" width="950" height="52" alt="我们的优势" title="我们的优势"> -->
				<img src="${pageContext.request.contextPath}/image/button.png"
					width="950" height="48" alt="我们的优势" title="我们的优势"/>
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