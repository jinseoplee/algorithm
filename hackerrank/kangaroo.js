/**
 * x1부터 시작하여 v1칸씩 뛰는 캥거루1이, x2부터 v2칸씩 뛰는 캥거루2와 동일 턴에 동일 칸으로 뛰는 지점이 있을까?
 * 캥거루1이 캥거루2보다 한 번에 뛰는 칸 수가 많아야 된다는 전제조건 하에
 * (캥거루2의 시작점 - 캥거루1의 시작점) % (캥거루1이 한 번에 뛰는 칸 수 - 캥거루2가 한 번에 뛰는 칸 수) === 0 이면 성사된다.
 * 캥거루1의 시작점을 start point 캥거루2의 시작점을 end point라고 치고 캥거루1이 뛰었을때 v1만큼 start point + v1 한 뒤
 * 캥거루2가 뛰었을때 그 만큼 - v2 하다가 end point에 도달하게 되면 조건이 성사되는 것이다.
 * @param x1
 * @param v1
 * @param x2
 * @param v2
 * @returns {string}
 */
function kangaroo(x1, v1, x2, v2) {
    if (v1 > v2 && ((x2-x1) % (v1-v2) === 0)) {
        return "YES";
    } else {
        return "NO";
    }
}

console.log(kangaroo(0, 3, 4, 2)); // YES
console.log(kangaroo(0, 2, 5, 3)); // NO
console.log(kangaroo(43, 5, 49, 3)); // YES
console.log(kangaroo(28, 8, 96, 2)); // NO