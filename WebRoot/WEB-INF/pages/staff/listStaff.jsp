<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>

<link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />
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
		<a href="javascript:void(0)" onclick="condition()"><img src="${pageContext.request.contextPath}/images/button/gaojichaxun.gif" /></a>
    	<%--员工注入 
    		* /pages/staff/addStaff.jsp
	  	<a href="${pageContext.request.contextPath}/uiAction_staff_addStaff">
	  		<img src="${pageContext.request.contextPath}/images/button/tianjia.gif" />
	  	</a>
    	--%>
	  	<s:a namespace="/" action="staffAction_addUI">
	  		<img src="${pageContext.request.contextPath}/images/button/tianjia.gif" />
	  	</s:a>
      
    </td>
    <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>

<!-- 查询条件：马上查询 -->
<form id="conditionFormId" action="${pageContext.request.contextPath}/staff/staffAction_findAll" method="post">
	<table width="88%" border="0" style="margin: 20px;" >
	  <tr>
	    <td width="80px">部门：</td>
	    <td width="200px">
	    	
	    	<select name="crmPost.crmDepartment.depId" onchange="changePost(this)">
			    <option value="">--请选择部门--</option>
			    <option value="2c9091c14c78e58b014c78e67de10001">java学院</option>
			    <option value="2c9091c14c78e58b014c78e68ded0002">咨询部</option>
			</select>

	    </td>
	    <td width="80px" >职务：</td>
	    <td width="200px" >
	    	
	    	<select name="crmPost.postId" id="postSelectId">
			    <option value="">--请选择职务--</option>
			    <option value="2c9091c14c78e58b014c78e6b34a0003">总监</option>
			    <option value="2c9091c14c78e58b014c78e6d4510004">讲师</option>
			    <option value="2c9091c14c78e58b014c78e6f2340005">主管</option>
			</select>

	    </td>
	    <td width="80px">姓名：</td>
	    <td width="200px" ><input type="text" name="staffName" size="12" /></td>
	    <td ></td>
	  </tr>
	</table>
</form>


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
  	
    <s:iterator value="#allStaff" status="vs">
	  <tr class="<s:property value="#vs.odd ? 'tabtd1' : 'tabtd2'" />"> 
	    <td align="center"><s:property value="staffName"/> </td>
	    <td align="center"><s:property value="gender"/> </td>
	    <td align="center"><s:property value="onDutyDate"/> </td>
	    <td align="center"><s:property value="crmPost.crmDepartment.depName"/> </td>
	    <td align="center"><s:property value="crmPost.name"/> </td>
	  	<td width="7%" align="center">
	  		
	  		<a href="${pageContext.request.contextPath}/pages/staff/editStaff.jsp"><img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img" /></a>	
	  	</td>
	  </tr>
    </s:iterator>
</table>

</body>
</html>
