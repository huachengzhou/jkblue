<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
	<!-- 必须在引入bootstrap之前先引入jquery模块 -->
	<!-- The jQuery module must be introduced before the introduction of bootstrap -->
	<script src="${pageContext.request.contextPath}/components/jquery-module/jquery-mini/jquery-1.9.1.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/components/module-bootstrap/laydate/laydate.js" type="text/javascript"></script>

	<!-- 必须在bootstrap之前先引入tether模块 -->
	<!-- The tether module must be introduced before bootstrap -->
	<script src="${pageContext.request.contextPath}/components/module-bootstrap/tether/tether-1.3.3/dist/js/tether.min.js" type="text/javascript"></script>
	<link href="${pageContext.request.contextPath}/components/module-bootstrap/tether/tether-1.3.3/dist/css/tether.min.css" rel="stylesheet" type="text/css">

	<!-- 引入bootstrap模块 -->
	<!-- Introducing bootstrap module -->
	<link href="${pageContext.request.contextPath}/components/module-bootstrap/bootstrap-4.0.0-alpha.6-dist/css/bootstrap.css" rel="stylesheet" type="text/css">
	<script src="${pageContext.request.contextPath}/components/module-bootstrap/bootstrap-4.0.0-alpha.6-dist/js/bootstrap.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/components/module-bootstrap/bootstrap-4.0.0-alpha.6-dist/js/popper.min.js"></script>

</head>
<script>
    //yyyy-MM-dd被固定了
    laydate.render({
        elem: '#demoLayDate' //指定元素 id
    });
</script>
<script>
    function formSubmitA (url,sTarget){
		var formJK = document.forms["formJK"];
		formJK.action = url;
		var contacts = $("#contacts").val();
		var phone = $("#phone").val();
		var mobile = $("#mobile").val();
		var fax = $("#fax").val();
		var inspector = $("#inspector").val();
		var orderNo = $("#orderNo").val();
		var cnote = $("#cnote").val();
		var EncodefactoryName = $("#EncodefactoryName").val();
		var EncodefullName = $("#EncodefullName").val();
		if (isNull(contacts)){
			if (isNull(phone))if (isNull(phone))if (isNull(mobile))if (isNull(fax))
				if (isNull(inspector)) if (isNull(orderNo))if (isNull(cnote)){
					if (isNull(EncodefactoryName)){
						if (isNull(EncodefullName)){
							formJK.submit();
						}
					}
				}
		}
    }
    function isNull(data) {
        var str = data;
        console.log(str);
		if(str!=null){
		    if (str!=''){
		        if (str.length>0){
		            return true;
				}else {
                    alert("数据未填写或者填写数据不符合约定");
                    console.log("error!");
				}
			}else {
                alert("数据未填写或者填写数据不符合约定");
                console.log("error!");
			}
		}else {
		    alert("数据未填写或者填写数据不符合约定");
		    console.log("error!");
		}
    }
</script>
<body>
<form method="post" name="formJK">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
    <div id="navMenubar">
<ul>
<li id="save"><a href="#" onclick="formSubmitA('${pageContext.request.contextPath}/basicinfo/factory/insert.action','_self');">确定</a></li>
<li id="back"><a href="${pageContext.request.contextPath}/basicinfo/factory/list.action">返回</a></li>
</ul>
    </div>
</div>
</div>
</div>
     
<div class="textbox" id="centerTextbox">
    
    <div class="textbox-header">
    <div class="textbox-inner-header">
    <div class="textbox-title">
		新增生产厂家信息
    </div> 
    </div>
    </div>
<div>
    <div>
		<table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle_mustbe">厂家名称：</td>
	            <td class="tableContent"><input type="text" name="fullName" id="EncodefullName"/></td>
	            <td class="columnTitle_mustbe">简称：</td>
	            <td class="tableContent"><input type="text" name="factoryName" id="EncodefactoryName"/></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">联系人：</td>
	            <td class="tableContent"><input type="text" id="contacts" name="contacts"/></td>
	            <td class="columnTitle_mustbe">电话：</td>
	            <td class="tableContent"><input type="text" id="phone" name="phone"/></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">手机：</td>
	            <td class="tableContent"><input type="text" id="mobile" name="mobile"/></td>
	            <td class="columnTitle_mustbe">传真：</td>
	            <td class="tableContent"><input type="text" id="fax" name="fax"/></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">验货员：</td>
	            <td class="tableContent"><input type="text" id="inspector" name="inspector"/></td>
	            <td class="columnTitle_mustbe">排序号：</td>
	            <td class="tableContent"><input type="text" id="orderNo" name="orderNo"/></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">备注：</td>
	            <td class="tableContent"><textarea name="cnote" id="cnote" style="height:120px;"></textarea></td>
	        </tr>
		</table>
	</div>
</div>
 
 
</form>
</body>
</html>

