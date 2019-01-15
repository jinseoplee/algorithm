/**
 * 유토피아의 나무는 일년 중 2번 자란다. 봄과 여름.
 * 봄 : 길이가 두배로 자란다.
 * 여름 : 1 자란다.
 * 처음 시작은 1
 * 나무는 얼마나 자랄까?
 * @param n Number of growth cycles
 * @returns {number}
 */
const utopianTree = (n) => {
    let count = 1;
    for (let i = 1; i < n+1; i++) {
        if (i % 2 === 0) count++;
        else count*=2;
    }
    return count;
};

(() => {
    "014".split("").map(a => parseInt(a, 10)).forEach(n => {
        console.log(utopianTree(n));
    });
})();