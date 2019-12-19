<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%--%>
<%--    String id = (String) session.getAttribute("id");--%>
<%--    if (id == null) {--%>
<%--        response.sendRedirect("/user/loginpage");--%>
<%--    }--%>
<%--%>--%>
<%--logged on--%>
<!DOCTYPE html>
<html>
<head>
    <style>
        span {
            font: bold 20px/5px Georgia, serif;
            color: Navy;
        }
        .ex1 {
            border-radius: 25px;
            border: 2px solid lightseagreen;
            padding: 10px;

        }

    </style>
    <meta charset="UTF-8">
    <title>user main page</title>

</head>
<body>
<div>
    <input type="button" onclick="goToEditProfilePage()" name="profile" value="edit profile">
<%--  move to edit profile page --%>
    <button onclick="location='/book/allBookListPage'">all books</button>
    <input type="button" onclick="goToSearchBookPage()" name="search" value="search book">
</div>
<%-- move to search book page --%>
<div class="ex1">
    <span>도서대출목록</span>
    <table id="borrow-list">
        <thead>
        <td class="ex1">Isbn</td>
        <td class="ex1">Title</td>
        <td class="ex1">BorrowDate</td>
        <td class="ex1">ReturnDate</td>
        </thead>
        <tbody>
        <c:forEach var="borrowbooks" items="${borrowbooks}">
            <c:url var="returnRequest" value="/book/expectedReturn">
                <c:param name="idBooks" value="${borrowbooks.idBooks}"/>
                <c:param name="idborrowBooks" value="${borrowbooks.idborrowBooks}"/>
            </c:url>
            <tr>
                <td>${borrowbooks.idBooks}</td>
                <td>${borrowbooks.idborrowBooks}</td>
                <td>${borrowbooks.borrowedDate}</td>
                <td>${borrowbooks.expectedReturn}</td>
                <td><a href="${returnRequest}" onclick="requestReturn()">도서 반납</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div class="ex1">
    <span>도서예약목록</span>
    <table id="reservation-list">
        <thead>
        <tr>
            <td class="ex1">Isbn</td>
            <td class="ex1">ReservationDate</td>
            <td class="ex1">Title</td>
            <td class="ex1">예약 대기자 수</td>
            <td class="ex1">isBorrow</td>
            <td class="ex1">예약취소</td>
            <td class="ex1">대여</td>
        </tr>
        </thead>
        <tbody>
        <%--        <c:forEach var="reservation" items="${reservations}">--%>
        <%--            <c:url var="cancealLink" value="/book/removereservationPage">--%>
        <%--                <c:param name="bookIsbn" value="${reservation.isbn}"/>--%>
        <%--            </c:url>--%>
        <%--            <c:url var="borrowLink" value="/book/borrowBookPage">--%>
        <%--                <c:param name="bookIsbn" value="${reservation.isbn}"/>--%>
        <%--                <c:param name="bookTitle" value="${reservation.title}"/>--%>
        <%--            </c:url>--%>
        <%--            <tr>--%>
        <%--                <td>${reservation.isbn}</td>--%>
        <%--                <td>${reservation.reservDate}</td>--%>
        <%--                <td>${reservation.title}</td>--%>
        <%--                <td class="lastPerson">${reservation.numberOfRestPerson}</td>--%>
        <%--                <td class="borrow">${reservation.isBorrow}</td>--%>
        <%--                <td><a href="${cancealLink}" onclick="cancealReservation()">예약 취소</a></td>--%>
        <%--                <td><a href="${borrowLink}" onclick="borrowAtReturnBook(event)">대여</a></td>--%>
        <%--            </tr>--%>
        <%--        </c:forEach>--%>
        </tbody>
    </table>

    <input type="button" onclick="logout()" value="로그아웃"/>
</div>
<script type="text/javascript" src="/resources/js/user-main.js">
</script>
</body>
</html>