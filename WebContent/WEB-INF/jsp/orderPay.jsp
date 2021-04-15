<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 导入ognl表达式  -->
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>付款页面</title>
<style type="text/css">
	body{
		background-color: #F0F8FF;
	}
	.biggest{
		width: 600px;
		height: 700px;
		border: 1 black;
		margin: 0 auto;
	}
	.left{
		width: 145px;
		height: 700px;
		border: 1 black;
		float: left;
	}
	.right{
		width: 450px;
		height: 700px;
		border: 1 black;
		float: left;
	}
</style>
<script type="text/javascript">
	alert("亲， 您的订单支付成功！");
</script>
<script type="text/javascript">
	var num = 4; //倒计时的秒数
    var URL = "${pageContext.request.contextPath }/order_callBackPage.action?oid=<s:property value="uOrders.oid"/>";
    window.setTimeout("doUpdate()", 1000);
    function doUpdate(){
        if(num != 0){
            document.getElementById('page_div').innerHTML = '将在'+num+'秒后自动跳转到订单列表' ;
            num --;
            window.setTimeout("doUpdate()", 1000);
        }else{
            num = 4;
            window.location = URL;
        }
    }
</script>
</head>
<body>
	
	<div class="biggest">
		<div class="left">
			<img src="${pageContext.request.contextPath}/images/f23.png" style="width: 170px;height: 140px;position: relative;top: 150px;right: 50px; ">
		</div>
		<div class="right">
			<h2>付款成功，请仔细查看订单信息！</h2>
			<h3>订单编号：<s:property value="uOrders.oid"/></h3>
			<h3>订单用户：<s:property value="uOrders.name"/></h3>
			<h3>订单总价：<span style="color: red"><s:property value="uOrders.total"/>￥</span></h3>
			<h3>订单创建时间：<s:property value="uOrders.ordertime"/></h3>
			<h3>用户收货地址：<s:property value="uOrders.address"/></h3>
			<h3>用户收货电话：<s:property value="uOrders.phone"/></h3>
			<a href="${pageContext.request.contextPath }/order_callBackPage.action?oid=<s:property value="uOrders.oid"/>">手动回到订单页面</a>
			<p id="page_div">将在<span style="color: red">5</span>秒后自动跳转到订单列表</p>
		</div>
	</div>
</body>
</html>