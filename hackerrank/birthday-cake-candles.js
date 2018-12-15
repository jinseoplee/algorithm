function birthdayCakeCandles(ar) {
    let max = Math.max(...ar);
    return ar.reduce((count, i) => i === max ? count+1 : count ,0);
}

const arCount = 4;
const ar = "3 2 1 3".split(' ').map(arTemp => parseInt(arTemp, 10));
console.log(birthdayCakeCandles(ar));

