function goToEditProfilePage() {
    location.href = "/user/editProfile"; // 위치 지정
}

function goToSearchBookPage() {
    if (!(confirm("도서검색을 하시겠습니까?"))) {
        return false;
    }
    location.href = "/book/bookSearchPage";
}

function logout() {
    if (!(confirm("로그아웃 하시겠습니까?"))) {
        return false;
    }
    location.href = "/user/logoutPage";// 위치 지정
}

function deleteAccount() {
    if (!(confirm("탈퇴 하시겠습니까?"))) {
        return false;
    }
    location.href = "/user/delete";
}

function requestReturn() {
    if (!(confirm("반납요청을 하시겠습니까?"))) {
        return false;
    }
    location.href = "/book/waitingForReturn";
}
//
// function borrowAtReturnBook(event) {
//     const thTag = event.target.parentElement.parentElement;
//     const arrayData = thTag.childNodes;
//
//     for (let index = 0; index < arrayData.length; index++) {
//         const classNameData = arrayData.item(index);
//         if (classNameData.className && classNameData.className === 'borrow'
//             && classNameData.firstChild && classNameData.firstChild.data && classNameData.firstChild.data === '1') {
//             alert("이미 대여중입니다!");
//             event.preventDefault ? event.preventDefault() : (event.returnValue = false);
//
//             return false;
//         }
//
//         if (classNameData.className && classNameData.className === 'lastPerson'
//             && classNameData.firstChild && classNameData.firstChild.data && parseInt(classNameData.firstChild.data) > 1) {
//             alert("대기자가 있습니다!");
//             event.preventDefault ? event.preventDefault() : (event.returnValue = false);
//
//             return false;
//         }
//     }
//
//     if (!(confirm('대출을 하시겠습니까?'))) {
//         event.preventDefault ? event.preventDefault() : (event.returnValue = false);
//
//         return false
//     }
// }