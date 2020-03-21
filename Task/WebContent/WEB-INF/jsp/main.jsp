<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Task</title>
</head>
<body>
Taskへようこそ<c:out value="${userName+userId }"/>さん <!-- register追加後に{userName+userId }に変更 -->
ここはメイン画面です
<a href="/Task/LogoutServlet">ログアウト</a>
</body>
</html>