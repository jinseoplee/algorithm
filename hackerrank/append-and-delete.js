/**
 * 문자열 s 를 문자열 t 로 convert 시키는 문제다. 단 k 번의 step 수로 완료 할 수 있는지 판단해야한다.
 * 맨 처음 문제를 봤을때 step k 만 넘어가지 않으면 무조건 성공이라 생각하여 아래와같이 로직을 만들었다.
 * 문자열 속의 문자를 뺄때 step 1, 넣을때 step 1 이라는 규칙이 있다.
 * 그러나 s : 'y' , t : 'yu' , k : 2 라는 input 데이터들에 대해서 Yes 를 출력하였는데 No 가 출력되어야 한다고 한다.
 * 문제를 다시 자세히 읽어보니 정확히 k 번으로 해결되어야 한다고 한다. 더도말고 덜도말고 정확한 k 번.
 * 꼭 필요한 replace 작업을 모두 완료 후, 남은 k 번을 모두 소모해야 한다는 말이다...
 * 다 완성된 문자열이지만 별 의미 없는 replace 를 더 진행해주면 된다. 예를 들어
 * s : 'abcdefg' , t : 'abcdhij' , k : 7 와 같은 input 데이터가 있으면
 * abcd 는 s 와 t 가 공통되는 부분이라 작업 수에서 제외된다. s의 efg 만 t의 hij 로 변경하면 된다.
 * 문자를 제거하고 다시 넣는것까지 한번에 2 step. 필요 최소의 step 수는 6번이 되는셈이다. 하지만 모든 k 를 소모해야 하기 때문에
 * 나머지 1을 사용해야한다. 그러나 어떤 아무 문자를 제거까진 가능하지만 다시 되돌릴 스탭 수가 부족하기에 No 를 출력해준다.
 * 만약 k 가 8이라면 아무 문자를 제거하고 다시 되돌리기까지 가능해서 Yes 를 출력한다.
 * @param s
 * @param t
 * @param k
 * @returns {string}
 */
const appendAndDelete = (s, t, k) => {
    let result = "Yes";

    if (s === t) {
        return result;
    }

    const [sArray, tArray] = [s.split(""), t.split("")];
    let [i, cnt] = [0, 0];

    while (sArray[i] !== undefined || tArray[i] !== undefined) {

        if (sArray[i] !== tArray[i]) {
            if (sArray[i] === undefined || tArray[i] === undefined) {
                cnt++;
            } else {
                cnt+=2;
            }
        }

        if (cnt > k) {
            result = "No"
            break;
        }

        i++;
    }

    return result;
};

const appendAndDelete2 = (s, t, k) => {

    let sumLen = s.length + t.length;

    if (sumLen < k || s === t) return "Yes";

    for (let i = 0, minLen = Math.min(s.length, t.length); i < minLen; i++, sumLen-=2) {
        if (s[i] !== t[i]) break;
    }

    return sumLen > k || (k - sumLen) % 2 !== 0 ? "No" : "Yes";
};

(() => {
    console.log(appendAndDelete2("hackerhappy", "hackerrank", 9));
    console.log(appendAndDelete2("aba", "aba", 7));
    console.log(appendAndDelete2("ashley","ash", 2));
    console.log(appendAndDelete2("qwerasdf", "qwerbsdf", 6));
    console.log(appendAndDelete2("y", "yu", 2));
})();