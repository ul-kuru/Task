<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Task</title>
</head>
<body>
Taskへようこそ
ログイン
<form action="/Task/LoginServlet" method="post">
<input type="text" name="userId"><br>
<input type="password" name="pass"><br>
<input type="submit" value="ログイン">
</form>


<a href="/Task/RegisterServlet" method="get">新規登録</a>
</body>
</html>