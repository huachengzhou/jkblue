<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
</head>
<body>
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
        var EncodefactoryName = $("#factoryName").val();
        var EncodefullName = $("#fullName").val();
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
    $(document).ready(function () {

    });
</script>
<form method="post" name="formJK">
	<input type="hidden" name="id" value="${obj.id}"/>

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
    <div id="navMenubar">
<ul>
<li id="save"><a href="#" onclick="formSubmitA('${pageContext.request.contextPath}/basicinfo/factory/update.action','_self');">确定</a></li>
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
		修改生产厂家信息
    </div> 
    </div>
    </div>
<div>
    <div>
		<table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle_mustbe">厂家名称：</td>
	            <td class="tableContent"><input type="text" id="fullName" name="fullName" value="${obj.fullName}"/></td>
	            <td class="columnTitle_mustbe">简称：</td>
	            <td class="tableContent"><input type="text" id="factoryName" name="factoryName" value="${obj.factoryName}"/></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">联系人：</td>
	            <td class="tableContent"><input type="text" id="contacts" name="contacts" value="${obj.contacts}"/></td>
	            <td class="columnTitle_mustbe">电话：</td>
	            <td class="tableContent"><input type="text" id="phone" name="phone" value="${obj.phone}"/></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">手机：</td>
	            <td class="tableContent"><input type="text" id="mobile" name="mobile" value="${obj.mobile}"/></td>
	            <td class="columnTitle_mustbe">传真：</td>
	            <td class="tableContent"><input type="text" id="fax" name="fax" value="${obj.fax}"/></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">验货员：</td>
	            <td class="tableContent"><input type="text" id="inspector" name="inspector" value="${obj.inspector}"/></td>
	            <td class="columnTitle_mustbe">排序号：</td>
	            <td class="tableContent"><input type="text" id="orderNo" name="orderNo" value="${obj.orderNo}"/></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">备注：</td>
	            <td class="tableContent"><textarea name="cnote" id="cnote" style="height:120px;">${obj.cnote}</textarea></td>
	        </tr>
		</table>
	</div>
</div>
 
 
</form>
</body>
</html>

