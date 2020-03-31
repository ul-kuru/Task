
<%@page import="model.Quest"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Task</title>
</head>
<body>
Taskへようこそ<c:out value="${userName}、${userId }"/>さん
<p>ここはメイン画面です</p>
<% ArrayList<Quest> quests = (ArrayList<Quest>) session.getAttribute("quests");
assert quests != null;
%>

<c:forEach var="quest" items="${quests}">
<c:out value="${quest.getTitle()}"/><br>
<c:out value="${quest.isCleared()}"/><br>
<c:out value="${quest.getDetails()}"/><br>
<c:out value="${quest.getDeadline()}"/>まで（残り{残り時間}）<br>
作成日時:<c:out value="${quest.getCreatedAt()}"/> 作成者:<c:out value="${quest.getCreatedUserId()}"/><br>
<c:out value="${quest.getQuestId()}"/><br>
-------------------------------------------<br>
</c:forEach>
<a href="/Task/LogoutServlet">ログアウト</a>
</body>
</html>