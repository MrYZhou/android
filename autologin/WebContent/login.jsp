<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="login" method="post">
		帐号：<input type="text" name="loginid"><br>
		密码：<input type="password" name="pwd"><br>
		<input type="checkbox" name="autologin" value="yes" >
		<input type="submit" value="提交">
	</form>
</body>
</html>