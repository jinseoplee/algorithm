/**
 * 마지막 돌을 가져가면 지는 NIM게임
 * 주의사항은 pile이 1개짜리가 딱 1개 있을 수 도 있음. 그것에 대한 처리를 해야함
 * @param s
 * @returns {string}
 */
function misereNim(s) {
    let sum = s.reduce((sum, val) => { return sum += val }, 0);
    if (sum === s.length) {
        if (sum % 2 === 0) {
            return "First";
        } else {
            return "Second";
        }
    }

    let result = s.reduce((nimSum, val) => {
        return nimSum ^= val;
    }, 0);
    return parseInt(result.toString(2)) !== 0 ? "First" : "Second";
}

let case1 = "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1".split(" ").map(sTemp => parseInt(sTemp, 10));
console.log(misereNim(case1));
