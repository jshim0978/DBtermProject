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
    <c:forEach var="book" items="${books}">
        <c:url var="deleteLink" value="/book/변경해야함">
            <c:param name="idBooks" value="${book.idBooks}"/>
        </c:url>
        <c:url var="updateLink" value="/book/변경해야함">
            <c:param name="idBooks" value="${book.idBooks}"/>
        </c:url>
        <div>
            <span>${book.idBooks}</span>
            <span>${book.bookAuthor}</span>
            <span>${book.bookName} </span>
            <span>${book.bookPublisher}</span>
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
<script type="text/javascript" src="/resources/js/login-page.js">
</script>
</body>
</html>