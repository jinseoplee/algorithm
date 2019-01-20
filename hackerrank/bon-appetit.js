/**
 * Brian과 Anna의 공평한 밥값 계산
 * @param bill 영수증
 * @param k Anna가 먹지 않은것(Zero based index of the item)
 * @param b Brian이 Anna에게 청구한 돈
 */
function bonAppetit(bill, k, b) {
    const fairlyCost = (bill.reduce((sum, cost) => sum + cost ,0) - bill[k]) / 2;
    console.log(fairlyCost < b ? b - fairlyCost : "Bon Appetit");
}

function bonAppetit2(bill, k, b) {
    let total = parseInt(bill.reduce((sum, cost) => sum + cost, 0) - bill[k]) / 2;
    let annaChange = bill[k] / 2;
    console.log( (total === b) ? "Bon Appetit" : annaChange);
}

bonAppetit([3, 10, 2, 9], 1, 12);
bonAppetit([3, 10, 2, 9], 1, 7);

