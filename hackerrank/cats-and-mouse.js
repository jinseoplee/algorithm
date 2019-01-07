/**
 * 고양이 두 마리와 쥐 한 마리가 있다. 고양이 A와 B 둘 중 누가 생쥐 C를 차지할까?
 * 1. 고양이 A와 고양이 B 중 생쥐 C와 더 가까운 고양이가 차지하게 된다.
 * 2. 단 각 고양이와 생쥐 사이의 거리가 같다면 고양이 둘이 생쥐를 서로 차지하겠다고 싸우는 사이 생쥐는 도망간다.
 * @param x Cat A's position
 * @param y Cat B's position
 * @param z Mouse C's position
 */
function catAndMouse(x, y, z) {
    const Z_TO_X = Math.abs(z - x);
    const Z_TO_Y = Math.abs(z - y);
    return Z_TO_X > Z_TO_Y ? "Cat B" : Z_TO_X === Z_TO_Y ? "Mouse C" : "Cat A";
}

const queries = [
    [1, 2, 3],
    [1, 3, 2]
];

queries.forEach((query) => console.log(catAndMouse(query[0], query[1], query[2])));