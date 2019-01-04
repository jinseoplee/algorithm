/**
 * 책의 맨 앞에서부터 페이지를 넘기는게 빠를까요, 맨 뒤에서부터 페이지를 넘기는게 빠를까요?
 * @param n 책의 총 페이지
 * @param p 가야하는 페이지 넘버
 */
function pageCount(n, p) {
    const totalPage = parseInt(n / 2 + 1);
    const pageToGo = parseInt(p / 2 + 1);
    return pageToGo > totalPage / 2 ? totalPage - pageToGo : pageToGo - 1;
}


console.log(pageCount(5, 4));