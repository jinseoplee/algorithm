/**
 * a 와 b 사이에 제곱수(Square of integer)를 구하라
 * 맨 처음 시도한 방법은 잘 나오지만 속도가 너무 느리다.
 * 두 번째 방법은 a와 b의 각각의 근사값을 구하여 그 사이의 갯수를 구하는 방식이다.
 * a = 3, b = 17
 * 1. Math.sqrt 로 a와 b의 제곱근을 구한다.
 * ex ) a(3) = 1.7320508075688772, b(17) = 4.123105625617661
 * 2. sqrt(a)는 ceil(올림), sqrt(b)는 floor(내림) 시켜준다.
 * 그 이유는 sqrt(3)을 내림 시키면 3보다 작은 수의 제곱근이 된다. 3 미만은 필요없다.
 * 마찬가지로 sqrt(17)을 올림 시켜면 17보다 큰 수의 제곱근이 된다. 17 초과는 필요없다.
 * 3. 마지막으로 floor(sqrt(b)) - ceil(sqrt(a)) 를 해주면 갯수가 나온다.
 *
 * ex)
 * 2 -> sqrt : 1.4142135623730951 (Start)
 * 3 -> sqrt : 1.7320508075688772
 * 4 -> sqrt : 2
 * 5 -> sqrt : 2.23606797749979
 * 6 -> sqrt : 2.449489742783178
 * 7 -> sqrt : 2.6457513110645907
 * 8 -> sqrt : 2.8284271247461903
 * 9 -> sqrt : 3
 * 10 -> sqrt : 3.1622776601683795 (End)
 *
 * 2 ~ 10 사이의 값은 제곱근 1 ~ 3 사이에 걸처져 있음을 알 수 있다.
 * @param a
 * @param b
 */
const squares = (a, b) => {

    let cnt = 0;

    for (let i = a; i <= b; i++) {
       if (Math.sqrt(i) - Math.floor(Math.sqrt(i)) === 0) cnt++;
    }
    return cnt;
};

const squares2 = (a, b) => {
    let low=Math.ceil(Math.sqrt(a));
    let upp=Math.floor(Math.sqrt(b));
    console.log("a : ", a, ", Math.sqrt(a) : ", Math.sqrt(a), ", Math.ceil : ", low);
    console.log("b : ", b, ", Math.sqrt(b) : ", Math.sqrt(b), ", Math.ceil : ", upp);
    return upp-low+1;
};

(() => {
    console.log(squares2(3,9));
    console.log(squares2(17,24));
    console.log(squares2(3,17));
})();