/**
 * 모니카가 가진 돈으로 키보드랑 유에스비 사기.(가진 돈을 최대한 다 쓰는 방향을 찾아라)
 * @param keyboards 키보드 값 배열
 * @param drives 유에스비 값 배열
 * @param b 가진 돈
 * @returns {*}
 */
function getMoneySpent(keyboards, drives, b) {

    keyboards.sort((a, b) => b - a);
    drives.sort((a, b) => b - a);

    let forward, reverse;
    if (keyboards[0] > drives[0]) {
        forward = keyboards;
        reverse = drives;
    } else {
        forward = drives;
        reverse = keyboards;
    }

    let loop = 0
    let loopEnd = forward.length * reverse.length;
    let i = 0, j = reverse.length - 1;
    let sum, max = -1;
    for (let loopCnt = 0; loopCnt < loopEnd; loopCnt++) {
        loop++;
        if ((sum = forward[i] + reverse[j]) === b) {
            return sum;
        }

        if (sum > b) {
            i++;
        } else {
            if (sum > max) max = sum;
            j--;
        }
    }

    return max;
}

console.log(getMoneySpent([4],[5], 5));
console.log(getMoneySpent([3, 1],[5, 2, 8], 10));
console.log(getMoneySpent([5, 3, 4, 2, 5], [10, 2, 11, 15, 6], 15));
console.log(getMoneySpent([11, 17], [12, 22, 14], 10));