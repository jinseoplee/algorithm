/**
 * Circular Array Rotation
 * 시계방향으로 한 자리씩 이동하는 정수 배열이 있다.
 * k만큼 회전했을때 배열의 각 인덱스에 해당하는 값은 무엇일까
 *
 * 만약 2번 회전한 후 1번 인덱스의 값이 궁금하다면, 인덱스값(1) -  회전 수(2) 를 한다.
 * 회전 수(2) 는 배열의 길이(3) 보다 길 수 있기 때문에 회전 수(2) % 배열의 길이(3) 를 하여 한 바퀴를 완전히 돌 수 있는 수를 제거해준다.
 * 그러면 인덱스값(1) - (회전 수(2) % 배열의 길이(3)) = -1 이 된다.
 * 인덱스 0 이전값은 인덱스 2이기 때문에 배열의 길이(3)을 더해준다. 그럼 2가 된다. 만약 인덱스 값이 0이 나올 경우를
 * 대비해서 % 배열의 길이(3)을 해준다면 그 상황에 대비할 수 있다.
 * @param a 순환될 정수 배열
 * @param k 순환 수
 * @param queries 궁금한 인덱스들을 가지고 있는 배열
 * @returns {*}
 */
const circularArrayRotation = (a, k, queries) => {
    return queries.reduce((result, q) => {
        result.push(a[(q - (k % a.length) + a.length) % a.length]);
        return result;
    },[]);
};

(() => {
    console.log(circularArrayRotation([1, 2, 3], 2, [0, 1, 2]));
})();