<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Task</title>
</head>
<body>
新規登録
<form action="/Task/RegisterServlet" method="post">
ユーザーID<input type="text" name="userId">
パスワード<input type="password" name="pass">
メールアドレス<input type="text" name="mail">
ユーザー名<input type="text" name="userName">
<input type="submit" value="新規登録">
</form>
</body>
</html>