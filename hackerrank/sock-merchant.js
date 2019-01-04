/**
 * John이 팔 수 있는 양말은 양말 더미에 총 몇 쌍이 있을까?
 * 오직 색이 맞는 쌍을 이루는 양말만 팔 수 있다.
 * pairsCheck에 양말 색상 코드를 Key로 항목을 생성하고 카운팅 한다.
 * 해당 항목이 한 쌍이 될때마다 pairsOfSocks를 1씩 증가시킨다. pairsCheck의 한 쌍이 된 항목은 값을 0으로 초기화
 * @param n 총 양말 수
 * @param ar 각각의 양말의 색상 배열
 */
function sockMerchant(n, ar) {
    const pairsCheck = {};
    return ar.reduce((pairsOfSocks, colorOfSocks) => {
        if (pairsCheck[colorOfSocks]) {
            pairsCheck[colorOfSocks]++;
            if (pairsCheck[colorOfSocks] === 2) {
                pairsOfSocks++;
                pairsCheck[colorOfSocks] = 0;
            }
        } else {
            pairsCheck[colorOfSocks] = 1;
        }
        return pairsOfSocks;
    }, 0);
}

console.log(sockMerchant(9, [10, 20, 20, 10, 10, 30, 50, 10, 20]));