/**
 * 숫자 n 을 이루고 있는 각각의 숫자중 n의 약수는 총 몇개인가
 * @param n
 * @returns {number}
 */
const findDigits = (n) => {
    return n.toString().split("").map(n => parseInt(n, 10)).reduce((count, value) => {
        return n % value === 0 ? ++count : count;
    }, 0);
};

(() => {
    console.log(findDigits(12));
    console.log(findDigits(1012));
})();