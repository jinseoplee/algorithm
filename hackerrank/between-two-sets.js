/**
 * a배열 모두가 x의 인수이고, x가 b배열 모두의 인수인 값의 개수
 * @param a
 * @param b
 * @returns {number}
 */
function getTotalX(a, b) {
    let count = 0;
    for(let x = Math.min(...a); x <= Math.max(...b); x++) {
        if (a.every(aVal => x % aVal === 0)) {
            if (b.every(bVal => bVal % x === 0)) {
                count++;
            }
        }
    }
    return count;
}

const a = [2, 4];
const b = [16, 32, 96];
console.log(getTotalX(a, b));