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

console.log(divisibleSumPairs(6, 3, [1, 3, 2, 6, 1, 2]));

