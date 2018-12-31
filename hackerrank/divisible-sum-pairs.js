/**
 * 
 * @param n The integer length of array ar
 * @param k The integer to divide the pair sum by
 * @param ar An array of integers
 */
function divisibleSumPairs(n, k, ar) {
    //let uniqueArr = ar.filter((item, pos, self) => self.indexOf(item) === pos);
    let count = 0;
    for (let i = 0; i < ar.length-1; i++) {
        for (let j = i+1; j < ar.length; j++) {
            if ((ar[i] + ar[j]) % k === 0) {
                count++;
            }
        }
    }
    return count;
}


/**
 * 각 요소를 k로 나누고 나머지 값을 구한다. 그 나머지 값이 0보다 크다면 그 수는 k의 배수가 아니다. 그래서 k에서 나머지 값을 빼면 배수가 되기 위해
 * 필요한 수를 구할 수 있다. 이 알고리즘에서는 buckets을 이용한다. buckets에 나머지 값을 인덱스로 이용해 카운팅한다.
 * 예를들면 2라는 수를 k로 나누면 나머지는 2고, k의 배수가 되려면 1이라는 수가 더 필요하다. 나중에 나머지가 1인 수가 나왔을때 나머지가 2였던 수가 필요한
 * 셈이다. 그래서 그때를 대비하여 buckets에 나머지 2를 인덱스로 이용하여 buckets[2] = 1이라고 카운팅 해논다. 이 후의 루프에서 2라는 수가 더 등장하면
 * buckets[2] = 2, buckets[2] = 3... 의 식으로 카운팅한다. 왜냐하면 나중에 숫자 1이 나왔을때 나머지가 1이 되는데 k의 배수가 되기 위해 2가 필요하다.
 * 기존에 만약 나머지가 2인 숫자가 3번 나왔다면 buckets[2] = 3인 상태일것이다. 그때 k=3의 배수가 되려면 1과 나머지가 2인 수를 더해야 하는데 그 가짓수가
 * 3번이 된다. 그래서 result에 buckets[2]을 더해준다.
 * @param n
 * @param k
 * @param ar
 */
function divisibleSumPairs2(n, k, ar) {
    let result = 0;
    let buckets = [];
    let matchWithRemainder, currentRemainder;
    for (let idx = 0; idx < ar.length; idx++) {
        currentRemainder = ar[idx] % k;
        matchWithRemainder = currentRemainder > 0 ? k - currentRemainder : 0;

        if (buckets[matchWithRemainder]) {
            result+=buckets[matchWithRemainder];
        }

        if (buckets[currentRemainder]) {
            buckets[currentRemainder]++;
        } else {
            buckets[currentRemainder] = 1;
        }
    }

    return result;
}

console.log(divisibleSumPairs(6, 3, [1, 3, 2, 6, 1, 2]));
console.log(divisibleSumPairs2(6, 3, [1, 3, 2, 6, 1, 2]))


