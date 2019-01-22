/**
 * Cloud hopping game.
 * 1 cloud : thunderhead
 * 0 cloud : cumulus cloud
 * 한 번에 k만큼 점프 할 수 있다. 단 한 번 점프 하는데 에너지 1 소모. 도착한 곳이 thunderhead면 추가 2 소모
 * 인덱스 0 부터 시작해서 다시 0 으로 돌아왔을때 남은 에너지는?( 에너지는 100으로 시작한다.)
 * @param c 구름 배열
 * @param k 점프 단위
 */
const jumpingOnClouds = (c, k) => {
    let e = 100;

    for (let i = 0; i < c.length; i+=k) {
        if (c[i] === 1) e -= 3;
        else e--;
    }

    return e;
};

(() => {
    console.log(jumpingOnClouds([0, 0, 1, 0, 0, 1, 1, 0], 2));
    console.log(jumpingOnClouds([1, 1, 1, 0, 1, 1, 0, 0, 0, 0], 3));
    console.log(jumpingOnClouds([0, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0], 1));
})();