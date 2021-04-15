<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0048)http://localhost:8080/mango/product/list/1.jhtml -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>商品列表</title>
<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/product.css" rel="stylesheet" type="text/css" />

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
				<a href="http://localhost:8080/mango/"> <img
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
	<div class="container productList">
		<div class="span6">
			<div class="hotProductCategory">
			<!-- 循环一级分类 -->
			<s:iterator var="c" value="#session.cList">
				<dl>
					<dt>
						<a href="${pageContext.request.contextPath}/product_findByCid.action?cid=<s:property value="#c.cid"/>&page=1"><s:property value="#c.cname"/></a>
					</dt>
					<!-- 循环一级分类对应的二级分类 -->
					<s:iterator var="cs" value="#c.categorySeconds">
						<dd>
							<a href="${pageContext.request.contextPath }/product_findByCsid.action?csid=<s:property value="#cs.csid"/>&page=1"><s:property value="#cs.csname"/></a>
						</dd>
					</s:iterator>
				</dl>
			</s:iterator>				
			</div>
		</div>
		<div class="span18 last">
			<form id="productForm"
				action="" method="get">
				<div id="result" class="result table clearfix">
					<ul>
						<s:iterator var="p" value="pageBean.list">
							<li><a
								href="${ pageContext.request.contextPath }/product_findByPid.action?pid=<s:property value="#p.pid"/>">
									<img
									src="${pageContext.request.contextPath}/<s:property value="#p.image"/>"
									width="170" height="170" style="display: inline-block;" /> <span
									style='color:green'> <s:property value="#p.pname" /> </span> <span
									class="price"> 商城价： ￥<s:property value="#p.shop_price" />
								</span> </a></li>
						</s:iterator>
					</ul>
				</div>
				<div class="pagination">
					<span>
						第 <s:property value="pageBean.page" />/<s:property value="pageBean.totalPage" /> 页
					</span>
					<!-- 判断是否通过一级分类的cid查询商品：cid是否为空  -->
					<s:if test="cid != null">
						<!-- 如果当前页数不等于1 -->
						<s:if test="pageBean.page != 1">
							<!-- 当前第一页 -->
							<a
								href="${ pageContext.request.contextPath }/product_findByCid.action?cid=<s:property value="cid"/>&page=1"
								class="firstPage">&nbsp;</a>
							<!-- 点击上一页 -->
							<a
								href="${ pageContext.request.contextPath }/product_findByCid.action?cid=<s:property value="cid"/>&page=<s:property value="pageBean.page-1"/>"
								class="previousPage">&nbsp;</a>
						</s:if>
						
						<!-- 循环显示总页数 -->
						<s:iterator var="i" begin="1" end="pageBean.totalPage">
							<!-- 如果当前页数不等于循环的值 ，提供分页链接  -->
							<s:if test="pageBean.page != #i">
								<a
									href="${ pageContext.request.contextPath }/product_findByCid.action?cid=<s:property value="cid"/>&page=<s:property value="#i"/>"><s:property
										value="#i" />
								</a>
							</s:if>
							<!-- 若处于当前页面，则不可以点击  -->
							<s:else>
								<span class="currentPage">
									<s:property value="#i"/>
								</span>
							</s:else>
						</s:iterator>
						
						<!-- 如果当前页数不等于总页数  -->
						<s:if test="pageBean.page != pageBean.totalPage">
							<!-- 点击下一页 -->
							<a class="nextPage"
								href="${ pageContext.request.contextPath }/product_findByCid.action?cid=<s:property value="cid"/>&page=<s:property value="pageBean.page+1"/>">&nbsp;</a>
								<!-- 点击最后一页 -->
							<a class="lastPage"
								href="${ pageContext.request.contextPath }/product_findByCid.action?cid=<s:property value="cid"/>&page=<s:property value="pageBean.totalPage"/>">&nbsp;</a>
						</s:if>
					</s:if>
					
					<!-- 判断是否通过二级分类的csid查询商品：csid是否为空  -->
					<s:if test="csid != null">
						<!-- 如果当前页数不等于1 -->
						<s:if test="pageBean.page != 1">
							<!-- 当前第一页 -->
							<a
								href="${ pageContext.request.contextPath }/product_findByCsid.action?csid=<s:property value="csid"/>&page=1"
								class="firstPage">&nbsp;</a>
							<!-- 点击上一页 -->
							<a
								href="${ pageContext.request.contextPath }/product_findByCsid.action?csid=<s:property value="csid"/>&page=<s:property value="pageBean.page-1"/>"
								class="previousPage">&nbsp;</a>
						</s:if>
						
						<!-- 循环显示总页数 -->
						<s:iterator var="i" begin="1" end="pageBean.totalPage">
							<!-- 如果当前页数不等于循环的值 ，提供分页链接  -->
							<s:if test="pageBean.page != #i">
								<a
									href="${ pageContext.request.contextPath }/product_findByCsid.action?csid=<s:property value="csid"/>&page=<s:property value="#i"/>"><s:property
										value="#i" />
								</a>
							</s:if>
							<!-- 若处于当前页面，则不可以点击  -->
							<s:else>
								<span class="currentPage">
									<s:property value="#i"/>
								</span>
							</s:else>
						</s:iterator>
						
						<!-- 如果当前页数不等于总页数  -->
						<s:if test="pageBean.page != pageBean.totalPage">
							<!-- 点击下一页 -->
							<a class="nextPage"
								href="${ pageContext.request.contextPath }/product_findByCsid.action?csid=<s:property value="csid"/>&page=<s:property value="pageBean.page+1"/>">&nbsp;</a>
							<!-- 点击最后一页 -->
							<a class="lastPage"
								href="${ pageContext.request.contextPath }/product_findByCsid.action?csid=<s:property value="csid"/>&page=<s:property value="pageBean.totalPage"/>">&nbsp;</a>
						</s:if>
					</s:if>
				</div>
			</form>
		</div>
	</div>
	<div class="container footer">

		<div class="span24">
			<div class="footerAd">
				<img src="${pageContext.request.contextPath}/image/button.png" width="950" height="48" alt="我们的优势"
					title="我们的优势"/>
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