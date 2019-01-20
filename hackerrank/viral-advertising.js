/**
 * 광고 효과
 * 5명한테 광고하면 5/2명이 수신 및 5/2명의 각각 친구 3명에게 공유.
 * 수신한 사람만 수신자로 카운팅.
 * 다음 광고는 5/2 x 3명에게 시도.
 * @param n 총 광고 횟수
 * @returns {number}
 */
const viralAdvertising = (n) => {
    let result = 0;
    let adTarget = 5;
    for (let i = 0; i < n; i++) {
        result += Math.floor(adTarget / 2);
        adTarget = Math.floor(adTarget / 2) * 3;
    }
    return result;
};

(() => {
    console.log(viralAdvertising(3));
})();