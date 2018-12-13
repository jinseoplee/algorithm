function birthdayCakeCandles(ar) {

    let tmp = 0;
    for(let item in ar) {
        if(tmp < ar[item]) {
            tmp = ar[item];
        }
    }

    let count = 0;
    for(let item in ar) {
        if(tmp == ar[item]) {
            count++;
        }
    }

    return count;
}

const arCount = 4;
const ar = "3 2 1 3".split(' ').map(arTemp => parseInt(arTemp, 10));

birthdayCakeCandles(ar);

