<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>更改口令</title>
<link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />
	<style>
		.updpwd{
			background-color: #2ae;
		}
		.login_btn{
			background-color: #9be;
			width: 99px;
			font-size: 14px;
			font-family: 微软雅黑;
		}
		.upd_pwd_msg{
			font-size: 14px;
			text-align: right;
		}
	</style>
	<script  type="text/javascript">
		function closeWindow(flag){
			if(flag == 'change'){
				//alert('修改完毕');
			}
			parent.window.opener = null;
			parent.close();
		}
	</script>
</head>

<body class="updpwd">
	<form action="/crm2/staff/staffAction_editPassword.action" method="post">
		<table style="width: 200px">
			<tr>
				<td colspan="2">
					<span id="msgId" class="upd_pwd_msg"> </span>
				</td>
			</tr>
			<tr>
				<td>原始密码：</td>
				<td><input type="password" name="oldPassword" value="" /></td>
			</tr>
			<tr>
				<td>新&nbsp;密&nbsp;码：</td>
				<td><input type="password" name="newPassword" value="" /></td>
			</tr>
			<tr>
				<td>确认密码：</td>
				<td><input type="password" name="reNewPassword" value="" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit"  value="修改" class="login_btn"/>

					<button type="reset" value="关闭" class="login_btn">关闭</button>

				</td>
			</tr>
		</table>
	</form>
</body>
</html>
