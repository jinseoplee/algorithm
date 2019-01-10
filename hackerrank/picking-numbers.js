const pickingNumbers = (a) => {
    a.sort((a, b) => a - b);
    let curValue = a[0];
    let count = 0;
    let maxCount = 0;
    for (let i = 0; i < a.length; i++) {
        if (a[i] === curValue) count++;
        else {
            if (Math.abs(a[i] - curValue) <= 1) count++;
            else if(maxCount < count) {
                maxCount = count;
                count = 1;
                curValue = a[i];
            }
        }
    }
    return maxCount;
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
})();
