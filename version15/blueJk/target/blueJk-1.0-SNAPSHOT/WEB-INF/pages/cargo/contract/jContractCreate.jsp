<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
    <script type="text/javascript" src="../../js/datepicker/WdatePicker.js"></script>
	<script src="${pageContext.request.contextPath}/components/jquery-module/jquery-mini/jquery-1.9.1.min.js" type="text/javascript"></script>
</head>
<body>
	<script>

        function formSubmitA (){
            var formJK = document.forms["formJK"];
            formJK.action = "${pageContext.request.contextPath}/cargo/contract/insert.action";
			var inputBy = $("#inputBy").val();
			var checkBy = $("#checkBy").val();
			var crequest = $("#crequest").val();
			var remark = $("#remark").val();
			var inspector = $("#inspector").val();
			var tradeTerms = $("#tradeTerms").val();
			var shipTime = $("#shipTime").val();
			var deliveryPeriod = $("#deliveryPeriod").val();
			var signingDate = $("#signingDate").val();
			var contractNo = $("#contractNo").val();
			var offeror = $("#offeror").val();
			var customName = $("#customName").val();
			if (isNull(inputBy)&&isNull(checkBy)&&isNull(crequest)&&isNull(remark)){
			    if (isNull(tradeTerms)&&isNull(inspector)){
			        if (isNull(shipTime)&&isNull(deliveryPeriod)&&isNull(signingDate)){
			            if (isNull(contractNo)&&isNull(offeror)&&isNull(customName)){
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

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
    <div id="navMenubar">
<ul>
<li id="save"><a onclick="formSubmitA()">确定</a> </li>
<li id="back"><a href="${pageContext.request.contextPath}/cargo/contract/list.action">返回</a></li>
</ul>
    </div>
</div>
</div>
</div>

<div class="textbox" id="centerTextbox">

    <div class="textbox-header">
    <div class="textbox-inner-header">
    <div class="textbox-title">
		新增购销合同信息
    </div>
    </div>
    </div>
<div>
    <div>
		<table class="commonTable" cellspacing="1">
		<form method="post"  name="formJK">
	        <tr>
	            <td class="columnTitle_mustbe">客户名称：</td>
	            <td class="tableContent"><input type="text" id="customName" name="customName"/></td>
	            <td class="columnTitle_mustbe">收购方：</td>
	            <td class="tableContent"><input id="offeror" type="text" name="offeror" value="杰信商贸有限公司"/></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">合同号：</td>
	            <td class="tableContent"><input type="text" id="contractNo" name="contractNo"/></td>
	            <td class="columnTitle_mustbe">打印版式：</td>
	            <td class="tableContentAuto">
	            	<input type="radio" name="printStyle" value="2" class="input" checked>两款
	            	<input type="radio" name="printStyle" value="1" class="input">一款
	            </td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">签单日期：</td>
	            <td class="tableContent">
					<input type="text" style="width:90px;" name="signingDate" id="signingDate"
	             			onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'});"/>
				</td>
	            <td class="columnTitle_mustbe">重要程度：</td>
	            <td class="tableContentAuto">
	            	<input type="radio" name="importNum" value="3" class="input" checked>★★★
	            	<input type="radio" name="importNum" value="2" class="input">★★
	            	<input type="radio" name="importNum" value="1" class="input">★
	            </td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">交货期限：</td>
	            <td class="tableContent">
					<input type="text" id="deliveryPeriod" style="width:90px;" name="deliveryPeriod"
	             			onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'});"/>
				</td>
	            <td class="columnTitle_mustbe">船期：</td>
	            <td class="tableContent">
					<input type="text" id="shipTime" style="width:90px;" name="shipTime"
	             			onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'});"/>
				</td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">贸易条款：</td>
	            <td class="tableContent"><input type="text" id="tradeTerms" name="tradeTerms"/></td>
	            <td class="columnTitle_mustbe">验货员：</td>
	            <td class="tableContent"><input type="text" id="inspector" name="inspector"/></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">制单人：</td>
	            <td class="tableContent"><input id="inputBy" type="text" name="inputBy"/></td>
	            <td class="columnTitle_mustbe">审单人：</td>
	            <td class="tableContent"><input id="checkBy" type="text" name="checkBy"/></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">要求：</td>
	            <td class="tableContent"><textarea id="crequest" name="crequest" style="height:120px;"></textarea></td>
	            <td class="columnTitle_mustbe">说明：</td>
	            <td class="tableContent"><textarea id="remark" name="remark" style="height:120px;"></textarea></td>
	        </tr>
		</form>
		</table>
	</div>
</div>


</body>
</html>

