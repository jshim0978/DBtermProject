function goToUserMainPage() {
    location.href = "/user/main";
}

function goToSearchPage() {
    location.href = "/book/bookSearchPage";
}

function borrowBookButton(event) {
    const thTag = event.target.parentElement.parentElement;
    const arrayData = thTag.childNodes;

    for (let index = 0; index < arrayData.length; index++) {
        const classNameData = arrayData.item(index);
        if (classNameData.className && classNameData.className === 'borrow'
            && classNameData.firstChild && classNameData.firstChild.data &&classNameData.firstChild.data === '1') {
            alert("이미 대여중입니다!");
            event.preventDefault ? event.preventDefault() : (event.returnValue = false);

            return false;
        }
    }

    if (!(confirm('대출을 하시겠습니까?'))) {
        event.preventDefault ? event.preventDefault() : (event.returnValue = false);

        return false
    }
}