<%@ page import="org.springframework.ui.Model" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>

<div id="container">
    <h1> Admin - user page </h1>

    <h3> Users </h3>

<%--    delete link, update link url 변경해야함--%>
<table style="border:1px solid">
    <tr>
    <th>ID</th>
    <th>Password</th>
    <th>Name</th>
    <th>Email</th>
    <th>Phone</th>
    <th>Type</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <c:url var="deleteLink" value="/admin/removeUser">
            <c:param name="userID" value="${user.userID}"/>
        </c:url>
        <c:url var="updateLink" value="/admin/editUserPage">
            <c:param name="userID" value="${user.userID}"/>
        </c:url>
        <tr>
            <div>
                <td> <span>${user.userID}</span> </td>
                <td> <span>${user.userPwd} </span> </td>
                <td> <span>${user.userName}</span> </td>
                <td> <span>${user.userEmail}</span> </td>
                <td> <span>${user.userPhone}</span> </td>
                <td> <span>${user.userType}</span> </td>
                <span>
                    <td> <a href="${deleteLink}"
                       onclick="if (!(confirm('회원을 탈퇴 시키시겠습니까?'))) return false">제거</a> </td>
                    <td> <a href="${updateLink}"
                       onclick="if (!(confirm('회원 정보 수정 화면으로 넘어가시겠습니까?'))) return false">수정</a> </td>
                </span>
            </div>
        </tr>
    </c:forEach>
    </table>
</div>
<script type="text/javascript" src="/resources/js/main-user.js">
</script>
</body>
</html>