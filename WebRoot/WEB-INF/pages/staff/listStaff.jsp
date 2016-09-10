<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>

<link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />
	<!-- 引入自定义 js 类库 -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/myQuery.js"></script>
	<!-- 编写js工具类 -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
	
</head>

<body >
 <table border="0" cellspacing="0" cellpadding="0" width="100%">
  <tr>
    <td class="topg"></td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0"  class="wukuang"width="100%">
  <tr>
    <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
    <td width="39%" align="left">[员工管理]</td>
   
    <td width="57%"align="right">
    	<%--高级查询 --%>
		<a href="javascript:void(0)" onclick="document.forms[0].submit()" ><img src="${pageContext.request.contextPath}/images/button/gaojichaxun.gif" /></a>

	  	<s:a namespace="/" action="staffAction_addUI">
	  		<img src="${pageContext.request.contextPath}/images/button/tianjia.gif" />
	  	</s:a>
      
    </td>
    <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>

<!-- 查询条件：马上查询 -->
<s:form namespace="/" action="staffAction_findAll">

	<table width="88%" border="0" style="margin: 20px;" >
	  <tr>
	    <td width="80px">部门：</td>
	    <td width="200px">
			<s:select list="#allDepartment" name="crmPost.crmDepartment.depId"
				listKey="depId" listValue="depName"
				headerKey="" headerValue="--请选择部门--"
				onchange="changePost(this,'postSelectId');"
			>
			
			</s:select>

	    </td>
	    <td width="80px" >职务：</td>
	    <td width="200px" >
	    	
			<s:select list="#allPost != null ? #allPost : {} " name="crmPost.postId" id="postSelectId"
				listKey="postId" listValue="name"
				headerKey="" headerValue="----请选择职务----"
			></s:select>

	    </td>
	    <td width="80px">姓名：</td>
	    <td width="200px" ><s:textfield name="staffName" size="12"></s:textfield></td>
	    <td ></td>
	  </tr>
	</table>
</s:form>


<table border="0" cellspacing="0" cellpadding="0" style="margin-top:5px;">
  <tr>
    <td ><img src="${pageContext.request.contextPath}/images/result.gif"/></td>
  </tr>
</table>

<table width="100%" border="1" >
  <tr class="henglan" style="font-weight:bold;">
    <td width="10%" align="center">员工姓名</td>
    <td width="6%" align="center">性别</td>
    <td width="12%" align="center">入职时间</td>
    <td width="15%" align="center">所属部门</td>
    <td width="10%" align="center">职务</td>
    <td width="10%" align="center">编辑</td>
  </tr>
  	<%-- 单行样式：tabtd1； 双行演样式：tabtd2 --%>
    <s:iterator value="#allStaff" status="vs">
	  <tr class="<s:property value="#vs.odd ? 'tabtd1' : 'tabtd2'" />"> 
	    <td align="center"><s:property value="staffName"/> </td>
	    <td align="center"><s:property value="gender"/> </td>
	    <td align="center"><s:property value="onDutyDate"/> </td>
	    <td align="center"><s:property value="crmPost.crmDepartment.depName"/> </td>
	    <td align="center"><s:property value="crmPost.name"/> </td>
	  	<td width="7%" align="center">
	  		<s:a namespace="/" action="staffAction_EditUI">
	    		<s:param name="staffId" value="staffId"></s:param>
	    		<img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img"/>
	    	</s:a>
	  		
	  	</td>
	  </tr>
    </s:iterator>
</table>

</body>
</html>
