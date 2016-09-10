<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/sys.css" type="text/css"/>
<title>班级管理</title>
</head>

<body>
<!--距离页面顶端5px-->
<table border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td class="topg"></td>
  </tr>
</table>
<form name="createForm" action="" method="post">
<table border="0" cellspacing="0" cellpadding="0" class="wukuang">
  <tr>
    <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
    <td width="20%" align="left">[班级管理]</td>
    <td width="42%"align="center">&nbsp;</td>
    <td width="36%"align="right">
    	<%--添加班级  /html/classesm/addClass.jsp--%>
    	<s:a namespace="/" action="classesAction_addOrEditUI">
    		<img src="${pageContext.request.contextPath}/images/button/tianjia.gif" class="img"/>
    	</s:a>
    	<%--高级查询 
        <a href="queryClass.html"><img src="${pageContext.request.contextPath}/images/button/gaojichaxun.gif" class="img"/></a>
    	--%>
    </td>
    <td width="1%"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>
</form>
<table border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td class="topg"></td>
  </tr>
</table>
<table border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td ><img src="${pageContext.request.contextPath}/images/result.gif"/></td>
  </tr>
</table>

<table width="97%" border="1">
<thead>
  <tr class="henglan" style="font-weight:bold;">
	<th width="150px" align="center">班级名称</th>
    <th width="200px" align="center">所属课程</th>
    <th width="150px" align="center">开班时间</th>
    <th width="150px" align="center">毕业时间</th>
    
    <th width="80px" align="center">状态</th>
    <th width="70px" align="center">学生总数</th>
    <th width="70px" align="center">升学数</th>
    <th width="70px" align="center">转班数</th>
    <th width="50px" align="center">编辑</th>
	<th width="50px" align="center">查看</th>
	<th align="center">课表</th>
  </tr>
  </thead>
  <tbody>
  	<s:iterator value="allClass" status="vs">
	  <tr class="<s:property value="#vs.odd ? 'tabtd1' : 'tabtd2' " />">
	    <td align="center"><s:property value="name" /> </td>
	    <td align="center"><s:property value="crmLessontype.lessonName" /> </td>
	    <td align="center"><s:property value="beginTime" /> </td>
	    <td align="center"><s:property value="endTime" /> </td>
	    <td align="center"><s:property value="state" /> </td>
	    <td align="center"><s:property value="totalCount" /> </td>
	    <td align="center"><s:property value="goCount" /> </td>
	    <td align="center"><s:property value="leaveCount" /> </td>
	    
	    <td align="center">
	    	<%--编辑 --%>
	    	<s:a namespace="/" action="classesAction_addOrEditUI">
	    		<s:param name="classId" value="classId"></s:param>
	    		<img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img"/>
	    	</s:a>
	    </td>
		<td align="center">
	    	<a href="${pageContext.request.contextPath}/pages/classesm/showClass.jsp"><img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img"/></a>
		</td>
		<td align="center" >
			<%--上传 --%>
			<s:a namespace="/" action="classesAction_uploadUI">
				<s:param name="classId" value="classId"></s:param>
				上传
			</s:a>
			
			<s:if test="uploadFileName != null">
				<s:a namespace="/" action="classesAction_download">
					<s:param name="classId" value="classId"></s:param>
					下载
				</s:a>
			</s:if>
			<s:else>
				
			</s:else>
		</td>
	  </tr>
  	</s:iterator>
  </tbody>
</table>


<table border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td align="right">
    	<span>第1/3页</span>
        <span>
        	<a href="#">[首页]</a>&nbsp;&nbsp;
            <a href="#">[上一页]</a>&nbsp;&nbsp;
            <a href="#">[下一页]</a>&nbsp;&nbsp;
            <a href="#">[尾页]</a>
        </span>
    </td>
  </tr>
</table>

</body>
</html>
