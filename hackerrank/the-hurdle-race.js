/**
 * Dan은 허들넘기 비디오게임을 하는데 그의 캐릭터가 넘을 수 있는 허들의 최대높이가 k이고, 넘어야하는 허들들은 height배열이다.
 * 그는 마법의 물약을 하나 마실때마다 넘을 수 있는 최대높이가 1씩 증가한다. 최소 몇개의 물약을 마셔야 모든 허들을 넘을 수 있는가.
 * @param k
 * @param height
 */
const hurdleRace = (k, height) => {
    const maximum = height.reduce((maximum, val) => maximum < val ? val : maximum ,0);
    return k < maximum ? maximum - k : 0;
};

(() => {
    console.log(hurdleRace(4, [1, 6, 3, 5, 2]));
    console.log(hurdleRace(7, [2, 5, 4, 5, 2]));
})();