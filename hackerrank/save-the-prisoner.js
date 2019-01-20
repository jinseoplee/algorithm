/**
 * 마지막 사탕을 가져가려면 몇번 의자에 앉아야 할까.
 * @param n 죄수 수
 * @param m 사탕 수
 * @param s 가장 먼저 사탕을 가져갈 의자 번호
 */
const saveThePrisoner = (n, m, s) => {
    let receiveLastCandy = (s - 1 + m) % n;
    return receiveLastCandy === 0 ? n : receiveLastCandy;
};

const input = [
    [5, 2, 1],
    [5, 2, 2],
    [7, 19, 2],
    [3, 7, 3],
    [352926151, 380324688, 94730870],
    [5, 5, 1],
    [5, 5, 5]
];

(() => {
    input.forEach(function (row) {
       console.log(saveThePrisoner(row[0], row[1], row[2]));
    });
})();