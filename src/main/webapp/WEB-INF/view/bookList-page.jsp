<%@ page import="org.springframework.ui.Model" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%--%>
<%--    String id = (String) session.getAttribute("id");--%>
<%--    String type = getUserObjById(id).getUserType();--%>
<%--    if (id == null) {--%>
<%--        response.sendRedirect("/user/loginpage");--%>
<%--    }--%>
<%--%>--%>
<%--logged on--%>
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
        <c:url var="borrowLink" value="/book/borrowBook">
            <c:param name="idBooks" value="${book.idBooks}"/>
            <c:param name="bookAuthor" value="${book.bookAuthor}"/>
            <c:param name="bookName" value="${book.bookName}"/>
            <c:param name="bookPublisher" value="${book.bookPublisher}"/>
            <c:param name="userID" value="${id}"/>
            <c:param name="userType" value="${type}"/>
        </c:url>
        <div>
            <span>${book.idBooks}</span>
            <span>${book.bookAuthor}</span>
            <span>${book.bookName} </span>
            <span>${book.bookPublisher}</span>
            <span>
                <a href="${borrowLink}"
                   onclick="if (!(confirm('책을 빌리시겠습니까?'))) return false">대여</a>
            </span>
        </div>
    </c:forEach>
</div>

</body>
</html>