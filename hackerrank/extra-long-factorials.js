/**
 * Extra long factorial
 * 배열을 사용해야함.
 * 일반적으로 팩토리얼을 계산한다고 하면 아래와 같이 재귀호출을 이용하여 간단하게 구현할 수 있다.
 * 그러나 연산결과 값이 자바스크립트의 max integer 값인 9007199254740991(Number.MAX_SAFE_INTEGER) 보다 커질경우 정상적인 결과를 기대하긴
 * 힘들다. 이를 해결하기 위해서는 배열을 이용해야 한다. extraLongFactorials 함수를 보자.
 * @param n
 * @returns {*}
 */
const factorials = (n) => {

    let result = 0;
    if (n !== 1)
        result = n * extraLongFactorials(n - 1);
    else
        return 1;

    return result;
};

/**
 * 아래 함수도 위 함수와 같은 팩토리얼 계산 함수이다. 다만 다른점은 위 함수는 정수 그대로를 계산하였다면 아래 함수는 각각의 자릿수를
 * 배열에 배치시켜 계산한것이다. 초등학교 수학시간에 배운 곱셈 방법과 같은 원리다. 한 자리씩 곱해주고 10 이상이면 10의 자리 수를 다음 곱셈 결과에
 * 더해주는 방법으로 배열에 저장해 가는 방법이다. 이런식으로 진행한다면 100 이상의 수를 팩토리얼 계산한다고 해도 문제없다.
 * @param n
 * @returns {string}
 */
const extraLongFactorials = (n) => {
    const result = n.toString().split("").map(Number).reverse();

    let currentNum, i, remainder;
    while (--n) {
        currentNum = remainder = i = 0;
        while ((currentNum = result[i++]) !== undefined || remainder) {
            currentNum = (currentNum || 0) * n + remainder;
            result[i-1] = currentNum % 10;
            remainder = parseInt(currentNum / 10, 10);
        }
    }

    return result.reverse().join("");
};


(() => {
    console.log(Number.MAX_SAFE_INTEGER);
    console.log(extraLongFactorials(500));
})();