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
    <h3> booklist</h3>
<%--    delete link, update link url 변경해야함--%>
    <c:forEach var="borrowbooks" items="${borrowbooks}">
        <c:url var="deleteLink" value="/book/변경해야함">
            <c:param name="idBooks" value="${borrowbooks.idBooks}"/>
        </c:url>
        <c:url var="updateLink" value="/book/takeAllReturnBooks">
            <c:param name="idBooks" value="${borrowbooks.idBooks}"/>
        </c:url>
        <div>
            <span>${borrowbooks.idborrowBooks}</span>
            <span>${borrowbooks.idBooks}</span>
            <span>${borrowbooks.userID}</span>
            <span>${borrowbooks.borrowedDate} </span>
            <span>${borrowbooks.expectedReturn}</span>
            <span>${borrowbooks.isReturned}</span>
            <span>
                <a href="${deleteLink}"
                   onclick="if (!(confirm('책을 목록에서 삭제 하시겠습니까?'))) return false">제거</a>
                |
                <a href="${updateLink}"
                   onclick="if (!(confirm('책 정보 수정 화면으로 넘어가시겠습니까?'))) return false">수정</a>
            </span>
        </div>
    </c:forEach>
</div>
</script>
</body>
</html>