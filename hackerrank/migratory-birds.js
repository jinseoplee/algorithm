/**
 * 철새들 중 마릿수가 가장 많은 종류를 찾아라(마릿수가 가장 많은 종류가 2종류 이상이면 더 낮은 코드인 철새를 리턴)
 * @param arr 철새들의 배열(철새는 정수로 표현(1~5))
 * @returns {number}
 */
function migratoryBirds(arr) {
    const countMap = {};
    let minIdx = 5;
    let maxCount = 0;
    for (let idx in arr) {
        if (countMap[arr[idx]]) {
            countMap[arr[idx]]++;
        } else {
            countMap[arr[idx]] = 1;
        }

        if (countMap[arr[idx]] > maxCount) {
           minIdx = arr[idx];
           maxCount = countMap[arr[idx]];
        } else if (countMap[arr[idx]] === maxCount && arr[idx] < minIdx) {
            minIdx = arr[idx];
        }

    }

    return minIdx;
}

console.log(migratoryBirds([1, 4, 4, 4, 5, 3]));
console.log(migratoryBirds([1, 2, 3, 4, 5, 4, 3, 2, 1, 3, 4]));
