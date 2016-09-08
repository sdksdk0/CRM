<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>CRM系统</title>
</head>

<frameset rows="100,*" framespacing="0px" frameborder="no">
	<frame src="${pageContext.request.contextPath}/uiAction_frame_top" scrolling="no"/>
    <frameset id="main" cols="170,9,*" framespacing="0px" frameborder="no" >
        <frameset rows="30,*,40" framespacing="0px" frameborder="no" >
			<frame src="${pageContext.request.contextPath}/uiAction_frame_left1" scrolling="no"/>
            <frame src="${pageContext.request.contextPath}/uiAction_frame_left" scrolling="yes"/>
            <frame src="${pageContext.request.contextPath}/uiAction_frame_left2" scrolling="no"/>
        </frameset>
        <frame src="${pageContext.request.contextPath}/uiAction_frame_control" scrolling="no"/>
        <frame src="${pageContext.request.contextPath}/uiAction_frame_right" name="right" scrolling="no"/>
	</frameset>
</frameset>
</html>
