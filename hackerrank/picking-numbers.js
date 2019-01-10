/**
 * absolute difference가 1보다 작거나 같다는 조건이 충족되는 수 들의 집합 중. 가장 많은 수의 조합을 찾아라.
 * 수가 바뀔때와, 과거 수, 현재 수, 그리고 해당 수의 갯수를 가지고 찾는다.
 * 현재 수의 갯수 카운팅
 *
 * @param a
 * @returns {*}
 */
const pickingNumbers = (a) => {
    a.sort((a, b) => a - b);

    const numCnt = {"cnt":0, "maxCnt":0, "numChangeCnt":0};
    const numFocus = {"curNum":0, "pastNum":0};

    for (let i = 0; i < a.length; i++) {
        if (!numCnt[a[i]]) {
            numCnt[a[i]] = 1;
        } else {
            numCnt[a[i]]++;
        }

        if (a[i] !== numFocus["curNum"]) {
            numCnt["numChangeCnt"]++;
            numFocus["pastNum"] = numFocus["curNum"];
            numFocus["curNum"] = a[i];

            if (numCnt["cnt"] > numCnt["maxCnt"]) {
                numCnt["maxCnt"] = numCnt["cnt"];
            }

            if (numCnt[numFocus["pastNum"]] && Math.abs(a[i] - numFocus["pastNum"]) <= 1) {
                numCnt["cnt"] = numCnt[numFocus["pastNum"]] + 1;
            } else numCnt["cnt"] = 1;
        } else {
            numCnt["cnt"]++;
        }
    }

    return numCnt["numChangeCnt"] > 1 ? numCnt["maxCnt"] : numCnt["cnt"];
};

const pickingNumbers2 = (a) => {
    //a.sort((a, b) => b - a);
    return a.reduce((count, value) => {
        count[value]++;
        return count;
    }, new Array(100).fill(0))
        .reduce((max, value, idx, count) => {
            if (max < value + count[idx + 1]) {
                max = value + count[idx + 1];
            }
            return max;
        },0);
};

(() => {
    console.log(pickingNumbers([1,2,2,3,3,3,5]));
    console.log(pickingNumbers([1, 2, 2, 3, 1, 2]));
    console.log(pickingNumbers([4, 6, 5, 3, 3, 1]));
    console.log(pickingNumbers("4 2 3 4 4 9 98 98 3 3 3 4 2 98 1 98 98 1 1 4 98 2 98 3 9 9 3 1 4 1 98 9 9 2 9 4 2 2 9 98 4 98 1 3 4 9 1 98 98 4 2 3 98 98 1 99 9 98 98 3 98 98 4 98 2 98 4 2 1 1 9 2 4".split(" ").map(a => parseInt(a, 10))));
    console.log(pickingNumbers("66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66".split(" ").map(a => parseInt(a, 10))));
})();
